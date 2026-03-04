package com.converted.cobol;

import java.util.Scanner;
import java.io.IOException; // Not used in this simple program, but included for template consistency
import java.math.BigDecimal; // Not used in this simple program, but included for template consistency
import java.math.RoundingMode; // Not used in this simple program, but included for template consistency

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
    // A String is used to hold the formatted number.
    // The Z(9) format (leading zero suppression) is the default behavior
    // of Java's String.valueOf(int).
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // A classe Scanner é usada para ler a entrada do console, substituindo o verbo ACCEPT.
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
            
            // COBOL: IF (A < 10) AND (B > 10) THEN
            if (a < 10 && b > 10) {
                // COBOL: IF RESULT > 50 THEN
                if (result > 50) {
                    // COBOL: DISPLAY "Result is bigger than 50."
                    System.out.println("Result is bigger than 50.");
                } else {
                    // COBOL: MOVE RESULT TO FORMATTED
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
        // O método run() termina, finalizando a execução da lógica do programa.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main padrão para iniciar a execução da classe.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new NestedIfs().run();
    }
}