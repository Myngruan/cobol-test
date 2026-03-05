package com.converted.cobol;

/**
 * Convertido do programa COBOL: PreDefMsg
 * @author auto-converted
 */
public class Predefmsg {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────

    /**
     * Corresponde a:
     * 01 PreDefMsg	PIC X(18) VALUE 'Hello again World!'.
     */
    private String preDefMsg = "Hello again World!";

    // ── Ponto de entrada ─────────────────────────────────────────────────

    /**
     * Executa a lógica principal do programa, correspondente à PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: DISPLAY PreDefMsg.
        System.out.println(preDefMsg);
        
        // COBOL: STOP RUN.
        // O retorno deste método encerra a execução.
    }

    // ── main ─────────────────────────────────────────────────────────────

    /**
     * Ponto de entrada principal para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Predefmsg().run();
    }
}