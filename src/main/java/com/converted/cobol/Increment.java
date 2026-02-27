package com.converted.cobol;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Serviço de aplicação principal que orquestra a execução do programa COBOL Increment.
 * Ele lida com a interação do usuário e coordena a chamada ao serviço de domínio.
 * Este é o ponto de entrada da aplicação Java convertida.
 * <p>
 * COBOL Source: PROGRAM-ID. Increment.
 */
public class IncrementApplicationService {

    private final IncrementService incrementService;
    private final UserInterface ui;

    /**
     * Construtor que inicializa os serviços e componentes necessários.
     * A injeção de dependência é feita manualmente aqui para simplicidade.
     */
    public IncrementApplicationService() {
        this.incrementService = new IncrementService();
        // Encapsula a interação com o console para facilitar testes e manutenção.
        this.ui = new UserInterface(new Scanner(System.in), System.out::println);
    }

    /**
     * Ponto de entrada principal da aplicação Java, conforme as regras de design.
     * Apenas instancia e executa o serviço de aplicação.
     * Nenhuma regra de negócio deve ser colocada aqui.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new IncrementApplicationService().run();
    }

    /**
     * Orquestra o fluxo de alto nível da aplicação, espelhando a PROCEDURE DIVISION.
     * 1. Exibe o cabeçalho.
     * 2. Solicita o valor limite ao usuário.
     * 3. Invoca o serviço de domínio para processar e exibir os incrementos.
     */
    public void run() {
        ui.displayHeader();
        int limit = ui.promptForLimit();

        // Cria um Value Object para passar os parâmetros de forma clara e segura.
        ProcessingParameters params = new ProcessingParameters(limit);

        // Delega a lógica de negócio real para o serviço de domínio.
        // A saída é direcionada para o consumidor de UI, desacoplando a lógica da exibição.
        incrementService.processAndDisplayIncrements(params, ui::displayLine);
        
        // COBOL: STOP RUN.
        // Em Java, o programa termina quando o método run() conclui.
    }
}

/**
 * Classe auxiliar para lidar com a interação do console (entrada e saída).
 * Isola a lógica de I/O do serviço de aplicação, seguindo o princípio de
 * responsabilidade única.
 */
class UserInterface {
    private final Scanner scanner;
    private final Consumer<String> output;

    /**
     * Constrói uma interface de usuário com fontes de entrada e saída específicas.
     * @param scanner Fonte de entrada de dados (ex: System.in).
     * @param output Consumidor para a saída de dados (ex: System.out::println).
     */
    public UserInterface(Scanner scanner, Consumer<String> output) {
        this.scanner = scanner;
        this.output = output;
    }

    /**
     * Exibe o cabeçalho da aplicação.
     * <p>
     * COBOL Source:
     * DISPLAY "This is an example using increment.".
     * DISPLAY "-----------------------------------".
     */
    public void displayHeader() {
        output.accept("This is an example using increment.");
        output.accept("-----------------------------------");
    }

    /**
     * Solicita e lê o valor limite do usuário, com tratamento de erro básico.
     * <p>
     * COBOL Source:
     * DISPLAY "Please enter a value:".
     * ACCEPT A.
     * @return O valor inteiro fornecido pelo usuário.
     */
    public int promptForLimit() {
        output.accept("Please enter a value:");
        while (true) {
            try {
                // COBOL A PIC 99(9) -> max value is 999,999,999, que cabe em um int.
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                output.accept("Invalid input. Please enter a valid integer.");
                scanner.next(); // Limpa o buffer de entrada inválido
            }
        }
    }

    /**
     * Exibe uma linha de texto na saída padrão.
     * @param line A linha a ser exibida.
     */
    public void displayLine(String line) {
        output.accept(line);
    }
}

/**
 * Serviço de domínio que encapsula a lógica de negócio principal do programa.
 * Contém a regra de incrementação e iteração, isolada de preocupações de I/O
 * ou orquestração de fluxo.
 */
class IncrementService {

    /**
     * Executa o loop de incremento e envia cada resultado para o consumidor de saída.
     * A lógica é uma tradução direta do loop PERFORM do COBOL para uma estrutura Java.
     * <p>
     * COBOL Source:
     * MOVE 0 TO I.
     * PERFORM UNTIL I GREATER THAN A
     *     COMPUTE X = I + 1
     *     DISPLAY X
     *     ADD 1 TO I
     * END-PERFORM.
     *
     * @param params Os parâmetros de processamento, contendo o limite.
     * @param output Um consumidor que aceita a string de saída para cada iteração.
     */
    public void processAndDisplayIncrements(ProcessingParameters params, Consumer<String> output) {
        // COBOL: 01 I PIC 99(9).
        // COBOL: MOVE 0 TO I.
        int counter = 0;

        // COBOL: PERFORM UNTIL I GREATER THAN A
        // Isso se traduz em "enquanto I for menor ou igual a A"
        while (counter <= params.limit()) {
            // COBOL: COMPUTE X = I + 1
            // COBOL: 01 X PIC Z(9)9.
            int valueToDisplay = counter + 1;

            // COBOL: DISPLAY X
            // A formatação PIC Z(9)9 suprime zeros à esquerda.
            // A conversão padrão de int para String em Java já tem este comportamento.
            output.accept(String.valueOf(valueToDisplay));

            // COBOL: ADD 1 TO I
            counter++;
        }
    }
}

/**
 * Value Object que representa os parâmetros de entrada para o processamento.
 * Sendo um record, é imutável e encapsula o valor limite de forma segura.
 * <p>
 * COBOL Source: 01 A PIC 99(9).
 *
 * @param limit O valor máximo para o contador (inclusive), lido do usuário.
 */
record ProcessingParameters(int limit) {
    /**
     * Construtor canônico compacto para validação. Garante que o limite não seja negativo,
     * adicionando uma regra de negócio que não estava explícita no COBOL, mas é uma
     * boa prática.
     */
    public ProcessingParameters {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit cannot be negative.");
        }
    }
}