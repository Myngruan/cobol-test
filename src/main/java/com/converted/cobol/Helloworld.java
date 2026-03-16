package com.converted.cobol;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Convertido do programa COBOL: HelloWorld
 * @author auto-converted
 */
public class Helloworld {

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa, análoga à PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: PROCEDURE DIVISION.
        procedureDivision();
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    
    /**
     * Contém a lógica da PROCEDURE DIVISION do programa COBOL.
     */
    private void procedureDivision() {
        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");
        
        // COBOL: STOP RUN.
        // A execução do método termina aqui, o que é análogo ao STOP RUN.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Helloworld().run();
    }
}