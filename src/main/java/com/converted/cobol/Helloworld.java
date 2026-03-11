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
     * Executa a lógica principal do programa, que é equivalente à
     * PROCEDURE DIVISION do programa COBOL.
     */
    public void run() {
        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");
        
        // COBOL: STOP RUN.
        // A execução do método termina aqui, o que é análogo ao STOP RUN.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada da aplicação Java.
     * Cria uma instância da classe e chama o método run.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Helloworld().run();
    }
}