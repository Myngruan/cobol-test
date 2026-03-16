package com.converted.cobol;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Convertido do programa COBOL: PreDefMsg
 * Prints predefined message
 * @author auto-converted from jiuweigui
 */
public class Predefmsg {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * <pre>
     * 01 PreDefMsg	PIC X(18) VALUE "Hello again World!".
     * </pre>
     */
    private String preDefMsg = "Hello again World!";

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // PROCEDURE DIVISION
        
        // COBOL: DISPLAY PreDefMsg.
        System.out.println(preDefMsg);
        
        // COBOL: STOP RUN.
        // A execução termina ao final deste método.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main para executar o programa convertido.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Predefmsg().run();
    }
}