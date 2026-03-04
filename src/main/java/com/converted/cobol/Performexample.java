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
     * Este campo é para exibição. A formatação será aplicada no momento do uso.
     */
    // Não é necessário um campo de classe para 'Formatted', 
    // pois ele é usado apenas como um destino temporário para formatação.

    // ── Handlers de I/O ───────────────────────────────────────────────────
    private Scanner scanner;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal da lógica de negócios, chamado pelo main.
     */
    public void run() {
        scanner = new Scanner(System.in);
        try {
            // A execução começa no primeiro parágrafo da PROCEDURE DIVISION.
            firstStage();
        } finally {
            // Garante que o scanner seja fechado para evitar vazamento de recursos.
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // ── Parágrafos convertidos (PROCEDURE DIVISION) ───────────────────────

    /**
     * COBOL: PARAGRAPH FirstStage.
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
        // A execução do método termina aqui, o que encerra o programa.
    }

    /**
     * COBOL: PARAGRAPH SecondStage.
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // COBOL: ACCEPT UserInitials
        this.userInitials = scanner.nextLine();
        
        System.out.println("Hello " + this.userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * COBOL: PARAGRAPH ThirdStage.
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // COBOL: MULTIPLY A BY B GIVING Result.
        this.result = this.a * this.b;
        
        // COBOL: MOVE Result TO Formatted.
        // A PIC Z(10).Z(2) formata um número com supressão de zeros à esquerda.
        // O resultado de 600 seria formatado como "600".
        // A conversão direta para String é suficiente para replicar a saída esperada.
        String formatted = String.valueOf(this.result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // COBOL: PERFORM SecondStage.
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método principal que cria uma instância da classe e executa o programa.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performexample().run();
    }
}