package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido de: UserInput
 * AUTHOR. jiuweigui
 */
public class Userinput {

    // WORKING-STORAGE SECTION
    // 01 UserName.
    //    02 Name PIC X(10).
    // A estrutura UserName é representada por uma única variável String em Java,
    // pois contém apenas um campo de texto.
    private String name;

    /**
     * Construtor padrão.
     */
    public Userinput() {
        // Inicialização de variáveis, se necessário.
        this.name = "";
    }

    /**
     * Método principal que executa a lógica do programa COBOL.
     * Equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // O bloco try-with-resources garante que o Scanner seja fechado automaticamente.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // ACCEPT UserName.
            // Lê a entrada do usuário do console.
            // O COBOL PIC X(10) define um campo de tamanho fixo, mas o ACCEPT do console
            // geralmente lê a linha inteira. A String Java é mais flexível.
            this.name = consoleInput.nextLine();

            // DISPLAY "It's nice to meet you" SPACE Name.
            // O método trim() remove espaços em branco no início e no fim,
            // um comportamento comum ao lidar com campos de texto COBOL.
            System.out.println("It's nice to meet you " + this.name.trim());
        }
        // STOP RUN.
        // O programa termina quando o método run() é concluído.
    }

    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Userinput().run();
    }
}