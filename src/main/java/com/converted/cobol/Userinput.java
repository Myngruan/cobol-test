package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Represents the 01 UserName group item from WORKING-STORAGE.
     */
    static class UserName {
        // 02 Name PIC X(10).
        String name = "";
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private UserName userName = new UserName();

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executes the main logic of the COBOL program.
     */
    public void run() {
        // The PROCEDURE DIVISION logic is executed here.
        
        // COBOL: DISPLAY "What is your name?".
        System.out.println("What is your name?");

        // COBOL: ACCEPT UserName.
        // We use a Scanner to read from standard input. For a simple console app,
        // it's common practice not to close the scanner on System.in.
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // Emulate COBOL's fixed-length, left-justified, space-padded string behavior.
        // A PIC X(10) field is always 10 characters. Input is truncated or padded.
        if (input.length() > 10) {
            userName.name = input.substring(0, 10);
        } else {
            // Pad with spaces to the right to reach a length of 10.
            userName.name = (input + "          ").substring(0, 10);
        }

        // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
        // The SPACE keyword adds a single space between the literal and the variable.
        System.out.println("It's nice to meet you " + userName.name);

        // COBOL: STOP RUN.
        // The program execution ends when the run() method completes.
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        new Userinput().run();
    }
}