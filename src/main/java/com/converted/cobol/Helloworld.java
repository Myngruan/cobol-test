package com.converted.cobol;

import java.io.IOException;

/**
 * Convertido do programa COBOL: HelloWorld
 * @author auto-converted
 */
public class Helloworld {

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Lógica principal do programa, convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");
        
        // COBOL: STOP RUN.
        // A execução termina ao final deste método.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * Cria uma instância da classe e chama o método run.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Helloworld().run();
    }
}