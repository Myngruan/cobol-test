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
     * Executa a lógica principal do programa COBOL convertido.
     */
    public void run() {
        procedureDivision();
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    /**
     * Corresponde à PROCEDURE DIVISION do programa COBOL.
     */
    private void procedureDivision() {
        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");

        // COBOL: STOP RUN.
        // A execução do programa termina após este método retornar.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Helloworld().run();
    }
}