package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: Increment
 * Program takes a value and increments until greater
 * and prints those values.
 * @author auto-converted from jiuweigui
 */
public class Increment {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 A PIC 99(9).
    private int a;

    // 01 I PIC 99(9).
    private int i;

    // 01 X PIC Z(9)9.
    // This is a numeric-edited field for display. In Java, formatting is
    // handled directly during the print operation, so no dedicated field is needed.

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        // A classe Scanner é usada para implementar o verbo ACCEPT do COBOL.
        try (Scanner consoleInput = new Scanner(System.in)) {
            // DISPLAY "This is an example using increment.".
            System.out.println("This is an example using increment.");
            
            // DISPLAY "-----------------------------------".
            System.out.println("-----------------------------------");
            
            // DISPLAY "Please enter a value:".
            System.out.println("Please enter a value:");
            
            // ACCEPT A.
            try {
                String inputLine = consoleInput.nextLine();
                if (inputLine != null && !inputLine.trim().isEmpty()) {
                    a = Integer.parseInt(inputLine.trim());
                } else {
                    a = 0; // Comportamento padrão para entrada vazia
                }
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida. Usando valor padrão 0.");
                a = 0;
            }
            
            // MOVE 0 TO I.
            i = 0;
            
            // PERFORM UNTIL I GREATER THAN A
            //   ...
            // END-PERFORM.
            // Isso se traduz em um loop "while" que continua enquanto i <= a.
            while (i <= a) {
                // COMPUTE X = I + 1
                // O resultado é calculado para ser exibido.
                int x = i + 1;
                
                // DISPLAY X
                // O PIC Z(9)9 suprime zeros à esquerda. System.out.println(int)
                // é o equivalente funcional em Java para este caso de uso.
                System.out.println(x);
                
                // ADD 1 TO I
                i++;
            }
        }
        // STOP RUN.
        // O fim do método "run" encerra a execução, equivalente ao STOP RUN.
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método principal que cria uma instância da classe e executa o programa.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Em caso de erros inesperados.
     */
    public static void main(String[] args) throws Exception {
        new Increment().run();
    }
}