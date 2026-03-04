package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Nested-IFs
 * @author auto-converted from jiuweigui
 */
public class NestedIfs {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 A PIC 99.
    private int a;

    // 01 B PIC 99.
    private int b;

    // 01 RESULT PIC 9999.
    private int result;

    // 01 FORMATTED PIC Z(9).
    // Em Java, um String armazena o valor formatado. A formatação em si
    // ocorre durante a atribuição (MOVE).
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal convertida da PROCEDURE DIVISION do COBOL.
     */
    public void run() {
        // O Scanner é o equivalente moderno do ACCEPT do COBOL para entrada de console.
        // Usamos try-with-resources para garantir que o scanner seja fechado.
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
                    // ELSE
                    // MOVE RESULT TO FORMATTED
                    // A PIC Z(9) em COBOL suprime zeros à esquerda. A conversão
                    // padrão de int para String em Java já tem esse comportamento.
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
        // O fim do método run() encerra a execução do programa.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main para iniciar a execução do programa.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new NestedIfs().run();
    }
}