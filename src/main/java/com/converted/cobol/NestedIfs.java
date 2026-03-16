package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Nested-IFs
 * COBOL Author: jiuweigui
 * @author auto-converted
 */
public class NestedIfs {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * <pre>
     * 01 A PIC 99.
     * </pre>
     */
    private int a;

    /**
     * <pre>
     * 01 B PIC 99.
     * </pre>
     */
    private int b;

    /**
     * <pre>
     * 01 RESULT PIC 9999.
     * </pre>
     */
    private int result;

    /**
     * <pre>
     * 01 FORMATTED PIC Z(9).
     * </pre>
     * Mapeado para String para lidar com a formatação de supressão de zeros.
     */
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // O Scanner é usado para emular o verbo ACCEPT do COBOL para entrada do console.
        try (Scanner scanner = new Scanner(System.in)) {
            procedureDivision(scanner);
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde à PROCEDURE DIVISION do programa COBOL.
     * @param scanner O scanner para ler a entrada do usuário.
     */
    private void procedureDivision(Scanner scanner) {
        // DISPLAY "Enter the first value: ".
        System.out.println("Enter the first value: ");
        
        // ACCEPT A.
        a = scanner.nextInt();
        
        // DISPLAY "You entered ", A " as a value.".
        System.out.println("You entered " + a + " as a value.");
        
        // DISPLAY "Please enter the second value: ".
        System.out.println("Please enter the second value: ");
        
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
                // A cláusula PIC Z(9) suprime os zeros à esquerda, o que é o comportamento
                // padrão da conversão de um inteiro para String em Java.
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
        // A execução termina ao final deste método.
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