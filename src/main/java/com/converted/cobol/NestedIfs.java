package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Nested-IFs
 * @author auto-converted
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
     * Mapeado para String para lidar com a formatação de saída.
     */
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // O try-with-resources garante que o Scanner seja fechado,
        // análogo ao gerenciamento de recursos em COBOL.
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
                    // A cláusula PIC Z(9) suprime zeros à esquerda.
                    // String.valueOf() em Java tem um efeito similar para exibição.
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
            
            // STOP RUN.
            // Em Java, o método simplesmente termina.
        } catch (Exception e) {
            System.err.println("Ocorreu um erro durante a execução: " + e.getMessage());
            // Em um cenário real, um tratamento de erro mais robusto seria necessário.
        }
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new NestedIfs().run();
    }
}