package com.converted.cobol;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Convertido do programa COBOL: PerformThroughExample
 * @author auto-converted
 */
public class Performthroughexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * <pre>
     * 01 RepeatTimes PIC 9 VALUE 7.
     * </pre>
     */
    private int repeatTimes = 7;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: DISPLAY "Program starts here...".
        System.out.println("Program starts here...");
        
        // COBOL: PERFORM 5 TIMES ... END-PERFORM
        for (int i = 0; i < 5; i++) {
            // COBOL: DISPLAY "[+] This is inline version printed 5 times."
            System.out.println("[+] This is inline version printed 5 times.");
        }
        
        // COBOL: DISPLAY "Done with inline next stop out-of-line..."
        System.out.println("Done with inline next stop out-of-line...");
        
        // COBOL: PERFORM SecondVersion RepeatTimes TIMES.
        for (int i = 0; i < repeatTimes; i++) {
            secondVersion();
        }
        
        // COBOL: DISPLAY "Program execution ends here...".
        System.out.println("Program execution ends here...");
        
        // COBOL: STOP RUN.
        // A execução termina ao final do método.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    
    /**
     * Parágrafo SecondVersion.
     */
    private void secondVersion() {
        // COBOL: DISPLAY "[-] This is Out-of-line Perform printed 7 times.".
        System.out.println("[-] This is Out-of-line Perform printed 7 times.");
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main para executar a lógica do programa COBOL.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Performthroughexample().run();
    }
}