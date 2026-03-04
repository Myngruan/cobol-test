package com.converted.cobol;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Convertido do programa COBOL: HelloWorld
 * @author auto-converted
 */
public class Helloworld {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    // Nenhuma estrutura de dados definida no programa COBOL.

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    // Nenhum campo de trabalho definido no programa COBOL.

    // ── Handlers de arquivo (FILE SECTION) ────────────────────────────────
    // Nenhum arquivo definido no programa COBOL.

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal da lógica do programa, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        procedureDivision();
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    /**
     * Contém a lógica da PROCEDURE DIVISION.
     */
    private void procedureDivision() {
        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");

        // COBOL: STOP RUN.
        // A execução termina naturalmente ao final deste método.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main para executar o programa convertido.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new Helloworld().run();
    }
}