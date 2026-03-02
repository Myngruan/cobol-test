package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Corresponde ao item de grupo 01 UserName em COBOL.
     */
    static class UserName {
        // 02 Name PIC X(10).
        String name = "";
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private UserName userName = new UserName();

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa, que corresponde à PROCEDURE DIVISION.
     */
    public void run() {
        // O try-with-resources garante que o Scanner seja fechado automaticamente.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê uma linha do console e a formata para 10 caracteres,
            // preenchendo com espaços à direita ou truncando, se necessário,
            // para emular o comportamento de um campo PIC X(10).
            String input = consoleInput.nextLine();
            userName.name = String.format("%-10.10s", input);

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            System.out.println("It's nice to meet you " + userName.name);
        }
        // COBOL: STOP RUN.
        // O método run() termina, finalizando a execução do programa.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Userinput().run();
    }
}