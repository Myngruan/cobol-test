package com.converted.cobol;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: if-example
 * @author auto-converted
 */
public class IfExample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * COBOL: 01 UserInput PIC X(20).
     */
    private String userInput = "";

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // O Scanner é usado para replicar o comando ACCEPT do COBOL para entrada do console.
        // O try-with-resources garante que o scanner seja fechado corretamente.
        try (Scanner scanner = new Scanner(System.in)) {
            
            // COBOL: DISPLAY "Please enter your name in upper-case: ".
            // Usamos System.out.print para manter o cursor na mesma linha.
            System.out.print("Please enter your name in upper-case: ");
            
            // COBOL: ACCEPT UserInput.
            userInput = scanner.nextLine();
            
            // COBOL: IF UserInput IS ALPHABETIC-LOWER
            // A classe de teste ALPHABETIC-LOWER em COBOL é verdadeira se todos os
            // caracteres forem letras minúsculas (a-z) ou espaços.
            // A expressão regular "[a-z ]+" em Java replica esse comportamento.
            if (userInput != null && !userInput.isEmpty() && userInput.matches("[a-z ]+")) {
                
                // COBOL: MOVE FUNCTION UPPER-CASE (UserInput) TO UserInput
                userInput = userInput.toUpperCase();
                
                // COBOL: DISPLAY "Plz uppercase. Fixed it, ", UserInput
                System.out.println("Plz uppercase. Fixed it, " + userInput);
            
            } else {
                // COBOL: ELSE DISPLAY "Hello, ", UserInput
                System.out.println("Hello, " + userInput);
            }
            // COBOL: END-IF
        }
        
        // COBOL: STOP RUN.
        // A execução termina quando o método run() retorna.
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