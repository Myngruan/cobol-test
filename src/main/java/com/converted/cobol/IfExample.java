package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: if-example
 * @author auto-converted
 */
public class IfExample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * Mapeia: 01 UserInput PIC X(20).
     */
    private String userInput = "";

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // A PROCEDURE DIVISION é mapeada aqui.
        try (Scanner scanner = new Scanner(System.in)) {
            // COBOL: DISPLAY "Please enter your name in upper-case: ".
            System.out.print("Please enter your name in upper-case: ");

            // COBOL: ACCEPT UserInput.
            // Lê a entrada do usuário e trunca para 20 caracteres para simular PIC X(20).
            String line = scanner.nextLine();
            userInput = (line.length() > 20) ? line.substring(0, 20) : line;

            // COBOL: IF UserInput IS ALPHABETIC-LOWER
            if (isAlphabeticLower(userInput)) {
                // COBOL: MOVE FUNCTION UPPER-CASE (UserInput) TO UserInput
                userInput = userInput.toUpperCase();
                // COBOL: DISPLAY "Plz uppercase. Fixed it, ", UserInput
                System.out.println("Plz uppercase. Fixed it, " + userInput);
            } else {
                // COBOL: ELSE DISPLAY "Hello, ", UserInput
                System.out.println("Hello, " + userInput);
            }
        }
        // COBOL: STOP RUN.
        // O método termina, finalizando a execução.
    }

    /**
     * Verifica se a string contém apenas caracteres alfabéticos minúsculos.
     * Simula o teste de classe COBOL "IS ALPHABETIC-LOWER".
     * Esta implementação assume que apenas as letras 'a" a "z' são válidas,
     * o que é uma interpretação comum para este tipo de validação simples.
     *
     * @param str A string a ser verificada.
     * @return true se a string não for vazia e contiver apenas letras minúsculas,
     *         false caso contrário.
     */
    private boolean isAlphabeticLower(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new IfExample().run();
    }
}