package com.converted.cobol;

import java.util.Scanner;

/**
 * Classe convertida do programa COBOL: PerformExample
 * 
 * Arquivo original: PerformExample.cbl
 * 
 * ⚠️ Conversão via regras - revisar manualmente
 *
 * @generated Conversão automática COBOL → Java 21
 * @since 2026-03-11
 */
public class Performexample {

    // ========== Campos ==========

    /** Origem COBOL: UserInitials
    PIC: x(10) */
    private String userinitials;
    /** Origem COBOL: A
    PIC: 999 */
    private int a;
    /** Origem COBOL: B
    PIC: 999 */
    private int b;
    /** Origem COBOL: Result
    PIC: 999999 */
    private int result;
    /** Origem COBOL: Formatted
    PIC: Z(10) */
    private String formatted;

    // ========== Construtor ==========

    public Performexample() {
        // Inicialização padrão
        this.a = 30;
        this.b = 20;
    }

    // ========== Métodos ==========

    /**
     * Origem COBOL: FirstStage
     */
    public void firststage() {
        System.out.println("------------------");
                System.out.println("This is the first stage of the program);
                // TODO: [CONVERSÃO MANUAL NECESSÁRIA] Comando COBOL não suportado
                // Original: "
                // Tipo: unknown
                System.out.println(");
                // TODO: [CONVERSÃO MANUAL NECESSÁRIA] Comando COBOL não suportado
                // Original: and next we're at???"
                // Tipo: unknown
                System.out.println("------------------");
                thirdstage();
                System.out.println("------------------");
                System.out.println("Previous one was Third Stage and now we're at 1st);
                // TODO: [CONVERSÃO MANUAL NECESSÁRIA] Comando COBOL não suportado
                // Original: "
                // Tipo: unknown
                System.out.println("Alas we've ran out lines);
                // TODO: [CONVERSÃO MANUAL NECESSÁRIA] Comando COBOL não suportado
                // Original: "
                // Tipo: unknown
                System.out.println("------------------");
                return; // STOP RUN
    }

    /**
     * Origem COBOL: SecondStage
     */
    public void secondstage() {
        System.out.println("You have reached Second Stage);
                // TODO: [CONVERSÃO MANUAL NECESSÁRIA] Comando COBOL não suportado
                // Original: "
                // Tipo: unknown
                System.out.println("Please enter your initials:");
                Scanner scanner = new Scanner(System.in);
        userinitials = scanner.nextLine();
                System.out.println("Hello ", UserInitials);
                System.out.println("I wonder what's the next destination);
                // TODO: [CONVERSÃO MANUAL NECESSÁRIA] Comando COBOL não suportado
                // Original: "
                // Tipo: unknown
    }

    /**
     * Origem COBOL: ThirdStage
     */
    public void thirdstage() {
        System.out.println("You've reached the third stage (instead of second));
                // TODO: [CONVERSÃO MANUAL NECESSÁRIA] Comando COBOL não suportado
                // Original: "
                // Tipo: unknown
                System.out.println("Here we like maths);
                // TODO: [CONVERSÃO MANUAL NECESSÁRIA] Comando COBOL não suportado
                // Original: "
                // Tipo: unknown
                result = a * b; // ou a.multiply(b) para BigDecimal
                formatted = result;
                System.out.println("We multiplied 30 with 20 and got ", Formatted);
                System.out.println("Next we'll jump to the Second Stage);
                // TODO: [CONVERSÃO MANUAL NECESSÁRIA] Comando COBOL não suportado
                // Original: "
                // Tipo: unknown
                System.out.println("--------------------------");
                secondstage();
    }

    /**
     * Ponto de entrada do programa
     */
    public static void main(String[] args) {
        new Performexample().firststage();
    }

    // ========== Getters e Setters ==========

    public String getUserinitials() {
        return this.userinitials;
    }
    
    public void setUserinitials(String userinitials) {
        this.userinitials = userinitials;
    }

    public int getA() {
        return this.a;
    }
    
    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return this.b;
    }
    
    public void setB(int b) {
        this.b = b;
    }

    public int getResult() {
        return this.result;
    }
    
    public void setResult(int result) {
        this.result = result;
    }

    public String getFormatted() {
        return this.formatted;
    }
    
    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

}