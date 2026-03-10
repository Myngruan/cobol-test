package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: SeqFileExample
 * @author auto-converted from jiuweigui
 */
public class Seqfileexample {

    private static final String FILENAME = "USERS.DATA";
    private final Scanner consoleReader = new Scanner(System.in);

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Representa a estrutura do registro do arquivo UserDatabase.
     * COBOL: 01 UserRecord.
     */
    static class UserRecord {
        // 02 UserId      PIC 9(5).
        int userId;
        // 02 UserNames.
        //   03 UserName  PIC X(5).
        String userName = "";
        //   03 RealName  PIC X(10).
        String realName = "";
        // 02 Password.
        //   03 Salt      PIC XX.
        String salt = "";
        //   03 Hash      PIC X(5).
        String hash = "";
        // 02 CountryCode PIC XX. (Nível 03 no original, interpretado como 02)
        String countryCode = "";

        /**
         * Formata o registro em uma string de largura fixa para gravação em arquivo.
         * O comprimento total é 5 + 5 + 10 + 2 + 5 + 2 = 29 caracteres.
         * @return A string formatada.
         */
        public String format() {
            return String.format("%05d", userId) +
                   String.format("%-5.5s", userName) +
                   String.format("%-10.10s", realName) +
                   String.format("%-2.2s", salt) +
                   String.format("%-5.5s", hash) +
                   String.format("%-2.2s", countryCode);
        }

        /**
         * Analisa uma linha de string de largura fixa e preenche os campos do registro.
         * @param line A linha lida do arquivo ou console.
         */
        public void parse(String line) {
            // Garante que a linha tenha o comprimento mínimo para evitar exceções,
            // preenchendo com espaços como o COBOL faria.
            String paddedLine = String.format("%-29s", line == null ? "" : line);

            try {
                this.userId = Integer.parseInt(paddedLine.substring(0, 5).trim());
            } catch (NumberFormatException e) {
                this.userId = 0;
            }
            this.userName = paddedLine.substring(5, 10);
            this.realName = paddedLine.substring(10, 20);
            this.salt = paddedLine.substring(20, 22);
            this.hash = paddedLine.substring(22, 27);
            this.countryCode = paddedLine.substring(27, 29);
        }

        /**
         * Retorna a senha completa (salt + hash).
         * @return A senha concatenada.
         */
        public String getPassword() {
            return this.salt + this.hash;
        }
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        try {
            // Primeira parte: Escrever dados no arquivo
            writeUserData();
            
            // Segunda parte: Ler dados do arquivo e exibir
            readAndDisplayUserData();

        } catch (IOException e) {
            System.err.println("Ocorreu um erro de I/O: " + e.getMessage());
            e.printStackTrace();
        } finally {
            consoleReader.close();
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde à primeira parte do PROCEDURE DIVISION.
     * Abre o arquivo para saída, solicita dados do usuário e os grava.
     * COBOL: OPEN OUTPUT, PERFORM GetUserRecord, WRITE, CLOSE.
     */
    private void writeUserData() throws IOException {
        // COBOL: OPEN OUTPUT UserDatabase
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            // O loop `PERFORM UNTIL UserRecord = SPACES` é implementado
            // lendo uma linha e verificando se está em branco.
            while (true) {
                // COBOL: PERFORM GetUserRecord
                UserRecord currentUserRecord = getUserRecordFromConsole();
                
                // COBOL: UNTIL UserRecord = SPACES
                // A condição de parada é uma entrada em branco do usuário.
                if (currentUserRecord == null) {
                    break;
                }
                
                // COBOL: WRITE UserRecord
                writer.write(currentUserRecord.format());
                writer.newLine();
            }
        } // COBOL: CLOSE UserDatabase (implícito pelo try-with-resources)
    }

    /**
     * Corresponde à segunda parte do PROCEDURE DIVISION.
     * Abre o arquivo para entrada, lê cada registro e exibe partes dele.
     * COBOL: OPEN INPUT, READ, PERFORM UNTIL EndOfUserDb, DISPLAY, CLOSE.
     */
    private void readAndDisplayUserData() throws IOException {
        System.out.println("\n--- Reading data from file ---");
        
        // COBOL: OPEN INPUT UserDatabase.
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            
            // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
            //        PERFORM UNTIL EndOfUserDb
            // A estrutura `while ((line = reader.readLine()) != null)` é o
            // equivalente idiomático em Java.
            while ((line = reader.readLine()) != null) {
                UserRecord userRecord = new UserRecord();
                userRecord.parse(line);
                
                // COBOL: DISPLAY UserId SPACE UserName SPACE Password
                System.out.println(
                    String.format("%05d", userRecord.userId) + " " +
                    userRecord.userName.trim() + " " +
                    userRecord.getPassword().trim()
                );
            }
        } // COBOL: CLOSE UserDatabase (implícito pelo try-with-resources)
    }

    /**
     * Corresponde ao parágrafo GetUserRecord.
     * Exibe um modelo e lê a entrada do usuário do console.
     * @return Um UserRecord preenchido ou null se a entrada for vazia.
     */
    private UserRecord getUserRecordFromConsole() {
        // COBOL: DISPLAY "IIIIIUUUUURRRRRRRRRRSSPPPPPCC"
        System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");
        
        // COBOL: ACCEPT UserRecord.
        String inputLine = consoleReader.nextLine();

        if (inputLine == null || inputLine.isBlank()) {
            return null; // Sinaliza o fim da entrada de dados
        }

        UserRecord record = new UserRecord();
        record.parse(inputLine);
        return record;
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String[] args) throws Exception {
        new Seqfileexample().run();
    }
}