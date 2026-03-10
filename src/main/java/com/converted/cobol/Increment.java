package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Increment
 * Program takes a value and increments until greater
 * and prints those values.
 * @author auto-converted from jiuweigui
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * <pre>
     * 01 A PIC 99(9).
     * </pre>
     */
    private int a;

    /**
     * <pre>
     * 01 I PIC 99(9).
     * </pre>
     */
    private int i;

    /**
     * <pre>
     * 01 X PIC Z(9)9.
     * </pre>
     * O formato de edição (Z) é tratado na exibição.
     */
    private int x;


    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // A PROCEDURE DIVISION é mapeada aqui.
        // Usamos um Scanner para ler a entrada do console, que é o equivalente moderno do ACCEPT.
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("This is an example using increment.");
            System.out.println("-----------------------------------");
            System.out.println("Please enter a value:");

            // COBOL: ACCEPT A.
            a = scanner.nextInt();

            // COBOL: MOVE 0 TO I.
            i = 0;

            // COBOL: PERFORM UNTIL I GREATER THAN A
            // A condição "UNTIL I > A" se traduz em um loop "while (i <= a)".
            while (i <= a) {
                // COBOL: COMPUTE X = I + 1
                x = i + 1;

                // COBOL: DISPLAY X
                // System.out.println lida com a conversão de int para String.
                // O formato PIC Z(9)9 suprime zeros à esquerda, que é o comportamento padrão de println.
                System.out.println(x);

                // COBOL: ADD 1 TO I
                i++;
            }
            // COBOL: END-PERFORM.
        }
        // COBOL: STOP RUN.
        // O método run() termina, finalizando a execução do programa.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Increment().run();
    }
}