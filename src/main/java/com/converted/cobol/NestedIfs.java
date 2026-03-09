package com.converted.cobol;

import java.util.Scanner;
import java.io.IOException;

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
     * Mapeado para String para lidar com a formatação de supressão de zeros.
     */
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     * Corresponde à PROCEDURE DIVISION.
     */
    public void run() {
        // Usamos try-with-resources para garantir que o Scanner seja fechado.
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Enter the first value: ");
            // COBOL: ACCEPT A.
            a = scanner.nextInt();
            
            System.out.println("You entered " + a + " as a value.");
            
            System.out.print("Please enter the second value: ");
            // COBOL: ACCEPT B.
            b = scanner.nextInt();
            
            System.out.println("You entered " + b + " as a second value.");
            
            // COBOL: COMPUTE RESULT = A + B.
            result = a + b;
            
            // COBOL: IF (A < 10) AND (B > 10) THEN ...
            if (a < 10 && b > 10) {
                // COBOL: IF RESULT > 50 THEN ...
                if (result > 50) {
                    System.out.println("Result is bigger than 50.");
                } else {
                    // COBOL: MOVE RESULT TO FORMATTED
                    // A formatação PIC Z(9) suprime zeros à esquerda, o que
                    // String.valueOf() faz por padrão para inteiros.
                    formatted = String.valueOf(result);
                    
                    // COBOL: DISPLAY FORMATTED
                    System.out.println(formatted);
                }
            } else {
                // COBOL: ELSE DISPLAY "Whatever."
                System.out.println("Whatever.");
            }
            
            // COBOL: STOP RUN.
            // O método termina aqui, equivalente ao STOP RUN.
        } catch (Exception e) {
            System.err.println("An error occurred during execution: " + e.getMessage());
            // Em caso de erro, terminamos o programa com um status de erro.
            System.exit(1);
        }
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