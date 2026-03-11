package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Convertido do programa COBOL: PreDefMsg
 * @author auto-converted
 */
public class Predefmsg {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * <pre>
     * 01 PreDefMsg	PIC X(18) VALUE 'Hello again World!'.
     * </pre>
     */
    private String preDefMsg = "Hello again World!";

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        procedureDivision();
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    
    /**
     * Contém a lógica da PROCEDURE DIVISION.
     */
    private void procedureDivision() {
        // DISPLAY PreDefMsg.
        System.out.println(preDefMsg);
        
        // STOP RUN.
        // A execução termina ao final deste método.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new Predefmsg().run();
    }
}