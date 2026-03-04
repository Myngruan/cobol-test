package com.converted.cobol;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Multip
 * @author auto-converted
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

    // Formatter for PIC Z(10).Z(2)
    private static final DecimalFormat PIC_Z10_Z2_FORMATTER = createPicZ10Z2Formatter();

    /**
     * Creates a DecimalFormat instance to simulate COBOL's PIC Z(10).Z(2).
     * This format suppresses leading zeros for up to 10 integer digits and always shows 2 decimal places.
     * @return A configured DecimalFormat instance.
     */
    private static DecimalFormat createPicZ10Z2Formatter() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        // The format "##########.00" suppresses leading zeros and ensures two decimal places.
        DecimalFormat formatter = new DecimalFormat("##########.00", symbols);
        formatter.setMinimumIntegerDigits(1); // Ensures "0.00" instead of ".00" for zero values.
        return formatter;
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Main execution logic, equivalent to the COBOL PROCEDURE DIVISION.
     */
    public void run() {
        // A single Scanner instance is used for all console input.
        // try-with-resources ensures it's closed automatically.
        try (Scanner scanner = new Scanner(System.in)) {
            calc1(scanner);
            calc2(scanner);
        } catch (Exception e) {
            System.err.println("Erro durante a execução: " + e.getMessage());
        }
        // COBOL: STOP RUN.
        // In Java, the program terminates when the run() method completes.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponds to the 'Calc1' paragraph in the COBOL program.
     * @param scanner The scanner to use for user input.
     */
    private void calc1(Scanner scanner) {
        System.out.print("Enter the first number: ");
        number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        number2 = scanner.nextInt();

        // COBOL: MULTIPLY Number1 BY Number2 GIVING Result1.
        result1 = number1 * number2;

        System.out.println("Displaying first result!");

        // COBOL: MOVE Result1 to Result1F.
        // COBOL: DISPLAY Result1F.
        // The formatting and display are combined in one step.
        String result1F = PIC_Z10_Z2_FORMATTER.format(result1);
        System.out.println(result1F);
    }

    /**
     * Corresponds to the 'Calc2' paragraph in the COBOL program.
     * @param scanner The scanner to use for user input.
     */
    private void calc2(Scanner scanner) {
        System.out.print("Enter the third number: ");
        number3 = scanner.nextInt();

        System.out.print("Enter the fourth number: ");
        number4 = scanner.nextInt();

        // COBOL: MULTIPLY Number3 BY Number4 GIVING Result2.
        result2 = number3 * number4;

        System.out.println("Displaying second result!");

        // COBOL: MOVE Result2 TO Result2F.
        // COBOL: DISPLAY Result2F.
        String result2F = PIC_Z10_Z2_FORMATTER.format(result2);
        System.out.println(result2F);

        // COBOL: ADD Result1,Result2 TO Total.
        // This is interpreted as GIVING Total = Result1 + Result2,
        // as Total is not used as an accumulator before this.
        total = result1 + result2;

        // COBOL: MOVE Total TO Formatted.
        String formattedTotal = PIC_Z10_Z2_FORMATTER.format(total);

        // Re-format Result1 for the final summary display
        String result1F = PIC_Z10_Z2_FORMATTER.format(result1);

        System.out.println("Entered values:");
        System.out.println("---------------");
        System.out.println("First result: " + result1F);
        System.out.println("Second result: " + result2F);
        System.out.println("Results added together: " + formattedTotal);
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * The main entry point for the Java application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        new Multip().run();
    }
}