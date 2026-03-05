package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Nested-IFs
 * @author auto-converted from jiuweigui
 */
public class NestedIfs {

    // ── Campos de trabalho (WORKING-STORAGE SECTION) ──────────────────────
    
    /**
     * COBOL: 01 A PIC 99.
     */
    private int a;

    /**
     * COBOL: 01 B PIC 99.
     */
    private int b;

    /**
     * COBOL: 01 RESULT PIC 9999.
     */
    private int result;

    /**
     * COBOL: 01 FORMATTED PIC Z(9).
     * Usado para formatação de saída. Em Java, é representado como String.
     */
    private String formatted;

    // ── Ponto de entrada e lógica principal ───────────────────────────────

    /**
     * Executa a lógica principal convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // O Scanner é usado para emular o verbo ACCEPT do COBOL para entrada do console.
        // O try-with-resources garante que o Scanner seja fechado corretamente.
        try (Scanner scanner = new Scanner(System.in)) {
            
            // DISPLAY "Enter the first value: ".
            System.out.print("Enter the first value: ");
            
            // ACCEPT A.
            a = scanner.nextInt();
            
            // DISPLAY "You entered ", A " as a value.".
            System.out.println("You entered " + a + " as a value.");
            
            // DISPLAY "Please enter the second value: ".
            System.out.print("Please enter the second value: ");
            
            // ACCEPT B.
            b = scanner.nextInt();
            
            // DISPLAY "You entered ", B " as a second value.".
            System.out.println("You entered " + b + " as a second value.");
            
            // COMPUTE RESULT = A + B.
            result = a + b;
            
            // IF (A < 10) AND (B > 10) THEN
            if (a < 10 && b > 10) {
                // IF RESULT > 50 THEN
                if (result > 50) {
                    // DISPLAY "Result is bigger than 50."
                    System.out.println("Result is bigger than 50.");
                } else {
                    // MOVE RESULT TO FORMATTED
                    // A cláusula PIC Z(9) suprime os zeros à esquerda.
                    // String.valueOf() atinge o mesmo objetivo para exibição.
                    formatted = String.valueOf(result);
                    
                    // DISPLAY FORMATTED
                    System.out.println(formatted);
                }
                // END-IF
            } else {
                // ELSE DISPLAY "Whatever."
                System.out.println("Whatever.");
            }
            // END-IF
        }
        // STOP RUN.
        // O programa termina naturalmente ao final do método run().
    }

    // ── Método main para inicialização ───────────────────────────────────
    
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new NestedIfs().run();
    }
}