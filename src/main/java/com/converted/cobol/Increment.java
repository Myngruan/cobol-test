package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Increment
 * @author auto-converted
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 A PIC 99(9).
    private int a;
    
    // 01 I PIC 99(9).
    private int i;
    
    // 01 X PIC Z(9)9.
    // Este é um campo de exibição. A formatação (supressão de zeros à esquerda)
    // é o comportamento padrão para a impressão de inteiros em Java.
    // Uma variável local será usada para clareza no loop.

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Lógica principal do programa, convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // DISPLAY "This is an example using increment.".
        System.out.println("This is an example using increment.");
        
        // DISPLAY "-----------------------------------".
        System.out.println("-----------------------------------");
        
        // DISPLAY "Please enter a value:".
        System.out.println("Please enter a value:");

        // ACCEPT A.
        // Usando um Scanner para ler a entrada do console.
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
            } else {
                System.err.println("Entrada inválida. Por favor, insira um número inteiro.");
                return; // Equivalente a STOP RUN em caso de erro.
            }
        }

        // MOVE 0 TO I.
        i = 0;

        // PERFORM UNTIL I GREATER THAN A
        //   ...
        // END-PERFORM.
        // A condição "UNTIL I GREATER THAN A" é equivalente a "while (i <= a)".
        while (i <= a) {
            // COMPUTE X = I + 1
            int x = i + 1;

            // DISPLAY X
            System.out.println(x);

            // ADD 1 TO I
            i++;
        }

        // STOP RUN.
        // O método run() termina, o que é o equivalente a STOP RUN.
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