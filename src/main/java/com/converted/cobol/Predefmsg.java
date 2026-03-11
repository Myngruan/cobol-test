package com.converted.cobol;

/**
 * Convertido do programa COBOL: PreDefMsg
 * Prints a predefined message.
 * @author auto-converted from jiuweigui
 */
public class Predefmsg {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * Mapeia para: 01 PreDefMsg PIC X(18) VALUE "Hello again World!".
     */
    private String preDefMsg = "Hello again World!";

    // ── Ponto de entrada e Lógica Principal ───────────────────────────────
    
    /**
     * Executa a lógica principal do programa, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: DISPLAY PreDefMsg.
        System.out.println(preDefMsg);
        
        // COBOL: STOP RUN.
        // A execução termina ao final deste método.
    }

    // ── Método main ───────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Predefmsg().run();
    }
}