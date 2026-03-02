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
     * Mapeado para String, a formatação será aplicada no momento do uso.
     */
    private String formatted = "";


    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa.
     * Corresponde ao início da PROCEDURE DIVISION.
     */
    public void run() {
        // O Scanner é usado para o verbo ACCEPT e é gerenciado com try-with-resources.
        try (Scanner scanner = new Scanner(System.in)) {
            firstStage(scanner);
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * COBOL: PARAGRAPH FirstStage.
     * @param scanner Instância do Scanner para entrada do usuário.
     */
    private void firstStage(Scanner scanner) {
        System.out.println("------------------");
        System.out.println("This is the first stage of the program.");
        System.out.println("...and next we're at???");
        System.out.println("------------------");
        
        // COBOL: PERFORM ThirdStage.
        thirdStage(scanner);
        
        System.out.println("------------------");
        System.out.println("Previous one was Third Stage and now we're at 1st.");
        System.out.println("Alas we've ran out lines..");
        System.out.println("------------------");
        
        // COBOL: STOP RUN.
        // Retornar do método inicial encerra a execução do programa.
        return;
    }

    /**
     * COBOL: PARAGRAPH SecondStage.
     * @param scanner Instância do Scanner para entrada do usuário.
     */
    private void secondStage(Scanner scanner) {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // COBOL: ACCEPT UserInitials
        userInitials = scanner.nextLine();
        // Garante que a entrada não exceda o tamanho original do COBOL PIC X(10)
        if (userInitials.length() > 10) {
            userInitials = userInitials.substring(0, 10);
        }
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * COBOL: PARAGRAPH ThirdStage.
     * @param scanner Instância do Scanner para entrada do usuário.
     */
    private void thirdStage(Scanner scanner) {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // COBOL: MULTIPLY A BY B GIVING Result.
        result = a * b;
        
        // COBOL: MOVE Result TO Formatted.
        // A máscara PIC Z(10).Z(2) formata o número em um campo de 13 caracteres,
        // com 2 casas decimais, suprimindo zeros à esquerda com espaços.
        // Ex: 600 -> "         600.00"
        formatted = String.format("%13.2f", (double)result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // COBOL: PERFORM SecondStage.
        secondStage(scanner);
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main padrão para execução da classe.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performexample().run();
    }
}