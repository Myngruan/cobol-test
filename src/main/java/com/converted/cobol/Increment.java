package com.converted.cobol;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Increment
 * <p>
 * Descrição original:
 * Program takes a value and increments until greater
 * and prints those values.
 *
 * @author auto-converted from jiuweigui
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE SECTION) ──────────────────────
    
    /**
     * COBOL: 01 A PIC 99(9).
     */
    private int a;

    /**
     * COBOL: 01 I PIC 99(9).
     */
    private int i;

    /**
     * COBOL: 01 X PIC Z(9)9.
     * Mapeado para uma variável local no método, pois é usado apenas para
     * cálculo e exibição temporária. A formatação Z(9)9 (supressão de
     * zeros à esquerda) é o comportamento padrão do System.out.println(int).
     */

    // ── Ponto de entrada e lógica principal ───────────────────────────────

    /**
     * Executa a lógica principal do programa, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // O Scanner é usado para ler a entrada do console, substituindo o ACCEPT.
        // O try-with-resources garante que o Scanner seja fechado ao final.
        try (Scanner scanner = new Scanner(System.in)) {
            
            // DISPLAY "This is an example using increment.".
            System.out.println("This is an example using increment.");
            // DISPLAY "-----------------------------------".
            System.out.println("-----------------------------------");
            // DISPLAY "Please enter a value:".
            System.out.println("Please enter a value:");

            // ACCEPT A.
            try {
                a = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
                return; // Equivalente a STOP RUN em caso de erro.
            }

            // MOVE 0 TO I.
            i = 0;

            // PERFORM UNTIL I GREATER THAN A
            //   COMPUTE X = I + 1
            //   DISPLAY X
            //   ADD 1 TO I
            // END-PERFORM.
            // A condição "UNTIL I GREATER THAN A" é traduzida para "while (i <= a)".
            while (i <= a) {
                // COMPUTE X = I + 1
                int x = i + 1;
                
                // DISPLAY X
                System.out.println(x);
                
                // ADD 1 TO I
                i++;
            }
        }
        // STOP RUN.
        // O programa termina naturalmente ao final do método run().
    }

    // ── Método Main ───────────────────────────────────────────────────────

    /**
     * Ponto de entrada padrão para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception para conformidade com o padrão de conversão.
     */
    public static void main(String[] args) throws Exception {
        new Increment().run();
    }
}