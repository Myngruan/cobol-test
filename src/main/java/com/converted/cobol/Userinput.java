package com.converted.cobol;

import java.io.IOException;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted (original: jiuweigui)
 */
public class Userinput {

    // ── Inner classes para estruturas de dados (nível 01) ─────────────────

    /**
     * Corresponde à estrutura de dados 01 UserName.
     */
    static class UserName {
        /**
         * Corresponde a: 02 Name PIC X(10).
         */
        String name = "";
    }

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────

    private UserName userName = new UserName();

    // ── Ponto de entrada ─────────────────────────────────────────────────

    /**
     * Executa a lógica principal do programa, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // A PROCEDURE DIVISION inteira é mapeada para este método.
        
        // Usamos um Scanner para ler a entrada do console, que é o equivalente
        // moderno do ACCEPT do COBOL para entrada de terminal.
        Scanner consoleInput = new Scanner(System.in);

        // COBOL: DISPLAY "What is your name?".
        System.out.println("What is your name?");

        // COBOL: ACCEPT UserName.
        // Lê a próxima linha de entrada do usuário e a armazena no campo "name".
        // Em Java, uma String não tem um tamanho fixo como PIC X(10),
        // então a entrada do usuário não é truncada ou preenchida.
        if (consoleInput.hasNextLine()) {
            this.userName.name = consoleInput.nextLine();
        }

        // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
        // Concatena a string literal com o nome fornecido pelo usuário.
        // O "SPACE" do COBOL é traduzido para um espaço literal " ".
        System.out.println("It's nice to meet you " + this.userName.name);

        // COBOL: STOP RUN.
        // A execução do método "run" termina aqui, e como é chamado pelo "main",
        // o programa encerra, o que é o equivalente a STOP RUN.
        // Não é recomendado fechar o Scanner para System.in.
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