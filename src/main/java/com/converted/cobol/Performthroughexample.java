package com.converted.cobol;

/**
 * Convertido do programa COBOL: PerformThroughExample
 * @author auto-converted
 */
public class Performthroughexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 RepeatTimes PIC 9 VALUE 7.
    private int repeatTimes = 7;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Main execution logic, equivalent to the COBOL PROCEDURE DIVISION.
     */
    public void run() {
        // DISPLAY "Program starts here...".
        System.out.println("Program starts here...");

        // PERFORM 5 TIMES
        //     DISPLAY "[+] This is inline version printed 5 times."
        // END-PERFORM
        for (int i = 0; i < 5; i++) {
            System.out.println("[+] This is inline version printed 5 times.");
        }

        // DISPLAY "Done with inline next stop out-of-line..."
        System.out.println("Done with inline next stop out-of-line...");

        // PERFORM SecondVersion RepeatTimes TIMES.
        for (int i = 0; i < repeatTimes; i++) {
            secondVersion();
        }

        // DISPLAY "Program execution ends here...".
        System.out.println("Program execution ends here...");

        // STOP RUN.
        // The run() method concludes, effectively stopping the program execution.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    
    /**
     * Corresponds to the paragraph SecondVersion.
     */
    private void secondVersion() {
        // DISPLAY "[-] This is Out-of-line Perform printed 7 times.".
        System.out.println("[-] This is Out-of-line Perform printed 7 times.");
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Entry point for the Java application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        new Performthroughexample().run();
    }
}