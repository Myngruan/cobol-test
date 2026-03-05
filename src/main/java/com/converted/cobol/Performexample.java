package com.converted.cobol;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

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
     * Mapeado para String, a formatação é aplicada na atribuição.
     */
    private String formatted = "";

    /**
     * Helper para ler a entrada do console, substituindo o verbo ACCEPT.
     */
    private final Scanner console = new Scanner(System.in);

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal da lógica de negócios, análogo à PROCEDURE DIVISION.
     */
    public void run() {
        // A execução começa no primeiro parágrafo do COBOL.
        firstStage();
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde ao parágrafo COBOL: FirstStage
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
        
        // STOP RUN
        // Retornar do método inicial invocado por run() encerra o programa.
    }

    /**
     * Corresponde ao parágrafo COBOL: SecondStage
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // ACCEPT UserInitials
        userInitials = console.nextLine();
        
        // Garante que a string não exceda o tamanho definido em PIC X(10)
        if (userInitials.length() > 10) {
            userInitials = userInitials.substring(0, 10);
        }
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * Corresponde ao parágrafo COBOL: ThirdStage
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // MULTIPLY A BY B GIVING Result
        result = a * b;
        
        // MOVE Result TO Formatted (PIC Z(10).Z(2))
        // O verbo MOVE para um campo numérico editado formata o número.
        // O resultado de DISPLAY em um campo editado geralmente remove espaços à esquerda.
        // A formatação "0.00" garante duas casas decimais.
        NumberFormat formatter = new DecimalFormat("0.00");
        formatted = formatter.format(result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // PERFORM SecondStage
        secondStage();
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