package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiFunction;

/**
 * Convertido do programa COBOL: SeqFileExample
 * @author auto-converted
 */
public class Seqfileexample {

    private static final String USER_DATA_FILE = "USERS.DATA";

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────

    /**
     * Mapeia a estrutura FD UserDatabase e 01 UserRecord do COBOL.
     */
    static class UserRecord {
        // 02 UserId PIC 9(5).
        int userId = 0;

        // 02 UserNames.
        UserNames userNames = new UserNames();

        // 02 Password.
        Password password = new Password();

        // 03 CountryCode PIC XX. (Tratado como 02 para estrutura lógica)
        String countryCode = "";

        /**
         * Mapeia o grupo 02 UserNames.
         */
        static class UserNames {
            // 03 UserName PIC X(5).
            String userName = "";
            // 03 RealName PIC X(10).
            String realName = "";
        }

        /**
         * Mapeia o grupo 02 Password.
         */
        static class Password {
            // 03 Salt PIC XX.
            String salt = "";
            // 03 Hash PIC X(5).
            String hash = "";
        }

        /**
         * Analisa uma linha de texto de largura fixa e preenche o registro.
         * @param line A linha lida do arquivo ou console.
         * @return Uma instância de UserRecord preenchida.
         */
        public static UserRecord parse(String line) {
            if (line == null) {
                return null;
            }
            UserRecord record = new UserRecord();

            // Helper para extrair substrings de forma segura, evitando IndexOutOfBoundsException
            BiFunction<Integer, Integer, String> safeSubstring = (start, end) ->
                line.length() > start ? line.substring(start, Math.min(end, line.length())) : "";

            String userIdStr = safeSubstring.apply(0, 5).trim();
            try {
                record.userId = userIdStr.isEmpty() ? 0 : Integer.parseInt(userIdStr);
            } catch (NumberFormatException e) {
                record.userId = 0; // Valor padrão em caso de erro de formatação
            }

            record.userNames.userName = safeSubstring.apply(5, 10);
            record.userNames.realName = safeSubstring.apply(10, 20);
            record.password.salt = safeSubstring.apply(20, 22);
            record.password.hash = safeSubstring.apply(22, 27);
            record.countryCode = safeSubstring.apply(27, 29);

            return record;
        }

        /**
         * Formata o registro em uma string de largura fixa para gravação.
         * @return A string formatada.
         */
        public String format() {
            StringBuilder sb = new StringBuilder(29);
            // Formata e trunca/preenche cada campo para garantir a largura fixa
            sb.append(String.format("%05d", userId));
            sb.append(String.format("%-5.5s", userNames.userName));
            sb.append(String.format("%-10.10s", userNames.realName));
            sb.append(String.format("%-2.2s", password.salt));
            sb.append(String.format("%-5.5s", password.hash));
            sb.append(String.format("%-2.2s", countryCode));
            return sb.toString();
        }
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────

    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        try {
            writeUserData();
            readAndDisplayUserData();
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde à primeira parte da PROCEDURE DIVISION:
     * OPEN OUTPUT, PERFORM de entrada de dados, WRITE e CLOSE.
     * @throws IOException se ocorrer um erro de I/O.
     */
    private void writeUserData() throws IOException {
        // COBOL: OPEN OUTPUT UserDatabase
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATA_FILE));
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            // COBOL: DISPLAY "..."
            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            // COBOL: PERFORM GetUserRecord
            // COBOL: PERFORM UNTIL UserRecord = SPACES
            while (true) {
                // Lógica do parágrafo GetUserRecord
                System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");
                // COBOL: ACCEPT UserRecord
                String inputLine = consoleReader.readLine();

                if (inputLine == null || inputLine.isBlank()) {
                    // Condição de saída do loop (UserRecord = SPACES)
                    break;
                }

                UserRecord record = UserRecord.parse(inputLine);
                if (record != null) {
                    // COBOL: WRITE UserRecord
                    writer.write(record.format());
                    writer.newLine();
                }
            }
        } // COBOL: CLOSE UserDatabase (implícito pelo try-with-resources)
    }

    /**
     * Corresponde à segunda parte da PROCEDURE DIVISION:
     * OPEN INPUT, READ em loop, DISPLAY e CLOSE.
     * @throws IOException se ocorrer um erro de I/O.
     */
    private void readAndDisplayUserData() throws IOException {
        System.out.println("\n--- Reading data from file ---");

        // COBOL: OPEN INPUT UserDatabase
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE))) {
            String line;

            // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
            // COBOL: PERFORM UNTIL EndOfUserDb
            while ((line = reader.readLine()) != null) {
                UserRecord record = UserRecord.parse(line);
                if (record != null) {
                    // COBOL: DISPLAY UserId SPACE UserName SPACE Password
                    // Em COBOL, exibir um grupo concatena seus filhos.
                    String passwordDisplay = record.password.salt + record.password.hash;
                    // Assumindo que "UserName" se refere ao campo e não ao grupo.
                    System.out.printf("%d %s %s%n",
                        record.userId,
                        record.userNames.userName.trim(),
                        passwordDisplay.trim());
                }
                // A próxima iteração do loop corresponde ao segundo READ dentro do PERFORM.
            }
        } // COBOL: CLOSE UserDatabase (implícito pelo try-with-resources)
    }

    // ── main ─────────────────────────────────────────────────────────────

    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro durante a execução.
     */
    public static void main(String[] args) throws Exception {
        // COBOL: Início da PROCEDURE DIVISION
        new Seqfileexample().run();
        // COBOL: STOP RUN
    }
}