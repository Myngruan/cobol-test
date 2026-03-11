package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Nested-IFs
 * Example using Nested IFs
 * @author auto-converted from jiuweigui
 */
public class NestedIfs {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
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
     * Mapeado para String para lidar com a formatação de supressão de zero.
     */
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            // COBOL: DISPLAY "Enter the first value: ".
            System.out.print("Enter the first value: ");
            
            // COBOL: ACCEPT A.
            a = scanner.nextInt();
            
            // COBOL: DISPLAY "You entered ", A " as a value.".
            System.out.println("You entered " + a + " as a value.");
            
            // COBOL: DISPLAY "Please enter the second value: ".
            System.out.print("Please enter the second value: ");
            
            // COBOL: ACCEPT B.
            b = scanner.nextInt();
            
            // COBOL: DISPLAY "You entered ", B " as a second value.".
            System.out.println("You entered " + b + " as a second value.");
            
            // COBOL: COMPUTE RESULT = A + B.
            result = a + b;
            
            // COBOL: IF (A < 10) AND (B > 10) THEN ...
            if (a < 10 && b > 10) {
                // COBOL: IF RESULT > 50 THEN ...
                if (result > 50) {
                    // COBOL: DISPLAY "Result is bigger than 50."
                    System.out.println("Result is bigger than 50.");
                } else {
                    // COBOL: MOVE RESULT TO FORMATTED
                    // A conversão para String em Java remove naturalmente os zeros à esquerda.
                    formatted = String.valueOf(result);
                    
                    // COBOL: DISPLAY FORMATTED
                    System.out.println(formatted);
                }
                // COBOL: END-IF (inner)
            } else {
                // COBOL: ELSE DISPLAY "Whatever."
                System.out.println("Whatever.");
            }
            // COBOL: END-IF (outer)
        }
        // COBOL: STOP RUN.
        // O método run() termina, efetivamente parando a execução.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new NestedIfs().run();
    }
}