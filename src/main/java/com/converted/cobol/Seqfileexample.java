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

    private static final String USER_DATABASE_FILE = "USERS.DATA";

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Representa a estrutura do registro no arquivo UserDatabase.
     * COBOL: 01 UserRecord.
     */
    static class UserRecord {
        
        /**
         * COBOL: 02 UserNames.
         */
        static class UserNames {
            String userName = ""; // PIC X(5)
            String realName = ""; // PIC X(10)
        }

        /**
         * COBOL: 02 Password.
         */
        static class Password {
            String salt = ""; // PIC XX
            String hash = ""; // PIC X(5)
        }

        int userId = 0; // PIC 9(5)
        UserNames userNames = new UserNames();
        Password password = new Password();
        String countryCode = ""; // PIC XX

        /**
         * Analisa uma linha de texto de comprimento fixo e preenche os campos do registro.
         * @param line A linha de 29 caracteres lida do arquivo.
         */
        public void parse(String line) {
            if (line == null || line.length() < 29) {
                // Em caso de linha inválida, zera os campos para evitar erros.
                this.userId = 0;
                this.userNames.userName = "";
                this.userNames.realName = "";
                this.password.salt = "";
                this.password.hash = "";
                this.countryCode = "";
                return;
            }

            int pos = 0;
            try {
                // Extrai UserId (5 caracteres)
                this.userId = Integer.parseInt(line.substring(pos, pos + 5).trim());
            } catch (NumberFormatException e) {
                System.err.println("Aviso: Formato numérico inválido para UserId. Usando 0.");
                this.userId = 0;
            }
            pos += 5;

            // Extrai UserNames (5 + 10 caracteres)
            this.userNames.userName = line.substring(pos, pos + 5);
            pos += 5;
            this.userNames.realName = line.substring(pos, pos + 10);
            pos += 10;

            // Extrai Password (2 + 5 caracteres)
            this.password.salt = line.substring(pos, pos + 2);
            pos += 2;
            this.password.hash = line.substring(pos, pos + 5);
            pos += 5;

            // Extrai CountryCode (2 caracteres)
            this.countryCode = line.substring(pos, pos + 2);
        }
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        try {
            // Primeira parte: Coleta dados do usuário e escreve no arquivo.
            collectAndWriteUserData();
            
            // Segunda parte: Lê os dados do arquivo e os exibe.
            readAndDisplayUserData();

        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde à primeira parte do PROCEDURE DIVISION:
     * OPEN OUTPUT, PERFORM de coleta e escrita, e CLOSE.
     * @throws IOException se ocorrer um erro de escrita no arquivo.
     */
    private void collectAndWriteUserData() throws IOException {
        // COBOL: OPEN OUTPUT UserDatabase
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATABASE_FILE));
             Scanner consoleScanner = new Scanner(System.in)) {

            // COBOL: DISPLAY "Enter user details..."
            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            String userInput;
            while (true) {
                // COBOL: PERFORM GetUserRecord
                System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");
                userInput = consoleScanner.nextLine();

                // COBOL: PERFORM UNTIL UserRecord = SPACES
                if (userInput == null || userInput.isBlank()) {
                    break; // Encerra o loop se a entrada for vazia.
                }

                // COBOL: WRITE UserRecord
                writer.write(userInput);
                writer.newLine();
            }
        } // COBOL: CLOSE UserDatabase (automático pelo try-with-resources)
    }

    /**
     * Corresponde à segunda parte do PROCEDURE DIVISION:
     * OPEN INPUT, PERFORM de leitura e exibição, e CLOSE.
     * @throws IOException se ocorrer um erro de leitura do arquivo.
     */
    private void readAndDisplayUserData() throws IOException {
        UserRecord userRecord = new UserRecord();
        boolean endOfUserDb = false;

        // COBOL: OPEN INPUT UserDatabase
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATABASE_FILE))) {
            
            // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
            String currentLine = reader.readLine();
            if (currentLine == null) {
                endOfUserDb = true;
            }

            // COBOL: PERFORM UNTIL EndOfUserDb
            while (!endOfUserDb) {
                userRecord.parse(currentLine);

                // COBOL: DISPLAY UserId SPACE UserName SPACE Password
                // A exibição de um grupo (Password) concatena seus subitens.
                String passwordDisplay = userRecord.password.salt + userRecord.password.hash;
                System.out.println(userRecord.userId + " " + userRecord.userNames.userName + " " + passwordDisplay);

                // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE (dentro do loop)
                currentLine = reader.readLine();
                if (currentLine == null) {
                    endOfUserDb = true;
                }
            }
        } // COBOL: CLOSE UserDatabase (automático pelo try-with-resources)
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada principal para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro durante a execução.
     */
    public static void main(String[] args) throws Exception {
        // COBOL: STOP RUN é efetivamente o final do método run().
        new Seqfileexample().run();
    }
}