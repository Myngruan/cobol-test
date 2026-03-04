package com.converted.cobol;

import java.util.Scanner;
import java.io.IOException;

/**
 * Convertido do programa COBOL: Increment
 * Program takes a value and increments until greater and prints those values.
 * @author auto-converted from jiuweigui
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────

    // COBOL: 01 A PIC 99(9).
    private int a;

    // COBOL: 01 I PIC 99(9).
    private int i;

    // COBOL: 01 X PIC Z(9)9.
    // Este é um campo de edição numérica para exibição. Seu valor é calculado
    // e exibido imediatamente, então um campo dedicado não é necessário na
    // versão Java. A formatação (supressão de zeros à esquerda) é o padrão
    // para inteiros em System.out.println.

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // O try-with-resources garante que o Scanner seja fechado automaticamente.
        try (Scanner scanner = new Scanner(System.in)) {
            // Início da PROCEDURE DIVISION
            
            // COBOL: DISPLAY "This is an example using increment.".
            System.out.println("This is an example using increment.");
            
            // COBOL: DISPLAY "-----------------------------------".
            System.out.println("-----------------------------------");
            
            // COBOL: DISPLAY "Please enter a value:".
            System.out.println("Please enter a value:");
            
            // COBOL: ACCEPT A.
            // Lê a entrada do usuário e a atribui à variável 'a'.
            // O programa COBOL original pode falhar com entrada não numérica;
            // esta implementação fará o mesmo lançando uma exceção.
            a = scanner.nextInt();
            
            // COBOL: MOVE 0 TO I.
            i = 0;
            
            // COBOL: PERFORM UNTIL I GREATER THAN A ... END-PERFORM.
            // A condição "UNTIL I GREATER THAN A" é equivalente a "while (i <= a)" em Java.
            while (i <= a) {
                // COBOL: COMPUTE X = I + 1
                // COBOL: DISPLAY X
                // O cálculo e a exibição são combinados em uma única instrução Java.
                int x = i + 1;
                System.out.println(x);
                
                // COBOL: ADD 1 TO I
                i++;
            }
            
            // COBOL: STOP RUN.
            // O método run() termina, o que é o equivalente a STOP RUN.
        }
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método principal para iniciar a execução do programa.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Lançada em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Increment().run();
    }
}