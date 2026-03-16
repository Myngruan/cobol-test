package com.converted.cobol;

import java.math.BigDecimal;

/**
 * Convertido do programa COBOL: PerformThroughExample
 * @author auto-converted
 */
public class Performthroughexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * COBOL: 01 RepeatTimes PIC 9 VALUE 7.
     */
    private int repeatTimes = 7;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
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
        // COBOL: SecondVersion.
        System.out.println("[-] This is Out-of-line Perform printed 7 times.");
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main para permitir a execução da classe.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performthroughexample().run();
    }
}