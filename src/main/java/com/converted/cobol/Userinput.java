package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Corresponde à estrutura 01 UserName em COBOL.
     */
    static class UserName {
        // 02 Name PIC X(10).
        String name = "";
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private UserName userName = new UserName();

    // ── Ponto de entrada e lógica principal ───────────────────────────────
    /**
     * Executa a lógica principal do programa, correspondendo à PROCEDURE DIVISION.
     */
    public void run() {
        // Usar try-with-resources para garantir que o Scanner seja fechado.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê a entrada do usuário e a ajusta para o formato PIC X(10).
            String input = consoleInput.nextLine();
            if (input.length() > 10) {
                // Trunca se a entrada for maior que 10 caracteres.
                userName.name = input.substring(0, 10);
            } else {
                // Preenche com espaços à direita se for menor que 10.
                userName.name = String.format("%-10s", input);
            }

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // O SPACE é traduzido como um espaço literal na string.
            System.out.println("It's nice to meet you " + userName.name);
        }
        // COBOL: STOP RUN.
        // O programa termina naturalmente ao final do método.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new Userinput().run();
    }
}