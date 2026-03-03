package com.converted.cobol;

/**
 * Serviço de aplicação principal que orquestra a execução do programa COBOL HelloWorld.
 * Esta classe é o ponto de entrada moderno, substituindo o fluxo procedural
 * da PROCEDURE DIVISION.
 */
public class HelloworldApplicationService {

    /**
     * Serviço de domínio que encapsula a lógica de negócio para gerar a saudação.
     */
    private final GreetingService greetingService;

    /**
     * Construtor que inicializa os serviços necessários.
     * Na injeção de dependência real, isso seria tratado por um framework.
     */
    public HelloworldApplicationService() {
        this.greetingService = new GreetingService();
    }

    /**
     * Ponto de entrada principal da aplicação, conforme as regras de design.
     * Apenas instancia e executa o serviço de aplicação.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new HelloworldApplicationService().run();
    }

    /**
     * Orquestra o fluxo de alto nível da aplicação.
     * Este método é o equivalente direto da PROCEDURE DIVISION, mas em um estilo orientado a objetos.
     * Ele delega a lógica de negócio e as operações de I/O para componentes especializados.
     *
     * COBOL Source:
     * PROCEDURE DIVISION.
     *   DISPLAY "Hello World!".
     *   STOP RUN.
     */
    public void run() {
        // 1. Obter a mensagem do serviço de domínio (lógica de negócio)
        String message = greetingService.createGreetingMessage();

        // 2. Exibir a mensagem (operação de I/O)
        displayMessage(message);

        // 3. Fim da execução (equivalente ao STOP RUN)
    }

    /**
     * Método auxiliar responsável por lidar com a saída de dados (I/O).
     * Isola a interação com o console da lógica de negócio principal.
     *
     * COBOL Source:
     *   DISPLAY "Hello World!".
     *
     * @param message A mensagem a ser exibida no console.
     */
    private void displayMessage(String message) {
        System.out.println(message);
    }
}

/**
 * Serviço de domínio responsável pela lógica de negócio relacionada a saudações.
 * Em um programa real, esta classe conteria regras complexas. Aqui, ela simplesmente
 * encapsula a criação da string "Hello World!", separando o "o quê" (a mensagem)
 * do "como" (a exibição no console).
 */
class GreetingService {

    /**
     * Cria a mensagem de saudação de acordo com as regras de negócio.
     *
     * @return A string de saudação "Hello World!".
     */
    public String createGreetingMessage() {
        // A "regra de negócio" deste programa é que a mensagem deve ser "Hello World!".
        return "Hello World!";
    }
}