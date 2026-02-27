package com.converted.cobol;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra a execução do programa COBOL Multip.
 * Este serviço é responsável por coordenar a entrada do usuário, os cálculos de negócio
 * e a exibição dos resultados, delegando as responsabilidades específicas para outras classes.
 */
public class MultipApplicationService {

    private final UserInterface userInterface;
    private final CalculationService calculationService;
    private final ReportFormatter reportFormatter;

    /**
     * Constrói o serviço de aplicação, inicializando suas dependências.
     */
    public MultipApplicationService() {
        this.userInterface = new UserInterface();
        this.calculationService = new CalculationService();
        this.reportFormatter = new ReportFormatter();
    }

    /**
     * Ponto de entrada principal da aplicação.
     * Instancia o serviço de aplicação e inicia a execução.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new MultipApplicationService().run();
    }

    /**
     * Executa o fluxo principal da aplicação, espelhando a PROCEDURE DIVISION do COBOL.
     * O fluxo é dividido em obter dados, processar e exibir resultados.
     */
    public void run() {
        try {
            // Corresponde ao parágrafo 'Calc1'
            CalculationResult firstCalculation = performFirstCalculation();

            // Corresponde ao parágrafo 'Calc2'
            CalculationResult secondCalculation = performSecondCalculation();

            // Corresponde à parte final de 'Calc2' (soma e relatório final)
            generateFinalReport(firstCalculation, secondCalculation);

        } finally {
            userInterface.close();
        }
    }

    /**
     * Orquestra a primeira parte do cálculo (parágrafo 'Calc1').
     * @return O resultado do primeiro cálculo.
     */
    private CalculationResult performFirstCalculation() {
        // COBOL: ACCEPT Number1, ACCEPT Number2
        BigDecimal number1 = userInterface.promptAndReadNumber("Enter the first number: ");
        BigDecimal number2 = userInterface.promptAndReadNumber("Enter the second number: ");

        // COBOL: MULTIPLY Number1 BY Number2 GIVING Result1
        BigDecimal result1 = calculationService.multiply(number1, number2);

        // COBOL: DISPLAY "Displaying first result!"
        userInterface.displayMessage("Displaying first result!");

        // COBOL: MOVE Result1 to Result1F, DISPLAY Result1F
        String formattedResult1 = reportFormatter.formatValue(result1);
        userInterface.displayRawValue(formattedResult1);

        return new CalculationResult(result1, formattedResult1);
    }

    /**
     * Orquestra a segunda parte do cálculo (início do parágrafo 'Calc2').
     * @return O resultado do segundo cálculo.
     */
    private CalculationResult performSecondCalculation() {
        // COBOL: ACCEPT Number3, ACCEPT Number4
        BigDecimal number3 = userInterface.promptAndReadNumber("Enter the third number: ");
        BigDecimal number4 = userInterface.promptAndReadNumber("Enter the fourth number: ");

        // COBOL: MULTIPLY Number3 BY Number4 GIVING Result2
        BigDecimal result2 = calculationService.multiply(number3, number4);

        // COBOL: DISPLAY "Displaying second result!"
        userInterface.displayMessage("Displaying second result!");

        // COBOL: MOVE Result2 TO Result2F, DISPLAY Result2F
        String formattedResult2 = reportFormatter.formatValue(result2);
        userInterface.displayRawValue(formattedResult2);

        return new CalculationResult(result2, formattedResult2);
    }

    /**
     * Calcula o total e gera o relatório final (final do parágrafo 'Calc2').
     * @param firstCalc O resultado do primeiro cálculo.
     * @param secondCalc O resultado do segundo cálculo.
     */
    private void generateFinalReport(CalculationResult firstCalc, CalculationResult secondCalc) {
        // COBOL: ADD Result1,Result2 TO Total
        BigDecimal total = calculationService.add(firstCalc.value(), secondCalc.value());

        // COBOL: MOVE Total TO Formatted
        String formattedTotal = reportFormatter.formatValue(total);

        // COBOL: DISPLAY "Entered values:", "---------------", etc.
        userInterface.displaySummary(
            firstCalc.formattedValue(),
            secondCalc.formattedValue(),
            formattedTotal
        );
    }
}

/**
 * Um Value Object (usando record) para encapsular o resultado de um cálculo.
 * Contém tanto o valor numérico bruto (para cálculos futuros) quanto sua representação formatada.
 *
 * @param value O valor numérico do resultado (COBOL: Result1, Result2).
 * @param formattedValue A representação em string formatada (COBOL: Result1F, Result2F).
 */
