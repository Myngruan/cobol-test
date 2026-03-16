package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Mapeia a estrutura de dados COBOL:
     * 01 UserName.
     *    02 Name PIC X(10).
     */
    static class UserName {
        // PIC X(10) é um campo de texto de tamanho fixo.
        // Inicializado com espaços para emular o comportamento padrão do COBOL.
        String name = "          ";
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private UserName userName = new UserName();

    // ── Handlers de arquivo (FILE SECTION) ────────────────────────────────
    // Nenhum arquivo é usado neste programa.

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     * Corresponde à PROCEDURE DIVISION.
     */
    public void run() {
        procedureDivision();
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    /**
     * Contém a lógica principal da PROCEDURE DIVISION.
     */
    private void procedureDivision() {
        // Usamos try-with-resources para garantir que o Scanner seja fechado.
        // O Scanner é o análogo Java para o verbo ACCEPT do console.
        try (Scanner scanner = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê a entrada do usuário e a formata para o campo PIC X(10).
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                
                // Emula o comportamento de um campo PIC X(10):
                // - Trunca se for maior que 10 caracteres.
                // - Preenche com espaços à direita se for menor.
                if (input.length() > 10) {
                    userName.name = input.substring(0, 10);
                } else {
                    userName.name = String.format("%-10s", input);
                }
            }

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // O "SPACE" no COBOL insere um espaço entre os itens.
            System.out.println("It's nice to meet you " + userName.name);

            // COBOL: STOP RUN.
            // O programa termina aqui. Em Java, o método simplesmente retorna.
        }
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main padrão para executar a classe.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception para conformidade com o padrão de conversão.
     */
    public static void main(String[] args) throws Exception {
        new Userinput().run();
    }
}