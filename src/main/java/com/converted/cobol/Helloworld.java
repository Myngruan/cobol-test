package com.converted.cobol;

/**
 * Convertido do programa COBOL: HelloWorld
 * @author auto-converted
 */
public class Helloworld {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    // Não há WORKING-STORAGE SECTION neste programa.

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa, correspondendo à PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");

        // COBOL: STOP RUN.
        // O retorno deste método encerra a execução da lógica principal.
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