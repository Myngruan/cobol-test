package com.converted.cobol;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Multip
 * @author auto-converted from jiuweigui
 */
public class Multip {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private int number1;
    private int number2;
    private int number3;
    private int number4;
    private int result1;
    private int result2;
    private int total;

    // Formatter to simulate COBOL's PIC Z(10).Z(2) for display purposes.
    // Since the source data is integer, the decimal part will be .00.
    // The pattern ensures at least one digit before the decimal point.
    private final DecimalFormat displayFormat = new DecimalFormat("##########0.00");

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // A single Scanner instance is used for all console input (ACCEPT verb)
        try (Scanner scanner = new Scanner(System.in)) {
            calc1(scanner);
            calc2(scanner);
        }
        // COBOL STOP RUN is implicit when this method returns.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde ao parágrafo COBOL "Calc1".
     * @param scanner O scanner para ler a entrada do usuário.
     */
    private void calc1(Scanner scanner) {
        // DISPLAY "Enter the first number: ".
        System.out.print("Enter the first number: ");
        // ACCEPT Number1.
        number1 = scanner.nextInt();

        // DISPLAY "Enter the second number: ".
        System.out.print("Enter the second number: ");
        // ACCEPT Number2.
        number2 = scanner.nextInt();

        // MULTIPLY Number1 BY Number2 GIVING Result1.
        result1 = number1 * number2;

        // DISPLAY "Displaying first result!".
        System.out.println("Displaying first result!");

        // MOVE Result1 to Result1F.
        // DISPLAY Result1F.
        // The MOVE is simulated by formatting the numeric value for display.
        String result1F = displayFormat.format(result1);
        System.out.println(result1F);
    }

    /**
     * Corresponde ao parágrafo COBOL "Calc2".
     * @param scanner O scanner para ler a entrada do usuário.
     */
    private void calc2(Scanner scanner) {
        // DISPLAY "Enter the third number: ".
        System.out.print("Enter the third number: ");
        // ACCEPT Number3.
        number3 = scanner.nextInt();

        // DISPLAY "Enter the fourth number: ".
        System.out.print("Enter the fourth number: ");
        // ACCEPT Number4.
        number4 = scanner.nextInt();

        // MULTIPLY Number3 BY Number4 GIVING Result2.
        result2 = number3 * number4;

        // DISPLAY "Displaying second result!".
        System.out.println("Displaying second result!");

        // MOVE Result2 TO Result2F.
        // DISPLAY Result2F.
        String result2F = displayFormat.format(result2);
        System.out.println(result2F);

        // ADD Result1,Result2 TO Total.
        // In this context, Total is uninitialized (defaults to 0), so this is equivalent to:
        // Total = Result1 + Result2
        total = result1 + result2;

        // MOVE Total TO Formatted.
        String formattedTotal = displayFormat.format(total);

        System.out.println("Entered values:");
        System.out.println("---------------");

        // DISPLAY "First result: ", Result1F.
        // Re-format for the final display summary
        System.out.println("First result: " + displayFormat.format(result1));

        // DISPLAY "Second result: ", Result2F.
        System.out.println("Second result: " + displayFormat.format(result2));

        // DISPLAY "Results added together: ", Formatted.
        System.out.println("Results added together: " + formattedTotal);
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main para executar a classe convertida.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Multip().run();
    }
}