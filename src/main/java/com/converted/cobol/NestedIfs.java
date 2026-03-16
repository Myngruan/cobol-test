package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Nested-IFs
 * @author auto-converted
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
    // A formatação Z(9) (supressão de zeros à esquerda) é melhor representada
    // por uma String em Java, que armazena o valor já formatado.
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Lógica principal do programa, convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // O Scanner substitui o ACCEPT do COBOL para entrada do console.
        // Usamos try-with-resources para garantir que o scanner seja fechado.
        try (Scanner consoleInput = new Scanner(System.in)) {
            
            // COBOL: DISPLAY "Enter the first value: ".
            System.out.print("Enter the first value: ");
            
            // COBOL: ACCEPT A.
            a = consoleInput.nextInt();
            
            // COBOL: DISPLAY "You entered ", A " as a value.".
            System.out.println("You entered " + a + " as a value.");
            
            // COBOL: DISPLAY "Please enter the second value: ".
            System.out.print("Please enter the second value: ");
            
            // COBOL: ACCEPT B.
            b = consoleInput.nextInt();
            
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
                    // A conversão padrão de int para String em Java já suprime zeros à esquerda,
                    // emulando o comportamento de PIC Z(9).
                    formatted = String.valueOf(result);
                    
                    // COBOL: DISPLAY FORMATTED
                    System.out.println(formatted);
                }
                // COBOL: END-IF
            } else {
                // COBOL: ELSE DISPLAY "Whatever."
                System.out.println("Whatever.");
            }
            // COBOL: END-IF
        }
        
        // COBOL: STOP RUN.
        // O método run() termina, efetivamente parando a execução do programa.
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