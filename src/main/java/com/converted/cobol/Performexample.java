package com.converted.cobol;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: PerformExample
 * @author auto-converted from jiuweigui
 */
public class Performexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private String userInitials = "";
    private int a = 30;
    private int b = 20;
    private int result = 0;
    // PIC Z(10).Z(2) é um campo de string formatado.
    private String formatted = "";

    // ── Utilitários ───────────────────────────────────────────────────────
    // Scanner para emular a instrução ACCEPT do COBOL.
    private final Scanner scanner = new Scanner(System.in);

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     * O fluxo de controle começa no primeiro parágrafo, firstStage.
     */
    public void run() {
        try {
            firstStage();
        } finally {
            // Garante que o scanner seja fechado ao final da execução.
            scanner.close();
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
        
        // STOP RUN
        // A execução do programa termina aqui, retornando para o método run() que então finaliza.
        return;
    }

    /**
     * COBOL Paragraph: SecondStage
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
     * COBOL Paragraph: ThirdStage
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // MULTIPLY A BY B GIVING Result
        result = a * b;
        
        // MOVE Result TO Formatted (PIC Z(10).Z(2))
        // O COBOL trata o 'Result' (inteiro) como se tivesse um ponto decimal implícito
        // à direita, então 600 se torna 600.00 para formatação.
        // A máscara Z(10).Z(2) suprime zeros à esquerda com espaços.
        DecimalFormat df = new DecimalFormat("0.00");
        String numericPart = df.format(result); // Ex: "600.00"
        // O tamanho total do campo é 13 (10 inteiros + 1 ponto + 2 decimais).
        // String.format preenche com espaços à esquerda para atingir o tamanho total.
        formatted = String.format("%13s", numericPart);
        
        // O comando DISPLAY em COBOL para um campo numérico editado remove os espaços à esquerda.
        // Portanto, usamos trim() para emular esse comportamento.
        System.out.println("We multiplied 30 with 20 and got " + formatted.trim());
        
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // PERFORM SecondStage
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String[] args) throws Exception {
        new Performexample().run();
    }
}