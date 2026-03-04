package com.converted.cobol;

import java.io.IOException;

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
        // A PROCEDURE DIVISION é mapeada diretamente aqui por ser simples.
        
        // COBOL: DISPLAY PreDefMsg.
        System.out.println(preDefMsg);
        
        // COBOL: STOP RUN.
        // A execução do método termina, finalizando o programa.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método principal para executar o programa convertido.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new Predefmsg().run();
    }
}