package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

    private static final String USER_DATABASE_FILENAME = "USERS.DATA";

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────

    /**
     * Mapeia a estrutura FD e 01 UserRecord do COBOL.
     * O layout do registro é um string de 29 caracteres de comprimento fixo.
     */
    static class UserRecord {
        // 02 UserId PIC 9(5).
        private int userId;
        // 02 UserNames.
        private final UserNames userNames = new UserNames();
        // 02 Password.
        private final Password password = new Password();
        // 03 CountryCode PIC XX. (Nível corrigido para 02)
        private String countryCode = "";

        // Classe interna para o grupo UserNames
        static class UserNames {
            // 03 UserName PIC X(5).
            private String userName = "";
            // 03 RealName PIC X(10).
            private String realName = "";

            public String getUserName() {
                return userName;
            }

            public String getRealName() {
                return realName;
            }
        }

        // Classe interna para o grupo Password
        static class Password {
            // 03 Salt PIC XX.
            private String salt = "";
            // 03 Hash PIC X(5).
            private String hash = "";

            public String getSalt() {
                return salt;
            }

            public String getHash() {
                return hash;
            }
            
            public String format() {
                return salt + hash;
            }
        }

        /**
         * Analisa uma linha de texto de comprimento fixo e preenche os campos do registro.
         * @param line A linha de 29 caracteres a ser analisada.
         */
        public void parse(String line) {
            // Garante que a linha tenha o comprimento esperado para evitar exceções
            String paddedLine = fixedLengthString(line, 29);

            try {
                this.userId = Integer.parseInt(paddedLine.substring(0, 5).trim());
            } catch (NumberFormatException e) {
                this.userId = 0; // Valor padrão em caso de erro de formato
            }
            this.userNames.userName = paddedLine.substring(5, 10);
            this.userNames.realName = paddedLine.substring(10, 20);
            this.password.salt = paddedLine.substring(20, 22);
            this.password.hash = paddedLine.substring(22, 27);
            this.countryCode = paddedLine.substring(27, 29);
        }

        /**
         * Formata os campos do registro em uma única string de comprimento fixo.
         * @return A string formatada de 29 caracteres.
         */
        public String format() {
            StringBuilder sb = new StringBuilder(29);
            sb.append(String.format("%05d", userId));
            sb.append(fixedLengthString(userNames.userName, 5));
            sb.append(fixedLengthString(userNames.realName, 10));
            sb.append(fixedLengthString(password.salt, 2));
            sb.append(fixedLengthString(password.hash, 5));
            sb.append(fixedLengthString(countryCode, 2));
            return sb.toString();
        }

        // Getters para acesso aos campos
        public int getUserId() {
            return userId;
        }

        public UserNames getUserNames() {
            return userNames;
        }

        public Password getPassword() {
            return password;
        }

        public String getCountryCode() {
            return countryCode;
        }

        /**
         * Utilitário para garantir que uma string tenha um comprimento fixo,
         * preenchendo com espaços ou truncando conforme necessário.
         * @param s A string de entrada.
         * @param len O comprimento desejado.
         * @return A string de comprimento fixo.
         */
        private static String fixedLengthString(String s, int len) {
            if (s == null) {
                s = "";
            }
            return String.format("%-" + len + "s", s).substring(0, len);
        }
    }

    // ── Campos de trabalho e de arquivo ───────────────────────────────────
    private UserRecord userRecord = new UserRecord();
    private boolean endOfUserDb = false;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa COBOL convertido.
     */
    public void run() {
        try {
            // Primeira parte: Escreve dados no arquivo a partir da entrada do usuário
            populateUserDatabase();
            
            // Segunda parte: Lê os dados do arquivo e os exibe
            readAndDisplayUserDatabase();

        } catch (IOException e) {
            System.err.println("Ocorreu um erro de I/O: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Corresponde à primeira parte da PROCEDURE DIVISION, que coleta dados
     * do usuário e os escreve no arquivo sequencial.
     */
    private void populateUserDatabase() throws IOException {
        // COBOL: OPEN OUTPUT UserDatabase
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATABASE_FILENAME));
             Scanner consoleScanner = new Scanner(System.in)) {
            
            // COBOL: DISPLAY "Enter user details..."
            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            // COBOL: PERFORM GetUserRecord
            String consoleInput = getUserRecord(consoleScanner);
            userRecord.parse(consoleInput);

            // COBOL: PERFORM UNTIL UserRecord = SPACES
            while (consoleInput != null && !consoleInput.isBlank()) {
                // COBOL: WRITE UserRecord
                writer.write(userRecord.format());
                writer.newLine();

                // COBOL: PERFORM GetUserRecord
                consoleInput = getUserRecord(consoleScanner);
                if (consoleInput != null && !consoleInput.isBlank()) {
                    userRecord.parse(consoleInput);
                }
            }
        } // COBOL: CLOSE UserDatabase (automático pelo try-with-resources)
    }

    /**
     * Corresponde à segunda parte da PROCEDURE DIVISION, que lê o arquivo
     * sequencial e exibe os registros.
     */
    private void readAndDisplayUserDatabase() throws IOException {
        // COBOL: OPEN INPUT UserDatabase
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATABASE_FILENAME))) {
            
            // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
            String currentLine = reader.readLine();
            if (currentLine == null) {
                endOfUserDb = true;
            } else {
                userRecord.parse(currentLine);
            }

            // COBOL: PERFORM UNTIL EndOfUserDb
            while (!endOfUserDb) {
                // COBOL: DISPLAY UserId SPACE UserName SPACE Password
                System.out.println(
                    userRecord.getUserId() + " " +
                    userRecord.getUserNames().getUserName().trim() + " " +
                    userRecord.getPassword().format()
                );

                // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
                currentLine = reader.readLine();
                if (currentLine == null) {
                    endOfUserDb = true;
                } else {
                    userRecord.parse(currentLine);
                }
            }
        } // COBOL: CLOSE UserDatabase (automático pelo try-with-resources)
    }

    /**
     * Corresponde ao parágrafo GetUserRecord.
     * Exibe um template e lê uma linha da entrada padrão.
     * @param consoleScanner O scanner para ler do console.
     * @return A linha de texto inserida pelo usuário.
     */
    private String getUserRecord(Scanner consoleScanner) {
        // COBOL: DISPLAY "IIIIIUUUUURRRRRRRRRRSSPPPPPCC"
        System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");
        
        // COBOL: ACCEPT UserRecord
        return consoleScanner.hasNextLine() ? consoleScanner.nextLine() : null;
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método principal que instancia e executa o programa.
     * @param args Argumentos de linha de comando (não utilizados).
     * @throws Exception Se ocorrer um erro durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Seqfileexample().run();
    }
}