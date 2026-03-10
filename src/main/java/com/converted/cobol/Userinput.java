package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: UserInput
 * @author auto-converted
 */
public class Userinput {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // COBOL:
    // 01 UserName.
    //    02 Name PIC X(10).
    // Mapeado para um único String, pois é um grupo com um único campo de texto.
    private String userName = "";

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // A PROCEDURE DIVISION é executada sequencialmente aqui.
        try (Scanner consoleInput = new Scanner(System.in)) {
            
            // COBOL: DISPLAY "What is your name?".
            System.out.println("What is your name?");

            // COBOL: ACCEPT UserName.
            // Lê a entrada do usuário. O comportamento do COBOL com PIC X(10)
            // é truncar a entrada se ela for maior que 10 caracteres.
            String input = consoleInput.nextLine();
            if (input.length() > 10) {
                this.userName = input.substring(0, 10);
            } else {
                this.userName = input;
            }

            // COBOL: DISPLAY "It's nice to meet you" SPACE Name.
            // Em COBOL, 'Name' é o campo dentro de 'UserName'. Em Java, usamos
            // a variável que representa a estrutura.
            System.out.println("It's nice to meet you " + this.userName);
        }
        
        // COBOL: STOP RUN.
        // A execução do método termina, finalizando o programa.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada padrão para a aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Userinput().run();
    }
}