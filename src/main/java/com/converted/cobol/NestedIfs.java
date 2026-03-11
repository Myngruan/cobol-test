package com.converted.cobol;

import java.util.Scanner;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Convertido do programa COBOL: Nested-IFs
 * @author auto-converted
 */
public class NestedIfs {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private int a;
    private int b;
    private int result;
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            // PROCEDURE DIVISION.
            
            System.out.print("Enter the first value: ");
            // ACCEPT A.
            this.a = scanner.nextInt();
            System.out.println("You entered " + this.a + " as a value.");
            
            System.out.print("Please enter the second value: ");
            // ACCEPT B.
            this.b = scanner.nextInt();
            System.out.println("You entered " + this.b + " as a second value.");
            
            // COMPUTE RESULT = A + B.
            this.result = this.a + this.b;
            
            // IF (A < 10) AND (B > 10) THEN
            if (this.a < 10 && this.b > 10) {
                // IF RESULT > 50 THEN
                if (this.result > 50) {
                    System.out.println("Result is bigger than 50.");
                } else {
                    // MOVE RESULT TO FORMATTED
                    // COBOL PIC Z(9) suppresses leading zeros. String.valueOf does this.
                    this.formatted = String.valueOf(this.result);
                    // DISPLAY FORMATTED
                    System.out.println(this.formatted);
                }
                // END-IF
            } else {
                System.out.println("Whatever.");
            }
            // END-IF
        }
        // STOP RUN.
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String[] args) throws Exception {
        new NestedIfs().run();
    }
}