package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: PerformExample
 * @author auto-converted
 */
public class Performexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 UserInitials PIC x(10).
    private String userInitials = "";
    
    // 01 A PIC 999 VALUE 30.
    private int a = 30;
    
    // 01 B PIC 999 VALUE 20.
    private int b = 20;
    
    // 01 Result PIC 999999.
    private int result = 0;
    
    // 01 Formatted PIC Z(10).Z(2).
    private String formatted = "";

    // ── Handlers de I/O (para ACCEPT) ─────────────────────────────────────
    private Scanner consoleScanner;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que orquestra a execução,
     * simulando a PROCEDURE DIVISION.
     */
    public void run() {
        consoleScanner = new Scanner(System.in);
        try {
            // A execução em COBOL começa no primeiro parágrafo.
            firstStage();
        } finally {
            // Garante que os recursos sejam liberados.
            if (consoleScanner != null) {
                consoleScanner.close();
            }
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Parágrafo: FirstStage
     */
    private void firstStage() {
        System.out.println("------------------");
        System.out.println("This is the first stage of the program.");
        System.out.println("...and next we're at???");
        System.out.println("------------------");
        
        // PERFORM ThirdStage.
        thirdStage();
        
        System.out.println("------------------");
        System.out.println("Previous one was Third Stage and now we're at 1st.");
        System.out.println("Alas we've ran out lines..");
        System.out.println("------------------");
        
        // STOP RUN.
        // Em uma estrutura de método, "return" encerra a execução deste fluxo.
        // Como este é o método de nível superior chamado por run(), o programa terminará.
        return;
    }

    /**
     * Parágrafo: SecondStage
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // ACCEPT UserInitials
        userInitials = consoleScanner.nextLine();
        // Garante que a string se ajuste à definição PIC X(10)
        if (userInitials.length() > 10) {
            userInitials = userInitials.substring(0, 10);
        }
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * Parágrafo: ThirdStage
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // MULTIPLY A BY B GIVING Result.
        result = a * b;
        
        // MOVE Result TO Formatted.
        // COBOL: PIC Z(10).Z(2) formata o inteiro "Result" em um campo de 13 caracteres
        // com 2 casas decimais, supressão de zeros à esquerda e preenchimento com espaços.
        // Ex: 600 se torna "       600.00"
        formatted = String.format("%13.2f", (double)result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // PERFORM SecondStage.
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main padrão para execução da classe.
     * @param args Argumentos de linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new Performexample().run();
    }
}