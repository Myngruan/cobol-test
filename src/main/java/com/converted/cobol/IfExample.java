package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: if-example
 * @author auto-converted
 */
public class IfExample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    // 01 UserInput PIC X(20).
    private String userInput;

    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // O PROCEDURE DIVISION é executado aqui.
        // Usamos try-with-resources para gerenciar o Scanner de forma segura.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // DISPLAY "Please enter your name in upper-case: ".
            System.out.print("Please enter your name in upper-case: ");

            // ACCEPT UserInput.
            String line = consoleInput.nextLine();
            this.userInput = line;

            // IF UserInput IS ALPHABETIC-LOWER
            if (isAlphabeticLower(this.userInput)) {
                // MOVE FUNCTION UPPER-CASE (UserInput) TO UserInput
                this.userInput = this.userInput.toUpperCase();
                // DISPLAY "Plz uppercase. Fixed it, ", UserInput
                // Usamos trim() para uma exibição mais limpa, removendo espaços em branco
                // que seriam comuns em uma variável PIC X(n) do COBOL.
                System.out.println("Plz uppercase. Fixed it, " + this.userInput.trim());
            } else {
                // ELSE DISPLAY "Hello, ", UserInput
                System.out.println("Hello, " + this.userInput.trim());
            }
        }
        // STOP RUN.
        // A execução termina ao final deste método.
    }

    /**
     * Simula a verificação COBOL 'IS ALPHABETIC-LOWER'.
     * Retorna verdadeiro se a string contiver apenas letras minúsculas ('a'-'z') e espaços.
     * A string não pode ser nula ou vazia.
     *
     * @param value A string a ser verificada.
     * @return true se a condição for atendida, false caso contrário.
     */
    private boolean isAlphabeticLower(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        // Verifica se todos os caracteres são minúsculos ou espaços.
        return value.chars().allMatch(c -> Character.isLowerCase(c) || c == ' ');
    }

    /**
     * Método main para iniciar a execução do programa.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new IfExample().run();
    }
}