record CalculationResult(BigDecimal value, String formattedValue) {}

/**
 * Serviço de Domínio responsável pelas regras de negócio de cálculo.
 * Isola a lógica matemática da orquestração do fluxo da aplicação.
 */
class CalculationService {

    /**
     * Multiplica dois números.
     * Corresponde à instrução 'MULTIPLY'.
     * @param num1 O primeiro número.
     * @param num2 O segundo número.
     * @return O produto dos dois números.
     */
    public BigDecimal multiply(BigDecimal num1, BigDecimal num2) {
        return num1.multiply(num2);
    }

    /**
     * Soma dois números.
     * Corresponde à instrução 'ADD'.
     * @param num1 O primeiro número.
     * @param num2 O segundo número.
     * @return A soma dos dois números.
     */
    public BigDecimal add(BigDecimal num1, BigDecimal num2) {
        return num1.add(num2);
    }
}

/**
 * Classe auxiliar para lidar com toda a interação de entrada e saída do console.
 * Isola os detalhes de I/O (System.in, System.out) do resto da aplicação.
 */
class UserInterface implements AutoCloseable {

    private final Scanner scanner;

    /**
     * Construtor que inicializa o leitor de entrada do console.
     */
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Exibe um prompt para o usuário e lê um número do console.
     * Corresponde à combinação 'DISPLAY' e 'ACCEPT' no COBOL.
     * @param prompt A mensagem a ser exibida para o usuário.
     * @return O número inserido pelo usuário como um BigDecimal.
     */
    public BigDecimal promptAndReadNumber(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                String line = scanner.nextLine();
                // Valida se a entrada é um número inteiro, como no PIC 99 do COBOL.
                return new BigDecimal(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            } catch (Exception e) {
                System.out.print("An unexpected error occurred. Please try again: ");
            }
        }
    }

    /**
     * Exibe uma mensagem simples no console.
     * @param message A mensagem a ser exibida.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }


    /**
     * Exibe um valor bruto formatado, sem rótulo adicional.
     * @param value O valor formatado a ser exibido.
     */
    public void displayRawValue(String value) {
        System.out.println(value);
    }

    /**
     * Exibe o relatório de resumo final.
     * @param formattedResult1 O primeiro resultado formatado.
     * @param formattedResult2 O segundo resultado formatado.
     * @param formattedTotal O total formatado.
     */
    public void displaySummary(String formattedResult1, String formattedResult2, String formattedTotal) {
        System.out.println("\nEntered values:");
        System.out.println("---------------");
        System.out.println("First result: " + formattedResult1.trim());
        System.out.println("Second result: " + formattedResult2.trim());
        System.out.println("Results added together: " + formattedTotal.trim());
    }

    /**
     * Fecha o recurso do scanner para evitar vazamentos de recursos.
     */
    @Override
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}

/**
 * Classe auxiliar responsável por formatar valores numéricos para exibição.
 * Encapsula a lógica de formatação que corresponde às cláusulas PICTURE (PIC) do COBOL.
 */
class ReportFormatter {

    private final DecimalFormat decimalFormat;

    /**
     * Construtor que configura o formato numérico.
     * O formato "0.00" garante duas casas decimais, como no COBOL.
     */
    public ReportFormatter() {
        // Formato para garantir duas casas decimais, sem separadores de milhar.
        this.decimalFormat = new DecimalFormat("0.00");
    }

    /**
     * Formata um valor BigDecimal para uma string, imitando a cláusula COBOL 'PIC Z(10).Z(2)'.
     * Isso inclui a formatação para duas casas decimais e a supressão de zeros à esquerda
     * (representada pelo preenchimento com espaços).
     *
     * @param value O valor BigDecimal a ser formatado (ex: Result1, Total).
     * @return A string formatada (ex: Result1F, Formatted).
     */
    public String formatValue(BigDecimal value) {
        // Garante que o número tenha duas casas decimais para formatação.
        String formattedNumber = decimalFormat.format(value);

        // A PIC Z(10).Z(2) define um campo de 13 caracteres (10 inteiros + ponto + 2 decimais).
        // O 'Z' suprime zeros à esquerda, preenchendo com espaços.
        // Usamos String.format para alinhar à direita e preencher com espaços.
        int totalWidth = 13;
        return String.format("%" + totalWidth + "s", formattedNumber);
    }
}