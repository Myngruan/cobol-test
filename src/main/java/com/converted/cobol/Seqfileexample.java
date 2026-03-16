package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Convertido do programa COBOL: SeqFileExample
 * @author auto-converted
 */
public class Seqfileexample {

    private static final String FILE_NAME = "USERS.DATA";

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Representa a estrutura do registro do arquivo UserDatabase.
     * COBOL: 01 UserRecord.
     */
    static class UserRecord {
        // 02 UserId PIC 9(5).
        int userId;
        // 02 UserNames.
        //    03 UserName PIC X(5).
        String userName = "";
        //    03 RealName PIC X(10).
        String realName = "";
        // 02 Password.
        //    03 Salt PIC XX.
        String salt = "";
        //    03 Hash PIC X(5).
        String hash = "";
        // 03 CountryCode PIC XX. (Assumido como 02)
        String countryCode = "";

        /**
         * Analisa uma linha de texto de comprimento fixo e preenche os campos do registro.
         * @param line A linha lida do arquivo.
         */
        public void parse(String line) {
            if (line == null || line.length() < 29) {
                // Em um cenário real, um tratamento de erro mais robusto seria necessário.
                // Por simplicidade, inicializamos com valores padrão.
                this.userId = 0;
                this.userName = "";
                this.realName = "";
                this.salt = "";
                this.hash = "";
                this.countryCode = "";
                return;
            }

            try {
                this.userId = Integer.parseInt(line.substring(0, 5).trim());
            } catch (NumberFormatException e) {
                this.userId = 0; // Valor padrão em caso de erro de parsing
            }
            this.userName = line.substring(5, 10);
            this.realName = line.substring(10, 20);
            this.salt = line.substring(20, 22);
            this.hash = line.substring(22, 27);
            this.countryCode = line.substring(27, 29);
        }

        /**
         * Retorna a concatenação de Salt e Hash, como no DISPLAY do COBOL.
         * @return A senha completa.
         */
        public String getPassword() {
            return this.salt + this.hash;
        }
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa, convertida da PROCEDURE DIVISION.
     */
    public void run() {
        try {
            // Primeira parte: Escrever dados no arquivo
            writeUserData();
            // Segunda parte: Ler dados do arquivo e exibi-los
            readAndDisplayUserData();
        } catch (IOException e) {
            System.err.println("Ocorreu um erro de I/O: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde à primeira parte da PROCEDURE DIVISION.
     * Abre o arquivo para saída, aceita a entrada do usuário e escreve no arquivo.
     * COBOL:
     *   OPEN OUTPUT UserDatabase
     *   ...
     *   PERFORM UNTIL UserRecord = SPACES
     *   ...
     *   CLOSE UserDatabase
     */
    private void writeUserData() throws IOException {
        // Usando try-with-resources para garantir que os recursos sejam fechados
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            String userRecordInput;
            while (true) {
                // COBOL: PERFORM GetUserRecord
                System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");
                // COBOL: ACCEPT UserRecord
                userRecordInput = consoleReader.readLine();

                // COBOL: PERFORM UNTIL UserRecord = SPACES
                if (userRecordInput == null || userRecordInput.isBlank()) {
                    break;
                }

                // Garante que a string tenha o comprimento fixo, preenchendo com espaços se necessário
                String fixedLengthRecord = String.format("%-29.29s", userRecordInput);

                // COBOL: WRITE UserRecord
                writer.write(fixedLengthRecord);
                writer.newLine();
            }
        } // COBOL: CLOSE UserDatabase (implícito pelo try-with-resources)
    }

    /**
     * Corresponde à segunda parte da PROCEDURE DIVISION.
     * Abre o arquivo para entrada, lê cada registro e exibe partes dele.
     * COBOL:
     *   OPEN INPUT UserDatabase
     *   ...
     *   PERFORM UNTIL EndOfUserDb
     *   ...
     *   CLOSE UserDatabase
     */
    private void readAndDisplayUserData() throws IOException {
        // Usando try-with-resources para garantir que o leitor seja fechado
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            UserRecord userRecord = new UserRecord();
            String line;
            boolean endOfUserDb = false;

            // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
            line = reader.readLine();
            if (line == null) {
                endOfUserDb = true;
            }

            // COBOL: PERFORM UNTIL EndOfUserDb
            while (!endOfUserDb) {
                userRecord.parse(line);

                // COBOL: DISPLAY UserId SPACE UserName SPACE Password
                System.out.println(userRecord.userId + " " + userRecord.userName + " " + userRecord.getPassword());

                // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
                line = reader.readLine();
                if (line == null) {
                    endOfUserDb = true;
                }
            }
        } // COBOL: CLOSE UserDatabase (implícito pelo try-with-resources)
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada principal para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Seqfileexample().run();
        // COBOL: STOP RUN
    }
}