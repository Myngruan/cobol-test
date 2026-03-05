package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: SeqFileExample
 * @author auto-converted
 */
public class Seqfileexample {

    private static final String FILENAME = "USERS.DATA";

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Representa a estrutura do registro do arquivo UserDatabase.
     * COBOL:
     * 01 UserRecord.
     *    02 UserId      PIC 9(5).
     *    02 UserNames.
     *       03 UserName PIC X(5).
     *       03 RealName PIC X(10).
     *    02 Password.
     *       03 Salt     PIC XX.
     *       03 Hash     PIC X(5).
     *    03 CountryCode PIC XX.
     */
    static class UserRecord {
        int userId;
        String userName = "";
        String realName = "";
        String salt = "";
        String hash = "";
        String countryCode = "";

        /**
         * Analisa uma linha de texto de formato fixo e a converte em um objeto UserRecord.
         * @param line A linha de 29 caracteres do arquivo de dados.
         * @return Um objeto UserRecord preenchido.
         */
        public static UserRecord fromString(String line) {
            UserRecord rec = new UserRecord();
            if (line != null && line.length() >= 29) {
                try {
                    // UserId: pos 0, length 5
                    rec.userId = Integer.parseInt(line.substring(0, 5).trim());
                } catch (NumberFormatException e) {
                    rec.userId = 0; // Valor padrão em caso de erro de formatação
                }
                // UserName: pos 5, length 5
                rec.userName = line.substring(5, 10);
                // RealName: pos 10, length 10
                rec.realName = line.substring(10, 20);
                // Salt: pos 20, length 2
                rec.salt = line.substring(20, 22);
                // Hash: pos 22, length 5
                rec.hash = line.substring(22, 27);
                // CountryCode: pos 27, length 2
                rec.countryCode = line.substring(27, 29);
            }
            return rec;
        }
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa, que consiste em duas fases:
     * 1. Coletar dados do usuário e gravá-los em um arquivo.
     * 2. Ler os dados do arquivo e exibi-los no console.
     */
    public void run() {
        try {
            populateUserDatabase();
            readAndDisplayUserDatabase();
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde à primeira parte da PROCEDURE DIVISION.
     * Abre o arquivo para escrita, solicita dados ao usuário em um loop e
     * grava cada registro no arquivo.
     * @throws IOException se ocorrer um erro de I/O.
     */
    private void populateUserDatabase() throws IOException {
        // COBOL: OPEN OUTPUT UserDatabase
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
             Scanner consoleScanner = new Scanner(System.in)) {

            // COBOL: DISPLAY "Enter user details..."
            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            // COBOL: PERFORM UNTIL UserRecord = SPACES
            while (true) {
                // COBOL: PERFORM GetUserRecord
                String userInput = getUserRecord(consoleScanner);

                if (userInput.isBlank()) {
                    break; // Fim da entrada de dados
                }

                // COBOL: WRITE UserRecord
                writer.write(userInput);
                writer.newLine();
            }
        } // COBOL: CLOSE UserDatabase (implícito pelo try-with-resources)
    }

    /**
     * Corresponde ao parágrafo GetUserRecord.
     * Exibe um modelo de entrada e aceita uma linha de dados do console.
     * @param scanner O Scanner para ler a entrada do console.
     * @return A linha de texto inserida pelo usuário.
     */
    private String getUserRecord(Scanner scanner) {
        // COBOL: DISPLAY "IIIIIUUUUURRRRRRRRRRSSPPPPPCC"
        System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");
        // COBOL: ACCEPT UserRecord
        return scanner.nextLine();
    }

    /**
     * Corresponde à segunda parte da PROCEDURE DIVISION.
     * Abre o arquivo para leitura, lê cada registro em um loop e exibe
     * partes do registro no console.
     * @throws IOException se ocorrer um erro de I/O.
     */
    private void readAndDisplayUserDatabase() throws IOException {
        System.out.println("\n--- Reading from User Database ---");
        // COBOL: OPEN INPUT UserDatabase
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;

            // COBOL: READ UserDatabase AT END ... PERFORM UNTIL EndOfUserDb
            while ((line = reader.readLine()) != null) {
                UserRecord record = UserRecord.fromString(line);

                // COBOL: DISPLAY UserId SPACE UserName SPACE Password
                // O grupo 'Password' é a concatenação de 'Salt' e 'Hash'.
                System.out.printf("%05d %s %s%n",
                        record.userId,
                        record.userName,
                        record.salt + record.hash);
            }
        } // COBOL: CLOSE UserDatabase (implícito pelo try-with-resources)
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método principal que inicia a execução do programa.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro irrecuperável.
     */
    public static void main(String[] args) throws Exception {
        new Seqfileexample().run();
    }
}