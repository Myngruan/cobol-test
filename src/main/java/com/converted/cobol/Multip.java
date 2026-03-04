package com.converted.cobol;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Multip
 * @author auto-converted (original: jiuweigui)
 */
public class Multip {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    private int number1 = 0;
    private int number2 = 0;
    private int number3 = 0;
    private int number4 = 0;
    private int result1 = 0;
    private String result1F = "";
    private int result2 = 0;
    private String result2F = "";
    private int total = 0;
    private String formatted = "";

    // ── Utilitários para I/O e Formatação ────────────────────────────────
    private final Scanner console = new Scanner(System.in);
    
    // Formatter para PIC Z(10).Z(2)
    // Z(10) -> suprime zeros à esquerda para até 10 dígitos.
    // .Z(2) -> ponto decimal com 2 casas decimais.
    // O padrão "##########0.00" garante que o valor 0 seja exibido como "0.00".
    private final DecimalFormat formatter = new DecimalFormat("##########0.00");

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        try {
            calc1();
            calc2();
        } catch (InputMismatchException e) {
            System.err.println("Erro: Entrada inválida. Por favor, insira apenas números inteiros.");
        } finally {
            // STOP RUN - Encerra o programa e libera recursos.
            console.close();
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde ao parágrafo COBOL 'Calc1'.
     * Pede dois números, calcula o produto e o exibe.
     */
    private void calc1() {
        System.out.print("Enter the first number: ");
        // ACCEPT Number1.
        number1 = console.nextInt();

        System.out.print("Enter the second number: ");
        // ACCEPT Number2.
        number2 = console.nextInt();

        // MULTIPLY Number1 BY Number2 GIVING Result1.
        result1 = number1 * number2;

        System.out.println("Displaying first result!");
        
        // MOVE Result1 to Result1F.
        result1F = formatter.format(result1);
        
        // DISPLAY Result1F.
        System.out.println(result1F);
    }

    /**
     * Corresponde ao parágrafo COBOL 'Calc2'.
     * Pede mais dois números, calcula o produto, soma com o resultado anterior
     * e exibe um resumo final.
     */
    private void calc2() {
        System.out.print("Enter the third number: ");
        // ACCEPT Number3.
        number3 = console.nextInt();

        System.out.print("Enter the fourth number: ");
        // ACCEPT Number4.
        number4 = console.nextInt();

        // MULTIPLY Number3 BY Number4 GIVING Result2.
        result2 = number3 * number4;

        System.out.println("Displaying second result!");
        
        // MOVE Result2 TO Result2F.
        result2F = formatter.format(result2);
        
        // DISPLAY Result2F.
        System.out.println(result2F);

        // ADD Result1,Result2 TO Total.
        // Em COBOL, isso adiciona Result1 e Result2 ao valor atual de Total.
        // Como Total começa em 0, a operação é uma soma simples.
        total = result1 + result2;

        // MOVE Total TO Formatted.
        formatted = formatter.format(total);

        System.out.println("Entered values:");
        System.out.println("---------------");
        System.out.println("First result: " + result1F);
        System.out.println("Second result: " + result2F);
        System.out.println("Results added together: " + formatted);
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main padrão para execução da classe.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Multip().run();
    }
}