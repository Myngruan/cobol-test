package com.converted.cobol;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Increment
 * <p>
 * Program takes a value and increments until greater
 * and prints those values.
 * @author auto-converted (original: jiuweigui)
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────

    // 01 A PIC 99(9).
    private int a;

    // 01 I PIC 99(9).
    private int i;

    // 01 X PIC Z(9)9.
    // This is a numeric-edited field for display. In Java, we will compute
    // the value into a standard integer and let the print function handle formatting.
    // A dedicated field is not necessary as it's computed and used immediately.

    // ── Ponto de entrada ─────────────────────────────────────────────────

    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // A PROCEDURE DIVISION inteira é mapeada para este método.
        try (Scanner scanner = new Scanner(System.in)) {
            // DISPLAY "This is an example using increment.".
            System.out.println("This is an example using increment.");

            // DISPLAY "-----------------------------------".
            System.out.println("-----------------------------------");

            // DISPLAY "Please enter a value:".
            System.out.println("Please enter a value:");

            // ACCEPT A.
            try {
                a = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
                return; // Equivalente a um STOP RUN em caso de erro de entrada
            }

            // MOVE 0 TO I.
            i = 0;

            // PERFORM UNTIL I GREATER THAN A
            // A condição do loop é executada enquanto I <= A.
            while (i <= a) {
                // COMPUTE X = I + 1
                int x = i + 1;

                // DISPLAY X
                // A formatação Z(9)9 suprime zeros à esquerda, que é o comportamento
                // padrão da impressão de inteiros em Java.
                System.out.println(x);

                // ADD 1 TO I
                i++;
            }
            // END-PERFORM.

        }
        // STOP RUN.
        // O método termina, finalizando a execução do programa.
    }

    // ── main ─────────────────────────────────────────────────────────────

    /**
     * Método main padrão para iniciar a execução da classe.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Increment().run();
    }
}