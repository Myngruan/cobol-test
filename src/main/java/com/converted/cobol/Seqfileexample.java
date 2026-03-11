package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Convertido do programa COBOL: SeqFileExample
 * Este programa Java emula a funcionalidade do programa COBOL original,
 * que primeiro solicita ao usuário que insira registros de usuário e os grava
 * em um arquivo sequencial de linha ("USERS.DATA"), e depois lê e exibe
 * os registros desse mesmo arquivo.
 *
 * @author auto-converted from jiuweigui's COBOL code
 */
public class Seqfileexample {

    // ── Constantes ────────────────────────────────────────────────────────
    private static final String USER_DATABASE_FILENAME = "USERS.DATA";

    // ── Estruturas de Dados (do FILE SECTION) ─────────────────────────────
    private UserRecord userRecord = new UserRecord();

    /**
     * Representa a estrutura do registro 01 UserRecord no arquivo UserDatabase.
     */
    static class UserRecord {
        // 88 EndOfUserDb VALUE HIGH-VALUES; é tratado por verificação de fim de arquivo (null) em Java.
        int userId; // 02 UserId PIC 9(5).
        UserNames userNames = new UserNames(); // 02 UserNames.
        Password password = new Password(); // 02 Password.
        String countryCode = ""; // 03 CountryCode PIC XX. (Tratado como 02 para estrutura correta)

        /**
         * Analisa uma linha de texto de comprimento fixo e preenche os campos deste registro.
         * @param line A linha de 29 caracteres lida do arquivo ou do console.
         */
        public void parse(String line) {
            if (line == null || line.length() < 29) {
                // Emula o comportamento de dados inválidos, limpando o registro.
                this.userId = 0;
                this.userNames.userName = "";
                this.userNames.realName = "";
                this.password.salt = "";
                this.password.hash = "";
                this.countryCode = "";
                return;
            }

            int offset = 0;
            try {
                this.userId = Integer.parseInt(line.substring(offset, offset + 5).trim());
            } catch (NumberFormatException e) {
                this.userId = 0; // COBOL moveria ZEROS em caso de erro de conversão.
            }
            offset += 5;

            this.userNames.userName = line.substring(offset, offset + 5);
            offset += 5;

            this.userNames.realName = line.substring(offset, offset + 10);
            offset += 10;

            this.password.salt = line.substring(offset, offset + 2);
            offset += 2;

            this.password.hash = line.substring(offset, offset + 5);
            offset += 5;

            this.countryCode = line.substring(offset, offset + 2);
        }

        /**
         * Formata os dados do registro em uma string de comprimento fixo para gravação.
         * @return Uma string de 29 caracteres representando o registro.
         */
        public String formatForFile() {
            return String.format("%05d", userId) +
                   String.format("%-5.5s", userNames.userName) +
                   String.format("%-10.10s", userNames.realName) +
                   String.format("%-2.2s", password.salt) +
                   String.format("%-5.5s", password.hash) +
                   String.format("%-2.2s", countryCode);
        }
    }

    /**
     * Grupo 02 UserNames.
     */
    static class UserNames {
        String userName = ""; // 03 UserName PIC X(5).
        String realName = ""; // 03 RealName PIC X(10).
    }

    /**
     * Grupo 02 Password.
     */
    static class Password {
        String salt = ""; // 03 Salt PIC XX.
        String hash = ""; // 03 Hash PIC X(5).
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa, dividida em fases de escrita e leitura.
     */
    public void run() {
        try {
            // Primeira fase: Escrever dados no arquivo
            populateUserDatabase();

            // Segunda fase: Ler e exibir dados do arquivo
            readAndDisplayUserDatabase();

        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
            e.printStackTrace();
        }
        // Fim da execução, análogo ao STOP RUN.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde à primeira parte da PROCEDURE DIVISION.
     * Abre o arquivo para saída, solicita dados do usuário em um loop e os grava.
     * @throws IOException se ocorrer um erro de I/O.
     */
    private void populateUserDatabase() throws IOException {
        // COBOL: OPEN OUTPUT UserDatabase
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATABASE_FILENAME));
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            // COBOL: DISPLAY "Enter user details..."
            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            // COBOL: PERFORM GetUserRecord
            String inputLine = getUserRecord(consoleReader);

            // COBOL: PERFORM UNTIL UserRecord = SPACES
            while (inputLine != null && !inputLine.trim().isEmpty()) {
                userRecord.parse(inputLine);

                // COBOL: WRITE UserRecord
                writer.write(userRecord.formatForFile());
                writer.newLine();

                // COBOL: PERFORM GetUserRecord (dentro do loop)
                inputLine = getUserRecord(consoleReader);
            }
        } // COBOL: CLOSE UserDatabase (automático pelo try-with-resources)
    }

    /**
     * Corresponde à segunda parte da PROCEDURE DIVISION.
     * Abre o arquivo para entrada, lê cada registro em um loop e exibe partes dele.
     * @throws IOException se ocorrer um erro de I/O.
     */
    private void readAndDisplayUserDatabase() throws IOException {
        // COBOL: OPEN INPUT UserDatabase.
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATABASE_FILENAME))) {
            boolean endOfUserDb = false;

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
                // O display do grupo "Password" mostra a concatenação de seus filhos.
                System.out.println(
                    userRecord.userId + " " +
                    userRecord.userNames.userName + " " +
                    userRecord.password.salt + userRecord.password.hash
                );

                // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE (dentro do loop)
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
     * Exibe um prompt e lê uma linha da entrada padrão.
     * @param consoleReader O leitor para o console.
     * @return A linha de texto inserida pelo usuário.
     * @throws IOException se ocorrer um erro de leitura.
     */
    private String getUserRecord(BufferedReader consoleReader) throws IOException {
        // COBOL: DISPLAY "IIIIIUUUUURRRRRRRRRRSSPPPPPCC"
        System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");
        // COBOL: ACCEPT UserRecord
        return consoleReader.readLine();
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada principal para a aplicação Java.
     * @param args Argumentos de linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro irrecuperável.
     */
    public static void main(String[] args) throws Exception {
        new Seqfileexample().run();
    }
}