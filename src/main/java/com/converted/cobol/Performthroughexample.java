package com.converted.cobol;

/**
 * Convertido do programa COBOL: PerformThroughExample
 * @author auto-converted (original: jiuweigui)
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
     * Corresponde à PROCEDURE DIVISION.
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
        // A execução do método termina aqui, equivalente ao STOP RUN.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    
    /**
     * Corresponde ao parágrafo COBOL 'SecondVersion'.
     */
    private void secondVersion() {
        // COBOL: DISPLAY "[-] This is Out-of-line Perform printed 7 times.".
        System.out.println("[-] This is Out-of-line Perform printed 7 times.");
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main para executar o programa convertido.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performthroughexample().run();
    }
}