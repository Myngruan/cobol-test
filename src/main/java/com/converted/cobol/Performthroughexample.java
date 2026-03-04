package com.converted.cobol;

/**
 * Serviço de aplicação principal que orquestra a execução do programa COBOL PerformThroughExample.
 * Este serviço é o ponto de entrada e coordena as chamadas para os serviços de domínio,
 * seguindo o fluxo definido na PROCEDURE DIVISION do programa original.
 */
public class PerformthroughexampleApplicationService {

    private final LoopingMessageService loopingMessageService;

    /**
     * Construtor que inicializa os serviços de domínio necessários para a aplicação.
     * A injeção de dependência (mesmo que manual) é uma boa prática de OO.
     */
    public PerformthroughexampleApplicationService() {
        this.loopingMessageService = new LoopingMessageService();
    }

    /**
     * Ponto de entrada da aplicação Java, conforme as regras de design.
     * Apenas instancia e executa o serviço de aplicação, mantendo a lógica de negócio
     * fora do método estático.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new PerformthroughexampleApplicationService().run();
    }

    /**
     * Executa o fluxo de negócio principal, replicando a lógica da PROCEDURE DIVISION.
     * Este método orquestra as etapas do programa: inicialização, processamento em loop
     * e finalização.
     */
    public void run() {
        // Corresponde ao: DISPLAY "Program starts here...".
        System.out.println("Program starts here...");

        // Corresponde ao: PERFORM 5 TIMES ... END-PERFORM
        // A lógica do loop foi delegada para um serviço de domínio.
        loopingMessageService.printInlineMessage(5);

        // Corresponde ao: DISPLAY "Done with inline next stop out-of-line..."
        System.out.println("Done with inline next stop out-of-line...");

        // Corresponde à inicialização da variável 'RepeatTimes PIC 9 VALUE 7.'
        // na WORKING-STORAGE SECTION. O valor é encapsulado em um Value Object.
        var config = new LoopConfiguration(7);

        // Corresponde ao: PERFORM SecondVersion RepeatTimes TIMES.
        // A chamada ao parágrafo 'SecondVersion' é modelada como uma chamada de método
        // no serviço de domínio, passando a configuração necessária.
        loopingMessageService.printOutOfLineMessage(config);

        // Corresponde ao: DISPLAY "Program execution ends here...".
        System.out.println("Program execution ends here...");

        // O 'STOP RUN.' do COBOL é implícito ao final do método 'run', quando o programa
        // termina sua execução normalmente.
    }
}

/**
 * Serviço de domínio responsável pela lógica de negócio de impressão de mensagens em loop.
 * Encapsula as regras que estavam nos parágrafos e verbos da PROCEDURE DIVISION,
 * promovendo a separação de responsabilidades.
 */
class LoopingMessageService {

    /**
     * Executa um loop "inline" para imprimir uma mensagem um número fixo de vezes.
     * Esta lógica é uma tradução direta do bloco `PERFORM 5 TIMES ... END-PERFORM`.
     *
     * @param times O número de vezes que a mensagem deve ser impressa.
     */
    public void printInlineMessage(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("[+] This is inline version printed 5 times.");
        }
    }

    /**
     * Executa um loop "out-of-line" para imprimir uma mensagem.
     * O número de repetições é definido pela configuração passada como parâmetro.
     * Esta lógica encapsula o comportamento do parágrafo `SecondVersion` do COBOL.
     *
     * @param config O objeto de configuração contendo o número de repetições.
     */
    public void printOutOfLineMessage(LoopConfiguration config) {
        // A lógica do parágrafo 'SecondVersion' está contida aqui.
        for (int i = 0; i < config.repeatTimes(); i++) {
            System.out.println("[-] This is Out-of-line Perform printed 7 times.");
        }
    }
}

/**
 * Value Object que representa os parâmetros de configuração para os loops.
 * Corresponde à variável '01 RepeatTimes' na WORKING-STORAGE SECTION.
 * O uso de um `record` do Java 16+ é ideal para Value Objects, pois garante
 * imutabilidade, além de fornecer construtor, getters, equals, hashCode e toString.
 *
 * @param repeatTimes O número de vezes que o loop 'SecondVersion' deve ser executado.
 */
record LoopConfiguration(int repeatTimes) {
}