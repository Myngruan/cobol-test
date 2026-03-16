package com.converted.cobol;

import java.text.DecimalFormat;
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
     * Representado como String em Java. A formatação é aplicada durante a atribuição.
     */
    private String formatted = "";

    // ── Recursos de I/O ───────────────────────────────────────────────────
    
    /**
     * Scanner para lidar com a instrução COBOL "ACCEPT".
     */
    private final Scanner consoleScanner = new Scanner(System.in);

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa, começando pelo primeiro parágrafo.
     */
    public void run() {
        try {
            firstStage();
        } finally {
            // Garante que o scanner seja fechado ao final da execução.
            consoleScanner.close();
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
        // Em Java, retornar do método principal de execução encerra o fluxo.
        return;
    }

    /**
     * COBOL: SecondStage.
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // COBOL: ACCEPT UserInitials
        String input = consoleScanner.nextLine();
        // Trunca a entrada se for maior que o tamanho definido em PIC X(10).
        if (input.length() > 10) {
            userInitials = input.substring(0, 10);
        } else {
            userInitials = input;
        }
        
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
        // A máscara PIC Z(10).Z(2) formata um número inteiro como um decimal com duas casas.
        // O 'Z' suprime zeros à esquerda. A exibição (DISPLAY) geralmente remove o preenchimento de espaços.
        DecimalFormat df = new DecimalFormat("0.00");
        formatted = df.format(result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // COBOL: PERFORM SecondStage.
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método principal que instancia e executa o programa.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performexample().run();
    }
}