package com.converted.cobol;

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
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // PROCEDURE DIVISION.
        System.out.println("Program starts here...");
        
        // PERFORM 5 TIMES
        for (int i = 0; i < 5; i++) {
            System.out.println("[+] This is inline version printed 5 times.");
        }
        // END-PERFORM
        
        System.out.println("Done with inline next stop out-of-line...");
        
        // PERFORM SecondVersion RepeatTimes TIMES.
        for (int i = 0; i < repeatTimes; i++) {
            secondVersion();
        }
        
        System.out.println("Program execution ends here...");
        // STOP RUN.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    
    /**
     * Lógica do parágrafo COBOL "SecondVersion".
     */
    private void secondVersion() {
        // SecondVersion.
        System.out.println("[-] This is Out-of-line Perform printed 7 times.");
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main para executar a aplicação.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new Performthroughexample().run();
    }
}