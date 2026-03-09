package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Serviço de aplicação principal que orquestra a conversão do programa COBOL
 * de processamento de arquivos sequenciais.
 * Este serviço coordena a leitura de transações, o processamento de negócios
 * e a geração de arquivos de saída e relatórios.
 *
 * Esta é a ÚNICA classe public do arquivo. Nome do arquivo: Seqfileexample.java
 */
public class Seqfileexample {

    // Colaboradores declarados como package-private abaixo neste mesmo arquivo
    private final FileHandler fileHandler;
    private final TransactionProcessingService processingService;

    // Nomes dos arquivos definidos como constantes, espelhando a seção SELECT do COBOL.
    private static final String INPUT_FILE_PATH = "INPFILE.DAT";
    private static final String OUTPUT_FILE_PATH = "OUTFILE.DAT";
    private static final String REPORT_FILE_PATH = "RPTFILE.DAT";

    /**
     * Construtor que inicializa os serviços e handlers necessários.
     */
    public Seqfileexample() {
        this.fileHandler = new FileHandler();
        this.processingService = new TransactionProcessingService();
    }

    /**
     * Orquestra o fluxo de alto nível, espelhando a PROCEDURE DIVISION.
     * 1. Prepara os arquivos (simulado).
     * 2. Lê todas as transações de entrada.
     * 3. Processa as transações para calcular os saldos dos clientes.
     * 4. Grava os resultados e o relatório nos arquivos de saída.
     */
    public void run() {
        try {
            System.out.println("Iniciando o processo...");
            
            // Simula a criação do arquivo de entrada para o exemplo ser executável
            fileHandler.createSampleInputFile(INPUT_FILE_PATH);

            // 1. Lê todas as transações do arquivo de entrada
            List<CustomerTransaction> transactions = fileHandler.readTransactions(INPUT_FILE_PATH);
            System.out.println("Lidas " + transactions.size() + " transações.");

            // 2. Processa as transações
            ProcessingResult result = processingService.processTransactions(transactions);
            System.out.println("Processados " + result.processedCustomers().size() + " clientes.");

            // 3. Grava os arquivos de saída
            fileHandler.writeCustomerData(OUTPUT_FILE_PATH, result.processedCustomers());
            System.out.println("Arquivo de saída '" + OUTPUT_FILE_PATH + "' gerado.");

            fileHandler.writeReport(REPORT_FILE_PATH, result.processedCustomers(), result.totalBalance());
            System.out.println("Arquivo de relatório '" + REPORT_FILE_PATH + "' gerado.");

            System.out.println("Processo concluído com sucesso.");

        } catch (IOException e) {
            System.err.println("Ocorreu um erro crítico durante o processamento de arquivos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Ponto de entrada da aplicação.
     * Apenas instancia e executa o serviço de aplicação.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Seqfileexample().run();
    }
}

// ── Value Object ── SEM "public" (package-private) ──────────────────────────
/**
 * Representa uma única transação lida do arquivo de entrada (INP-FILE).
 * É um Value Object imutável, implementado como um record Java.
 * Corresponde à estrutura `INP-RECORD` na `FILE SECTION`.
 */
record CustomerTransaction(
    String customerId,
    String customerName,
    BigDecimal transactionAmount,
    char transactionType
) {}

// ── Entidade de domínio ── SEM "public" (package-private) ──────────────────
/**
 * Entidade que representa um Cliente. Possui identidade (id) e estado (saldo)
 * que é modificado pelas transações.
 * Corresponde à área de trabalho `WS-CURRENT-CUSTOMER`.
 */
class Customer {
    private final String id;
    private String name;
    private BigDecimal balance;

    /**
     * Construtor para um novo cliente.
     * @param id O identificador único do cliente.
     * @param name O nome do cliente.
     */
    Customer(String id, String name) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.balance = BigDecimal.ZERO; // COBOL: INITIALIZE WS-CUST-BALANCE.
    }

    /**
     * Aplica uma transação ao saldo do cliente.
     * Encapsula a lógica de crédito ('C') e débito ('D').
     * @param transaction A transação a ser aplicada.
     */
    void applyTransaction(CustomerTransaction transaction) {
        // Atualiza o nome do cliente, caso a primeira transação lida não tivesse o nome completo.
        if (this.name.isBlank()) {
            this.name = transaction.customerName();
        }

        if (transaction.transactionType() == 'C') {
            this.balance = this.balance.add(transaction.transactionAmount());
        } else if (transaction.transactionType() == 'D') {
            this.balance = this.balance.subtract(transaction.transactionAmount());
        }
    }

    String getId() { return id; }
    String getName() { return name; }
    BigDecimal getBalance() { return balance; }
}

// ── Value Object (Data Carrier) ── SEM "public" (package-private) ──────────
/**
 * Um Value Object para transportar os resultados do serviço de processamento.
 * Agrupa os clientes processados e o saldo total para facilitar o retorno
 * de múltiplos valores.
 */
record ProcessingResult(
    List<Customer> processedCustomers,
    BigDecimal totalBalance
) {}

// ── Serviço de domínio ── SEM "public" (package-private) ────────────────────
/**
 * Encapsula a lógica de negócio principal do programa COBOL.
 * Implementa o padrão de "quebra de controle" para processar transações
 * agrupadas por cliente.
 */
class TransactionProcessingService {

    /**
     * Processa uma lista de transações, agrupando-as por cliente e calculando
     * os saldos finais.
     * @param transactions A lista de transações lidas do arquivo.
     * @return Um {@link ProcessingResult} contendo a lista de clientes com saldos atualizados e o saldo total.
     */
    ProcessingResult processTransactions(List<CustomerTransaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            return new ProcessingResult(new ArrayList<>(), BigDecimal.ZERO);
        }

        // O COBOL assume que o arquivo está pré-ordenado. Em Java, garantimos isso.
        transactions.sort(Comparator.comparing(CustomerTransaction::customerId));

        List<Customer> processedCustomers = new ArrayList<>();
        BigDecimal totalBalance = BigDecimal.ZERO;
        
        Customer currentCustomer = null;

        for (CustomerTransaction tx : transactions) {
            // Lógica de quebra de controle: se o cliente mudou (ou é o primeiro)
            if (currentCustomer == null || !currentCustomer.getId().equals(tx.customerId())) {
                // Se havia um cliente anterior, finaliza-o e adiciona à lista.
                if (currentCustomer != null) {
                    processedCustomers.add(currentCustomer);
                    totalBalance = totalBalance.add(currentCustomer.getBalance());
                }
                // Inicia o processamento do novo cliente.
                currentCustomer = new Customer(tx.customerId(), tx.customerName());
            }
            // Aplica a transação ao cliente atual.
            currentCustomer.applyTransaction(tx);
        }

        // Adiciona o último cliente processado à lista.
        if (currentCustomer != null) {
            processedCustomers.add(currentCustomer);
            totalBalance = totalBalance.add(currentCustomer.getBalance());
        }

        return new ProcessingResult(processedCustomers, totalBalance);
    }
}

// ── Handler de I/O ── SEM "public" (package-private) ───────────────────────
/**
 * Responsável por toda a interação com o sistema de arquivos.
 * Isola a lógica de leitura e escrita, mantendo os serviços de domínio puros.
 * Corresponde às operações OPEN, READ, WRITE, CLOSE do COBOL.
 */
class FileHandler {

    /**
     * Lê o arquivo de transações e o converte em uma lista de objetos.
     * Corresponde ao parágrafo `300-READ-INPUT`.
     * @param filePath O caminho para o arquivo de entrada.
     * @return Uma lista de {@link CustomerTransaction}.
     * @throws IOException Se ocorrer um erro de leitura.
     */
    List<CustomerTransaction> readTransactions(String filePath) throws IOException {
        List<CustomerTransaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() >= 46) {
                    // Mapeamento do layout do registro COBOL (INP-RECORD)
                    String id = line.substring(0, 5).trim();
                    String name = line.substring(5, 35).trim();
                    // PIC 9(8)V99 -> 10 dígitos, 2 casas decimais
                    BigDecimal amount = new BigDecimal(line.substring(35, 45)).movePointLeft(2);
                    char type = line.substring(45, 46).charAt(0);
                    
                    transactions.add(new CustomerTransaction(id, name, amount, type));
                }
            }
        }
        return transactions;
    }

    /**
     * Grava os dados consolidados dos clientes no arquivo de saída.
     * Corresponde à instrução `WRITE OUT-RECORD`.
     * @param filePath O caminho para o arquivo de saída.
     * @param customers A lista de clientes processados.
     * @throws IOException Se ocorrer um erro de escrita.
     */
    void writeCustomerData(String filePath, List<Customer> customers) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                // Formatação do OUT-RECORD: ID(5), NOME(30), SALDO(10 com 2 decimais)
                String balanceStr = String.format("%010.2f", customer.getBalance()).replace(",", ".");
                String line = String.format("%-5s%-30s%s",
                    customer.getId(),
                    customer.getName(),
                    balanceStr);
                writer.write(line);
                writer.newLine();
            }
        }
    }

    /**
     * Gera o arquivo de relatório formatado.
     * Corresponde às instruções `WRITE RPT-LINE`.
     * @param filePath O caminho para o arquivo de relatório.
     * @param customers A lista de clientes processados.
     * @param totalBalance O saldo total de todos os clientes.
     * @throws IOException Se ocorrer um erro de escrita.
     */
    void writeReport(String filePath, List<Customer> customers, BigDecimal totalBalance) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Escreve o cabeçalho (WS-REPORT-HEADER)
            writer.write("ID    NOME DO CLIENTE                NOVO SALDO");
            writer.newLine();
            writer.write("----- ------------------------------ ----------");
            writer.newLine();

            // Escreve as linhas de detalhe (WS-DETAIL-LINE)
            for (Customer customer : customers) {
                String line = String.format("%-5s %-30s %10.2f",
                    customer.getId(),
                    customer.getName(),
                    customer.getBalance());
                writer.write(line);
                writer.newLine();
            }

            // Escreve a linha de total (WS-TOTAL-LINE)
            writer.newLine();
            String totalLine = String.format("SALDO TOTAL GERAL: %27.2f", totalBalance);
            writer.write(totalLine);
            writer.newLine();
        }
    }
    
    /**
     * Método auxiliar para criar um arquivo de entrada de exemplo,
     * permitindo que o programa seja executado de forma autônoma.
     * @param filePath O caminho onde o arquivo de exemplo será criado.
     * @throws IOException Se ocorrer um erro de escrita.
     */
    void createSampleInputFile(String filePath) throws IOException {
        // Não recria o arquivo se ele já existir
        if (Files.exists(Paths.get(filePath))) {
            System.out.println("Arquivo de entrada '" + filePath + "' já existe. Usando o arquivo existente.");
            return;
        }
        
        System.out.println("Criando arquivo de entrada de exemplo: " + filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Layout: ID(5) NOME(30) VALOR(10) TIPO(1)
            // Valor 0000150050 -> 1500.50
            writer.write("10001JOAO SILVA                   0000150050C"); writer.newLine();
            writer.write("10001JOAO SILVA                   0000025000D"); writer.newLine();
            writer.write("20002MARIA SOUZA                  0000300000C"); writer.newLine();
            writer.write("10001JOAO SILVA                   0000010000C"); writer.newLine();
            writer.write("30003PEDRO ALVES                  0000050000C"); writer.newLine();
            writer.write("20002MARIA SOUZA                  0000050000D"); writer.newLine();
            writer.write("20002MARIA SOUZA                  0000100000C"); writer.newLine();
            writer.write("30003PEDRO ALVES                  0000005025D"); writer.newLine();
        }
    }
}