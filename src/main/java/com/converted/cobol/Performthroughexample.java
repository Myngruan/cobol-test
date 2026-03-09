package com.converted.cobol;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Serviço de aplicação principal para o programa COBOL PerformThroughExample.
 * Orquestra a leitura de registros de vendas, o processamento e a exibição de um relatório.
 * Esta é a ÚNICA classe public do arquivo. Nome do arquivo: Performthroughexample.java
 */
public class Performthroughexample {

    // Colaboradores declarados como package-private abaixo neste mesmo arquivo
    private final SalesRepository salesRepository;
    private final SalesProcessingService salesProcessingService;

    /**
     * Construtor que inicializa os serviços necessários.
     */
    public Performthroughexample() {
        this.salesRepository = new SalesRepository();
        this.salesProcessingService = new SalesProcessingService();
    }

    /**
     * Orquestra o fluxo de alto nível, correspondendo à PROCEDURE DIVISION principal.
     * Este método não contém regras de negócio.
     */
    public void run() {
        // Corresponde a A000-INITIALIZE
        System.out.println("Iniciando processamento do relatório de vendas...");

        // Carrega os dados que seriam lidos do SALES-FILE
        List<SalesRecord> salesRecords = salesRepository.loadAllSalesRecords();

        // Processa os registros e gera o relatório.
        // Corresponde ao PERFORM 100-PROCESS-RECORDS THRU 100-EXIT
        salesProcessingService.processAndDisplayReport(salesRecords);

        // Corresponde a Z000-TERMINATE
        System.out.println("Processamento do relatório de vendas finalizado.");
    }

    /**
     * Ponto de entrada da aplicação.
     * A única responsabilidade é instanciar e executar o serviço de aplicação.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performthroughexample().run();
    }
}

// ── Value Object ── SEM "public" (package-private) ──────────────────────────
/**
 * Representa um único registro de venda, análogo a WS-SALES-RECORD.
 * É um Value Object, pois representa um valor sem identidade própria.
 */
class SalesRecord {
    private final String productId;
    private final int quantity;
    private final BigDecimal unitPrice;

    /**
     * Constrói um registro de venda.
     * @param productId ID do produto (SR-PRODUCT-ID)
     * @param quantity Quantidade vendida (SR-QUANTITY)
     * @param unitPrice Preço por unidade (SR-UNIT-PRICE)
     */
    SalesRecord(String productId, int quantity, BigDecimal unitPrice) {
        this.productId = productId;
        this.quantity = quantity;
        // Garante a escala correta para cálculos monetários
        this.unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);
    }

    String getProductId() {
        return productId;
    }

    int getQuantity() {
        return quantity;
    }

    BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Calcula o total da linha para este registro.
     * @return O valor total (quantidade * preço unitário).
     */
    BigDecimal calculateLineTotal() {
        return unitPrice.multiply(new BigDecimal(quantity));
    }
}

// ── Repositório ── SEM "public" (package-private) ───────────────────────────
/**
 * Responsável por carregar dados de vendas.
 * Simula a leitura do arquivo sequencial 'SALES-FILE' do COBOL.
 */
class SalesRepository {

    /**
     * Carrega todos os registros de vendas.
     * Em uma aplicação real, este método leria um arquivo físico.
     * Aqui, usamos dados fixos para demonstrar a funcionalidade.
     * @return Uma lista de objetos SalesRecord.
     */
    List<SalesRecord> loadAllSalesRecords() {
        // Simula a leitura do SALES-FILE. A lógica de loop AT END é substituída
        // pela iteração sobre uma coleção pré-carregada.
        List<SalesRecord> records = new ArrayList<>();
        records.add(new SalesRecord("PROD001", 10, new BigDecimal("15.50")));
        records.add(new SalesRecord("PROD002", 5, new BigDecimal("100.00")));
        records.add(new SalesRecord("PROD003", 25, new BigDecimal("2.75")));
        records.add(new SalesRecord("PROD004", 150, new BigDecimal("0.50")));
        records.add(new SalesRecord("PROD005", 2, new BigDecimal("1250.99")));
        return records;
    }
}

// ── Serviço de domínio ── SEM "public" (package-private) ────────────────────
/**
 * Encapsula as regras de negócio para processamento de vendas e geração de relatórios.
 * Contém a lógica derivada dos parágrafos da PROCEDURE DIVISION.
 */
class SalesProcessingService {

    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("###,##0.00");

    /**
     * Processa uma lista de registros de vendas e exibe um relatório formatado no console.
     * Este método engloba a lógica dos parágrafos 100, 200, 300 e 400 do COBOL.
     * @param salesRecords A lista de registros de vendas a serem processados.
     */
    void processAndDisplayReport(List<SalesRecord> salesRecords) {
        // WS-TOTAL-SALES inicializado com ZERO.
        BigDecimal grandTotal = BigDecimal.ZERO;

        printReportHeader();

        // O loop 'for-each' substitui o 'PERFORM 100-PROCESS-RECORDS THRU 100-EXIT'.
        // Cada iteração do loop representa a execução dos parágrafos 200 e 300.
        for (SalesRecord record : salesRecords) {
            // Lógica de 200-CALCULATE-TOTAL
            BigDecimal lineTotal = record.calculateLineTotal();
            grandTotal = grandTotal.add(lineTotal);

            // Lógica de 300-DISPLAY-DETAIL
            printDetailLine(record, lineTotal);
        }

        // Lógica de 400-DISPLAY-SUMMARY, executada após o término do loop.
        printSummary(grandTotal);
    }

    /**
     * Imprime o cabeçalho do relatório.
     */
    private void printReportHeader() {
        System.out.println("=================================================");
        System.out.println("                 RELATÓRIO DE VENDAS             ");
        System.out.println("=================================================");
        System.out.println("PRODUTO    | QTD | PREÇO UNIT. | TOTAL DA LINHA");
        System.out.println("-------------------------------------------------");
    }

    /**
     * Formata e imprime uma única linha de detalhe do relatório.
     * Corresponde ao parágrafo 300-DISPLAY-DETAIL.
     * @param record O registro de venda da linha.
     * @param lineTotal O total calculado para a linha.
     */
    private void printDetailLine(SalesRecord record, BigDecimal lineTotal) {
        // Corresponde a mover os dados para WS-REPORT-LINE e DISPLAY.
        String formattedUnitPrice = String.format("%11s", CURRENCY_FORMAT.format(record.getUnitPrice()));
        String formattedLineTotal = String.format("%14s", CURRENCY_FORMAT.format(lineTotal));

        String reportLine = String.format("%-10s | %3d | %s | %s",
            record.getProductId(),
            record.getQuantity(),
            formattedUnitPrice,
            formattedLineTotal);

        System.out.println(reportLine);
    }

    /**
     * Imprime o rodapé com o total geral do relatório.
     * Corresponde ao parágrafo 400-DISPLAY-SUMMARY.
     * @param grandTotal O total geral de todas as vendas.
     */
    private void printSummary(BigDecimal grandTotal) {
        System.out.println("-------------------------------------------------");
        String formattedGrandTotal = CURRENCY_FORMAT.format(grandTotal);
        System.out.println("TOTAL GERAL: " + formattedGrandTotal);
        System.out.println("=================================================");
    }
}