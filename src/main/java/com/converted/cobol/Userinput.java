package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted from jiuweigui
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────
    /**
     * Mapeia a estrutura COBOL:
     * 01 UserName.
     *    02 Name PIC X(10).
     */
    static class UserNameRecord {
        // PIC X(10) -> String. Inicializado para evitar NullPointerException.
        String name = "";
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private UserNameRecord userName = new UserNameRecord();

    // ── Ponto de entrada da lógica do programa ───────────────────────────
    /**
     * Executa a lógica principal convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // Usar try-with-resources para garantir que o Scanner seja fechado.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê a entrada do usuário do console.
            String line = consoleInput.nextLine();

            // Simula o preenchimento do campo PIC X(10): truncando ou preenchendo com espaços à direita.
            if (line.length() > 10) {
                userName.name = line.substring(0, 10);
            } else {
                userName.name = String.format("%-10s", line);
            }

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // O 'SPACE' em COBOL insere um único espaço.
            // A variável 'name' é exibida com seu preenchimento de espaços,
            // que é o comportamento literal do COBOL.
            System.out.println("It's nice to meet you " + userName.name);
        }
        // COBOL: STOP RUN.
        // A execução termina quando o método 'run' retorna.
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Ponto de entrada principal para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception para conformidade com o template, embora nenhuma exceção verificada seja lançada aqui.
     */
    public static void main(String[] args) throws Exception {
        new Userinput().run();
    }
}