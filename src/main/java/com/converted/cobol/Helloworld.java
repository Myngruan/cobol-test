package com.converted.cobol;

import java.io.PrintStream;

/**
 * Serviço de domínio responsável por encapsular a lógica de negócio
 * relacionada à geração de saudações.
 * <p>
 * Em um programa mais complexo, esta classe conteria regras de negócio
 * mais elaboradas. Aqui, a "regra" é simplesmente saber qual mensagem
 * deve ser exibida.
 */
class GreetingService {

    /**
     * Gera a mensagem de saudação.
     * <p>
     * Origem COBOL: A lógica que define o literal "Hello World!".
     *
     * @return A string de saudação.
     */
    public String generateGreetingMessage() {
        return "Hello World!";
    }
}

/**
 * Serviço de aplicação principal para o programa COBOL HelloWorld.
 * <p>
 * Esta classe orquestra o fluxo da aplicação, atuando como a camada
 * de entrada para a lógica de negócio. Ela não contém regras de negócio
 * diretamente, mas delega para os serviços de domínio apropriados.
 * <p>
 * Origem COBOL: Corresponde ao `PROGRAM-ID. HelloWorld.` e ao fluxo principal
 * da `PROCEDURE DIVISION`.
 */
public class HelloworldApplicationService {

    private final GreetingService greetingService;
    private final PrintStream outputChannel;

    /**
     * Construtor padrão que inicializa os serviços de domínio e
     * as dependências necessárias.
     */
    public HelloworldApplicationService() {
        this.greetingService = new GreetingService();
        // Encapsula a saída padrão para facilitar testes e isolamento de I/O.
        this.outputChannel = System.out;
    }

    /**
     * Ponto de entrada principal para a lógica da aplicação.
     * Orquestra as chamadas para executar o caso de uso.
     * <p>
     * Origem COBOL: Corresponde à execução sequencial dos parágrafos na
     * `PROCEDURE DIVISION`.
     */
    public void run() {
        // 1. Obter a mensagem do serviço de domínio.
        String message = greetingService.generateGreetingMessage();

        // 2. Exibir a mensagem (operação de I/O).
        displayMessage(message);

        // 3. Finalizar a execução.
        // Origem COBOL: STOP RUN.
    }

    /**
     * Lida com a operação de saída (I/O), mantendo a lógica de negócio
     * separada dos detalhes de infraestrutura.
     * <p>
     * Origem COBOL: `DISPLAY "Hello World!"`.
     *
     * @param message A mensagem a ser exibida.
     */
    private void displayMessage(String message) {
        this.outputChannel.println(message);
    }

    /**
     * Ponto de entrada da aplicação Java (bootstrap).
     * <p>
     * A única responsabilidade deste método é instanciar e iniciar o serviço
     * de aplicação. Nenhuma lógica de negócio deve ser colocada aqui.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new HelloworldApplicationService().run();
    }
}