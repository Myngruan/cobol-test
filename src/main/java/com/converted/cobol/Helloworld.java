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
     * Executa a lógica principal do programa, correspondendo à PROCEDURE DIVISION.
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
        // A execução termina naturalmente ao final do método chamado pelo main.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erro na execução.
     */
    public static void main(String[] args) throws Exception {
        new Helloworld().run();
    }
}