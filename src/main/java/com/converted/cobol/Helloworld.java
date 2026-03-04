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
    // Nenhum arquivo utilizado no programa COBOL.

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");

        // COBOL: STOP RUN.
        // O método termina aqui, finalizando a execução da lógica.
        return;
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception para qualquer erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new Helloworld().run();
    }
}