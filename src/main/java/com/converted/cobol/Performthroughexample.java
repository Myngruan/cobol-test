package com.converted.cobol;

/**
 * Convertido do programa COBOL: PerformThroughExample
 * @author auto-converted
 */
public class Performthroughexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * Mapeia: 01 RepeatTimes PIC 9 VALUE 7.
     */
    private int repeatTimes = 7;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: DISPLAY "Program starts here...".
        System.out.println("Program starts here...");

        // COBOL: PERFORM 5 TIMES ... END-PERFORM
        for (int i = 0; i < 5; i++) {
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
        // A execução do método termina aqui, que é o equivalente a STOP RUN.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    
    /**
     * Converte o parágrafo COBOL 'SecondVersion'.
     */
    private void secondVersion() {
        // COBOL: DISPLAY "[-] This is Out-of-line Perform printed 7 times.".
        System.out.println("[-] This is Out-of-line Perform printed 7 times.");
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método principal que instancia e executa a classe convertida.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performthroughexample().run();
    }
}