package com.converted.cobol;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Convertido do programa COBOL: Increment
 * Program takes a value and increments until greater
 * and prints those values.
 * @author auto-converted
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 A PIC 99(9).
    private int a;
    
    // 01 I PIC 99(9).
    private int i;
    
    // 01 X PIC Z(9)9.
    // This is a numeric-edited field for display. The underlying value is numeric.
    // Java's System.out.println handles the formatting (suppressing leading zeros).
    private int x;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // PROCEDURE DIVISION.
        System.out.println("This is an example using increment.");
        System.out.println("-----------------------------------");
        System.out.println("Please enter a value:");

        // ACCEPT A.
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
            } else {
                System.err.println("Invalid input. Please provide an integer.");
                return; // STOP RUN
            }
        }

        // MOVE 0 TO I.
        i = 0;

        // PERFORM UNTIL I GREATER THAN A
        while (i <= a) {
            // COMPUTE X = I + 1
            x = i + 1;
            
            // DISPLAY X
            System.out.println(x);
            
            // ADD 1 TO I
            i++;
        }
        // END-PERFORM.

        // STOP RUN.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Increment().run();
    }
}