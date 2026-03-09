package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

/**
 * Serviço de aplicação principal para o programa COBOL Increment.
 * Esta é a ÚNICA classe public do arquivo. Nome do arquivo: Increment.java
 * <p>
 * Este programa lê números de um arquivo de entrada, incrementa cada um em 1,
 * e escreve o resultado em um arquivo de saída. Ao final, exibe um resumo
 * do total de registros processados.
 */
public class Increment {

    private final NumberFileHandler fileHandler;
    private final NumberProcessor numberProcessor;

    public Increment() {
        this.fileHandler = new NumberFileHandler();
        this.numberProcessor = new NumberProcessor();
    }

    /**
     * Orquestra o fluxo de alto nível, espelhando a PROCEDURE DIVISION.
     * Corresponde ao parágrafo MAIN-PROCEDURE do COBOL.
     */
    public void run() {
        long recordsProcessed = 0;
        try {
            fileHandler.openFiles();

            // Corresponde a: PERFORM PROCESS-RECORDS UNTIL WS-EOF = 'Y'
            Optional<NumberRecord> recordOpt = fileHandler.readNextRecord();
            while (recordOpt.isPresent()) {
                NumberRecord inputRecord = recordOpt.get();

                // Corresponde a: ADD WS-INCREMENT-VALUE TO IN-NUMBER GIVING OUT-NUMBER
                NumberRecord outputRecord = numberProcessor.increment(inputRecord);

                // Corresponde a: WRITE OUTPUT-RECORD
                fileHandler.writeRecord(outputRecord);

                // Corresponde a: ADD 1 TO WS-COUNTER
                recordsProcessed++;

                // Corresponde a: PERFORM READ-INPUT-FILE (dentro do loop)
                recordOpt = fileHandler.readNextRecord();
            }

            // Corresponde a: PERFORM DISPLAY-SUMMARY
            displaySummary(recordsProcessed);

        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        } finally {
            // Corresponde a: CLOSE INPUT-FILE, OUTPUT-FILE
            fileHandler.closeFiles();
        }
    }

    /**
     * Exibe o resumo da execução.
     * Corresponde ao parágrafo DISPLAY-SUMMARY.
     * @param count O número de registros processados.
     */
    private void displaySummary(long count) {
        // Corresponde a: DISPLAY "Total records processed: " WS-COUNTER
        System.out.println("Total records processed: " + count);
    }

    /**
     * Ponto de entrada da aplicação.
     * Apenas instancia e executa o serviço de aplicação.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Increment().run();
    }
}

// ── Value Object ── SEM "public" (package-private) ────────────────────────
/**
 * Representa um registro de dados contendo um único número.
 * Este Value Object modela a estrutura de INPUT-RECORD e OUTPUT-RECORD.
 */
class NumberRecord {
    private final int value;

    /**
     * Constrói um registro com um valor numérico.
     * @param value O número para este registro.
     */
    NumberRecord(int value) {
        this.value = value;
    }

    /**
     * Retorna o valor numérico do registro.
     * @return O valor.
     */
    int getValue() {
        return value;
    }
}

// ── Serviço de domínio ── SEM "public" (package-private) ──────────────────
/**
 * Encapsula a regra de negócio principal do programa: incrementar um número.
 * A lógica aqui é derivada do parágrafo PROCESS-RECORDS.
 */
class NumberProcessor {

    private static final int INCREMENT_VALUE = 1; // Corresponde a WS-INCREMENT-VALUE

    /**
     * Incrementa o valor de um NumberRecord em 1.
     * Corresponde a: ADD WS-INCREMENT-VALUE TO IN-NUMBER GIVING OUT-NUMBER.
     * @param inputRecord O registro de entrada.
     * @return Um novo NumberRecord com o valor incrementado.
     */
    NumberRecord increment(NumberRecord inputRecord) {
        int newValue = inputRecord.getValue() + INCREMENT_VALUE;
        return new NumberRecord(newValue);
    }
}

// ── Repositório / File Handler ── SEM "public" (package-private) ──────────
/**
 * Responsável por toda a interação com os arquivos de entrada e saída.
 * Abstrai as operações de I/O, como OPEN, READ, WRITE e CLOSE.
 */
class NumberFileHandler {

    // Nomes dos arquivos definidos na seção FILE-CONTROL
    private static final String INPUT_FILE_NAME = "INPUT-FILE.DAT";
    private static final String OUTPUT_FILE_NAME = "OUTPUT-FILE.DAT";

    private BufferedReader reader;
    private BufferedWriter writer;

    /**
     * Abre os arquivos de entrada e saída.
     * Corresponde a: OPEN INPUT INPUT-FILE, OUTPUT OUTPUT-FILE.
     * @throws IOException se ocorrer um erro ao abrir os arquivos.
     */
    void openFiles() throws IOException {
        // Simula a criação dos arquivos se não existirem para evitar erros na primeira execução.
        try (FileWriter fw = new FileWriter(INPUT_FILE_NAME, true)) {
            // Garante que o arquivo de entrada exista.
        }
        reader = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
    }

    /**
     * Lê o próximo registro do arquivo de entrada.
     * Corresponde ao parágrafo READ-INPUT-FILE, incluindo a lógica AT END.
     * @return Um Optional contendo o NumberRecord se a leitura for bem-sucedida,
     *         ou um Optional vazio se o fim do arquivo for alcançado.
     * @throws IOException se ocorrer um erro de leitura.
     */
    Optional<NumberRecord> readNextRecord() throws IOException {
        String line = reader.readLine();
        if (line == null) {
            // Lógica AT END: retorna um indicativo de fim de arquivo.
            return Optional.empty();
        }
        // Assume que cada linha contém um número de 5 dígitos.
        // O trim() ajuda a lidar com espaços em branco extras.
        try {
            int number = Integer.parseInt(line.trim());
            return Optional.of(new NumberRecord(number));
        } catch (NumberFormatException e) {
            System.err.println("Skipping invalid line in input file: " + line);
            return readNextRecord(); // Tenta ler a próxima linha
        }
    }

    /**
     * Escreve um registro no arquivo de saída.
     * Corresponde a: WRITE OUTPUT-RECORD.
     * @param record O registro a ser escrito.
     * @throws IOException se ocorrer um erro de escrita.
     */
    void writeRecord(NumberRecord record) throws IOException {
        // Formata o número para ter 5 dígitos com preenchimento de zeros à esquerda (PIC 9(5)).
        String formattedNumber = String.format("%05d", record.getValue());
        writer.write(formattedNumber);
        writer.newLine();
    }

    /**
     * Fecha os arquivos de entrada e saída.
     * Corresponde a: CLOSE INPUT-FILE, OUTPUT-FILE.
     */
    void closeFiles() {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing input file: " + e.getMessage());
        }
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing output file: " + e.getMessage());
        }
    }
}