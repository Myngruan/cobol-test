package com.converted.cobol;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra o fluxo do programa COBOL PerformExample.
 * <p>
 * Este serviço gerencia o fluxo de controle, a interação com o usuário (console)
 * e delega as regras de negócio para serviços de domínio específicos.
 * Ele substitui a PROCEDURE DIVISION do programa COBOL.
 *
 * @author Gerado por IA especialista em refatoração COBOL-Java
 */
public class PerformexampleApplicationService {

    private final MathService mathService;
    private final Scanner consoleInput;

    /**
     * Construtor que inicializa os serviços de domínio e recursos necessários.
     */
    public PerformexampleApplicationService() {
        this.mathService = new MathService();
        this.consoleInput = new Scanner(System.in);
    }

    /**
     * Ponto de entrada principal da aplicação.
     * Instancia o serviço de aplicação e executa o fluxo principal.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        PerformexampleApplicationService app = new PerformexampleApplicationService();
        app.run();
    }

    /**
     * Orquestra o fluxo de alto nível da aplicação, espelhando a lógica
     * de execução do programa COBOL original.
     */
    public void run() {
        try {
            performFirstStage();
        } finally {
            // Garante que o recurso do scanner seja fechado ao final da execução.
            consoleInput.close();
        }
    }

    /**
     * Executa a lógica correspondente ao parágrafo 'FirstStage' do COBOL.
     * Inicia o fluxo, chama o terceiro estágio e finaliza a execução.
     */
    private void performFirstStage() {
        // COBOL: FirstStage.
        System.out.println("------------------");
        System.out.println("This is the first stage of the program.");
        System.out.println("...and next we're at???");
        System.out.println("------------------");

        // COBOL: PERFORM ThirdStage.
        performThirdStage();

        System.out.println("------------------");
        System.out.println("Previous one was Third Stage and now we're at 1st.");
        System.out.println("Alas we've ran out lines..");
        System.out.println("------------------");
        // COBOL: STOP RUN. (O fim do método 'run' encerra o programa)
    }

    /**
     * Executa a lógica correspondente ao parágrafo 'ThirdStage' do COBOL.
     * Realiza um cálculo matemático e em seguida chama o segundo estágio.
     */
    private void performThirdStage() {
        // COBOL: ThirdStage.
        System.out.println("You've reached the third stage (instead of second).");
        System.out.println("Here we like maths.");

        // COBOL: 01 A PIC 999 VALUE 30.
        // COBOL: 01 B PIC 999 VALUE 20.
        CalculationInput calculationData = new CalculationInput(30, 20);

        // COBOL: MULTIPLY A BY B GIVING Result.
        CalculationResult result = mathService.multiply(calculationData);

        // COBOL: MOVE Result TO Formatted. (PIC Z(10).Z(2))
        // A formatação COBOL Z(10) suprime zeros à esquerda em um campo de 10 dígitos.
        // Para um inteiro, isso é representado de forma simples em Java.
        String formattedResult = new DecimalFormat("#,##0").format(result.value());

        System.out.println("We multiplied 30 with 20 and got " + formattedResult.trim());
        System.out.println("Next we'll jump to the Second Stage..");
        System.out.println("--------------------------");

        // COBOL: PERFORM SecondStage.
        performSecondStage();
    }

    /**
     * Executa a lógica correspondente ao parágrafo 'SecondStage' do COBOL.
     * Interage com o usuário para obter suas iniciais e exibe uma saudação.
     *
     * @return Um Value Object {@link UserInput} contendo as iniciais do usuário.
     */
    private UserInput performSecondStage() {
        // COBOL: SecondStage.
        System.out.println("You have reached Second Stage.");
        System.out.println("Please enter your initials:");

        // COBOL: ACCEPT UserInitials
        String initials = consoleInput.nextLine();
        UserInput userInput = new UserInput(initials);

        System.out.println("Hello " + userInput.initials());
        System.out.println("I wonder what's the next destination...");

        return userInput;
    }
}

/**
 * Serviço de domínio responsável por encapsular a lógica de negócio de cálculos matemáticos.
 * <p>
 * Este serviço é stateless e contém regras de negócio puras, sem se preocupar com I/O
 * ou orquestração de fluxo.
 */
class MathService {

    /**
     * Multiplica os dois operandos fornecidos no objeto de entrada.
     * <p>
     * Corresponde à lógica: MULTIPLY A BY B GIVING Result.
     *
     * @param input O {@link CalculationInput} contendo os valores a serem multiplicados.
     * @return Um {@link CalculationResult} com o produto da operação.
     */
    public CalculationResult multiply(CalculationInput input) {
        long product = (long) input.operandA() * input.operandB();
        return new CalculationResult(product);
    }
}

/**
 * Value Object (Record) que representa os dados de entrada para um cálculo.
 * <p>
 * Corresponde às variáveis 'A' e 'B' na WORKING-STORAGE SECTION.
 * É imutável, garantindo a integridade dos dados.
 *
 * @param operandA O primeiro operando (COBOL: A).
 * @param operandB O segundo operando (COBOL: B).
 */
record CalculationInput(int operandA, int operandB) {
}

/**
 * Value Object (Record) que representa o resultado de um cálculo.
 * <p>
 * Corresponde à variável 'Result' na WORKING-STORAGE SECTION.
 * É imutável.
 *
 * @param value O valor numérico do resultado.
 */
record CalculationResult(long value) {
}

/**
 * Value Object (Record) que representa a entrada de dados do usuário.
 * <p>
 * Corresponde à variável 'UserInitials' na WORKING-STORAGE SECTION.
 * É imutável.
 *
 * @param initials As iniciais fornecidas pelo usuário.
 */
record UserInput(String initials) {
}