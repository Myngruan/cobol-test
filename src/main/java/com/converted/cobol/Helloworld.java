package com.converted.cobol;

import java.io.PrintStream;

/**
 * Serviço de aplicação principal que orquestra a execução do programa COBOL HelloWorld.
 * Corresponde ao fluxo de controle principal da PROCEDURE DIVISION, separando a lógica
 * de negócio da infraestrutura de I/O.
 */
public class HelloworldApplicationService {

    private final GreetingService greetingService;
    private final ConsoleDisplay consoleDisplay;

    /**
     * Constrói o serviço de aplicação com suas dependências.
     * Em um sistema real, isso seria gerenciado por um framework de injeção de dependência.
     *
     * @param greetingService O serviço de domínio para obter a mensagem de saudação.
     * @param consoleDisplay O serviço de infraestrutura para exibir a mensagem.
     */
    public HelloworldApplicationService(GreetingService greetingService, ConsoleDisplay consoleDisplay) {
        this.greetingService = greetingService;
        this.consoleDisplay = consoleDisplay;
    }

    /**
     * Ponto de entrada principal para a lógica da aplicação.
     * Este método executa o fluxo de alto nível do programa, que consiste em
     * obter uma saudação e exibi-la.
     * O `STOP RUN` do COBOL é implícito ao final da execução deste método.
     */
    public void run() {
        // 1. Obter a mensagem de saudação (regra de negócio)
        String message = greetingService.getGreetingMessage();

        // 2. Exibir a mensagem (operação de I/O)
        // Corresponde diretamente ao `DISPLAY "Hello World!"` no COBOL.
        consoleDisplay.show(message);
    }

    /**
     * Ponto de entrada da JVM para o programa.
     * Responsável apenas por instanciar e executar o serviço de aplicação.
     * Nenhuma regra de negócio deve ser colocada aqui.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Injeção de dependência manual para simplicidade.
        var greetingService = new GreetingService();
        var consoleDisplay = new ConsoleDisplay(System.out);
        var app = new HelloworldApplicationService(greetingService, consoleDisplay);

        app.run();
    }
}

/**
 * Serviço de domínio responsável por encapsular a lógica de negócio relacionada a saudações.
 * Neste caso simples, a "lógica" é apenas saber qual é a mensagem correta a ser exibida,
 * isolando o conteúdo da forma como ele é apresentado.
 */
class GreetingService {

    /**
     * Retorna a mensagem de saudação padrão do sistema.
     * Esta é a regra de negócio central do programa original.
     *
     * @return A string "Hello World!".
     */
    public String getGreetingMessage() {
        // Lógica de negócio: a mensagem a ser exibida é sempre "Hello World!".
        return "Hello World!";
    }
}

/**
 * Classe de infraestrutura responsável por interagir com o console.
 * Isola as operações de I/O (saída padrão) do resto da aplicação, tornando o
 * código mais testável e flexível a mudanças no meio de saída.
 * Corresponde à implementação técnica da instrução `DISPLAY` do COBOL.
 */
class ConsoleDisplay {

    private final PrintStream outputStream;

    /**
     * Constrói o serviço de display, especificando para qual stream de saída
     * as mensagens devem ser enviadas.
     *
     * @param outputStream O stream de saída (ex: System.out).
     */
    public ConsoleDisplay(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * Exibe uma mensagem no stream de saída configurado.
     *
     * @param message A mensagem a ser exibida.
     */
    public void show(String message) {
        outputStream.println(message);
    }
}