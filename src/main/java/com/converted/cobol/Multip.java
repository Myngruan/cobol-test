package com.converted.cobol;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Multip
 * COBOL Author: jiuweigui
 * @author auto-converted
 */
public class Multip {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    // 01 Number1 PIC 99.
    private int number1;
    // 01 Number2 PIC 99.
    private int number2;
    // 01 Number3 PIC 99.
    private int number3;
    // 01 Number4 PIC 99.
    private int number4;
    // 01 Result1  PIC 99999.
    private int result1;
    // 01 Result2 PIC 99999.
    private int result2;
    // 01 Total PIC 999999999.
    private int total;

    // Campos formatados (Result1F, Result2F, Formatted) são tratados em tempo de execução.

    // ── Utilitários para I/O e Formatação ─────────────────────────────────
    private Scanner consoleInput;
    private NumberFormat formatter;

    /**
     * Ponto de entrada que executa a lógica principal do programa.
     * Equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            this.consoleInput = scanner;
            initializeFormatter();

            // Executa os parágrafos em sequência
            calc1();
            calc2();

        } catch (InputMismatchException e) {
            System.err.println("ERRO: Entrada inválida. Por favor, insira apenas números inteiros.");
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
        // COBOL: STOP RUN é implícito ao final deste método.
    }

    /**
     * Configura o formatador de números para emular PIC Z(10).Z(2).
     */
    private void initializeFormatter() {
        // O formato PIC Z(10).Z(2) é traduzido para um DecimalFormat.
        // "Z" em COBOL suprime zeros à esquerda, o que é o comportamento padrão.
        // ".Z(2)" é incomum, mas a intenção é quase sempre mostrar dois decimais.
        // Usamos "0.00" para garantir dois decimais e setMaximumIntegerDigits para o limite.
        this.formatter = new DecimalFormat();
        formatter.setMaximumIntegerDigits(10);
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        formatter.setGroupingUsed(false); // PIC Z não usa separadores de milhar por padrão
    }

    /**
     * Converte o parágrafo COBOL "Calc1".
     * Pede dois números, multiplica-os e exibe o resultado formatado.
     */
    private void calc1() {
        System.out.print("Enter the first number: ");
        number1 = consoleInput.nextInt();

        System.out.print("Enter the second number: ");
        number2 = consoleInput.nextInt();

        // COBOL: MULTIPLY Number1 BY Number2 GIVING Result1.
        result1 = number1 * number2;

        System.out.println("Displaying first result!");
        
        // COBOL: MOVE Result1 to Result1F.
        // COBOL: DISPLAY Result1F.
        String result1F = formatter.format(result1);
        System.out.println(result1F.trim());
    }

    /**
     * Converte o parágrafo COBOL "Calc2".
     * Pede mais dois números, multiplica-os, soma os resultados e exibe um resumo.
     */
    private void calc2() {
        System.out.print("Enter the third number: ");
        number3 = consoleInput.nextInt();

        System.out.print("Enter the fourth number: ");
        number4 = consoleInput.nextInt();

        // COBOL: MULTIPLY Number3 BY Number4 GIVING Result2.
        result2 = number3 * number4;

        System.out.println("Displaying second result!");
        
        // COBOL: MOVE Result2 TO Result2F.
        // COBOL: DISPLAY Result2F.
        String result2F = formatter.format(result2);
        System.out.println(result2F.trim());

        // COBOL: ADD Result1,Result2 TO Total.
        // Como Total começa em 0, é equivalente a Total = Result1 + Result2.
        total = result1 + result2;

        // COBOL: MOVE Total TO Formatted.
        String formattedTotal = formatter.format(total);

        // Formata novamente os resultados para a exibição final, garantindo consistência.
        String result1F_final = formatter.format(result1);
        String result2F_final_display = formatter.format(result2);

        System.out.println("Entered values:");
        System.out.println("---------------");
        System.out.println("First result: " + result1F_final.trim());
        System.out.println("Second result: " + result2F_final_display.trim());
        System.out.println("Results added together: " + formattedTotal.trim());
    }

    /**
     * Método main para iniciar a execução da classe.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Multip().run();
    }
}