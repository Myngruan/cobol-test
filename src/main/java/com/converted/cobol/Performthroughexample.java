package com.converted.cobol;

import java.util.stream.IntStream;

/**
 * Serviço de aplicação principal que orquestra a execução do processo
 * convertido do programa COBOL PerformThroughExample.
 * Este serviço é o ponto de entrada para a lógica de negócio.
 */
public class PerformthroughexampleApplicationService {

    private final ProcessConfiguration config;
    private final ConsoleDisplay display;
    private final RepetitionService repetitionService;

    /**
     * Construtor que inicializa os serviços e configurações necessários.
     * A injeção de dependência é simulada aqui para clareza.
     */
    public PerformthroughexampleApplicationService() {
        // Corresponde a '01 RepeatTimes PIC 9 VALUE 7.' em WORKING-STORAGE.
        this.config = new ProcessConfiguration(7);
        this.display = new ConsoleDisplay();
        this.repetitionService = new RepetitionService(display);
    }

    /**
     * Ponto de entrada principal para a execução da aplicação.
     * Este método é responsável por chamar o `run()` do serviço de aplicação.
     * Nenhuma lógica de negócio deve residir aqui.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new PerformthroughexampleApplicationService().run();
    }

    /**
     * Orquestra o fluxo principal do programa, espelhando a PROCEDURE DIVISION.
     */
    public void run() {
        // Corresponde a 'DISPLAY "Program starts here..."'.
        display.show("Program starts here...");

        // Corresponde a 'PERFORM 5 TIMES ... END-PERFORM'.
        executeInlineRepetition();

        // Corresponde a 'DISPLAY "Done with inline next stop out-of-line..."'.
        display.show("Done with inline next stop out-of-line...");

        // Corresponde a 'PERFORM SecondVersion RepeatTimes TIMES.'.
        // A lógica do parágrafo 'SecondVersion' foi movida para o RepetitionService.
        repetitionService.performOutOfLineRepetition(config.repeatTimes());

        // Corresponde a 'DISPLAY "Program execution ends here..."'.
        display.show("Program execution ends here...");

        // A finalização do método 'run' equivale ao 'STOP RUN.'.
    }

    /**
     * Executa a lógica que estava no laço 'PERFORM 5 TIMES' inline.
     * Extraído para um método privado para maior clareza e responsabilidade única.
     */
    private void executeInlineRepetition() {
        final int inlineRepetitions = 5;
        IntStream.range(0, inlineRepetitions).forEach(i ->
            display.show("[+] This is inline version printed 5 times.")
        );
    }
}

/**
 * Um Value Object que encapsula os parâmetros de configuração do processo.
 * Neste caso, armazena o número de repetições para o segundo laço.
 * É imutável, como um bom Value Object deve ser.
 *
 * @param repeatTimes Corresponde à variável 'RepeatTimes' do COBOL.
 */
record ProcessConfiguration(int repeatTimes) {
}

/**
 * Serviço de Domínio responsável pela lógica de negócio relacionada a repetições.
 * Encapsula a lógica do parágrafo 'SecondVersion' do COBOL.
 */
class RepetitionService {

    private final ConsoleDisplay display;

    /**
     * Construtor do serviço de repetição.
     *
     * @param display Uma dependência para um serviço de exibição de console.
     */
    public RepetitionService(ConsoleDisplay display) {
        this.display = display;
    }

    /**
     * Executa a lógica do parágrafo 'SecondVersion' do COBOL.
     * Este método contém a regra de negócio de exibir uma mensagem específica
     * um número determinado de vezes.
     *
     * @param times O número de vezes que a mensagem deve ser exibida.
     */
    public void performOutOfLineRepetition(int times) {
        IntStream.range(0, times).forEach(i ->
            this.printOutOfLineMessage()
        );
    }

    /**
     * Método privado que representa a ação dentro do parágrafo 'SecondVersion'.
     */
    private void printOutOfLineMessage() {
        // Corresponde a 'DISPLAY "[-] This is Out-of-line Perform printed 7 times."'.
        display.show("[-] This is Out-of-line Perform printed 7 times.");
    }
}

/**
 * Classe auxiliar de infraestrutura para lidar com a saída no console.
 * Isola a lógica de negócio de como as mensagens são exibidas (neste caso, System.out).
 * Corresponde ao verbo 'DISPLAY' do COBOL.
 */
class ConsoleDisplay {

    /**
     * Exibe uma mensagem no dispositivo de saída padrão.
     *
     * @param message A mensagem a ser exibida.
     */
    public void show(String message) {
        System.out.println(message);
    }
}