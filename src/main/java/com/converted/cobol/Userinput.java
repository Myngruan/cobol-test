package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Corresponde à estrutura COBOL:
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
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // A PROCEDURE DIVISION é mapeada aqui.
        // Usar try-with-resources para o Scanner garante que ele seja fechado.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê a entrada do usuário do console e a armazena na variável.
            // O COBOL preencheria ou truncaria para 10 caracteres, mas para
            // a lógica deste programa, ler a linha inteira é suficiente.
            if (consoleInput.hasNextLine()) {
                userName.name = consoleInput.nextLine();
            }

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // O literal SPACE é traduzido para um espaço na string.
            System.out.println("It's nice to meet you " + userName.name);
        }
        // COBOL: STOP RUN.
        // O método run() termina, e o programa encerra.
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