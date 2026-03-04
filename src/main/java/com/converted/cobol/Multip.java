package com.converted.cobol;

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

    // NOTE: Os campos formatados (Result1F, Result2F, Formatted) são tratados
    // durante as operações de exibição e não requerem variáveis separadas em Java.
    // Um formatador é usado para emular a cláusula PIC Z(10).Z(2).
    private final DecimalFormat formatter;

    /**
     * Construtor da classe, inicializa os recursos necessários.
     */
    public Multip() {
        // Este formatador emula PIC Z(10).Z(2) para fins de exibição.
        // Formata um inteiro como um decimal com duas casas (ex: 123 -> 123.00).
        // Usamos Locale.US para garantir que o ponto decimal seja '.'
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        this.formatter = new DecimalFormat("0.00", symbols);
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal para a lógica de negócio, equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // Um único Scanner é usado para toda a entrada do console (verbo ACCEPT).
        // É gerenciado por um bloco try-with-resources para garantir que seja fechado.
        try (Scanner scanner = new Scanner(System.in)) {
            calc1(scanner);
            calc2(scanner);
        }
        // STOP RUN é implícito no final deste método.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────
    /**
     * Corresponde ao parágrafo Calc1 do COBOL.
     * @param scanner O scanner para entrada do console.
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
        System.out.println(formatter.format(result1));
    }

    /**
     * Corresponde ao parágrafo Calc2 do COBOL.
     * @param scanner O scanner para entrada do console.
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
        System.out.println(formatter.format(result2));

        // ADD Result1,Result2 TO Total.
        total = result1 + result2;

        // MOVE Total TO Formatted.
        // A formatação é feita diretamente na exibição.

        // DISPLAY "Entered values:".
        System.out.println("Entered values:");
        // DISPLAY "---------------".
        System.out.println("---------------");
        // DISPLAY "First result: ", Result1F.
        System.out.println("First result: " + formatter.format(result1));
        // DISPLAY "Second result: ", Result2F.
        System.out.println("Second result: " + formatter.format(result2));
        // DISPLAY "Results added together: ", Formatted.
        System.out.println("Results added together: " + formatter.format(total));
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * O método main, ponto de entrada da aplicação Java.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Multip().run();
    }
}