package com.converted.cobol;

import java.io.IOException;

/**
 * Convertido do programa COBOL: HelloWorld
 * @author auto-converted from jiuweigui
 */
public class Helloworld {

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa COBOL.
     * Este método corresponde à PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");
        
        // COBOL: STOP RUN.
        // A execução do programa termina ao final deste método.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * Cria uma instância da classe e chama o método run().
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Lançada em caso de erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new Helloworld().run();
    }
}