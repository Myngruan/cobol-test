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
    // This is a numeric-edited field. It's used for display formatting.
    // In Java, we'll compute the value into a standard numeric type and then
    // format it for printing, so no direct field is needed.

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // PROCEDURE DIVISION.
        
        System.out.println("This is an example using increment.");
        System.out.println("-----------------------------------");
        System.out.println("Please enter a value:");
        
        // ACCEPT A.
        // Reading from standard input.
        try (Scanner scanner = new Scanner(System.in)) {
            a = scanner.nextInt();
        }
        
        // MOVE 0 TO I.
        i = 0;
        
        // PERFORM UNTIL I GREATER THAN A
        // This translates to a while loop that continues as long as I <= A.
        while (i <= a) {
            // COMPUTE X = I + 1
            int x = i + 1;
            
            // DISPLAY X
            // The COBOL PIC Z(9)9 defines a 10-character field where leading
            // zeros are replaced by spaces. String.format("%10d", ...) achieves this.
            System.out.println(String.format("%10d", x));
            
            // ADD 1 TO I
            i++;
        }
        // END-PERFORM.
        
        // STOP RUN.
        // The program terminates when the run() method completes.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main para executar a aplicação.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Increment().run();
    }
}