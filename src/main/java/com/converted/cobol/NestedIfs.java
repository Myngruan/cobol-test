package com.converted.cobol;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Convertido de: Nested-IFs
 * Example using Nested IFs
 * AUTHOR: jiuweigui
 */
public class NestedIfs {

    // WORKING-STORAGE SECTION
    private int a;
    private int b;
    private int result;
    // 01 FORMATTED PIC Z(9) is handled by the formatZ9 method.

    /**
     * Formatter for PIC Z(9). Suppresses leading zeros.
     * In COBOL, DISPLAY on a Z-edited field typically trims leading spaces.
     * So, a simple String conversion is the most direct equivalent for console output.
     */
    private static final DecimalFormat Z9_FORMAT = new DecimalFormat("#########");

    /**
     * Main business logic, equivalent to PROCEDURE DIVISION.
     */
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            // DISPLAY "Enter the first value: ".
            System.out.print("Enter the first value: ");
            // ACCEPT A.
            this.a = scanner.nextInt();

            // DISPLAY "You entered ", A " as a value.".
            System.out.println("You entered " + this.a + " as a value.");

            // DISPLAY "Please enter the second value: ".
            System.out.print("Please enter the second value: ");
            // ACCEPT B.
            this.b = scanner.nextInt();

            // DISPLAY "You entered ", B " as a second value.".
            System.out.println("You entered " + this.b + " as a second value.");

            // COMPUTE RESULT = A + B.
            this.result = this.a + this.b;

            // IF (A < 10) AND (B > 10) THEN
            if (this.a < 10 && this.b > 10) {
                // IF RESULT > 50 THEN
                if (this.result > 50) {
                    // DISPLAY "Result is bigger than 50."
                    System.out.println("Result is bigger than 50.");
                } else {
                    // ELSE
                    //   MOVE RESULT TO FORMATTED
                    //   DISPLAY FORMATTED
                    System.out.println(formatZ9(this.result));
                }
                // END-IF
            } else {
                // ELSE DISPLAY "Whatever."
                System.out.println("Whatever.");
            }
            // END-IF

        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid numeric input.");
        }
        // STOP RUN.
    }

    /**
     * Formats an integer according to PIC Z(9).
     * @param value The integer to format.
     * @return The formatted string.
     */
    private String formatZ9(int value) {
        return Z9_FORMAT.format(value);
    }

    /**
     * Entry point for the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Creates an