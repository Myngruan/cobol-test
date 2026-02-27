package com.converted.cobol;

import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra a execução do programa COBOL Nested-IFs.
 * Este serviço é responsável por coordenar a interação com o usuário, invocar a lógica de negócio
 * e apresentar os resultados, seguindo o fluxo original do programa legado.
 *
 * COBOL Source: PROGRAM-ID. Nested-IFs.
 */
public class NestedIfsApplicationService {

    /**
     * Serviço de domínio que encapsula a lógica de cálculo principal.
     */
    private final CalculationService calculationService;

    /**
     * Construtor que inicializa os serviços de domínio necessários.
     */
    public NestedIfsApplicationService() {
        this.calculationService = new CalculationService();
    }

    /**
     * Ponto de entrada principal para a aplicação Java.
     * Apenas instancia e executa o serviço de aplicação, mantendo a lógica de negócio
     * fora do método `main`.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new NestedIfsApplicationService().run();
    }

    /**
     * Orquestra o fluxo de alto nível da aplicação, espelhando a PROCEDURE DIVISION.
     * 1. Coleta a entrada do usuário.
     * 2. Executa as regras de negócio.
     * 3. Exibe o resultado.
     */
    public void run() {
        // O try-with-resources garante que o Scanner seja fechado corretamente.
        try (UserInterface ui = new UserInterface()) {
            // Corresponde aos comandos ACCEPT A e ACCEPT B.
            CalculationInput input = ui.promptForInputs();

            // Corresponde à lógica COMPUTE e IF aninhada.
            CalculationResult result = calculationService.process(input);

            // Corresponde aos comandos DISPLAY.
            ui.displayResult(result);
        }
        // Corresponde ao STOP RUN.
    }
}

/**
 * Serviço de domínio responsável por encapsular a lógica de negócio principal
 * do programa COBOL. Ele é isolado de preocupações de I/O.
 */
class CalculationService {

    /**
     * Processa os valores de entrada de acordo com as regras de negócio definidas
     * na PROCEDURE DIVISION do programa COBOL.
     *
     * <p>COBOL Logic:</p>
     * <pre>
     * COMPUTE RESULT = A + B.
     * IF (A < 10) AND (B > 10) THEN
     *     IF RESULT > 50 THEN
     *         DISPLAY "Result is bigger than 50."
     *     ELSE
     *         MOVE RESULT TO FORMATTED
     *         DISPLAY FORMATTED
     *     END-IF
     * ELSE DISPLAY "Whatever."
     * END-IF
     * </pre>
     *
     * @param input O Value Object contendo os dados de entrada (A e B).
     * @return O Value Object contendo a mensagem de resultado a ser exibida.
     */
    public CalculationResult process(CalculationInput input) {
        int a = input.a();
        int b = input.b();

        // COBOL: COMPUTE RESULT = A + B.
        int result = a + b;

        // COBOL: IF (A < 10) AND (B > 10) THEN ...
        if (a < 10 && b > 10) {
            // COBOL: IF RESULT > 50 THEN ...
            if (result > 50) {
                return new CalculationResult("Result is bigger than 50.");
            } else {
                // COBOL: MOVE RESULT TO FORMATTED / DISPLAY FORMATTED
                // A conversão para String em Java já remove zeros à esquerda,
                // simulando o comportamento de PIC Z(9).
                return new CalculationResult(String.valueOf(result));
            }
        } else {
            // COBOL: ELSE DISPLAY "Whatever."
            return new CalculationResult("Whatever.");
        }
    }
}

/**
 * Value Object (usando um Record do Java 21) para representar os dados de entrada.
 * É imutável e encapsula os valores que antes eram variáveis na WORKING-STORAGE.
 *
 * <p>COBOL Source:</p>
 * <pre>
 * 01 A PIC 99.
 * 01 B PIC 99.
 * </pre>
 *
 * @param a O primeiro valor numérico.
 * @param b O segundo valor numérico.
 */
record CalculationInput(int a, int b) {}

/**
 * Value Object (usando um Record do Java 21) para representar o resultado do processamento.
 * Encapsula a mensagem final a ser exibida, tornando a comunicação entre as camadas mais clara.
 *
 * @param message A mensagem de resultado a ser exibida para o usuário.
 */
record CalculationResult(String message) {}

/**
 * Classe auxiliar responsável por toda a interação com o console (Entrada/Saída).
 * Isola os detalhes de I/O (System.in, System.out) do resto da aplicação.
 * Implementa AutoCloseable para gerenciar o recurso Scanner de forma segura.
 */
class UserInterface implements AutoCloseable {

    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Solicita e lê os dois valores numéricos do usuário, espelhando os comandos
     * DISPLAY e ACCEPT do COBOL.
     *
     * @return Um objeto {@link CalculationInput} com os valores fornecidos.
     */
    public CalculationInput promptForInputs() {
        System.out.print("Enter the first value: ");
        int a = scanner.nextInt();
        System.out.println("You entered " + a + " as a value.");

        System.out.print("Please enter the second value: ");
        int b = scanner.nextInt();
        System.out.println("You entered " + b + " as a second value.");

        return new CalculationInput(a, b);
    }

    /**
     * Exibe o resultado final do processamento no console.
     *
     * @param result O objeto {@link CalculationResult} contendo a mensagem a ser exibida.
     */
    public void displayResult(CalculationResult result) {
        System.out.println(result.message());
    }

    /**
     * Fecha o recurso Scanner para evitar vazamentos de recursos.
     * Este método é chamado automaticamente pelo bloco try-with-resources.
     */
    @Override
    public void close() {
        scanner.close();
    }
}