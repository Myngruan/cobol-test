package com.converted.cobol;

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
     * COBOL: 01 PreDefMsg	PIC X(18) VALUE "Hello again World!".
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
        // A execução do programa termina aqui, o que é análogo a retornar do método.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada da aplicação Java.
     * Cria uma instância da classe e chama o método run.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Predefmsg().run();
    }
}