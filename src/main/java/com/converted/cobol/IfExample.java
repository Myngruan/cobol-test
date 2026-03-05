package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: if-example
 * @author auto-converted (original: jiuweigui)
 */
public class IfExample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 UserInput PIC X(20).
    private String userInput = "";

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // O uso de try-with-resources garante que o Scanner seja fechado automaticamente.
        try (Scanner consoleInput = new Scanner(System.in)) {
            
            // PROCEDURE DIVISION.
            
            // DISPLAY "Please enter your name in upper-case: ".
            System.out.print("Please enter your name in upper-case: ");
            
            // ACCEPT UserInput.
            // Em COBOL, ACCEPT em um campo PIC X(n) lê a entrada e a preenche ou trunca
            // para o tamanho 'n'. Aqui, lemos a linha inteira e a truncamos se necessário.
            String line = consoleInput.nextLine();
            if (line.length() > 20) {
                userInput = line.substring(0, 20);
            } else {
                userInput = line;
            }

            // IF UserInput IS ALPHABETIC-LOWER
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
        // A execução do método termina, o que é análogo ao STOP RUN.
    }

    /**
     * Simula a verificação COBOL 'IS ALPHABETIC-LOWER'.
     * Retorna true se a string contiver apenas letras minúsculas (a-z) e espaços.
     * @param value A string a ser verificada.
     * @return true se a condição for atendida, caso contrário false.
     */
    private boolean isAlphabeticLower(String value) {
        if (value == null || value.trim().isEmpty()) {
            return false; // Uma string vazia ou apenas com espaços não é considerada alfabética.
        }
        // A expressão regular "[a-z ]+" verifica se a string contém um ou mais
        // caracteres que são letras minúsculas ou espaços.
        return value.matches("[a-z ]+");
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método principal para executar o programa.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new IfExample().run();
    }
}