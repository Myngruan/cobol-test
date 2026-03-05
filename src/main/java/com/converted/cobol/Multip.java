package com.converted.cobol;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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
    private int total;
    private String formatted;

    // ── Utilitários de conversão ──────────────────────────────────────────
    private final Scanner scanner;
    private final DecimalFormat picZ10_2Format;

    /**
     * Construtor que inicializa os recursos necessários.
     */
    public Multip() {
        this.scanner = new Scanner(System.in);
        
        // Formato para PIC Z(10).Z(2)
        // 'Z' em COBOL é substituído por '#' em DecimalFormat para suprimir zeros à esquerda.
        // O padrão total tem 13 posições (10 inteiros + ponto + 2 decimais).
        // Usamos um padrão fixo para garantir o preenchimento com espaços à esquerda.
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        this.picZ10_2Format = new DecimalFormat("##########0.00", symbols);
        this.picZ10_2Format.setMinimumIntegerDigits(1);
    }

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal para a execução da lógica do programa.
     */
    public void run() {
        try {
            calc1();
            calc2();
        } finally {
            // Equivalente ao fim do programa, fechando recursos abertos.
            if (scanner != null) {
                scanner.close();
            }
        }
        // STOP RUN é implícito ao final do método run.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Lógica do parágrafo 'Calc1'.
     * Realiza o primeiro cálculo de multiplicação.
     */
    private void calc1() {
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
        result1F = formatPicZ(result1);
        
        // DISPLAY Result1F.
        System.out.println(result1F);
    }

    /**
     * Lógica do parágrafo 'Calc2'.
     * Realiza o segundo cálculo, a soma e exibe os resultados finais.
     */
    private void calc2() {
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
        result2F = formatPicZ(result2);
        
        // DISPLAY Result2F.
        System.out.println(result2F);

        // ADD Result1,Result2 TO Total.
        total = result1 + result2;

        // MOVE Total TO Formatted.
        formatted = formatPicZ(total);

        // DISPLAY "Entered values:".
        System.out.println("Entered values:");
        // DISPLAY "---------------".
        System.out.println("---------------");
        // DISPLAY "First result: ", Result1F.
        System.out.println("First result: " + result1F);
        // DISPLAY "Second result: ", Result2F.
        System.out.println("Second result: " + result2F);
        // DISPLAY "Results added together: ", Formatted.
        System.out.println("Results added together: " + formatted);
    }

    /**
     * Formata um número inteiro para simular o formato COBOL PIC Z(10).Z(2).
     * Isso resulta em uma string com 13 caracteres de largura, com espaços à esquerda.
     * @param value O valor inteiro a ser formatado.
     * @return A string formatada.
     */
    private String formatPicZ(int value) {
        // Converte o inteiro para um double para formatação com casas decimais.
        double doubleValue = (double) value;
        String formattedString = picZ10_2Format.format(doubleValue);
        
        // Garante o preenchimento com espaços à esquerda para um total de 13 caracteres.
        return String.format("%13s", formattedString);
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main padrão para iniciar a aplicação.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Multip().run();
        // STOP RUN é equivalente a System.exit(0) no contexto do main,
        // mas como run() retorna, a JVM encerra normalmente.
    }
}