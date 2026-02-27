package com.converted.cobol;

/**
 * Serviço de aplicação principal que orquestra a execução do programa HelloWorld.
 * Corresponde ao fluxo de controle principal da PROCEDURE DIVISION do COBOL.
 * Este serviço delega a criação da mensagem para um serviço de domínio e a exibição
 * para um serviço de saída, mantendo as responsabilidades separadas.
 */
public class HelloworldApplicationService {

    private final GreetingService greetingService;
    private final OutputService outputService;

    /**
     * Construtor que inicializa os serviços necessários (dependências).
     * Em um framework real (como Spring), isso seria feito por injeção de dependência.
     */
    public HelloworldApplicationService() {
        // Corresponds to initializing resources or modules
        this.greetingService = new GreetingService();
        this.outputService = new OutputService();
    }

    /**
     * Ponto de entrada da lógica de negócio, orquestra os passos da aplicação.
     * Este método é o equivalente moderno da execução sequencial da PROCEDURE DIVISION.
     */
    public void run() {
        // 1. Obter a mensagem de saudação (regra de negócio)
        GreetingMessage message = greetingService.getGreetingMessage();

        // 2. Exibir a mensagem (operação de I/O)
        // Corresponde diretamente ao `DISPLAY "Hello World!"`
        outputService.displayMessage(message);

        // O `STOP RUN` do COBOL é implícito ao final da execução do método.
    }

    /**
     * Ponto de entrada da aplicação Java (main).
     * Sua única responsabilidade é instanciar e executar o serviço de aplicação,
     * mantendo o método livre de qualquer lógica de negócio.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new HelloworldApplicationService().run();
    }
}

/**
 * Serviço de domínio responsável por encapsular a lógica de negócio
 * para criar a mensagem de saudação.
 * Em um programa mais complexo, este serviço conteria regras de negócio
 * mais elaboradas (ex: customizar a saudação baseada na hora do dia ou usuário).
 */
class GreetingService {

    /**
     * Gera a mensagem de saudação padrão.
     * Esta