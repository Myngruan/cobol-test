package com.converted.cobol;

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
    private int total;
    private String formatted;

    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // Usamos um Scanner para ler a entrada do usuário, equivalente ao ACCEPT.
        // O try-with-resources garante que o Scanner seja fechado corretamente.
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Início do parágrafo Calc1
            calc1(scanner);
            
            // Início do parágrafo Calc2
            calc2();
        }
        // STOP RUN é implícito ao final deste método.
    }

    /**
     * Corresponde ao parágrafo "Calc1" do COBOL.
     * Pede dois números, os multiplica e exibe o resultado formatado.
     * @param scanner A instância do Scanner para ler a entrada do usuário.
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
        // A PIC Z(10).Z(2) formata o número com espaços à esquerda e duas casas decimais.
        // String.format com Locale.US é a tradução mais próxima.
        result1F = String.format(Locale.US, "%13.2f", (double) result1);
        
        // DISPLAY Result1F.
        System.out.println(result1F);
    }

    /**
     * Corresponde ao parágrafo "Calc2" do COBOL.
     * Pede mais dois números, os multiplica, soma os resultados e exibe o total.
     */
    private void calc2() {
        // Reutilizamos o mesmo Scanner da chamada anterior, que ainda está aberto.
        Scanner scanner = new Scanner(System.in);

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
        result2F = String.format(Locale.US, "%13.2f", (double) result2);
        
        // DISPLAY Result2F.
        System.out.println(result2F);
        
        // ADD Result1,Result2 TO Total.
        // Em COBOL, isso significa Total = Total + Result1 + Result2.
        // Como "total" começa em 0, é equivalente a uma simples soma.
        total = result1 + result2;
        
        // MOVE Total TO Formatted.
        formatted = String.format(Locale.US, "%13.2f", (double) total);
        
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
        
        // Fechamos o scanner aqui, pois não será mais usado.
        scanner.close();
    }

    /**
     * Método main para iniciar a execução do programa.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Multip().run();
    }
}