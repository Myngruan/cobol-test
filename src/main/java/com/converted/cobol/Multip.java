package com.converted.cobol;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra a conversão do programa COBOL Multip.
 * <p>
 * Este serviço coordena a interação com o usuário, a execução dos cálculos
 * e a exibição dos resultados, seguindo o fluxo do programa original.
 *
 * @author COBOL to Java 21 Converter
 */
public class MultipApplicationService {

    private final CalculatorService calculatorService;
    private final ConsoleUI consoleUI;

    /**
     * Constrói o serviço de aplicação com suas dependências necessárias.
     */
    public MultipApplicationService() {
        this.calculatorService = new CalculatorService();
        this.consoleUI = new ConsoleUI();
    }

    /**
     * Ponto de entrada da aplicação. Instancia e executa o serviço de aplicação.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new MultipApplicationService().run();