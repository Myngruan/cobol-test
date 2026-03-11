package com.converted.cobol;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Nested-IFs
 * Example using Nested IFs
 * @author auto-converted (original: jiuweigui)
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
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Lógica principal do programa, convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // Usamos um Scanner para ler a entrada do console, equivalente ao ACCEPT.
        // O try-with-resources garante que o Scanner seja fechado ao final.
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
                    // A formatação PIC Z(9) suprime zeros à esquerda.
                    // String.valueOf(int) em Java tem comportamento similar para exibição.
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
            
        } catch (InputMismatchException e) {
            System.err.println("Erro: Entrada inválida. Por favor, insira apenas números inteiros.");
        }
        // COBOL: STOP RUN.
        // O método run() termina, o que é o equivalente a STOP RUN.
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