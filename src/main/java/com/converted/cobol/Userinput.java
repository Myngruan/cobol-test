package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted (original: jiuweigui)
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

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa, convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // Um Scanner é usado para ler a entrada do console, o que é o equivalente
        // moderno do verbo COBOL 'ACCEPT'.
        try (Scanner scanner = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê uma linha do console e a formata para o comportamento de PIC X(10),
            // que trunca ou preenche com espaços à direita para atingir o comprimento fixo.
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                userName.name = formatToPicX(input, 10);
            }

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // Concatena a string literal, um espaço e o conteúdo da variável 'name'.
            // A saída incluirá os espaços de preenchimento, replicando o comportamento do COBOL.
            System.out.println("It's nice to meet you " + userName.name);
        }
        // COBOL: STOP RUN.
        // O programa termina quando o método run() é concluído.
    }

    /**
     * Formata uma string para emular o comportamento de um campo COBOL PIC X(n).
     * A string é truncada se for muito longa ou preenchida com espaços à direita
     * se for muito curta.
     *
     * @param value A string de entrada.
     * @param length O comprimento fixo desejado.
     * @return A string formatada com o comprimento exato.
     */
    private String formatToPicX(String value, int length) {
        if (value == null) {
            value = "";
        }
        if (value.length() > length) {
            return value.substring(0, length);
        } else {
            return String.format("%-" + length + "s", value);
        }
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada principal para a aplicação Java.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Userinput().run();
    }
}