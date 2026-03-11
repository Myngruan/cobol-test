package com.converted.cobol;

/**
 * Classe convertida do programa COBOL: PerformThroughExample
 * 
 * Arquivo original: PerformTimes.cbl
 * 
 * ⚠️ Conversão via regras - revisar manualmente
 *
 * @generated Conversão automática COBOL → Java 21
 * @since 2026-03-11
 */
public class Performthroughexample {

    // ========== Campos ==========

    /** Origem COBOL: RepeatTimes
    PIC: 9 */
    private int repeattimes;

    // ========== Construtor ==========

    public Performthroughexample() {
        // Inicialização padrão
        this.repeattimes = 7;
    }

    // ========== Métodos ==========

    /**
     * Origem COBOL: SecondVersion
     */
    public void secondversion() {
        System.out.println("[-] This is Out-of-line);
                for (int i = 0; i < 7; i++) { printed(); }
                // TODO: [CONVERSÃO MANUAL NECESSÁRIA] Comando COBOL não suportado
                // Original: "
                // Tipo: unknown
    }

    /**
     * Ponto de entrada do programa
     */
    public static void main(String[] args) {
        new Performthroughexample().secondversion();
    }

    // ========== Getters e Setters ==========

    public int getRepeattimes() {
        return this.repeattimes;
    }
    
    public void setRepeattimes(int repeattimes) {
        this.repeattimes = repeattimes;
    }

}