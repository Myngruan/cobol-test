package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Nested-IFs
 * @author auto-converted
 */
public class NestedIfs {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // COBOL: 01 A PIC 99.
    private int a;
    
    // COBOL: 01 B PIC 99.
    private int b;
    
    // COBOL: 01 RESULT PIC 9999.
    private int result;
    
    // A variável "FORMATTED PIC Z(9)" é um campo de edição para exibição.
    // Sua funcionalidade é replicada formatando o valor no momento da impressão,
    // em vez de usar um campo de membro separado.

    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     * Corresponde à PROCEDURE DIVISION.
     */
    public void run() {
        // O Scanner é usado para replicar o verbo ACCEPT do COBOL para entrada do console.
        // O bloco try-with-resources garante que o scanner seja fechado corretamente.
        try (Scanner scanner = new Scanner(System.in)) {
            
            // COBOL: DISPLAY "Enter the first value: ".
            System.out.println("Enter the first value: ");
            // COBOL: ACCEPT A.
            a = scanner.nextInt();
            
            // COBOL: DISPLAY "You entered ", A " as a value.".
            System.out.println("You entered " + a + " as a value.");
            
            // COBOL: DISPLAY "Please enter the second value: ".
            System.out.println("Please enter the second value: ");
            // COBOL: ACCEPT B.
            b = scanner.nextInt();
            
            // COBOL: DISPLAY "You entered ", B " as a second value.".
            System.out.println("You entered " + b + " as a second value.");
            
            // COBOL: COMPUTE RESULT = A + B.
            result = a + b;
            
            // COBOL: IF (A < 10) AND (B > 10) THEN
            if (a < 10 && b > 10) {
                // COBOL: IF RESULT > 50 THEN
                if (result > 50) {
                    // COBOL: DISPLAY "Result is bigger than 50."
                    System.out.println("Result is bigger than 50.");
                } else {
                    // COBOL: MOVE RESULT TO FORMATTED
                    // COBOL: DISPLAY FORMATTED
                    // A formatação PIC Z(9) suprime zeros à esquerda, o que
                    // String.valueOf(int) faz por padrão em Java.
                    System.out.println(String.valueOf(result));
                }
            // COBOL: ELSE
            } else {
                // COBOL: DISPLAY "Whatever."
                System.out.println("Whatever.");
            }
            // COBOL: END-IF
        }
        // COBOL: STOP RUN.
        // A execução termina quando o método run() é concluído.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new NestedIfs().run();
    }
}