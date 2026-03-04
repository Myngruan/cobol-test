package com.converted.cobol;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: Multip
 * @author auto-converted from jiuweigui
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
    
    // 01 Result1 PIC 99999.
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

    // ── Utilitários de conversão ──────────────────────────────────────────
    
    /**
     * Formatter para emular PIC Z(10).Z(2)
     * Suprime zeros à esquerda e garante duas casas decimais.
     */
    private final DecimalFormat displayFormat = new DecimalFormat("##########.00");

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // O Scanner é gerenciado com try-with-resources para garantir que seja fechado.
        try (Scanner scanner = new Scanner(System.in)) {
            calc1(scanner);
            calc2(scanner);
        } catch (InputMismatchException e) {
            System.err.println("Erro: Entrada inválida. Por favor, insira apenas números inteiros.");
        }
        // COBOL: STOP RUN é implícito ao final deste método.
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde ao parágrafo COBOL 'Calc1'.
     * @param scanner A instância do Scanner para ler a entrada do usuário.
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
        result1F = displayFormat.format(result1);
        System.out.println(result1F);
    }

    /**
     * Corresponde ao parágrafo COBOL 'Calc2'.
     * @param scanner A instância do Scanner para ler a entrada do usuário.
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
        result2F = displayFormat.format(result2);
        System.out.println(result2F);
        
        // COBOL: ADD Result1,Result2 TO Total.
        // Assumindo que Total começa em 0, isso é equivalente a GIVING.
        total = result1 + result2;
        
        // COBOL: MOVE Total TO Formatted.
        formatted = displayFormat.format(total);
        
        System.out.println("Entered values:");
        System.out.println("---------------");
        System.out.println("First result: " + result1F);
        System.out.println("Second result: " + result2F);
        System.out.println("Results added together: " + formatted);
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Ponto de entrada padrão da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Multip().run();
    }
}