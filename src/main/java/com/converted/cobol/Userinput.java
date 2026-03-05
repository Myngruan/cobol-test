package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Mapeia a estrutura COBOL:
     * 01 UserName.
     *    02 Name PIC X(10).
     */
    static class UserName {
        String name = "";
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private UserName userName = new UserName();

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // A Scanner é a forma moderna em Java para ler a entrada do console,
        // sendo o equivalente direto do verbo ACCEPT.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê a linha inteira da entrada do usuário.
            if (consoleInput.hasNextLine()) {
                String input = consoleInput.nextLine();
                
                // Emula o comportamento de PIC X(10) truncando a entrada se for maior.
                if (input.length() > 10) {
                    userName.name = input.substring(0, 10);
                } else {
                    userName.name = input;
                }
            }

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // O SPACE é traduzido para um espaço literal na string de saída.
            System.out.println("It's nice to meet you " + userName.name);
        }
        
        // COBOL: STOP RUN.
        // O programa termina naturalmente ao final do método run().
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada padrão para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Userinput().run();
    }
}