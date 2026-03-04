package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal, executa a lógica da PROCEDURE DIVISION.
     */
    public void run() {
        // Um Scanner é usado para lidar com o verbo ACCEPT do COBOL para entrada do console.
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
                    // PIC Z(9) suprime zeros à esquerda. String.valueOf() é suficiente aqui.
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
        // STOP RUN é implícito no final do método.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método principal que instancia e executa a classe convertida.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Se ocorrer um erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new NestedIfs().run();
    }
}