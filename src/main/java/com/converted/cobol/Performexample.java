package com.converted.cobol;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: PerformExample
 * @author auto-converted
 */
public class Performexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private String userInitials = "";
    private int a = 30;
    private int b = 20;
    private int result = 0;
    private String formatted = "";

    // ── Helpers para I/O e formatação ─────────────────────────────────────
    private Scanner consoleScanner;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        consoleScanner = new Scanner(System.in);
        try {
            // A execução do COBOL começa no primeiro parágrafo.
            firstStage();
        } finally {
            // Garante que o recurso de entrada seja fechado.
            if (consoleScanner != null) {
                consoleScanner.close();
            }
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * COBOL Paragraph: FirstStage
     */
    private void firstStage() {
        System.out.println("------------------");
        System.out.println("This is the first stage of the program.");
        System.out.println("...and next we're at???");
        System.out.println("------------------");
        
        // PERFORM ThirdStage
        thirdStage();
        
        System.out.println("------------------");
        System.out.println("Previous one was Third Stage and now we're at 1st.");
        System.out.println("Alas we've ran out lines..");
        System.out.println("------------------");
        
        // STOP RUN: A execução termina aqui. O método retorna e o programa encerra.
    }

    /**
     * COBOL Paragraph: SecondStage
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // ACCEPT UserInitials
        userInitials = consoleScanner.nextLine();
        
        // Garante que a string não exceda o tamanho do PIC X(10)
        if (userInitials.length() > 10) {
            userInitials = userInitials.substring(0, 10);
        }
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * COBOL Paragraph: ThirdStage
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // MULTIPLY A BY B GIVING Result
        result = a * b;
        
        // MOVE Result TO Formatted (PIC Z(10).Z(2))
        // Formata o número inteiro para ter duas casas decimais, suprimindo zeros à esquerda.
        DecimalFormat df = new DecimalFormat("##########.00");
        formatted = df.format(result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // PERFORM SecondStage
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main padrão para iniciar a execução da classe.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performexample().run();
    }
}