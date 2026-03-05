package com.converted.cobol;

import java.util.Scanner;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
    private String formatted;

    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // O Scanner é usado para emular o verbo ACCEPT do COBOL para entrada do console.
        // O try-with-resources garante que o scanner seja fechado corretamente.
        try (Scanner scanner = new Scanner(System.in)) {
            
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
                    // A cláusula PIC Z(9) em COBOL é para formatação de exibição,
                    // suprimindo zeros à esquerda. O verbo DISPLAY em um campo
                    // editado numericamente geralmente remove os espaços em branco
                    // à esquerda. String.valueOf() alcança um resultado similar.
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
        // O método run() termina, finalizando a execução do programa.
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