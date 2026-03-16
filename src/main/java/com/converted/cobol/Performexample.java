package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: PerformExample
 * @author auto-converted
 */
public class Performexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * COBOL: 01 UserInitials PIC x(10).
     */
    private String userInitials = "";
    
    /**
     * COBOL: 01 A PIC 999 VALUE 30.
     */
    private int a = 30;
    
    /**
     * COBOL: 01 B PIC 999 VALUE 20.
     */
    private int b = 20;
    
    /**
     * COBOL: 01 Result PIC 999999.
     */
    private int result = 0;
    
    /**
     * COBOL: 01 Formatted PIC Z(10).Z(2).
     * This will hold the string representation after formatting.
     */
    private String formatted = "";

    // Helper for console input (ACCEPT verb)
    private Scanner scanner;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa.
     */
    public void run() {
        scanner = new Scanner(System.in);
        try {
            // A execução começa no primeiro parágrafo da PROCEDURE DIVISION.
            firstStage();
        } finally {
            // Garante que o scanner seja fechado ao final da execução.
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde ao parágrafo COBOL: FirstStage.
     */
    private void firstStage() {
        System.out.println("------------------");
        System.out.println("This is the first stage of the program.");
        System.out.println("...and next we're at???");
        System.out.println("------------------");
        
        // COBOL: PERFORM ThirdStage.
        thirdStage();
        
        System.out.println("------------------");
        System.out.println("Previous one was Third Stage and now we're at 1st.");
        System.out.println("Alas we've ran out lines..");
        System.out.println("------------------");
        
        // COBOL: STOP RUN.
        // Em Java, o retorno deste método encerra o fluxo principal.
    }

    /**
     * Corresponde ao parágrafo COBOL: SecondStage.
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // COBOL: ACCEPT UserInitials
        String input = scanner.nextLine();
        
        // Emula o comportamento de PIC X(10) truncando a entrada se for maior.
        if (input.length() > 10) {
            userInitials = input.substring(0, 10);
        } else {
            userInitials = input;
        }
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * Corresponde ao parágrafo COBOL: ThirdStage.
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // COBOL: MULTIPLY A BY B GIVING Result.
        result = a * b;
        
        // COBOL: MOVE Result TO Formatted.
        // A máscara PIC Z(10).Z(2) formata o número em um campo de 13 caracteres
        // (10 para a parte inteira, 1 para o ponto, 2 para a fração)
        // com supressão de zeros à esquerda (substituídos por espaços).
        // String.format("%13.2f", ...) é um equivalente próximo em Java.
        formatted = String.format("%13.2f", (double)result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // COBOL: PERFORM SecondStage.
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main padrão para execução da classe.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new Performexample().run();
    }
}