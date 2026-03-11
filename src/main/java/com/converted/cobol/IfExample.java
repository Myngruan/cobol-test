package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: if-example
 * @author auto-converted
 */
public class IfExample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * Mapeado de: 01 UserInput PIC X(20).
     */
    private String userInput = "";

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // O uso de try-with-resources garante que o Scanner seja fechado automaticamente.
        try (Scanner scanner = new Scanner(System.in)) {
            
            // COBOL: DISPLAY "Please enter your name in upper-case: ".
            // Usamos System.out.print para manter o cursor na mesma linha.
            System.out.print("Please enter your name in upper-case: ");
            
            // COBOL: ACCEPT UserInput.
            // Lê a entrada do usuário da linha de comando.
            userInput = scanner.nextLine();
            
            // COBOL: IF UserInput IS ALPHABETIC-LOWER
            // A classe de teste 'IS ALPHABETIC-LOWER' verifica se a string contém
            // apenas letras minúsculas de 'a' a 'z'.
            if (isAlphabeticLower(userInput)) {
                // COBOL: MOVE FUNCTION UPPER-CASE (UserInput) TO UserInput
                userInput = userInput.toUpperCase();
                
                // COBOL: DISPLAY "Plz uppercase. Fixed it, ", UserInput
                System.out.println("Plz uppercase. Fixed it, " + userInput);
            } else {
                // COBOL: ELSE DISPLAY "Hello, ", UserInput
                System.out.println("Hello, " + userInput);
            }
            // COBOL: END-IF
            
        } // O Scanner é fechado aqui.
        
        // COBOL: STOP RUN.
        // O método run() termina, efetivamente parando a execução do programa.
    }

    /**
     * Simula a classe de teste COBOL 'IS ALPHABETIC-LOWER'.
     * Retorna verdadeiro se a string não for nula, não estiver vazia e
     * contiver apenas caracteres alfabéticos minúsculos.
     *
     * @param str A string a ser verificada.
     * @return true se a string for alfabética minúscula, false caso contrário.
     */
    private boolean isAlphabeticLower(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        // A expressão regular "[a-z]+" corresponde a uma ou mais letras minúsculas.
        return str.matches("[a-z]+");
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new IfExample().run();
    }
}