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

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Lógica principal do programa, convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // Usamos try-with-resources para garantir que o Scanner seja fechado.
        try (Scanner scanner = new Scanner(System.in)) {
            // COBOL: DISPLAY "Please enter your name in upper-case: ".
            // Usamos print para manter o cursor na mesma linha para a entrada.
            System.out.print("Please enter your name in upper-case: ");

            // COBOL: ACCEPT UserInput.
            // Lê a linha inteira da entrada do console.
            userInput = scanner.nextLine();

            // Emula a limitação de tamanho do PIC X(20) do COBOL.
            if (userInput.length() > 20) {
                userInput = userInput.substring(0, 20);
            }

            // COBOL: IF UserInput IS ALPHABETIC-LOWER
            // A expressão regular "[a-z]+" verifica se a string contém um ou mais
            // caracteres e se todos eles são letras minúsculas de 'a' a 'z'.
            // Esta é uma tradução fiel da classe de teste ALPHABETIC-LOWER.
            if (userInput.matches("[a-z]+")) {
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
        // O programa termina naturalmente ao final do método run().
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new IfExample().run();
    }
}