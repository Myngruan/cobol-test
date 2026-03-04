package com.converted.cobol;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra o fluxo do programa COBOL Nested-IFs.
 * Responsável por interagir com o usuário, invocar o serviço de domínio e apresentar o resultado.
 * Este é o ponto de entrada e o orquestrador de alto nível.
 */
public class NestedIfsApplicationService {

    private final CalculationService calculationService;

    /**
     * Construtor que inicializa os serviços de domínio necessários.
     * A injeção de dependência (mesmo que manual) é uma boa prática.
     */
    public NestedIfsApplicationService() {
        this.calculationService = new CalculationService();
    }

    /**
     * Ponto de entrada principal da lógica da aplicação.
     * Orquestra a leitura de dados, o processamento e a exibição da saída.
     * Corresponde à PROCEDURE DIVISION do programa COBOL.
     */
    public void run() {
        // O try-with-resources garante que o Scanner seja fechado corretamente,
        // uma prática moderna para gerenciamento de recursos.
        try (UserInterface ui = new UserInterface()) {
            // Corresponde a: DISPLAY "Enter the first value: " e ACCEPT A.
            int a = ui.readIntegerValue("Enter the first value: ");
            ui.echoValue("You entered", a, "as a value.");

            // Corresponde a: DISPLAY "Please enter the second value: " e ACCEPT B.
            int b = ui.readIntegerValue("Please enter the second value: ");
            ui.echoValue("You entered", b, "as a second value.");

            // Cria um Value Object para encapsular os dados de entrada.
            CalculationInput input = new CalculationInput(a, b);

            // Invoca o serviço de domínio para aplicar as regras de negócio.
            String resultMessage = calculationService.process(input);

            // Exibe o resultado final.
            ui.displayResult(resultMessage);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Ponto de entrada do programa Java (main).
     * A única responsabilidade deste método é instanciar e executar o serviço de aplicação.
     * Nenhuma regra de negócio deve ser colocada aqui.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new NestedIfsApplicationService().run();
    }
}

/**
 * Serviço de domínio que encapsula a lógica de negócio principal do programa COBOL.
 * É responsável por avaliar as condições e determinar a mensagem de resultado.
 * Esta classe não tem estado e contém apenas comportamento (regras de negócio).
 */
class CalculationService {

    /**
     * Processa os valores de entrada de acordo com as regras de negócio aninhadas.
     * Corresponde à lógica IF/ELSE da PROCEDURE DIVISION.
     *
     * @param input O Value Object contendo os valores 'A' e 'B'.
     * @return Uma String contendo a mensagem de resultado a ser exibida.
     */
    public String process(CalculationInput input) {
        // Corresponde a: COMPUTE RESULT = A + B.
        int result = input.a() + input.b();

        // Corresponde a: IF (A < 10) AND (B > 10) THEN
        if (input.a() < 10 && input.b() > 10) {
            // Lógica do IF aninhado foi extraída para um método privado para maior clareza.
            return processNestedCondition(result);
        } else {
            // Corresponde a: ELSE DISPLAY "Whatever."
            return "Whatever.";
        }
    }

    /**
     * Método auxiliar para lidar com a condição aninhada, melhorando a legibilidade.
     *
     * @param calculationResult O resultado da soma de A e B.
     * @return A mensagem de resultado baseada na condição aninhada.
     */
    private String processNestedCondition(int calculationResult) {
        // Corresponde a: IF RESULT > 50 THEN
        if (calculationResult > 50) {
            // Corresponde a: DISPLAY "Result is bigger than 50."
            return "Result is bigger than 50.";
        } else {
            // Corresponde a: MOVE RESULT TO FORMATTED e DISPLAY FORMATTED
            // A conversão padrão de Integer para String em Java já remove zeros à esquerda,
            // replicando o comportamento de PIC Z(9).
            return Integer.toString(calculationResult);
        }
    }
}

/**
 * Um Value Object (implementado como um record Java 21) que representa os dados de entrada
 * para o cálculo.
 * Corresponde às variáveis 'A' e 'B' da WORKING-STORAGE SECTION.
 * É imutável, o que é uma boa prática para objetos de valor.
 *
 * @param a O primeiro valor numérico, correspondente a 'A' no COBOL.
 * @param b O segundo valor numérico, correspondente a 'B' no COBOL.
 */
record CalculationInput(int a, int b) {
}

/**
 * Classe auxiliar responsável por toda a interação com o console (entrada e saída).
 * Isola os detalhes de I/O do resto da aplicação, seguindo o princípio de responsabilidade única.
 * Corresponde às instruções DISPLAY e ACCEPT do COBOL.
 * Implementa AutoCloseable para ser usada em blocos try-with-resources.
 */
class UserInterface implements AutoCloseable {

    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Lê um valor inteiro do console após exibir uma mensagem.
     * Inclui tratamento básico de erro para entrada não numérica.
     *
     * @param prompt A mensagem a ser exibida para o usuário.
     * @return O valor inteiro lido.
     */
    public int readIntegerValue(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.print("Invalid input. Please enter a valid integer: ");
                scanner.next(); // Descarta a entrada inválida para evitar loop infinito.
            }
        }
    }

    /**
     * Exibe (eco) o valor que o usuário digitou, formatando a mensagem.
     *
     * @param prefix A primeira parte da mensagem.
     * @param value O valor a ser exibido.
     * @param suffix A parte final da mensagem.
     */
    public void echoValue(String prefix, int value, String suffix) {
        System.out.println(prefix + " " + value + " " + suffix);
    }

    /**
     * Exibe a mensagem de resultado final no console.
     *
     * @param result A mensagem a ser exibida.
     */
    public void displayResult(String result) {
        System.out.println(result);
    }

    /**
     * Fecha o recurso Scanner. Este método é chamado automaticamente
     * pelo bloco try-with-resources, garantindo que não haja vazamento de recursos.
     */
    @Override
    public void close() {
        scanner.close();
    }
}