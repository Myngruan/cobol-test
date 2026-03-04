package com.converted.cobol;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

/**
 * Convertido do programa COBOL: PerformExample
 * @author auto-converted from jiuweigui
 */
public class Performexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    /**
     * COBOL: 01 UserInitials PIC x(10).
     */
    private String userInitials = "";

    /**
     * COBOL: 01 A PIC 999 VALUE 30.
     */
    private int a = 30;

    /**
     * COBOL: 01 B PIC 999 VALUE 20.
     */
    private int b = 20;

    /**
     * COBOL: 01 Result PIC 999999.
     */
    private int result = 0;

    /**
     * COBOL: 01 Formatted PIC Z(10).Z(2).
     * Representa um campo numérico editado.
     */
    private String formatted = "";

    // ── Recursos de I/O ───────────────────────────────────────────────────
    
    private Scanner consoleScanner;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa.
     */
    public void run() {
        try {
            consoleScanner = new Scanner(System.in);
            // A PROCEDURE DIVISION começa no primeiro parágrafo.
            firstStage();
        } finally {
            if (consoleScanner != null) {
                consoleScanner.close();
            }
        }
    }

    // ── Parágrafos convertidos (PROCEDURE DIVISION) ───────────────────────

    /**
     * Corresponde ao parágrafo FIRST-STAGE.
     */
    private void firstStage() {
        System.out.println("------------------");
        System.out.println("This is the first stage of the program.");
        System.out.println("...and next we're at???");
        System.out.println("------------------");
        
        // PERFORM ThirdStage
        thirdStage();
        
        System.out.println("------------------");
        System.out.println("Previous one was Third Stage and now we're at 1st.");
        System.out.println("Alas we've ran out lines..");
        System.out.println("------------------");
        
        // STOP RUN
        // A execução termina quando este método retorna para run().
    }

    /**
     * Corresponde ao parágrafo SECOND-STAGE.
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // ACCEPT UserInitials
        userInitials = consoleScanner.nextLine();
        // TODO: Revisão manual: COBOL PIC X(10) implica um campo de tamanho fixo.
        // A entrada do usuário deve ser truncada ou preenchida para corresponder.
        if (userInitials.length() > 10) {
            userInitials = userInitials.substring(0, 10);
        }
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * Corresponde ao parágrafo THIRD-STAGE.
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // MULTIPLY A BY B GIVING Result.
        result = a * b;
        
        // MOVE Result TO Formatted.
        // A PIC Z(10).Z(2) é um campo de edição numérica.
        // Formata o inteiro 'Result' para uma string com duas casas decimais.
        // O 'Z' suprime zeros à esquerda, comportamento padrão do DecimalFormat.
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US); // Garante '.' como separador decimal
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        formatted = df.format(result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // PERFORM SecondStage.
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método main para inicializar e executar a classe.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Performexample().run();
    }
}