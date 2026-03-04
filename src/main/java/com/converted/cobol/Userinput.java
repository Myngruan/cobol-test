package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Corresponde à estrutura de dados COBOL '01 UserName'.
     */
    static class UserName {
        // 02 Name PIC X(10).
        String name = "";
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private UserName userName = new UserName();

    // ── Ponto de entrada e lógica principal ───────────────────────────────
    /**
     * Executa a lógica principal convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // O Scanner emula o verbo ACCEPT do COBOL para entrada do console.
        // O bloco try-with-resources garante que o scanner seja fechado.
        try (Scanner scanner = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê uma linha da entrada padrão e a formata para corresponder a PIC X(10).
            // A entrada é truncada se tiver mais de 10 caracteres ou
            // preenchida com espaços à direita se for menor.
            String input = scanner.nextLine();
            userName.name = formatToPicX(input, 10);

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // O 'SPACE' do COBOL é traduzido como um espaço literal na string.
            System.out.println("It's nice to meet you " + userName.name);
        }
        // COBOL: STOP RUN.
        // O programa termina naturalmente ao final do método run.
    }

    /**
     * Formata uma string para emular o comportamento de um campo COBOL PIC X(n).
     * @param value A string de entrada.
     * @param length O tamanho fixo do campo.
     * @return A string formatada (truncada ou com padding).
     */
    private String formatToPicX(String value, int length) {
        if (value.length() > length) {
            return value.substring(0, length);
        }
        return String.format("%-" + length + "s", value);
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado durante a execução.
     */
    public static void main(String[] args) throws Exception {
        new Userinput().run();
    }
}