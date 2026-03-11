package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Represents the FD UserDatabase record structure.
     * COBOL: 01 UserRecord.
     */
    static class UserRecord {
        // 88 EndOfUserDb VALUE HIGH-VALUES is handled by checking for null from readLine.
        
        // 02 UserId PIC 9(5).
        int userId;
        
        // 02 UserNames.
        UserNames userNames = new UserNames();
        
        // 02 Password.
        Password password = new Password();
        
        // 03 CountryCode PIC XX.
        String countryCode = "";

        /**
         * Parses a fixed-length string record into a UserRecord object.
         * @param line The raw string line from the data file.
         * @return A populated UserRecord object.
         */
        public static UserRecord fromString(String line) {
            UserRecord record = new UserRecord();
            // Ensure line has at least 29 chars to prevent StringIndexOutOfBoundsException
            String safeLine = padRight(line, 29);

            try {
                String userIdStr = safeLine.substring(0, 5).trim();
                if (!userIdStr.isEmpty()) {
                    record.userId = Integer.parseInt(userIdStr);
                } else {
                    record.userId = 0;
                }
            } catch (NumberFormatException e) {
                record.userId = 0; // Default value on parsing error
            }
            
            record.userNames.userName = safeLine.substring(5, 10);
            record.userNames.realName = safeLine.substring(10, 20);
            
            record.password.salt = safeLine.substring(20, 22);
            record.password.hash = safeLine.substring(22, 27);
            
            record.countryCode = safeLine.substring(27, 29);
            
            return record;
        }
    }

    /**
     * Represents the 02 UserNames group item.
     */
    static class UserNames {
        // 03 UserName PIC X(5).
        String userName = "";
        // 03 RealName PIC X(10).
        String realName = "";
    }

    /**
     * Represents the 02 Password group item.
     */
    static class Password {
        // 03 Salt PIC XX.
        String salt = "";
        // 03 Hash PIC X(5).
        String hash = "";

        /**
         * COBOL DISPLAY on a group item concatenates its children.
         */
        @Override
        public String toString() {
            return salt + hash;
        }
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Main execution logic, mirroring the COBOL PROCEDURE DIVISION.
     */
    public void run() {
        try {
            // First part: OPEN OUTPUT, get records, write them.
            writeUsersToFile();
            
            // Second part: OPEN INPUT, read records, display them.
            readAndDisplayUsersFromFile();

        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Handles the first part of the COBOL program:
     * writing user-provided data to the sequential file.
     * @throws IOException if an I/O error occurs.
     */
    private void writeUsersToFile() throws IOException {
        // COBOL: OPEN OUTPUT UserDatabase
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
             Scanner console = new Scanner(System.in)) {
            
            // COBOL: DISPLAY "Enter user details..."
            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            // COBOL: PERFORM GetUserRecord
            String userRecordInput = getUserRecord(console);

            // COBOL: PERFORM UNTIL UserRecord = SPACES
            while (userRecordInput != null && !userRecordInput.isBlank()) {
                // Ensure the record is exactly 29 characters long, padding with spaces.
                String formattedRecord = padRight(userRecordInput, 29);
                
                // COBOL: WRITE UserRecord
                writer.write(formattedRecord);
                writer.newLine();

                // COBOL: PERFORM GetUserRecord (for the next iteration)
                userRecordInput = getUserRecord(console);
            }
            // COBOL: CLOSE UserDatabase (handled by try-with-resources)
        }
    }

    /**
     * Handles the second part of the COBOL program:
     * reading the sequential file and displaying its contents.
     * @throws IOException if an I/O error occurs.
     */
    private void readAndDisplayUsersFromFile() throws IOException {
        // COBOL: OPEN INPUT UserDatabase.
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            boolean endOfUserDb = false;

            // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
            String line = reader.readLine();
            if (line == null) {
                endOfUserDb = true;
            }

            // COBOL: PERFORM UNTIL EndOfUserDb
            while (!endOfUserDb) {
                UserRecord record = UserRecord.fromString(line);
                
                // COBOL: DISPLAY UserId SPACE UserName SPACE Password
                System.out.println(
                    String.format("%05d", record.userId) + " " + 
                    record.userNames.userName + " " + 
                    record.password.toString()
                );

                // COBOL: READ UserDatabase AT END SET EndOfUserDb TO TRUE
                line = reader.readLine();
                if (line == null) {
                    endOfUserDb = true;
                }
            }
            // COBOL: CLOSE UserDatabase (handled by try-with-resources)
        } catch (FileNotFoundException e) {
            // This is a normal condition if the user enters no data in the first step.
            System.out.println("File " + FILENAME + " is empty or was not created.");
        }
    }

    /**
     * Corresponds to the GetUserRecord paragraph.
     * Prompts the user and accepts one line of input.
     * @param console The Scanner to read from.
     * @return The line entered by the user.
     */
    private String getUserRecord(Scanner console) {
        // COBOL: DISPLAY "IIIIIUUUUURRRRRRRRRRSSPPPPPCC"
        System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC");
        // COBOL: ACCEPT UserRecord.
        return console.hasNextLine() ? console.nextLine() : null;
    }

    /**
     * Utility to pad a string on the right with spaces to a specific length.
     * If the string is longer, it's truncated.
     * @param s The string to pad/truncate.
     * @param n The target length.
     * @return The formatted string.
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

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * The main entry point for the application.
     * @param args Command line arguments (not used).
     * @throws Exception if any error occurs during execution.
     */
    public static void main(String[] args) throws Exception {
        new Seqfileexample().run();
        // COBOL: STOP RUN. is implicitly handled by the end of the main method.
    }
}