package com.converted.cobol;

/**
 * Classe convertida do programa COBOL: UserInput
 * 
 * Arquivo original: UserInput.cbl
 * 
 * ⚠️ Conversão via regras - revisar manualmente
 *
 * @generated Conversão automática COBOL → Java 21
 * @since 2026-03-16
 */
public class Userinput {

    // ========== Campos ==========

    /** Origem COBOL: UserName */
    private Object username;
    /** Origem COBOL: Name
    PIC: X(10) */
    private String name;

    // ========== Construtor ==========

    public Userinput() {
        // Inicialização padrão
    }

    // ========== Getters e Setters ==========

    public Object getUsername() {
        return this.username;
    }
    
    public void setUsername(Object username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    // ========== Main ==========

    public static void main(String[] args) {
        new Userinput();
    }
}