package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted (original: jiuweigui)
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Corresponde ao grupo 01 UserName em COBOL.
     */
    static class UserName {
        // 02 Name PIC X(10).
        String name = "";
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private UserName userName = new UserName();

    // ── Ponto de entrada (PROCEDURE DIVISION) ─────────────────────────────
    public void run() {
        // Usar try-with-resources para garantir que o Scanner seja fechado.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê uma linha do console e a atribui à estrutura de dados.
            acceptUserName(consoleInput);

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // O SPACE é tratado pela concatenação com " ".
            System.out.println("It's nice to meet you " + userName.name);
        }
        // COBOL: STOP RUN.
        // O programa termina quando o método run() retorna.
    }

    /**
     * Simula o verbo ACCEPT do COBOL para ler a entrada do usuário
     * e preencher a estrutura UserName, respeitando o PIC X(10).
     * @param scanner O Scanner para ler da entrada padrão.
     */
    private void acceptUserName(Scanner scanner) {
        String input = scanner.nextLine();

        // Simula o comportamento de PIC X(10): trunca se for maior,
        // ou preenche com espaços à direita se for menor.
        if (input.length() > 10) {
            userName.name = input.substring(0, 10);
        } else {
            userName.name = String.format("%-10s", input);
        }
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        new Userinput().run();
    }
}