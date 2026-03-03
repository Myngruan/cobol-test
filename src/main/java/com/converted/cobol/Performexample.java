package com.converted.cobol;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra o fluxo do programa COBOL PerformExample.
 * Este serviço inicializa os serviços necessários e executa a lógica de negócio
 * de alto nível, espelhando a estrutura da PROCEDURE DIVISION.
 *
 * @author Especialista em Refatoração COBOL para Java
 */
public class PerformexampleApplicationService {

    private final UserInteractionService userInteractionService;
    private final CalculationService calculationService;

    /**
     * Construtor que inicializa os serviços dependentes.
     * Na injeção de dependência, isso seria feito por um framework.
     */
    public PerformexampleApplicationService() {
        // Em um aplicativo real, estes seriam injetados.
        this.userInteractionService = new UserInteractionService();
        this.calculationService = new CalculationService();
    }

    /**
     * Ponto de entrada principal para a execução da lógica da aplicação.
     * Este método orquestra as chamadas para os diferentes "estágios" do programa original.
     */
    public void run() {
        try {
            performFirstStage();
        } finally {
            // Garante que os recursos (como o Scanner) sejam fechados.
            userInteractionService.close();
        }
    }

    /**
     * Corresponde ao parágrafo 'FirstStage' do COBOL.
     * Inicia o fluxo do programa, chama o terceiro estágio e depois termina.
     */
    private void performFirstStage() {
        userInteractionService.displaySeparator();
        userInteractionService.display("This is the first stage of the program.");
        userInteractionService.display("...and next we're at???");
        userInteractionService.displaySeparator();

        // PERFORM ThirdStage.
        // Os dados da WORKING-STORAGE (A, B) são passados como um objeto de contexto.
        CalculationContext context = new CalculationContext(30, 20);
        performThirdStage(context);

        userInteractionService.displaySeparator();
        userInteractionService.display("Previous one was Third Stage and now we're at 1st.");
        userInteractionService.display("Alas we've ran out lines..");
        userInteractionService.displaySeparator();
        // STOP RUN é implícito ao final do método run().
    }

    /**
     * Corresponde ao parágrafo 'ThirdStage' do COBOL.
     * Realiza um cálculo e depois chama o segundo estágio.
     *
     * @param context Os dados de entrada para o cálculo, originários da WORKING-STORAGE.
     */
    private void performThirdStage(CalculationContext context) {
        userInteractionService.display("You've reached the third stage (instead of second).");
        userInteractionService.display("Here we like maths.");

        // MULTIPLY A BY B GIVING Result.
        CalculationResult result = calculationService.multiply(context.a(), context.b());

        // MOVE Result TO Formatted.
        // DISPLAY "We multiplied 30 with 20 and got ", Formatted.
        userInteractionService.display("We multiplied 30 with 20 and got ", result.getFormattedValue());

        userInteractionService.display("Next we'll jump to the Second Stage..");
        userInteractionService.displaySeparator();

        // PERFORM SecondStage.
        userInteractionService.performSecondStage();
    }

    /**
     * Ponto de entrada padrão da aplicação Java.
     * Apenas instancia e executa o serviço de aplicação, mantendo a lógica de negócio fora do 'main'.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new PerformexampleApplicationService().run();
    }
}

/**
 * Serviço de domínio responsável por encapsular a lógica de cálculo.
 * Isola as regras de negócio matemáticas do fluxo da aplicação.
 */
class CalculationService {

    /**
     * Multiplica dois inteiros, correspondendo à instrução 'MULTIPLY A BY B'.
     *
     * @param a O primeiro número (COBOL: A PIC 999 VALUE 30).
     * @param b O segundo número (COBOL: B PIC 999 VALUE 20).
     * @return Um objeto CalculationResult contendo o produto.
     */
    public CalculationResult multiply(int a, int b) {
        return new CalculationResult(a * b);
    }
}

/**
 * Serviço de infraestrutura que lida com toda a interação com o console (entrada e saída).
 * Isola a lógica de I/O dos serviços de aplicação e domínio.
 */
class UserInteractionService {

    private final Scanner scanner;

    public UserInteractionService() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Exibe uma única linha de texto no console.
     *
     * @param message A mensagem a ser exibida.
     */
    public void display(String message) {
        System.out.println(message);
    }

    /**
     * Exibe uma mensagem composta por duas partes, como no COBOL 'DISPLAY "Hello ", UserInitials'.
     *
     * @param part1 A primeira parte da mensagem.
     * @param part2 A segunda parte da mensagem.
     */
    public void display(String part1, String part2) {
        System.out.println(part1 + part2);
    }

    /**
     * Exibe uma linha separadora para formatação da saída.
     */
    public void displaySeparator() {
        System.out.println("------------------");
    }

    /**
     * Corresponde ao parágrafo 'SecondStage' do COBOL.
     * Lida com a solicitação e exibição das iniciais do usuário.
     */
    public void performSecondStage() {
        display("You have reached Second Stage.");
        display("Please enter your initials:");

        // ACCEPT UserInitials
        String userInitials = scanner.nextLine();

        display("Hello ", userInitials);
        display("I wonder what's the next destination...");
    }

    /**
     * Fecha os recursos subjacentes, como o Scanner, para evitar vazamentos de recursos.
     */
    public void close() {
        scanner.close();
    }
}

/**
 * Um Value Object (implementado como um Record) para agrupar os parâmetros de entrada
 * para um cálculo. Representa os valores de 'A' e 'B' da WORKING-STORAGE.
 *
 * @param a O primeiro operando.
 * @param b O segundo operando.
 */
record CalculationContext(int a, int b) {
}

/**
 * Um Value Object (implementado como um Record) para encapsular o resultado de um cálculo
 * e sua lógica de formatação. Representa 'Result' e 'Formatted' da WORKING-STORAGE.
 *
 * @param value O valor numérico do resultado.
 */
record CalculationResult(int value) {

    private static final DecimalFormat FORMATTER = new DecimalFormat("########0.00");

    /**
     * Formata o valor numérico para exibição, simulando a PIC 'Z(10).Z(2)'.
     * O formato remove zeros à esquerda e garante duas casas decimais.
     *
     * @return O valor formatado como uma String.
     */
    public String getFormattedValue() {
        // O COBOL MOVE para um campo numérico com decimais implícitos adicionaria .00.
        // O 'Z' suprime zeros à esquerda, o que é o comportamento padrão do DecimalFormat
        // quando não há um '0' no início do padrão para a parte inteira.
        return FORMATTER.format(this.value).trim();
    }
}