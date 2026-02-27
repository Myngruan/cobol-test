package com.converted.cobol;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Convertido de: HelloWorld
 * AUTHOR: jiuweigui
 */
public class Helloworld {

    // Não há WORKING-STORAGE SECTION ou FILE SECTION neste programa COBOL.
    // Nenhuma variável de instância, classe interna ou formatação é necessária.

    /**
     * Construtor da classe.
     */
    public Helloworld() {
        // O construtor está vazio pois não há inicializações a serem feitas.
    }

    /**
     * Executa a lógica principal convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: PROCEDURE DIVISION.

        // COBOL: DISPLAY "Hello World!".
        System.out.println("Hello World!");

        // COBOL: STOP RUN.
        // A execução do método 'run' termina aqui, e o programa encerra.
    }

    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Helloworld().run();
    }
}