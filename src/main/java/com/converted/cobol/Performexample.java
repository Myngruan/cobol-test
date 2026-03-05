package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: PerformExample
 * @author jiuweigui (auto-converted)
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
    private final int a = 30;

    /**
     * COBOL: 01 B PIC 999 VALUE 20.
     */
    private final int b = 20;

    /**
     * COBOL: 01 Result PIC 999999.
     */
    private int result = 0;

    // Formatted PIC Z(10).Z(2) is handled locally during display operations.

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa.
     * Corresponde ao início da PROCEDURE DIVISION.
     */
    public void run() {
        // O Scanner é usado para a instrução ACCEPT e é fechado automaticamente.
        try (Scanner scanner = new Scanner(System.in)) {
            firstStage(scanner);
        }
        // STOP RUN é implícito ao final deste método.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * COBOL: PARAGRAPH FirstStage.
     * @param scanner Instância do Scanner para I/O do console.
     */
    private void firstStage(Scanner scanner) {
        System.out.println("------------------");
        System.out.println("This is the first stage of the program.");
        System.out.println("...and next we're at???");
        System.out.println("------------------");
        
        // PERFORM ThirdStage.
        thirdStage(scanner);
        
        System.out.println("------------------");
        System.out.println("Previous one was Third Stage and now we're at 1st.");
        System.out.println("Alas we've ran out lines..");
        System.out.println("------------------");
        
        // STOP RUN.
    }

    /**
     * COBOL: PARAGRAPH SecondStage.
     * @param scanner Instância do Scanner para I/O do console.
     */
    private void secondStage(Scanner scanner) {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // ACCEPT UserInitials
        String input = scanner.nextLine();
        
        // Emula PIC X(10) truncando a entrada se for maior que 10 caracteres.
        if (input.length() > 10) {
            userInitials = input.substring(0, 10);
        } else {
            userInitials = input;
        }
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * COBOL: PARAGRAPH ThirdStage.
     * @param scanner Instância do Scanner para I/O do console.
     */
    private void thirdStage(Scanner scanner) {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // MULTIPLY A BY B GIVING Result.
        this.result = this.a * this.b;
        
        // MOVE Result TO Formatted.
        // PIC Z(10).Z(2) formata um inteiro em uma representação decimal,
        // alinhado à direita em um campo de 13 caracteres (10 int + 1 ponto + 2 dec).
        // 'Z' suprime zeros à esquerda com espaços.
        String formatted = String.format("%13.2f", (double)this.result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // PERFORM SecondStage.
        secondStage(scanner);
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main padrão para executar a classe.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performexample().run();
    }
}