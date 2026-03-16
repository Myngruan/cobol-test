package com.converted.cobol;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Increment
 * Program takes a value and increments until greater
 * and prints those values.
 * @author auto-converted from jiuweigui
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 A PIC 99(9).
    private int a;

    // 01 I PIC 99(9).
    private int i;

    // 01 X PIC Z(9)9.
    // This is a display-formatted field. The underlying value is numeric.
    // An int is used for calculation, and standard output handles formatting.
    private int x;

    // ── Ponto de entrada e lógica principal ───────────────────────────────
    /**
     * Executa a lógica principal do programa COBOL.
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
            try {
                a = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a whole number.");
                // COBOL: STOP RUN (em caso de erro de entrada)
                return;
            }

            // COBOL: MOVE 0 TO I.
            i = 0;

            // COBOL: PERFORM UNTIL I GREATER THAN A
            // A condição UNTIL executa o loop enquanto a condição for falsa.
            // Portanto, o loop continua enquanto I <= A.
            while (i <= a) {
                // COBOL: COMPUTE X = I + 1
                x = i + 1;

                // COBOL: DISPLAY X
                // A formatação PIC Z(9)9 suprime zeros à esquerda, o que é o
                // comportamento padrão ao imprimir um inteiro em Java.
                System.out.println(x);

                // COBOL: ADD 1 TO I
                i++;
            }
            // COBOL: END-PERFORM.
        }
        // COBOL: STOP RUN.
        // A execução do método run termina aqui, finalizando o programa.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Increment().run();
    }
}