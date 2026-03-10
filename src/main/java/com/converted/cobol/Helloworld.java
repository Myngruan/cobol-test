package com.converted.cobol;

import java.io.IOException;

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

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        procedureDivision();
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    /**
     * Contém a lógica principal da PROCEDURE DIVISION.
     */
    private void procedureDivision() {
        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");

        // COBOL: STOP RUN.
        // A execução termina naturalmente ao final deste método, que é o
        // comportamento equivalente ao STOP RUN neste contexto.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main para permitir a execução da classe como um programa autônomo.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Helloworld().run();
    }
}