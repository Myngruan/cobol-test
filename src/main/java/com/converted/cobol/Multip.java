package com.converted.cobol;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.InputMismatchException;
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
    private String result1F;
    private int result2;
    private String result2F;
    private int total; // PIC 9(9) fits within a standard Java int
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // O Scanner é usado para o verbo ACCEPT do COBOL, lendo da entrada padrão.
        // O try-with-resources garante que o scanner seja fechado automaticamente.
        try (Scanner consoleInput = new Scanner(System.in)) {
            calc1(consoleInput);
            calc2(consoleInput);
        } catch (InputMismatchException e) {
            System.err.println("ERRO: Entrada inválida. Um valor numérico inteiro era esperado.");
            // No COBOL, isso resultaria em um erro de tempo de execução (data exception).
        }
        // O STOP RUN do COBOL é implícito ao final deste método.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde ao parágrafo COBOL "Calc1".
     * @param consoleInput O scanner para ler a entrada do usuário.
     */
    private void calc1(Scanner consoleInput) {
        System.out.print("Enter the first number: ");
        number1 = consoleInput.nextInt();

        System.out.print("Enter the second number: ");
        number2 = consoleInput.nextInt();

        // COBOL: MULTIPLY Number1 BY Number2 GIVING Result1.
        result1 = number1 * number2;

        System.out.println("Displaying first result!");

        // COBOL: MOVE Result1 to Result1F.
        // A PIC Z(10).Z(2) formata o inteiro com duas casas decimais e suprime zeros à esquerda.
        result1F = formatForDisplay(result1);

        System.out.println(result1F);
    }

    /**
     * Corresponde ao parágrafo COBOL "Calc2".
     * @param consoleInput O scanner para ler a entrada do usuário.
     */
    private void calc2(Scanner consoleInput) {
        System.out.print("Enter the third number: ");
        number3 = consoleInput.nextInt();

        System.out.print("Enter the fourth number: ");
        number4 = consoleInput.nextInt();

        // COBOL: MULTIPLY Number3 BY Number4 GIVING Result2.
        result2 = number3 * number4;

        System.out.println("Displaying second result!");

        // COBOL: MOVE Result2 TO Result2F.
        result2F = formatForDisplay(result2);

        System.out.println(result2F);

        // COBOL: ADD Result1,Result2 TO Total.
        // Isso é C = C + A + B. Como Total é inicializado em 0, equivale a Total = A + B.
        total = result1 + result2;

        // COBOL: MOVE Total TO Formatted.
        formatted = formatForDisplay(total);

        System.out.println("Entered values:");
        System.out.println("---------------");
        System.out.println("First result: " + result1F);
        System.out.println("Second result: " + result2F);
        System.out.println("Results added together: " + formatted);
    }

    /**
     * Método auxiliar para formatar um valor numérico de acordo com a PIC COBOL Z(10).Z(2).
     * Esta formatação suprime zeros à esquerda e adiciona duas casas decimais.
     * @param value O número a ser formatado.
     * @return A string formatada.
     */
    private String formatForDisplay(long value) {
        // A PIC COBOL Z(10).Z(2) é interpretada como um formato com até 10 dígitos
        // antes do ponto decimal e 2 dígitos depois.
        // Usamos Locale.US para garantir que o separador decimal seja '.'
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        // O padrão "##########0.00" garante duas casas decimais e não mostra zeros à esquerda.
        DecimalFormat df = new DecimalFormat("##########0.00", symbols);
        return df.format(value);
    }
}