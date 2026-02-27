package com.converted.cobol;

/**
 * Serviço de aplicação principal para a conversão do programa COBOL PreDefMsg.
 * Orquestra o fluxo geral da aplicação, atuando como o ponto de entrada
 * para a lógica de negócio.
 *
 * @author jiuweigui (COBOL Author)
 * @version 21 (Java Conversion)
 */
public class PredefmsgApplicationService {

    private final MessageService messageService;
    private final ConsoleWriter consoleWriter;

    /**
     * Constrói o serviço de aplicação e inicializa suas dependências.
     * Em uma aplicação real, estas dependências seriam injetadas por um framework de DI.
     */
    public PredefmsgApplicationService() {
        this.messageService = new MessageService();
        this.consoleWriter = new ConsoleWriter();
    }

    /**
     * Executa a lógica principal da aplicação.
     * Este método corresponde à 'PROCEDURE DIVISION' do programa COBOL.
     * O fluxo é:
     * 1. Obter a mensagem predefinida.
     * 2. Exibir a mensagem.
     */
    public void run() {
        // 1. Obter a mensagem predefinida do serviço de domínio.
        Message messageToDisplay = messageService.getPredefinedMessage();

        // 2. Usar o componente de I/O para exibir a mensagem.
        // Corresponde à instrução COBOL: 'DISPLAY PreDefMsg.'
        consoleWriter.display(messageToDisplay);

        // A instrução 'STOP RUN.' é implícita em Java quando o método main termina.
    }

    /**
     * O ponto de entrada principal para a aplicação Java.
     * Sua única responsabilidade é instanciar e executar o serviço de aplicação.
     * Nenhuma regra de negócio deve ser colocada aqui.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        PredefmsgApplicationService app = new PredefmsgApplicationService();
        app.run();
    }
}

/**
 * Um serviço de domínio responsável pela lógica de negócio relacionada a mensagens.
 * Neste caso simples, sua única responsabilidade é fornecer a mensagem predefinida.
 */
class MessageService {

    /**
     * Cria e retorna a mensagem predefinida.
     * O valor é derivado da declaração COBOL:
     * '01 PreDefMsg PIC X(18) VALUE 'Hello again World!'.'
     *
     * @return Um objeto Message contendo o texto predefinido.
     */
    public Message getPredefinedMessage() {
        return new Message("Hello again World!");
    }
}

/**
 * Representa uma mensagem como um Value Object.
 * É um objeto imutável que encapsula um valor de string.
 * Corresponde ao item de dados 'PreDefMsg' na WORKING-STORAGE SECTION.
 * Usar um 'record' do Java 21 é ideal para Value Objects concisos e imutáveis.
 *
 * @param value O conteúdo textual da mensagem.
 */
record Message(String value) {
}

/**
 * Classe auxiliar responsável por operações de saída (I/O).
 * Isola a lógica de exibição no console, tornando o resto da aplicação
 * independente da forma como a saída é apresentada.
 * Corresponde ao verbo 'DISPLAY' do COBOL.
 */
class ConsoleWriter {

    /**
     * Exibe o conteúdo de um objeto Message na saída padrão (console).
     *
     * @param message A mensagem a ser exibida.
     */
    public void display(Message message) {
        if (message != null && message.value() != null) {
            System.out.println(message.value());
        }
    }
}