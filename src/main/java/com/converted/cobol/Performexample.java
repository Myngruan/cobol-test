package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: PerformExample
 * @author auto-converted
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
     * Representado como String para conter o valor formatado.
     */
    private String formatted = "";

    /**
     * Scanner para emular o verbo ACCEPT.
     */
    private Scanner console;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    
    /**
     * Ponto de entrada principal que executa a lógica do programa.
     * Corresponde ao início da PROCEDURE DIVISION.
     */
    public void run() {
        // O Scanner é inicializado aqui para ser usado em todo o programa.
        // Não usamos try-with-resources em System.in para não fechar o stream padrão.
        console = new Scanner(System.in);
        
        firstStage();
        
        // O programa termina aqui, equivalente ao STOP RUN no COBOL.
        console.close();
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * COBOL: PARAGRAPH FirstStage.
     */
    private void firstStage() {
        System.out.println("------------------");
        System.out.println("This is the first stage of the program.");
        System.out.println("...and next we're at???");
        System.out.println("------------------");
        
        // COBOL: PERFORM ThirdStage.
        thirdStage();
        
        System.out.println("------------------");
        System.out.println("Previous one was Third Stage and now we're at 1st.");
        System.out.println("Alas we've ran out lines..");
        System.out.println("------------------");
        
        // COBOL: STOP RUN.
        // A execução retorna para o método run() e o programa termina.
    }

    /**
     * COBOL: PARAGRAPH SecondStage.
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // COBOL: ACCEPT UserInitials
        userInitials = console.nextLine();
        // Garante que a string não exceda o tamanho definido em PIC X(10)
        if (userInitials != null && userInitials.length() > 10) {
            userInitials = userInitials.substring(0, 10);
        }
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * COBOL: PARAGRAPH ThirdStage.
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // COBOL: MULTIPLY A BY B GIVING Result.
        result = a * b;
        
        // COBOL: MOVE Result TO Formatted.
        // A cláusula PIC Z(10).Z(2) é para formatação. O 'Z' suprime zeros à esquerda.
        // A parte '.Z(2)' é incomum para uma fonte inteira, mas a interpretação mais
        // provável é simplesmente converter o inteiro para uma string.
        formatted = String.valueOf(result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // COBOL: PERFORM SecondStage.
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    
    /**
     * Método principal para execução da classe.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new Performexample().run();
    }
}