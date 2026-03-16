package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Increment
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
    // This is a numeric-edited field for display. The computed value is stored here.
    private int x;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // A PROCEDURE DIVISION é mapeada aqui.
        // Usamos try-with-resources para garantir que o Scanner seja fechado.
        try (Scanner scanner = new Scanner(System.in)) {
            // DISPLAY "This is an example using increment.".
            System.out.println("This is an example using increment.");
            
            // DISPLAY "-----------------------------------".
            System.out.println("-----------------------------------");
            
            // DISPLAY "Please enter a value:".
            System.out.println("Please enter a value:");
            
            // ACCEPT A.
            // O COBOL abendaria com entrada não numérica.
            // Integer.parseInt lançará uma NumberFormatException, um comportamento análogo.
            String input = scanner.nextLine();
            a = Integer.parseInt(input.trim());
            
            // MOVE 0 TO I.
            i = 0;
            
            // PERFORM UNTIL I GREATER THAN A
            // A condição é "até que I > A", então o loop continua enquanto I <= A.
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
        // O método run() termina, o que é equivalente a STOP RUN.
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