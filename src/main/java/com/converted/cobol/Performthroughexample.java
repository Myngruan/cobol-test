package com.converted.cobol;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Convertido do programa COBOL: PerformThroughExample
 * @author auto-converted
 */
public class Performthroughexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private int repeatTimes = 7;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    public void run() {
        // COBOL: PROCEDURE DIVISION.
        System.out.println("Program starts here...");
        
        // COBOL: PERFORM 5 TIMES ... END-PERFORM
        for (int i = 0; i < 5; i++) {
            System.out.println("[+] This is inline version printed 5 times.");
        }
        
        System.out.println("Done with inline next stop out-of-line...");
        
        // COBOL: PERFORM SecondVersion RepeatTimes TIMES.
        for (int i = 0; i < repeatTimes; i++) {
            secondVersion();
        }
        
        System.out.println("Program execution ends here...");
        
        // COBOL: STOP RUN.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    
    /**
     * Corresponde ao parágrafo COBOL "SecondVersion".
     */
    private void secondVersion() {
        // COBOL: DISPLAY "[-] This is Out-of-line Perform printed 7 times.".
        System.out.println("[-] This is Out-of-line Perform printed 7 times.");
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        new Performthroughexample().run();
    }
}