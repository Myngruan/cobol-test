package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Convertido do programa COBOL: SeqFileExample
 * Este programa Java emula a funcionalidade do programa COBOL original.
 * Ele primeiro solicita ao usuário que insira registros de usuário, que são
 * salvos em um arquivo de texto de formato fixo ("USERS.DATA").
 * Em seguida, ele lê o arquivo recém-criado e exibe os registros no console.
 * @author auto-converted
 */
public class Seqfileexample {

    private static final String FILENAME = "USERS.DATA";

    /**
     * Ponto de entrada principal do programa.
     * @param args Argumentos de linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro irrecuperável.
     */
    public static void main(String[] args) throws Exception {
        new Seqfileexample().run();
    }

    /**
     * Orquestra a execução do programa, espelhando a PROCEDURE DIVISION do COBOL.
     * @throws IOException se ocorrer um erro de I/O durante a operação do arquivo.
     */
    public void run() throws IOException {
        // Primeira fase: Escrever dados do usuário no arquivo.
        writeUserData();

        // Segunda fase: Ler os dados do arquivo e exibi-los.
        readAndDisplayUserData();
    }

    /**
     * Lida com a criação e escrita no arquivo de dados do usuário.
     * Corresponde à primeira parte da PROCEDURE DIVISION (OPEN OUTPUT até CLOSE).
     * @throws IOException se ocorrer um erro de I/O.
     */
    private void writeUserData() throws IOException {
        // COBOL: OPEN OUTPUT UserDatabase
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            // COBOL: DISPLAY "Enter user details..."
            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            UserRecord recordForWriting = new UserRecord();

            // COBOL: PERFORM GetUserRecord
            String inputLine = getUserRecordFromConsole(consoleReader);

            // COBOL: PERFORM UNTIL UserRecord = SPACES
            // A condição é verificada na linha de entrada bruta. Uma linha vazia termina o loop.
            while (inputLine != null && !inputLine.trim().isEmpty()) {
                recordForWriting.parse(inputLine);
                // COBOL: WRITE UserRecord
                writer.write(recordForWriting.format());
                writer.newLine();

                // COBOL: PERFORM GetUserRecord (para a próxima iteração)
                inputLine = getUserRecordFromConsole(consoleReader);
            }
        } // COBOL: CLOSE UserDatabase (gerenciado pelo try-with-resources)
    }

    /**
     * Lê e exibe os dados do arquivo de usuário.
     * Corresponde à segunda parte da PROCEDURE DIVISION (OPEN INPUT até CLOSE).
     * @throws IOException se ocorrer um erro de I/O.
     */
    private void readAndDisplayUserData() throws IOException {
        System.out.println("\n--- Reading from USERS.DATA ---");
        // COBOL: OPEN INPUT UserDatabase
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            UserRecord recordForReading = new UserRecord();
            String line;

            // Este loop combina o READ inicial e o PERFORM UNTIL do COBOL.
            // A condição AT END é emulada pela verificação de "line != null".
            while ((line = reader.readLine()) != null) {
                recordForReading.parse(line);

                // COBOL: DISPLAY UserId SPACE UserName SPACE Password
                // O grupo "Password" é a concatenação de Salt e Hash.
                System.out.println(
                    String.format("%05d", recordForReading.userId) + " " +
                    recordForReading.userName.trim() + " " +
                    recordForReading.getPassword().trim()
                );
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + FILENAME + ". Execute o programa primeiro para criar o arquivo.");
        } // COBOL: CLOSE UserDatabase (gerenciado pelo try-with-resources)
    }

    /**
     * Emula o parágrafo GetUserRecord do COBOL.
     * Exibe um modelo e lê uma linha da entrada padrão.
     * @param consoleReader O leitor para o console.
     * @return A linha de dados inserida pelo usuário.
     * @throws IOException se ocorrer um erro ao ler do console.
     */
    private String getUserRecordFromConsole(BufferedReader consoleReader) throws IOException {
        // COBOL: DISPLAY "IIIIIUUUUURRRRRRRRRRSSPPPPPCC"
        System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");
        // COBOL: ACCEPT UserRecord
        return consoleReader.readLine();
    }

    // ── Inner class para a estrutura de dados do arquivo ──────────────────
    /**
     * Representa a estrutura do registro no arquivo USERS.DATA,
     * mapeando a definição 01 UserRecord da FILE SECTION do COBOL.
     */
    static class UserRecord {
        // 02 UserId PIC 9(5).
        int userId;
        // 03 UserName PIC X(5).
        String userName = "";
        // 03 RealName PIC X(10).
        String realName = "";
        // 03 Salt PIC XX.
        String salt = "";
        // 03 Hash PIC X(5).
        String hash = "";
        // 03 CountryCode PIC XX. (Nível corrigido para 02)
        String countryCode = "";

        // Comprimento total do registro: 5 + 5 + 10 + 2 + 5 + 2 = 29 caracteres.

        /**
         * Analisa uma string de comprimento fixo do arquivo de dados nos campos deste registro.
         * @param line A string de 29 caracteres a ser analisada.
         */
        public void parse(String line) {
            if (line == null || line.length() < 29) {
                line = String.format("%-29s", (line == null ? "" : line)); // Garante o comprimento para evitar exceções
            }

            try {
                this.userId = Integer.parseInt(line.substring(0, 5).trim());
            } catch (NumberFormatException e) {
                this.userId = 0; // Valor padrão em caso de erro de análise
            }
            this.userName = line.substring(5, 10);
            this.realName = line.substring(10, 20);
            this.salt = line.substring(20, 22);
            this.hash = line.substring(22, 27);
            this.countryCode = line.substring(27, 29);
        }

        /**
         * Formata os campos do registro em uma única string de comprimento fixo para escrita.
         * @return Uma string de 29 caracteres representando o registro.
         */
        public String format() {
            return new StringBuilder(29)
                .append(String.format("%05d", userId))
                .append(String.format("%-5.5s", userName))
                .append(String.format("%-10.10s", realName))
                .append(String.format("%-2.2s", salt))
                .append(String.format("%-5.5s", hash))
                .append(String.format("%-2.2s", countryCode))
                .toString();
        }

        /**
         * Helper para obter os campos de senha combinados para exibição,
         * emulando a referência ao item de grupo "Password" do COBOL.
         * @return A concatenação de salt e hash.
         */
        public String getPassword() {
            return this.salt + this.hash;
        }
    }
}