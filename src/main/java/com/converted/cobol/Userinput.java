package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    
    /**
     * Corresponde ao item de grupo '01 UserName'.
     */
    static class UserName {
        /**
         * Corresponde a '02 Name PIC X(10)'.
         */
        String name = "";
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    private UserName userName = new UserName();

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // Um Scanner é usado para lidar com a entrada do console, equivalente ao ACCEPT.
        try (Scanner consoleInput = new Scanner(System.in)) {
            
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê uma linha do console e a formata para se ajustar às regras do PIC X(10):
            // - Trunca se for maior que 10 caracteres.
            // - Preenche com espaços à direita se for menor que 10.
            String input = consoleInput.nextLine();
            if (input.length() > 10) {
                userName.name = input.substring(0, 10);
            } else {
                // O formato "%-10s" alinha à esquerda e preenche com espaços até 10 caracteres.
                userName.name = String.format("%-10s", input);
            }

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // Em Java, concatenamos as strings. O espaço é adicionado explicitamente.
            // A variável 'userName.name' já contém os espaços de preenchimento, se houver.
            System.out.println("It's nice to meet you " + userName.name);
        }
        
        // COBOL: STOP RUN.
        // O programa termina naturalmente quando o método run() é concluído.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Userinput().run();
    }
}