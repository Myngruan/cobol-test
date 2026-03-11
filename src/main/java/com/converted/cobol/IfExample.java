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
        // O Scanner é usado para emular o comando ACCEPT do COBOL.
        // O try-with-resources garante que o Scanner seja fechado corretamente.
        try (Scanner scanner = new Scanner(System.in)) {
            
            // COBOL: DISPLAY "Please enter your name in upper-case: ".
            System.out.print("Please enter your name in upper-case: ");
            
            // COBOL: ACCEPT UserInput.
            userInput = scanner.nextLine();
            
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
        // COBOL: STOP RUN. (implícito ao final do método "run")
    }

    /**
     * Helper para emular a verificação "IS ALPHABETIC-LOWER" do COBOL.
     * Retorna true se a string contém apenas caracteres alfabéticos minúsculos.
     * @param str A string a ser verificada.
     * @return true se a condição for satisfeita, false caso contrário.
     */
    private boolean isAlphabeticLower(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            // A verificação COBOL considera qualquer coisa que não seja a-z como não alfabético.
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
     * @throws Exception se ocorrer um erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new IfExample().run();
    }
}