package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        // A PROCEDURE DIVISION é executada aqui.
        // O STOP RUN ao final do COBOL é implícito pelo término deste método.
        procedureDivision();
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    
    /**
     * Corresponde à PROCEDURE DIVISION do programa COBOL.
     */
    private void procedureDivision() {
        // Usamos try-with-resources para garantir que o Scanner seja fechado automaticamente.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // COBOL: DISPLAY "Please enter your name in upper-case: ".
            System.out.print("Please enter your name in upper-case: ");

            // COBOL: ACCEPT UserInput.
            this.userInput = consoleInput.nextLine();

            // COBOL: IF UserInput IS ALPHABETIC-LOWER
            // A expressão regular "[a-z]+" é um equivalente moderno para verificar
            // se a string contém apenas (e pelo menos um) caracteres alfabéticos minúsculos.
            if (this.userInput.matches("[a-z]+")) {
                // COBOL: MOVE FUNCTION UPPER-CASE (UserInput) TO UserInput
                this.userInput = this.userInput.toUpperCase();
                
                // COBOL: DISPLAY "Plz uppercase. Fixed it, ", UserInput
                System.out.println("Plz uppercase. Fixed it, " + this.userInput);
            } else {
                // COBOL: ELSE DISPLAY "Hello, ", UserInput
                System.out.println("Hello, " + this.userInput);
            }
            // COBOL: END-IF
        }
        // COBOL: STOP RUN.
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