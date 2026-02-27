package com.converted.cobol;

import java.io.IOException;

/**
 * Convertido de: PreDefMsg
 * Author: jiuweigui
 * Description: Prints a predefined message.
 */
public class Predefmsg {

    // WORKING-STORAGE SECTION
    // 01 PreDefMsg	PIC X(18) VALUE 'Hello again World!'.
    private final String preDefMsgValue;

    /**
     * Construtor da classe. Inicializa as variáveis da Working-Storage.
     */
    public Predefmsg() {
        this.preDefMsgValue = "Hello again World!";
    }

    /**
     * Método principal que executa a lógica do programa COBOL.
     * Equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // PROCEDURE DIVISION.
        
        // DISPLAY PreDefMsg.
        System.out.println(this.preDefMsgValue);
        
        // STOP RUN.
    }

    /**
     * Ponto de entrada da aplicação Java.
     * Cria uma instância da classe e executa o método run().
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        try {
            new Predefmsg().run();
        } catch (Exception e) {
            System.err.println("Ocorreu um erro durante a execução do programa: " + e.getMessage());
            e.printStackTrace();
        }
    }
}