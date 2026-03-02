package com.converted.cobol;

/**
 * Convertido do programa COBOL: PreDefMsg
 * <p>
 * Este programa Java é uma conversão do programa COBOL PreDefMsg,
 * cujo propósito é exibir uma mensagem predefinida no console.
 *
 * @author auto-converted
 */
public class Predefmsg {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * COBOL: 01 PreDefMsg PIC X(18) VALUE 'Hello again World!'.
     */
    private String preDefMsg = "Hello again World!";

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal que corresponde à PROCEDURE DIVISION do COBOL.
     */
    public void run() {
        // COBOL: DISPLAY PreDefMsg.
        System.out.println(preDefMsg);
        
        // COBOL: STOP RUN.
        // A execução termina ao final deste método.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada da aplicação Java.
     * Cria uma instância da classe e invoca o método run.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Predefmsg().run();
    }
}