package com.converted.cobol;

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
        // O try-with-resources garante que o Scanner seja fechado automaticamente.
        try (Scanner scanner = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê a entrada do usuário e a armazena no campo "name".
            userName.name = scanner.nextLine();

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // O "SPACE" em COBOL é traduzido para um espaço literal na string.
            System.out.println("It's nice to meet you " + userName.name);
        }
        // COBOL: STOP RUN.
        // O programa termina quando o método "run" é concluído.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Userinput().run();
    }
}