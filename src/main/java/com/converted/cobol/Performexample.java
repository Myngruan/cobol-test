package com.converted.cobol;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: PerformExample
 * @author jiuweigui (auto-converted)
 */
public class Performexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private String userInitials = "";
    private int a = 30;
    private int b = 20;
    private int result = 0;

    // Formatter para emular PIC Z(10).Z(2)
    private static final DecimalFormat FORMATTER_Z10_Z2 = new DecimalFormat("##########.00");

    // Scanner para emular o comando ACCEPT
    private Scanner consoleScanner;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    public void run() {
        // Inicializa o Scanner para entrada do console dentro de um try-with-resources
        // para garantir que ele seja fechado corretamente.
        try (Scanner scanner = new Scanner(System.in)) {
            this.consoleScanner = scanner;
            // A execução do COBOL começa no primeiro parágrafo.
            firstStage();
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Parágrafo COBOL: FirstStage
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
        // Em Java, o final do método "run" ou uma chamada explícita de System.exit()
        // encerra o programa. Aqui, o retorno para "run" é suficiente.
    }

    /**
     * Parágrafo COBOL: SecondStage
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // ACCEPT UserInitials
        if (consoleScanner.hasNextLine()) {
            userInitials = consoleScanner.nextLine();
            // Garante que a string não exceda o tamanho de PIC X(10)
            if (userInitials.length() > 10) {
                userInitials = userInitials.substring(0, 10);
            }
        }
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * Parágrafo COBOL: ThirdStage
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // MULTIPLY A BY B GIVING Result
        result = a * b;
        
        // MOVE Result TO Formatted
        // A formatação PIC Z(10).Z(2) suprime zeros à esquerda e adiciona duas casas decimais.
        String formatted = FORMATTER_Z10_Z2.format(result);
        
        // O DISPLAY em COBOL geralmente remove espaços à esquerda de campos numéricos editados.
        System.out.println("We multiplied 30 with 20 and got " + formatted.trim());
        
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // PERFORM SecondStage
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        new Performexample().run();
    }
}