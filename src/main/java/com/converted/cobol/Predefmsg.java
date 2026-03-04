package com.converted.cobol;

/**
 * Serviço de aplicação principal que orquestra a execução da lógica
 * portada do programa COBOL PreDefMsg.
 * <p>
 * Responsável por coordenar a obtenção da mensagem e sua exibição,
 * seguindo o fluxo original do programa legado.
 */
public class PredefmsgApplicationService {

    private final MessageService messageService;

    /**
     * Constrói o serviço de aplicação, inicializando suas dependências de domínio.
     * Em um sistema maior, isso seria feito por um framework de injeção de dependência.
     */
    public PredefmsgApplicationService() {
        this.messageService = new MessageService();
    }

    /**
     * Ponto de entrada principal para a lógica de negócio.
     * Orquestra o fluxo: obter a mensagem predefinida e exibi-la.
     * Este método substitui a PROCEDURE DIVISION de alto nível.
     */
    public void run() {
        // 1. Obter o dado do domínio (a mensagem)
        PredefinedMessage message = messageService.getPredefinedMessage();

        // 2. Executar a ação de saída (exibir a mensagem)
        //    Isso corresponde ao parágrafo que continha 'DISPLAY'.
        displayMessage(message);
    }

    /**
     * Lida com a lógica de I/O, exibindo a mensagem no console.
     * Isola a interação com o sistema de saída, mapeando a instrução 'DISPLAY' do COBOL.
     *
     * @param message O objeto de valor contendo a mensagem a ser exibida.
     */
    private void displayMessage(PredefinedMessage message) {
        System.out.println(message.text());
    }

    /**
     * Ponto de entrada da aplicação Java (JVM).
     * Sua única responsabilidade é instanciar e executar o serviço de aplicação,
     * mantendo o método 'main' livre de qualquer regra de negócio.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Mapeia o 'STOP RUN' implícito ao final da execução.
        new PredefmsgApplicationService().run();
    }
}

/**
 * Serviço de domínio responsável pelas regras de negócio relacionadas a mensagens.
 * <p>
 * Encapsula a lógica de como as mensagens são criadas ou obtidas,
 * mantendo o serviço de aplicação focado na orquestração.
 */
class MessageService {

    /**
     * Fornece a mensagem predefinida do sistema.
     * <p>
     * Esta lógica mapeia diretamente a definição e o valor da variável
     * 'PreDefMsg' na WORKING-STORAGE SECTION do programa COBOL.
     * <p>
     * COBOL Source:
     * <pre>
     * WORKING-STORAGE SECTION.
     * 01 PreDefMsg	PIC X(18) VALUE 'Hello again World!'.
     * </pre>
     *
     * @return Um Value Object representando a mensagem predefinida.
     */
    public PredefinedMessage getPredefinedMessage() {
        return new PredefinedMessage("Hello again World!");
    }
}

/**
 * Representa um Value Object para a mensagem predefinida.
 * <p>
 * É imutável e sua identidade é definida pelo seu conteúdo (o texto), não por um ID.
 * Mapeia a estrutura de dados '01 PreDefMsg' da DATA DIVISION do COBOL.
 * O uso de 'record' do Java 21 é ideal para implementar Value Objects de forma concisa.
 *
 * @param text O conteúdo textual da mensagem.
 */
record PredefinedMessage(String text) {
}