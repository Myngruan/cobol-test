package com.converted.cobol;

import java.util.Scanner;

/**
 * Convertido do programa COBOL: PerformExample
 * @author auto-converted
 */
public class Performexample {

    // ── Campos de trabalho (WORKING-STORAGE) ──────────────────────────────
    
    // 01 UserInitials PIC x(10).
    private String userInitials = "";
    
    // 01 A PIC 999 VALUE 30.
    private int a = 30;
    
    // 01 B PIC 999 VALUE 20.
    private int b = 20;
    
    // 01 Result PIC 999999.
    private long result = 0;
    
    // 01 Formatted PIC Z(10).Z(2).
    // Em Java, isso é uma máscara de formatação, não um tipo.
    // A variável correspondente conterá o resultado formatado como String.
    private String formatted = "";

    // ── Recursos de I/O (para o verbo ACCEPT) ─────────────────────────────
    private Scanner scanner;

    // ── Ponto de entrada ─────────────────────────────────────────────────
    /**
     * Ponto de entrada principal que executa a lógica do programa COBOL.
     */
    public void run() {
        scanner = new Scanner(System.in);
        try {
            // A PROCEDURE DIVISION começa com o primeiro parágrafo.
            firstStage();
        } finally {
            // Garante que os recursos sejam fechados.
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // ── Parágrafos convertidos ────────────────────────────────────────────

    /**
     * Corresponde ao parágrafo COBOL: FirstStage
     */
    private void firstStage() {
        System.out.println("------------------");
        System.out.println("This is the first stage of the program.");
        System.out.println("...and next we're at???");
        System.out.println("------------------");
        
        // PERFORM ThirdStage.
        thirdStage();
        
        System.out.println("------------------");
        System.out.println("Previous one was Third Stage and now we're at 1st.");
        System.out.println("Alas we've ran out lines..");
        System.out.println("------------------");
        
        // STOP RUN.
        // A execução termina aqui, pois o método run() retorna após esta chamada.
    }

    /**
     * Corresponde ao parágrafo COBOL: SecondStage
     */
    private void secondStage() {
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");
        
        // ACCEPT UserInitials
        userInitials = scanner.nextLine();
        
        System.out.println("Hello " + userInitials);
        System.out.println("I wonder what's the next destination...");
    }

    /**
     * Corresponde ao parágrafo COBOL: ThirdStage
     */
    private void thirdStage() {
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");
        
        // MULTIPLY A BY B GIVING Result.
        result = (long) a * b;
        
        // MOVE Result TO Formatted.
        // A PIC Z(10).Z(2) em COBOL formata um inteiro (ex: 600) como uma string decimal ("  600.00").
        // String.format em Java pode replicar este comportamento.
        // A largura total é 10 (dígitos) + 1 (ponto) + 2 (decimais) = 13.
        // O resultado é justificado à direita com espaços.
        formatted = String.format("%13.2f", (double)result);
        
        System.out.println("We multiplied 30 with 20 and got " + formatted);
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");
        
        // PERFORM SecondStage.
        secondStage();
    }

    // ── main ─────────────────────────────────────────────────────────────
    /**
     * Método main padrão para execução da classe.
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception se ocorrer um erro inesperado.
     */
    public static void main(String[] args) throws Exception {
        new Performexample().run();
    }
}