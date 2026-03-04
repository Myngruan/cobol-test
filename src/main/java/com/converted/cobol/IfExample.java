package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: if-example
 * @author auto-converted (original: jiuweigui)
 */
public class IfExample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * Mapeia: 01 UserInput PIC X(20).
     * Em Java, String é usada para campos alfanuméricos. O comprimento fixo
     * do COBOL não é imposto por padrão, mas pode ser validado se necessário.
     */
    private String userInput = "";

    // ── Ponto de entrada da lógica do programa ───────────────────────────
    
    /**
     * Executa a lógica principal convertida da PROCEDURE DIVISION.
     */
    public void run() {
        // Usamos try-with-resources para garantir que o Scanner seja fechado.
        try (Scanner scanner = new Scanner(System.in)) {
            
            // COBOL: DISPLAY "Please enter your name in upper-case: ".
            // Usamos print para manter o cursor na mesma linha para a entrada.
            System.out.print("Please enter your name in upper-case: ");

            // COBOL: ACCEPT UserInput.
            // Lemos a linha inteira da entrada padrão.
            userInput = scanner.nextLine();

            // Em COBOL, a variável teria um comprimento fixo e seria preenchida com espaços.
            // A verificação 'IS ALPHABETIC-LOWER' falharia com espaços.
            // A intenção moderna é verificar o texto real inserido, então usamos trim().
            String trimmedInput = userInput.trim();

            // COBOL: IF UserInput IS ALPHABETIC-LOWER
            if (isAlphabeticLower(trimmedInput)) {
                // COBOL: MOVE FUNCTION UPPER-CASE (UserInput) TO UserInput
                userInput = trimmedInput.toUpperCase();
                
                // COBOL: DISPLAY "Plz uppercase. Fixed it, ", UserInput
                System.out.println("Plz uppercase. Fixed it, " + userInput);
            } else {
                // COBOL: ELSE DISPLAY "Hello, ", UserInput
                System.out.println("Hello, " + trimmedInput);
            }
        }
        // COBOL: STOP RUN.
        // O método run() termina, finalizando a execução do programa.
    }

    /**
     * Simula a verificação COBOL 'IS ALPHABETIC-LOWER'.
     * Esta verificação é verdadeira se a string contiver exclusivamente
     * caracteres de 'a' a 'z'.
     * @param str A string a ser verificada.
     * @return true se todos os caracteres forem letras minúsculas, false caso contrário.
     */
    private boolean isAlphabeticLower(String str) {
        // Garante que a string não seja nula ou vazia.
        if (str == null || str.isEmpty()) {
            return false;
        }
        // A expressão regular "[a-z]+" corresponde a uma ou mais letras minúsculas do alfabeto ASCII.
        return str.matches("[a-z]+");
    }

    // ── main: Ponto de entrada da aplicação Java ─────────────────────────
    
    /**
     * Cria uma instância da classe e executa a lógica principal.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new IfExample().run();
    }
}