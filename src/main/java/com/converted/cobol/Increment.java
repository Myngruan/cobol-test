package com.converted.cobol;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Convertido do programa COBOL: Increment
 * Program takes a value and increments until greater
 * and prints those values.
 * @author auto-converted (original: jiuweigui)
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    // As variáveis COBOL A, I, e X são mapeadas para variáveis locais
    // no método run() pois seu escopo é limitado a essa execução.

    // ── Ponto de entrada ─────────────────────────────────────────────────
    public void run() {
        // O try-with-resources garante que o Scanner seja fechado.
        try (Scanner scanner = new Scanner(System.in)) {
            // COBOL: DISPLAY "This is an example using increment.".
            System.out.println("This is an example using increment.");
            // COBOL: DISPLAY "-----------------------------------".
            System.out.println("-----------------------------------");
            // COBOL: DISPLAY "Please enter a value:".
            System.out.println("Please enter a value:");

            // COBOL: ACCEPT A.
            // A PIC 99(9) -> int
            int a = 0;
            try {
                a = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
                return; // Equivalente a STOP RUN em caso de erro
            }

            // COBOL: MOVE 0 TO I.
            // I PIC 99(9) -> int
            int i = 0;

            // COBOL: PERFORM UNTIL I GREATER THAN A
            // A condição UNTIL I > A é convertida para while (i <= a)
            while (i <= a) {
                // COBOL: COMPUTE X = I + 1
                // X PIC Z(9)9 é um campo de exibição. A formatação (supressão de zeros)
                // é o comportamento padrão de System.out.println para inteiros.
                int x = i + 1;

                // COBOL: DISPLAY X
                System.out.println(x);

                // COBOL: ADD 1 TO I
                i++;
            }
            // COBOL: END-PERFORM.
        }
        // COBOL: STOP RUN.
        // O método termina, finalizando a execução.
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String[] args) throws Exception {
        new Increment().run();
    }
}