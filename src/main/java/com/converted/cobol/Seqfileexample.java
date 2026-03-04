package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: SeqFileExample
 * @author auto-converted
 */
public class Seqfileexample {

    private static final String FILENAME = "USERS.DATA";

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Mapeia a estrutura do registro FD UserDatabase e 01 UserRecord.
     * O layout de arquivo de largura fixa é gerenciado pelos métodos parse e format.
     */
    static class UserRecord {
        // 88 EndOfUserDb VALUE HIGH-VALUES; é tratado pela verificação de fim de arquivo (null) em Java.
        
        // 02 UserId PIC 9(5).
        public int userId;
        
        // 02 UserNames.
        //    03 UserName PIC X(5).
        public String userName = "";
        //    03 RealName PIC X(10).
        public String realName = "";
        
        // 02 Password.
        //    03 Salt PIC XX.
        public String salt = "";
        //    03 Hash PIC X(5).
        public String hash = "";
        
        // 03 CountryCode PIC XX. (Nível 03 é provavelmente um erro de digitação, tratado como 02)
        public String countryCode = "";

        /**
         * Analisa uma linha de texto de largura fixa e preenche os campos deste registro.
         * @param line A linha de 29 caracteres do arquivo de dados.
         * @return Uma instância de UserRecord preenchida.
         */
        public static UserRecord parse(String line) {
            UserRecord rec = new UserRecord();
            if (line != null && line.length() >= 29) {
                try {
                    rec.userId = Integer.parseInt(line.substring(0, 5).trim());
                } catch (NumberFormatException e) {
                    rec.userId = 0; // Comportamento padrão para dados inválidos
                }
                rec.userName = line.substring(5, 10);
                rec.realName = line.substring(10, 20);
                rec.salt = line.substring(20, 22);
                rec.hash = line.substring(22, 27);
                rec.countryCode = line.substring(27, 29);
            }
            return rec;
        }

        /**
         * Formata os campos do registro em uma única string de largura fixa para escrita em arquivo.
         * @return Uma string de 29 caracteres.
         */
        public String format() {
            return new StringBuilder()
                .append(String.format("%05d", userId))
                .append(padRight(userName, 5))
                .append(padRight(realName, 10))
                .append(padRight(salt, 2))
                .append(padRight(hash, 5))
                .append(padRight(countryCode, 2))
                .toString();
        }

        /**
         * Utilitário para preencher ou truncar uma string para um comprimento exato.
         */
        private static String padRight(String s, int n) {
            if (s == null) s = "";
            return String.format("%-" + n + "s", s).substring(0, n);
        }
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        try {
            // Primeira parte: Escreve dados no arquivo a partir da entrada do usuário.
            populateUserDatabase();
            
            // Segunda parte: Lê os dados do arquivo e os exibe.
            readAndDisplayUserDatabase();

        } catch (IOException e) {
            System.err.println("Ocorreu um erro de I/O: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde à primeira seção do PROCEDURE DIVISION.
     * Abre o arquivo para saída, solicita a entrada do usuário e escreve os registros.
     */
    private void populateUserDatabase() throws IOException {
        // COBOL: OPEN OUTPUT UserDatabase
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
             Scanner console = new Scanner(new InputStreamReader(System.in))) {

            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            // COBOL: PERFORM GetUserRecord
            String consoleInput = getUserRecord(console);

            // COBOL: PERFORM UNTIL UserRecord = SPACES
            while (consoleInput != null && !consoleInput.isBlank()) {
                UserRecord record = UserRecord.parse(consoleInput);
                
                // COBOL: WRITE UserRecord
                writer.write(record.format());
                writer.newLine();

                // COBOL: PERFORM GetUserRecord (para a próxima iteração)
                consoleInput = getUserRecord(console);
            }
        } // COBOL: CLOSE UserDatabase (automático pelo try-with-resources)
    }

    /**
     * Corresponde à segunda seção do PROCEDURE DIVISION.
     * Abre o arquivo para entrada, lê cada registro e exibe os detalhes.
     */
    private void readAndDisplayUserDatabase() throws IOException {
        File dataFile = new File(FILENAME);
        if (!dataFile.exists()) {
            System.out.println("Arquivo " + FILENAME + " não encontrado para leitura.");
            return;
        }

        // COBOL: OPEN INPUT UserDatabase
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            boolean endOfUserDb = false;
            
            // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
            String line = reader.readLine();
            if (line == null) {
                endOfUserDb = true;
            }

            // COBOL: PERFORM UNTIL EndOfUserDb
            while (!endOfUserDb) {
                UserRecord currentRecord = UserRecord.parse(line);
                
                // COBOL: DISPLAY UserId SPACE UserName SPACE Password
                // O grupo 'Password' contém Salt e Hash.
                String passwordGroup = currentRecord.salt + currentRecord.hash;
                System.out.println(currentRecord.userId + " " + currentRecord.userName.trim() + " " + passwordGroup);

                // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
                line = reader.readLine();
                if (line == null) {
                    endOfUserDb = true;
                }
            }
        } // COBOL: CLOSE UserDatabase (automático pelo try-with-resources)
    }

    /**
     * Corresponde ao parágrafo GetUserRecord.
     * Exibe o template e aceita a entrada do usuário.
     * @param console O Scanner para ler da entrada padrão.
     * @return A linha de texto inserida pelo usuário.
     */
    private String getUserRecord(Scanner console) {
        // COBOL: DISPLAY "IIIIIUUUUURRRRRRRRRRSSPPPPPCC"
        System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");
        
        // COBOL: ACCEPT UserRecord
        return console.hasNextLine() ? console.nextLine() : null;
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) throws Exception {
        Seqfileexample program = new Seqfileexample();
        program.run();
        // COBOL: STOP RUN
    }
}