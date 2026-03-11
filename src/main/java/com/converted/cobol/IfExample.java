package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: if-example
 * @author auto-converted
 */
public class IfExample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    // 01 UserInput PIC X(20).
    private String userInput = "";

    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // Usamos try-with-resources para garantir que o Scanner seja fechado automaticamente.
        try (Scanner scanner = new Scanner(System.in)) {
            // PROCEDURE DIVISION.
            
            // DISPLAY "Please enter your name in upper-case: ".
            System.out.print("Please enter your name in upper-case: ");

            // ACCEPT UserInput.
            // Em Java, lemos a linha inteira. COBOL PIC X(20) implica um limite de tamanho,
            // mas para este exemplo, ler a linha inteira é uma tradução funcional.
            userInput = scanner.nextLine();

            // IF UserInput IS ALPHABETIC-LOWER
            // A classe de teste ALPHABETIC-LOWER do COBOL verifica se todos os caracteres 
            // são letras minúsculas.
            if (isAlphabeticLower(userInput)) {
                // MOVE FUNCTION UPPER-CASE (UserInput) TO UserInput
                userInput = userInput.toUpperCase();
                // DISPLAY "Plz uppercase. Fixed it, ", UserInput
                System.out.println("Plz uppercase. Fixed it, " + userInput);
            } else {
                // ELSE DISPLAY "Hello, ", UserInput
                System.out.println("Hello, " + userInput);
            }
            // END-IF
        }
        // STOP RUN.
        // O método run() termina, o que é equivalente a STOP RUN no contexto de um programa simples.
    }

    /**
     * Simula a classe de teste COBOL 'IS ALPHABETIC-LOWER'.
     * Retorna true se a string não estiver vazia e contiver apenas letras minúsculas ('a'-'z').
     * @param str A string a ser verificada.
     * @return true se a string for alfabética minúscula, false caso contrário.
     */
    private boolean isAlphabeticLower(String str) {
        // Uma string nula ou vazia não é considerada alfabética.
        if (str == null || str.isEmpty()) {
            return false;
        }
        // A expressão regular "^[a-z]+$" verifica se a string inteira, do início (^) ao fim ($),
        // consiste em uma ou mais (+) letras minúsculas ([a-z]).
        return str.matches("^[a-z]+$");
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método principal que instancia e executa a classe do programa.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new IfExample().run();
    }
}