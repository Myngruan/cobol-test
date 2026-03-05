package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Multip
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
    // 01 Result1F PIC Z(10).Z(2).
    private String result1F;
    // 01 Result2 PIC 99999.
    private int result2;
    // 01 Result2F PIC Z(10).Z(2).
    private String result2F;
    // 01 Total PIC 999999999.
    private int total;
    // 01 Formatted PIC Z(10).Z(2).
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // O Scanner é inicializado em um bloco try-with-resources para garantir que seja fechado.
        try (Scanner scanner = new Scanner(System.in)) {
            // A lógica da PROCEDURE DIVISION é executada sequencialmente.
            calc1(scanner);
            calc2(scanner);
        }
        // STOP RUN é implícito ao final deste método.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde ao parágrafo COBOL 'Calc1'.
     * @param scanner Instância para ler a entrada do usuário.
     */
    private void calc1(Scanner scanner) {
        System.out.print("Enter the first number: ");
        // ACCEPT Number1.
        number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        // ACCEPT Number2.
        number2 = scanner.nextInt();

        // MULTIPLY Number1 BY Number2 GIVING Result1.
        result1 = number1 * number2;

        System.out.println("Displaying first result!");

        // MOVE Result1 to Result1F.
        // PIC Z(10).Z(2) formata o número em um campo de 13 caracteres
        // (10 para a parte inteira, 1 para o ponto, 2 para os decimais),
        // com preenchimento de espaços à esquerda.
        result1F = String.format("%13.2f", (double) result1);

        // DISPLAY Result1F.
        System.out.println(result1F);
    }

    /**
     * Corresponde ao parágrafo COBOL 'Calc2'.
     * @param scanner Instância para ler a entrada do usuário.
     */
    private void calc2(Scanner scanner) {
        System.out.print("Enter the third number: ");
        // ACCEPT Number3.
        number3 = scanner.nextInt();

        System.out.print("Enter the fourth number: ");
        // ACCEPT Number4.
        number4 = scanner.nextInt();

        // MULTIPLY Number3 BY Number4 GIVING Result2.
        result2 = number3 * number4;

        System.out.println("Displaying second result!");

        // MOVE Result2 TO Result2F.
        result2F = String.format("%13.2f", (double) result2);

        // DISPLAY Result2F.
        System.out.println(result2F);

        // ADD Result1,Result2 TO Total.
        // Em COBOL, "ADD A, B TO C" significa C = C + A + B.
        // Como 'Total' começa em 0, isso é equivalente a Total = Result1 + Result2.
        total = result1 + result2;

        // MOVE Total TO Formatted.
        formatted = String.format("%13.2f", (double) total);

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