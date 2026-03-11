package com.converted.cobol;

/**
 * Classe convertida do programa COBOL: PreDefMsg
 * 
 * Arquivo original: Message.cbl
 * 
 * ⚠️ Conversão via regras - revisar manualmente
 *
 * @generated Conversão automática COBOL → Java 21
 * @since 2026-03-11
 */
public class Predefmsg {

    // ========== Campos ==========

    /** Origem COBOL: PreDefMsg
    PIC: X(18) */
    private String predefmsg;

    // ========== Construtor ==========

    public Predefmsg() {
        // Inicialização padrão
        this.predefmsg = "Hello";
    }

    // ========== Getters e Setters ==========

    public String getPredefmsg() {
        return this.predefmsg;
    }
    
    public void setPredefmsg(String predefmsg) {
        this.predefmsg = predefmsg;
    }


    // ========== Main ==========

    public static void main(String[] args) {
        new Predefmsg();
    }
}