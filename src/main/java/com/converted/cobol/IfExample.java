package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: if-example
 * @author auto-converted from jiuweigui
 */
public class IfExample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    // 01 UserInput PIC X(20).
    private String userInput = "";

    /**
     * Ponto de entrada principal da lógica do programa.
     */
    public void run() {
        // O uso de try-with-resources garante que o Scanner seja fechado.
        try (Scanner scanner = new Scanner(System.in)) {
            
            // PROCEDURE DIVISION.
            
            // DISPLAY "Please enter your name in upper-case: ".
            System.out.print("Please enter your name in upper-case: ");
            
            // ACCEPT UserInput.
            userInput = scanner.nextLine();

            // Garante que a entrada não exceda o tamanho definido em PIC X(20).
            if (userInput.length() > 20) {
                userInput = userInput.substring(0, 20);
            }

            // IF UserInput IS ALPHABETIC-LOWER
            if (isCobolAlphabeticLower(userInput)) {
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
        // O método termina, equivalente ao STOP RUN.
    }

    /**
     * Simula a cláusula 'IS ALPHABETIC-LOWER' do COBOL.
     * <p>
     * Esta verificação considera uma string como "alfabética minúscula" se ela
     * contiver exclusivamente caracteres de 'a' a 'z' e espaços. Uma string
     * vazia ou contendo apenas espaços não é considerada alfabética.
     *
     * @param str A string a ser validada.
     * @return {@code true} se a string corresponde à classe ALPHABETIC-LOWER do COBOL,
     *         {@code false} caso contrário.
     */
    private boolean isCobolAlphabeticLower(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isLowerCase(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    /**
     * Método main para execução do programa.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new IfExample().run();
    }
}