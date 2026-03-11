package com.converted.cobol;

import java.util.Scanner;

/**
 * Classe convertida do programa COBOL: Multip
 * 
 * Arquivo original: Multiply.cbl
 * 
 * ⚠️ Conversão via regras - revisar manualmente
 *
 * @generated Conversão automática COBOL → Java 21
 * @since 2026-03-11
 */
public class Multip {

    // ========== Campos ==========

    /** Origem COBOL: Number1
    PIC: 99 */
    private int number1;
    /** Origem COBOL: Number2
    PIC: 99 */
    private int number2;
    /** Origem COBOL: Number3
    PIC: 99 */
    private int number3;
    /** Origem COBOL: Number4
    PIC: 99 */
    private int number4;
    /** Origem COBOL: Result1
    PIC: 99999 */
    private int result1;
    /** Origem COBOL: Result1F
    PIC: Z(10) */
    private String result1f;
    /** Origem COBOL: Result2
    PIC: 99999 */
    private int result2;
    /** Origem COBOL: Result2F
    PIC: Z(10) */
    private String result2f;
    /** Origem COBOL: Total
    PIC: 999999999 */
    private int total;
    /** Origem COBOL: Formatted
    PIC: Z(10) */
    private String formatted;

    // ========== Construtor ==========

    public Multip() {
        // Inicialização padrão
    }

    // ========== Métodos ==========

    /**
     * Origem COBOL: Calc1
     */
    public void calc1() {
        System.out.println("Enter the first number: ");
                Scanner scanner = new Scanner(System.in);
        number1 = scanner.nextInt();
                System.out.println("Enter the second number: ");
                Scanner scanner = new Scanner(System.in);
        number2 = scanner.nextInt();
                result1 = number1 * number2; // ou number1.multiply(number2) para BigDecimal
                System.out.println("Displaying first result!");
                result1f = result1;
                System.out.println(result1f);
    }

    /**
     * Origem COBOL: Calc2
     */
    public void calc2() {
        System.out.println("Enter the third number: ");
                Scanner scanner = new Scanner(System.in);
        number3 = scanner.nextInt();
                System.out.println("Enter the fourth number: ");
                Scanner scanner = new Scanner(System.in);
        number4 = scanner.nextInt();
                result2 = number3 * number4; // ou number3.multiply(number4) para BigDecimal
                System.out.println("Displaying second result!");
                result2f = result2;
                System.out.println(result2f);
                total = total + result1Result2; // ou total.add(result1Result2) para BigDecimal
                formatted = total;
                System.out.println("Entered values:");
                System.out.println("---------------");
                System.out.println("First result: \", Result1F");
                System.out.println("Second result: \", Result2F");
                System.out.println("Results added together: \", Formatted");
                return; // STOP RUN
    }

    /**
     * Ponto de entrada do programa
     */
    public static void main(String[] args) {
        new Multip().calc1();
    }

    // ========== Getters e Setters ==========

    public int getNumber1() {
        return this.number1;
    }
    
    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return this.number2;
    }
    
    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getNumber3() {
        return this.number3;
    }
    
    public void setNumber3(int number3) {
        this.number3 = number3;
    }

    public int getNumber4() {
        return this.number4;
    }
    
    public void setNumber4(int number4) {
        this.number4 = number4;
    }

    public int getResult1() {
        return this.result1;
    }
    
    public void setResult1(int result1) {
        this.result1 = result1;
    }

    public String getResult1f() {
        return this.result1f;
    }
    
    public void setResult1f(String result1f) {
        this.result1f = result1f;
    }

    public int getResult2() {
        return this.result2;
    }
    
    public void setResult2(int result2) {
        this.result2 = result2;
    }

    public String getResult2f() {
        return this.result2f;
    }
    
    public void setResult2f(String result2f) {
        this.result2f = result2f;
    }

    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }

    public String getFormatted() {
        return this.formatted;
    }
    
    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

}