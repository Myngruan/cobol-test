package com.converted.cobol;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Convertido do programa COBOL: PreDefMsg
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
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // COBOL: PROCEDURE DIVISION.
        
        // COBOL: DISPLAY PreDefMsg.
        System.out.println(preDefMsg);
        
        // COBOL: STOP RUN.
        // A execução do programa termina aqui, equivalente ao retorno do método.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main para permitir a execução da classe como um programa autônomo.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Predefmsg().run();
    }
}