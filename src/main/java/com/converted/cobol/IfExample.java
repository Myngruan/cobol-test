package com.converted.cobol;

/**
 * Classe convertida do programa COBOL: if-example
 * 
 * Arquivo original: IF-Example.cbl
 * 
 * ⚠️ Conversão via regras - revisar manualmente
 *
 * @generated Conversão automática COBOL → Java 21
 * @since 2026-03-13
 */
public class IfExample {

    // ========== Campos ==========

    /** Origem COBOL: UserInput
    PIC: X(20) */
    private String userinput;

    // ========== Construtor ==========

    public IfExample() {
        // Inicialização padrão
    }

    // ========== Getters e Setters ==========

    public String getUserinput() {
        return this.userinput;
    }
    
    public void setUserinput(String userinput) {
        this.userinput = userinput;
    }


    // ========== Main ==========

    public static void main(String[] args) {
        new IfExample();
    }
}