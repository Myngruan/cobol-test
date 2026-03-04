package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Corresponde à estrutura de dados COBOL:
     * <pre>
     * 01 UserName.
     *    02 Name PIC X(10).
     * </pre>
     */
    static class UserName {
        String name = ""; // PIC X(10)
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private UserName userName = new UserName();

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa, análogo à PROCEDURE DIVISION.
     */
    public void run() {
        // O try-with-resources garante que o Scanner seja fechado automaticamente,
        // emulando o gerenciamento de recursos do ambiente COBOL.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê a entrada do usuário e a formata para o campo PIC X(10).
            if (consoleInput.hasNextLine()) {
                String input = consoleInput.nextLine();
                userName.name = formatToPicX(input, 10);
            }

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            System.out.println("It's nice to meet you " + userName.name);
        }
        // COBOL: STOP RUN.
        // A execução termina naturalmente ao final do método run.
    }

    /**
     * Formata uma string para emular o comportamento de um campo PIC X(n) do COBOL.
     * A string é truncada se for mais longa que o comprimento especificado,
     * ou preenchida com espaços à direita se for mais curta.
     *
     * @param input A string de entrada.
     * @param length O comprimento do campo PIC X.
     * @return A string formatada.
     */
    private String formatToPicX(String input, int length) {
        if (input == null) {
            input = "";
        }
        if (input.length() > length) {
            return input.substring(0, length);
        } else {
            // %-Ns: Alinha à esquerda a string (N é a largura) e preenche com espaços.
            return String.format("%-" + length + "s", input);
        }
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada padrão para a aplicação Java.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Userinput().run();
    }
}