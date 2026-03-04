package com.converted.cobol;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Convertido do programa COBOL: Increment
 * <p>
 * Descrição original:
 * Program takes a value and increments until greater and prints those values.
 *
 * @author auto-converted from jiuweigui's COBOL code
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE SECTION) ──────────────────────
    
    /**
     * Mapeado de: 01 A PIC 99(9).
     * Valor de entrada fornecido pelo usuário.
     */
    private int a;

    /**
     * Mapeado de: 01 I PIC 99(9).
     * Contador do loop.
     */
    private int i;

    /**
     * Mapeado de: 01 X PIC Z(9)9.
     * Variável para cálculo e exibição. A formatação Z(9)9 (supressão de zeros
     * à esquerda) é o comportamento padrão do System.out.println para inteiros.
     */
    private int x;


    // ── Ponto de entrada e lógica principal ────────────────────────────────
    
    /**
     * Executa a lógica principal do programa COBOL.
     */
    public void run() {
        // COBOL: PROCEDURE DIVISION.
        
        System.out.println("This is an example using increment.");
        System.out.println("-----------------------------------");
        System.out.println("Please enter a value:");

        // COBOL: ACCEPT A.
        try (Scanner scanner = new Scanner(System.in)) {
            a = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
            // Emula STOP RUN em caso de erro de entrada
            System.exit(1); 
        }

        // COBOL: MOVE 0 TO I.
        i = 0;

        // COBOL: PERFORM UNTIL I GREATER THAN A
        // A condição "UNTIL I GREATER THAN A" é equivalente a "while (i <= a)"
        while (i <= a) {
            // COBOL: COMPUTE X = I + 1
            x = i + 1;
            
            // COBOL: DISPLAY X
            System.out.println(x);
            
            // COBOL: ADD 1 TO I
            i++;
        }
        // COBOL: END-PERFORM.

        // COBOL: STOP RUN.
        // O método termina aqui, finalizando a execução.
    }

    // ── Método main para inicialização ───────────────────────────────────
    
    /**
     * Ponto de entrada da aplicação Java.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Increment().run();
    }
}