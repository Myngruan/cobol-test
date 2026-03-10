package com.converted.cobol;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Convertido do programa COBOL: Nested-IFs
 * @author auto-converted
 */
public class NestedIfs {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 A PIC 99.
    private int a;
    
    // 01 B PIC 99.
    private int b;
    
    // 01 RESULT PIC 9999.
    private int result;
    
    // 01 FORMATTED PIC Z(9).
    // Em Java, a formatação Z(9) (supressão de zeros à esquerda) é o comportamento
    // padrão ao converter um número para String. Usamos um String para armazenar o resultado.
    private String formatted;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // O Scanner é o equivalente Java para o verbo ACCEPT do COBOL para entrada de console.
        // Usamos try-with-resources para garantir que o scanner seja fechado automaticamente.
        try (Scanner scanner = new Scanner(System.in)) {
            procedureDivision(scanner);
        } catch (InputMismatchException e) {
            System.err.println("Erro: Entrada inválida. Por favor, insira apenas números inteiros.");
        }
    }

    // ── Lógica Principal (PROCEDURE DIVISION) ─────────────────────────────
    
    /**
     * Contém a lógica principal convertida da PROCEDURE DIVISION.
     * @param scanner Instância do Scanner para ler a entrada do usuário.
     */
    private void procedureDivision(Scanner scanner) {
        // DISPLAY "Enter the first value: ".
        System.out.print("Enter the first value: ");
        // ACCEPT A.
        a = scanner.nextInt();
        
        // DISPLAY "You entered ", A " as a value.".
        System.out.println("You entered " + a + " as a value.");
        
        // DISPLAY "Please enter the second value: ".
        System.out.print("Please enter the second value: ");
        // ACCEPT B.
        b = scanner.nextInt();
        
        // DISPLAY "You entered ", B " as a second value.".
        System.out.println("You entered " + b + " as a second value.");
        
        // COMPUTE RESULT = A + B.
        result = a + b;
        
        // IF (A < 10) AND (B > 10) THEN
        if (a < 10 && b > 10) {
            // IF RESULT > 50 THEN
            if (result > 50) {
                // DISPLAY "Result is bigger than 50."
                System.out.println("Result is bigger than 50.");
            } else {
                // MOVE RESULT TO FORMATTED
                // A conversão para String em Java naturalmente suprime zeros à esquerda.
                formatted = String.valueOf(result);
                // DISPLAY FORMATTED
                System.out.println(formatted);
            }
            // END-IF
        } else {
            // ELSE DISPLAY "Whatever."
            System.out.println("Whatever.");
        }
        // END-IF
        
        // STOP RUN.
        // O fim do método serve como um "STOP RUN", encerrando a execução.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main padrão para iniciar a execução da classe.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        try {
            new NestedIfs().run();
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado durante a execução: " + e.getMessage());
            e.printStackTrace();
        }
    }
}