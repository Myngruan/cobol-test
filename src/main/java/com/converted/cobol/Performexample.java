package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: PerformExample
 * Example of jumping around using Perform
 * @author auto-converted from jiuweigui
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
     * Mapeado para String para armazenar o resultado formatado.
     */
    private String formatted = "";

    // ── Utilitários ───────────────────────────────────────────────────────
    
    private Scanner scanner;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa.
     */
    public void run() {
        try (Scanner sc = new Scanner(System.in)) {
            this.scanner = sc;
            // A execução começa no primeiro parágrafo da PROCEDURE DIVISION.
            firstStage();
        }
    }

    // ── Parágrafos convertidos (PROCEDURE DIVISION) ───────────────────────

    /**
     * COBOL: FirstStage.
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
        // Em Java, sair do método run() encerra o fluxo do programa.
        return;
    }

    /**
     * COBOL: SecondStage.
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // COBOL: ACCEPT UserInitials
        userInitials = scanner.nextLine();
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * COBOL: ThirdStage.
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // COBOL: MULTIPLY A BY B GIVING Result.
        result = a * b;
        
        // COBOL: MOVE Result TO Formatted.
        // A máscara PIC Z(10).Z(2) formata o número com até 10 dígitos inteiros
        // (suprimindo zeros à esquerda com espaços) e 2 casas decimais.
        // A largura total é 13 (10 + ponto + 2).
        // String.format é uma boa aproximação para isso.
        formatted = String.format("%13.2f", (double)result).trim();
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // COBOL: PERFORM SecondStage.
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main padrão para iniciar a execução do programa.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performexample().run();
    }
}