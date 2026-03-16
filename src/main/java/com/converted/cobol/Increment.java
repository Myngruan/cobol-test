package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Increment
 * Program takes a value and increments until greater
 * and prints those values.
 * @author auto-converted from jiuweigui
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 A PIC 99(9).
    private int a;
    
    // 01 I PIC 99(9).
    private int i;
    
    // 01 X PIC Z(9)9.
    // This is a display-formatted variable. In Java, the value is calculated
    // into a standard integer and System.out.println handles the formatting.
    private int x;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            // PROCEDURE DIVISION
            
            // DISPLAY "This is an example using increment.".
            System.out.println("This is an example using increment.");
            
            // DISPLAY "-----------------------------------".
            System.out.println("-----------------------------------");
            
            // DISPLAY "Please enter a value:".
            System.out.println("Please enter a value:");
            
            // ACCEPT A.
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
            } else {
                System.err.println("Error: Input must be a valid integer.");
                return; // Equivalent to STOP RUN on error
            }
            
            // MOVE 0 TO I.
            i = 0;
            
            // PERFORM UNTIL I GREATER THAN A
            // This is equivalent to a while loop that continues as long as i <= a
            while (i <= a) {
                // COMPUTE X = I + 1
                x = i + 1;
                
                // DISPLAY X
                System.out.println(x);
                
                // ADD 1 TO I
                i++;
            }
            // END-PERFORM.
        }
        // STOP RUN.
        // The end of the run() method serves as the STOP RUN.
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