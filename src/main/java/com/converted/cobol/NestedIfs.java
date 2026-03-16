package com.converted.cobol;

/**
 * Classe convertida do programa COBOL: Nested-IFs
 * 
 * Arquivo original: NestedIFExample.cbl
 * 
 * ⚠️ Conversão via regras - revisar manualmente
 *
 * @generated Conversão automática COBOL → Java 21
 * @since 2026-03-16
 */
public class NestedIfs {

    // ========== Campos ==========

    /** Origem COBOL: A
    PIC: 99 */
    private int a;
    /** Origem COBOL: B
    PIC: 99 */
    private int b;
    /** Origem COBOL: RESULT
    PIC: 9999 */
    private int result;
    /** Origem COBOL: FORMATTED
    PIC: Z(9) */
    private String formatted;

    // ========== Construtor ==========

    public NestedIfs() {
        // Inicialização padrão
    }

    // ========== Getters e Setters ==========

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


    // ========== Main ==========

    public static void main(String[] args) {
        new NestedIfs();
    }
}