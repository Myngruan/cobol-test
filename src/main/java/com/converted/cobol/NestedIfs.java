package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Nested-IFs
 * @author auto-converted (original: jiuweigui)
 */
public class NestedIfs {

    // ── Campos de trabalho (WORKING-STORAGE SECTION) ──────────────────────
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
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // O try-with-resources garante que o Scanner seja fechado automaticamente.
        try (Scanner scanner = new Scanner(System.in)) {
            performProcedureDivision(scanner);
        }
        // COBOL: STOP RUN.
        // O fim do método run() encerra a execução, equivalente ao STOP RUN.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    /**
     * Mapeia a PROCEDURE DIVISION do programa COBOL.
     * @param scanner Instância para ler a entrada do usuário.
     */
    private void performProcedureDivision(Scanner scanner) {
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
                // A formatação PIC Z(9) suprime zeros à esquerda, o que é o comportamento
                // padrão da conversão de um inteiro para String em Java.
                formatted = String.valueOf(result);
                // COBOL: DISPLAY FORMATTED
                System.out.println(formatted);
            }
        } else {
            // COBOL: ELSE DISPLAY "Whatever."
            System.out.println("Whatever.");
        }
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método principal para iniciar a execução do programa.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new NestedIfs().run();
    }
}