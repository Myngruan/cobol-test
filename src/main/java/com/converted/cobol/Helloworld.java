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
     * Executa a lógica principal do programa, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");
        
        // COBOL: STOP RUN.
        // A execução do método termina aqui, que é o equivalente a STOP RUN.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada padrão para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Helloworld().run();
    }
}