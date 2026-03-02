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

    private static final String USER_DATABASE_FILENAME = "USERS.DATA";

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────

    /**
     * Mapeia a estrutura FD UserDatabase e 01 UserRecord do COBOL.
     * Representa um registro de usuário com layout de arquivo de comprimento fixo.
     */
    static class UserRecord {
        // Campo para armazenar a linha bruta lida do console ou arquivo
        private String rawData = "";

        // 02 UserId PIC 9(5).
        int userId;

        // 02 UserNames.
        //    03 UserName PIC X(5).
        String userName = "";
        //    03 RealName PIC X(10).
        String realName = "";

        // 02 Password.
        Password password = new Password();

        // 03 CountryCode PIC XX.
        String countryCode = "";

        /**
         * Mapeia o grupo 02 Password.
         */
        static class Password {
            // 03 Salt PIC XX.
            String salt = "";
            // 03 Hash PIC X(5).
            String hash = "";

            /**
             * Formata o grupo Password para exibição, concatenando seus campos.
             * @return A string combinada de salt e hash.
             */
            @Override
            public String toString() {
                return salt + hash;
            }
        }

        /**
         * Verifica se o registro está vazio, equivalente a `UserRecord = SPACES`.
         * @return true se a linha de dados brutos estiver em branco.
         */
        public boolean isSpaces() {
            return rawData.isBlank();
        }

        /**
         * Analisa uma linha de string de comprimento fixo nos campos do registro.
         * @param line A string de 29 caracteres a ser analisada.
         */
        public void parse(String line) {
            this.rawData = line;
            if (line == null || line.length() < 29) {
                // Garante que não haja exceções em linhas curtas ou nulas
                this.userId = 0;
                this.userName = "";
                this.realName = "";
                this.password.salt = "";
                this.password.hash = "";
                this.countryCode = "";
                return;
            }

            this.userId = parseIntField(line, 0, 5);
            // UserNames group
            this.userName = parseStringField(line, 5, 5);
            this.realName = parseStringField(line, 10, 10);
            // Password group
            this.password.salt = parseStringField(line, 20, 2);
            this.password.hash = parseStringField(line, 22, 5);
            this.countryCode = parseStringField(line, 27, 2);
        }

        /**
         * Formata os campos do registro em uma única string de comprimento fixo para escrita em arquivo.
         * @return A string formatada de 29 caracteres.
         */
        public String format() {
            return String.format("%05d", userId) +
                   String.format("%-5.5s", userName) +
                   String.format("%-10.10s", realName) +
                   String.format("%-2.2s", password.salt) +
                   String.format("%-5.5s", password.hash) +
                   String.format("%-2.2s", countryCode);
        }

        private static String parseStringField(String line, int start, int length) {
            return line.substring(start, start + length);
        }

        private static int parseIntField(String line, int start, int length) {
            try {
                String numericString = line.substring(start, start + length).trim();
                return numericString.isEmpty() ? 0 : Integer.parseInt(numericString);
            } catch (NumberFormatException e) {
                // Em COBOL, dados inválidos em um campo numérico resultam em um estado imprevisível
                // ou zero, dependendo do compilador. Retornar 0 é uma opção segura.
                return 0;
            }
        }
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────

    /**
     * Executa a lógica principal do programa, convertida da PROCEDURE DIVISION.
     */
    public void run() {
        try {
            // Primeira parte: Escreve dados no arquivo a partir da entrada do usuário.
            writeUserData();

            // Segunda parte: Lê os dados do arquivo e os exibe.
            readAndDisplayUserData();

        } catch (IOException e) {
            System.err.println("Ocorreu um erro de I/O: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Lida com a criação do arquivo de dados do usuário.
     * COBOL: OPEN OUTPUT, PERFORM GetUserRecord, WRITE, CLOSE.
     */
    private void writeUserData() throws IOException {
        try (Scanner consoleReader = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATABASE_FILENAME))) {

            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            UserRecord currentUserRecord = getUserRecord(consoleReader);

            // PERFORM UNTIL UserRecord = SPACES
            while (!currentUserRecord.isSpaces()) {
                // WRITE UserRecord
                writer.write(currentUserRecord.format());
                writer.newLine();
                // PERFORM GetUserRecord
                currentUserRecord = getUserRecord(consoleReader);
            }
        } // O try-with-resources fecha o writer e o scanner automaticamente.
    }

    /**
     * Lida com a leitura e exibição dos dados do arquivo do usuário.
     * COBOL: OPEN INPUT, READ, PERFORM UNTIL EndOfUserDb, DISPLAY, CLOSE.
     */
    private void readAndDisplayUserData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATABASE_FILENAME))) {
            UserRecord userRecord = new UserRecord();
            boolean endOfUserDb = false;

            // READ UserDatabase AT END SET EndOfUserDb TO TRUE
            String line = reader.readLine();
            if (line == null) {
                endOfUserDb = true;
            } else {
                userRecord.parse(line);
            }

            // PERFORM UNTIL EndOfUserDb
            while (!endOfUserDb) {
                // DISPLAY UserId SPACE UserName SPACE Password
                System.out.println(userRecord.userId + " " + userRecord.userName + " " + userRecord.password.toString());

                // READ UserDatabase AT END SET EndOfUserDb TO TRUE
                line = reader.readLine();
                if (line == null) {
                    endOfUserDb = true;
                } else {
                    userRecord.parse(line);
                }
            }
        } // O try-with-resources fecha o reader automaticamente.
    }

    /**
     * Mapeia o parágrafo GetUserRecord.
     * Exibe um template e aceita a entrada do usuário.
     * COBOL: DISPLAY, ACCEPT UserRecord.
     * @param consoleReader O Scanner para ler do console.
     * @return Um novo objeto UserRecord preenchido com os dados do usuário.
     */
    private UserRecord getUserRecord(Scanner consoleReader) {
        // DISPLAY "IIIIIUUUUURRRRRRRRRRSSPPPPPCC"
        System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");

        // ACCEPT UserRecord
        String inputLine = consoleReader.hasNextLine() ? consoleReader.nextLine() : "";

        UserRecord record = new UserRecord();
        // Garante que a string tenha 29 caracteres, preenchendo com espaços se for mais curta,
        // para evitar StringIndexOutOfBoundsException durante a análise.
        record.parse(String.format("%-29s", inputLine));
        return record;
    }

    // ── main ─────────────────────────────────────────────────────────────

    /**
     * Ponto de entrada principal para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Seqfileexample().run();
    }
}