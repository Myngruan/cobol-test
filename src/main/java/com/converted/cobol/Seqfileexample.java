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

    // ── Constantes ────────────────────────────────────────────────────────
    private static final String FILE_NAME = "USERS.DATA";
    private static final int RECORD_LENGTH = 29;

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Representa a estrutura do registro UserRecord no arquivo UserDatabase.
     * Comprimento total: 29 bytes.
     */
    static class UserRecord {
        // 02 UserId      PIC 9(5).
        private int userId;
        // 02 UserNames.
        //    03 UserName PIC X(5).
        private String userName = "";
        //    03 RealName PIC X(10).
        private String realName = "";
        // 02 Password.
        //    03 Salt     PIC XX.
        private String salt = "";
        //    03 Hash     PIC X(5).
        private String hash = "";
        // 03 CountryCode PIC XX. (Nível 03 é provavelmente um erro, tratado como 02)
        private String countryCode = "";

        // Campo para armazenar a linha original para a verificação de SPACES
        private String rawData = "";

        /**
         * Analisa uma linha de dados de comprimento fixo e preenche os campos do registro.
         * @param line A linha de dados a ser analisada.
         */
        public void parse(String line) {
            this.rawData = line;
            if (line == null || line.length() < RECORD_LENGTH) {
                // Emula MOVE SPACES TO UserRecord para entradas inválidas/curtas
                this.userId = 0;
                this.userName = "     ";
                this.realName = "          ";
                this.salt = "  ";
                this.hash = "     ";
                this.countryCode = "  ";
                this.rawData = String.format("%-" + RECORD_LENGTH + "s", line == null ? "" : line);
                return;
            }

            try {
                this.userId = Integer.parseInt(line.substring(0, 5).trim());
            } catch (NumberFormatException e) {
                this.userId = 0; // Valor padrão em caso de erro de formato
            }
            this.userName = line.substring(5, 10);
            this.realName = line.substring(10, 20);
            this.salt = line.substring(20, 22);
            this.hash = line.substring(22, 27);
            this.countryCode = line.substring(27, 29);
        }

        /**
         * Formata os dados do registro em uma string de comprimento fixo para gravação em arquivo.
         * @return Uma string de 29 caracteres.
         */
        public String formatForFile() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%05d", userId));
            sb.append(padRight(userName, 5));
            sb.append(padRight(realName, 10));
            sb.append(padRight(salt, 2));
            sb.append(padRight(hash, 5));
            sb.append(padRight(countryCode, 2));
            return sb.toString();
        }

        /**
         * Verifica se o registro é equivalente a SPACES.
         * @return true se a linha de dados original estiver em branco.
         */
        public boolean isSpaces() {
            return rawData.trim().isEmpty();
        }

        // Getters para exibição
        public int getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return salt + hash;
        }

        /**
         * Helper para preencher ou truncar uma string para um comprimento fixo.
         */
        private static String padRight(String s, int n) {
            if (s == null) {
                s = "";
            }
            if (s.length() > n) {
                return s.substring(0, n);
            }
            return String.format("%-" + n + "s", s);
        }
    }

    // ── Campos de trabalho e de arquivo ───────────────────────────────────
    private UserRecord userRecord = new UserRecord();
    private boolean endOfUserDb = false;
    private Scanner consoleScanner = new Scanner(System.in);

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa, convertida da PROCEDURE DIVISION.
     */
    public void run() {
        try {
            // Fase de escrita (OPEN OUTPUT, WRITE, CLOSE)
            writeUsersToFile();

            // Fase de leitura (OPEN INPUT, READ, DISPLAY, CLOSE)
            readAndDisplayUsers();

        } catch (IOException e) {
            System.err.println("Ocorreu um erro de I/O: " + e.getMessage());
            e.printStackTrace();
        } finally {
            consoleScanner.close();
        }
        // COBOL: STOP RUN
    }

    /**
     * Corresponde à primeira parte da PROCEDURE DIVISION:
     * Coleta dados do usuário e os grava no arquivo.
     */
    private void writeUsersToFile() throws IOException {
        // COBOL: OPEN OUTPUT UserDatabase
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            // COBOL: DISPLAY "Enter user details..."
            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            // COBOL: PERFORM GetUserRecord
            getUserRecord();

            // COBOL: PERFORM UNTIL UserRecord = SPACES
            while (!userRecord.isSpaces()) {
                // COBOL: WRITE UserRecord
                writer.write(userRecord.formatForFile());
                writer.newLine();

                // COBOL: PERFORM GetUserRecord
                getUserRecord();
            }
        } // COBOL: CLOSE UserDatabase (automático pelo try-with-resources)
    }

    /**
     * Corresponde à segunda parte da PROCEDURE DIVISION:
     * Lê os dados do arquivo e os exibe.
     */
    private void readAndDisplayUsers() throws IOException {
        // COBOL: OPEN INPUT UserDatabase
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
            String line = reader.readLine();
            if (line == null) {
                endOfUserDb = true;
            } else {
                userRecord.parse(line);
            }

            // COBOL: PERFORM UNTIL EndOfUserDb
            while (!endOfUserDb) {
                // COBOL: DISPLAY UserId SPACE UserName SPACE Password
                System.out.println(userRecord.getUserId() + " " + userRecord.getUserName().trim() + " " + userRecord.getPassword().trim());

                // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
                line = reader.readLine();
                if (line == null) {
                    endOfUserDb = true;
                } else {
                    userRecord.parse(line);
                }
            }
        } // COBOL: CLOSE UserDatabase (automático pelo try-with-resources)
    }

    /**
     * Corresponde ao parágrafo GetUserRecord.
     * Lê uma linha do console e a carrega no objeto userRecord.
     */
    private void getUserRecord() {
        // COBOL: DISPLAY "IIIIIUUUUURRRRRRRRRRSSPPPPPCC"
        System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");
        // COBOL: ACCEPT UserRecord
        String inputLine = consoleScanner.nextLine();
        // Garante que a linha tenha o comprimento esperado para o parse, preenchendo com espaços
        String paddedInput = String.format("%-" + RECORD_LENGTH + "s", inputLine);
        userRecord.parse(paddedInput);
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        try {
            new Seqfileexample().run();
        } catch (Exception e) {
            System.err.println("Erro inesperado na execução: " + e.getMessage());
            e.printStackTrace();
        }
    }
}