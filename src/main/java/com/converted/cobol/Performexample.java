package com.converted.cobol;

import java.util.Scanner;
import java.lang.String;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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

    // ── Recursos de I/O ───────────────────────────────────────────────────
    private final Scanner scanner;

    /**
     * Construtor da classe.
     */
    public Performexample() {
        this.scanner = new Scanner(System.in);
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────
    public void run() {
        try {
            // O fluxo do programa começa no primeiro parágrafo.
            firstStage();
        } finally {
            // Garante que os recursos sejam fechados.
            scanner.close();
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde ao parágrafo "FirstStage" do COBOL.
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
        // A execução termina ao retornar deste método para o "run".
    }

    /**
     * Corresponde ao parágrafo "SecondStage" do COBOL.
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // ACCEPT UserInitials
        userInitials = scanner.nextLine();
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * Corresponde ao parágrafo "ThirdStage" do COBOL.
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // MULTIPLY A BY B GIVING Result.
        result = a * b;
        
        // MOVE Result TO Formatted.
        // A PIC Z(10).Z(2) formata um número em um campo de 13 caracteres
        // (10 para a parte inteira, 1 para o ponto, 2 para a decimal),
        // com supressão de zeros à esquerda (substituídos por espaços).
        // O valor inteiro "result" é tratado como "result.00".
        // String.format("%13.2f", ...) é o equivalente direto em Java.
        formatted = String.format("%13.2f", (double)result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // PERFORM SecondStage.
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String[] args) throws Exception {
        new Performexample().run();
    }
}