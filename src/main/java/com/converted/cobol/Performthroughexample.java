package com.converted.cobol;

import java.math.BigDecimal;

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
     * Ponto de entrada principal que executa a lógica da PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: PROCEDURE DIVISION.
        System.out.println("Program starts here...");
        
        // COBOL: PERFORM 5 TIMES
        for (int i = 0; i < 5; i++) {
            System.out.println("[+] This is inline version printed 5 times.");
        }
        // COBOL: END-PERFORM
        
        System.out.println("Done with inline next stop out-of-line...");
        
        // COBOL: PERFORM SecondVersion RepeatTimes TIMES.
        for (int i = 0; i < repeatTimes; i++) {
            secondVersion();
        }
        
        System.out.println("Program execution ends here...");
        
        // COBOL: STOP RUN.
        // A execução termina quando o método run() retorna.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    
    /**
     * Corresponde ao parágrafo COBOL 'SecondVersion'.
     * <pre>
     * SecondVersion.
     *     DISPLAY "[-] This is Out-of-line Perform printed 7 times.".
     * </pre>
     */
    private void secondVersion() {
        System.out.println("[-] This is Out-of-line Perform printed 7 times.");
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método principal para executar o programa convertido.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performthroughexample().run();
    }
}