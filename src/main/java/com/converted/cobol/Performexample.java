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
    // A variável COBOL "Formatted" é tratada pela formatação sob demanda em Java.

    // ── Handlers de I/O ───────────────────────────────────────────────────
    // Usado para o verbo ACCEPT
    private Scanner console;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que executa a lógica do programa.
     */
    public void run() {
        // Inicializa o scanner para entrada do console
        console = new Scanner(System.in);
        try {
            // A execução começa no primeiro parágrafo, como no COBOL.
            firstStage();
        } finally {
            // Garante que o scanner seja fechado ao final da execução.
            if (console != null) {
                console.close();
            }
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Lógica do parágrafo COBOL: FirstStage
     */
    private void firstStage() {
        System.out.println("------------------");
        System.out.println("This is the first stage of the program.");
        System.out.println("...and next we're at???");
        System.out.println("------------------");
        
        // COBOL: PERFORM ThirdStage
        thirdStage();
        
        System.out.println("------------------");
        System.out.println("Previous one was Third Stage and now we're at 1st.");
        System.out.println("Alas we've ran out lines..");
        System.out.println("------------------");
        
        // COBOL: STOP RUN
        // Em Java, o retorno deste método encerrará a execução do método run(),
        // que efetivamente termina o programa.
    }

    /**
     * Lógica do parágrafo COBOL: SecondStage
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // COBOL: ACCEPT UserInitials
        if (console.hasNextLine()) {
            userInitials = console.nextLine();
        }
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * Lógica do parágrafo COBOL: ThirdStage
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // COBOL: MULTIPLY A BY B GIVING Result.
        result = a * b;
        
        // COBOL: MOVE Result TO Formatted.
        // A variável "Formatted" tem PIC Z(10).Z(2).
        // Isso formata um número inteiro com supressão de zeros à esquerda e
        // adiciona duas casas decimais para exibição.
        DecimalFormat formatter = new DecimalFormat("0.00");
        String formattedResult = formatter.format(result);
        
        System.out.println("We multiplied 30 with 20 and got " + formattedResult);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // COBOL: PERFORM SecondStage.
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