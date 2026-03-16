package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Nested-IFs
 * @author auto-converted
 */
public class NestedIfs {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private int a;
    private int b;
    private int result;
    private String formatted; // COBOL: 01 FORMATTED PIC Z(9).

    // ── Ponto de entrada ─────────────────────────────────────────────────
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the first value: ");
            a = scanner.nextInt();
            System.out.println("You entered " + a + " as a value.");

            System.out.print("Please enter the second value: ");
            b = scanner.nextInt();
            System.out.println("You entered " + b + " as a second value.");

            result = a + b;

            if (a < 10 && b > 10) {
                if (result > 50) {
                    System.out.println("Result is bigger than 50.");
                } else {
                    // MOVE RESULT TO FORMATTED
                    // PIC Z(9) suppresses leading zeros, which String.valueOf does by default.
                    formatted = String.valueOf(result);
                    System.out.println(formatted);
                }
            } else {
                System.out.println("Whatever.");
            }
        }
        // STOP RUN is implicit at the end of the method.
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        new NestedIfs().run();
    }
}