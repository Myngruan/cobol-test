package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Increment
 * <p>
 * Program takes a value and increments until greater
 * and prints those values.
 * @author auto-converted
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────

    // 01 A PIC 99(9).
    private int a;

    // 01 I PIC 99(9).
    private int i;

    // 01 X PIC Z(9)9.
    // The formatting part of PIC Z(9)9 is handled by standard Java number-to-string conversion.
    // It is used as a numeric variable in the COMPUTE statement.
    private int x;


    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // A lógica da PROCEDURE DIVISION é executada aqui.
        // Usamos um Scanner para ler a entrada do console, que é o equivalente Java do ACCEPT.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // DISPLAY "This is an example using increment.".
            System.out.println("This is an example using increment.");
            // DISPLAY "-----------------------------------".
            System.out.println("-----------------------------------");
            // DISPLAY "Please enter a value:".
            System.out.println("Please enter a value:");

            // ACCEPT A.
            a = consoleInput.nextInt();

            // MOVE 0 TO I.
            i = 0;

            // PERFORM UNTIL I GREATER THAN A
            // Este loop continua enquanto a condição (I > A) for falsa.
            // Em Java, isso é equivalente a while (i <= a).
            while (i <= a) {
                // COMPUTE X = I + 1
                x = i + 1;

                // DISPLAY X
                System.out.println(x);

                // ADD 1 TO I
                i++;
            }
            // END-PERFORM.
        }
        // STOP RUN.
        // O programa termina quando o método run() é concluído.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main para permitir a execução da classe como um programa autônomo.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Lançada em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Increment().run();
    }
}