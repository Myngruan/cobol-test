package com.converted.cobol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Convertido de: if-example
 * AUTHOR. jiuweigui.
 */
public class IfExample {

    // Não há seções de arquivo ou estruturas de dados complexas neste programa.

    // WORKING-STORAGE SECTION
    // A variável UserInput será declarada localmente no método run.

    /**
     * Construtor padrão.
     */
    public IfExample() {
        // Inicialização, se necessário.
    }

    /**
     * Método principal que executa a lógica do programa COBOL.
     * Equivalente à PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: PROCEDURE DIVISION.
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {