package com.converted.cobol;

import java.util.Scanner;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Convertido do programa COBOL: Increment
 * Program takes a value and increments until greater and prints those values.
 * @author auto-converted from jiuweigui
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 A PIC 99(9).
    private int a;
    
    // 01 I PIC 99(9).
    private int i;
    
    // 01 X PIC Z(9)9.
    // This is a numeric edited field. In Java, we use a standard integer
    // for calculation, and default formatting handles leading zero suppression.
    private int x;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal, executa a lógica da PROCEDURE DIVISION.
     */
    public void run() {
        // A PROCEDURE DIVISION é mapeada para este método.
        // Usamos try-with-resources para garantir que o Scanner seja fechado.
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
            //   ...
            // END-PERFORM.
            // A condição "UNTIL I GREATER THAN A" é equivalente a "while (i <= a)".
            while (i <= a) {
                // COMPUTE X = I + 1
                x = i + 1;
                
                // DISPLAY X
                System.out.println(x);
                
                // ADD 1 TO I
                i++;
            }
        }
        // STOP RUN.
        // O método termina, finalizando a execução do programa.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main para iniciar a execução do programa.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Lançada em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Increment().run();
    }
}