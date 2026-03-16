package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Representa a estrutura de dados COBOL:
     * 01 UserName.
     *    02 Name PIC X(10).
     */
    static class UserName {
        String name = "";
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private UserName userName = new UserName();

    // ── Ponto de entrada e lógica principal ───────────────────────────────
    /**
     * Executa a lógica principal convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // Usamos try-with-resources para garantir que o Scanner seja fechado.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê uma linha da entrada padrão. O COBOL PIC X(10) implica um campo
            // de tamanho fixo. Para emular esse comportamento, truncamos a entrada
            // se ela for maior que 10 caracteres.
            if (consoleInput.hasNextLine()) {
                String input = consoleInput.nextLine();
                if (input.length() > 10) {
                    this.userName.name = input.substring(0, 10);
                } else {
                    this.userName.name = input;
                }
            }

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // A palavra-chave SPACE adiciona um único espaço.
            System.out.println("It's nice to meet you " + this.userName.name);

            // COBOL: STOP RUN.
            // O programa termina naturalmente quando o método run() é concluído.
        }
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