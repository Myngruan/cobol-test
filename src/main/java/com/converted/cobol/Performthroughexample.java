package com.converted.cobol;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Convertido de: PerformThroughExample
 * AUTHOR. jiuweigui.
 */
public class Performthroughexample {

    // WORKING-STORAGE SECTION
    private int repeatTimes = 7; // 01 RepeatTimes PIC 9 VALUE 7.

    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     * Equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // PROCEDURE DIVISION.
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
    }

    /**
     * Equivalente ao parágrafo COBOL 'SecondVersion'.
     */
    private void secondVersion() {
        // SecondVersion.
        // DISPLAY "[-] This is Out-of-line Perform printed 7 times.".
        System.out.println("[-] This is Out-of-line Perform printed 7 times.");
    }

    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performthroughexample().run();
    }
}