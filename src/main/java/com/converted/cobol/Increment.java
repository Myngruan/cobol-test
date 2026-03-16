package com.converted.cobol;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Increment
 * COBOL Author: jiuweigui
 * 
 * <p>Program takes a value and increments until greater
 * and prints those values.
 *
 * @author auto-converted
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────

    /**
     * COBOL: 01 A PIC 99(9).
     */
    private int a;

    /**
     * COBOL: 01 I PIC 99(9).
     */
    private int i;

    // A variável X (PIC Z(9)9) é usada para exibição formatada.
    // Em Java, isso é tratado como uma variável local no momento da impressão.

    // ── Ponto de entrada ─────────────────────────────────────────────────

    /**
     * Executa a lógica principal convertida da PROCEDURE DIVISION do COBOL.
     */
    public void run() {
        // O try-with-resources garante que o Scanner seja fechado automaticamente.
        try (Scanner scanner = new Scanner(System.in)) {
            // COBOL: DISPLAY "This is an example using increment.".
            System.out.println("This is an example using increment.");

            // COBOL: DISPLAY "-----------------------------------".
            System.out.println("-----------------------------------");

            // COBOL: DISPLAY "Please enter a value:".
            System.out.println("Please enter a value:");

            // COBOL: ACCEPT A.
            // Lendo a entrada do usuário e tratando possíveis erros de formato.
            try {
                a = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
                // Equivalente a um STOP RUN em caso de erro de entrada.
                return;
            }

            // COBOL: MOVE 0 TO I.
            i = 0;

            // COBOL: PERFORM UNTIL I GREATER THAN A
            // A condição "UNTIL I > A" se traduz para "while (!(i > a))" ou "while (i <= a)".
            while (i <= a) {
                // COBOL: COMPUTE X = I + 1
                int x = i + 1;

                // COBOL: DISPLAY X
                // A formatação PIC Z(9)9 (supressão de zeros à esquerda) é o comportamento
                // padrão para a impressão de inteiros em Java.
                System.out.println(x);

                // COBOL: ADD 1 TO I
                i++;
            }
            // COBOL: END-PERFORM.

        } // O Scanner é fechado aqui.

        // COBOL: STOP RUN.
        // O método run() termina, finalizando a execução do programa.
    }

    // ── main ─────────────────────────────────────────────────────────────

    /**
     * Ponto de entrada principal para a aplicação Java.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Increment().run();
    }
}