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
     * 01 UserName.
     *    02 Name PIC X(10).
     */
    static class UserName {
        String name = ""; // Mapeado de PIC X(10)
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private UserName userName = new UserName();

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal para a lógica do programa.
     */
    public void run() {
        procedureDivision();
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    /**
     * Contém a lógica da PROCEDURE DIVISION do programa COBOL.
     */
    private void procedureDivision() {
        // O Scanner é usado para ler a entrada do console, equivalente ao ACCEPT.
        // Usar try-with-resources garante que o scanner seja fechado corretamente.
        try (Scanner scanner = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê uma linha da entrada padrão e a formata para 10 caracteres,
            // preenchendo com espaços à direita ou truncando, conforme o comportamento do COBOL.
            String inputLine = scanner.nextLine();
            if (inputLine.length() > 10) {
                userName.name = inputLine.substring(0, 10);
            } else {
                userName.name = String.format("%-10s", inputLine);
            }

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // O literal SPACE é convertido para um espaço em branco na string.
            System.out.println("It's nice to meet you " + userName.name);
        }

        // COBOL: STOP RUN.
        // A execução termina ao final deste método, que é o fim da lógica principal.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main para executar a aplicação.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Userinput().run();
    }
}