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

    /**
     * COBOL: 01 A PIC 99(9).
     */
    private int a;

    /**
     * COBOL: 01 I PIC 99(9).
     */
    private int i;

    /**
     * COBOL: 01 X PIC Z(9)9.
     * Numeric-edited field for display. In Java, a simple int is used for
     * computation, and standard printing handles leading zero suppression.
     */
    private int x;

    // ── Ponto de entrada ─────────────────────────────────────────────────

    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // COBOL: DISPLAY "This is an example using increment.".
        System.out.println("This is an example using increment.");
        
        // COBOL: DISPLAY "-----------------------------------".
        System.out.println("-----------------------------------");
        
        // COBOL: DISPLAY "Please enter a value:".
        System.out.println("Please enter a value:");

        // COBOL: ACCEPT A.
        // Usamos um Scanner para ler a entrada do console.
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
            } else {
                System.err.println("Invalid input. Please enter a valid integer.");
                // COBOL: STOP RUN (on error)
                return;
            }
        }

        // COBOL: MOVE 0 TO I.
        i = 0;

        // COBOL: PERFORM UNTIL I GREATER THAN A
        // A condição "UNTIL I > A" é equivalente a "while (I <= A)".
        while (i <= a) {
            // COBOL: COMPUTE X = I + 1
            x = i + 1;
            
            // COBOL: DISPLAY X
            System.out.println(x);
            
            // COBOL: ADD 1 TO I
            i = i + 1;
        }
        // COBOL: END-PERFORM.

        // COBOL: STOP RUN.
        // O método run() termina aqui, finalizando a execução.
    }

    // ── main ─────────────────────────────────────────────────────────────

    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Increment().run();
    }
}