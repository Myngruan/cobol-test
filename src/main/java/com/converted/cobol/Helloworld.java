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
    // Nenhuma variável de trabalho definida no programa COBOL.

    // ── Handlers de arquivo (FILE SECTION) ────────────────────────────────
    // Nenhum arquivo definido no programa COBOL.

    // ── Ponto de entrada (PROCEDURE DIVISION) ────────────────────────────
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");

        // COBOL: STOP RUN.
        // A execução do programa termina naturalmente quando este método retorna.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main para instanciar e executar a classe principal.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Helloworld().run();
    }
}