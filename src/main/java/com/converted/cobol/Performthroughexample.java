package com.converted.cobol;

/**
 * Serviço de aplicação principal que orquestra a execução do programa COBOL legado
 * PerformThroughExample.
 * <p>
 * Esta classe é o ponto de entrada e coordena as chamadas para os serviços de domínio,
 * seguindo o fluxo definido na PROCEDURE DIVISION original.
 *
 * @author Gerado por IA especialista em refatoração COBOL para Java
 */
public class PerformthroughexampleApplicationService {

    /**
     * Constante que representa a variável 'RepeatTimes' da WORKING-STORAGE.
     * COBOL: 01 RepeatTimes PIC 9 VALUE 7.
     */
    private static final int REPEAT_TIMES = 7;

    /**
     * Serviço de domínio responsável pela lógica de impressão em loop.
     * Encapsula a lógica dos parágrafos da PROCEDURE DIVISION.
     */
    private final LoopPrintingService loopPrintingService;

    /**
     * Construtor que inicializa os serviços de domínio necessários.
     */
    public PerformthroughexampleApplicationService() {
        this.loopPrintingService = new LoopPrintingService();
    }

    /**
     * Ponto de entrada principal da aplicação, conforme as regras de design.
     * Apenas instancia e executa o serviço de aplicação.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new PerformthroughexampleApplicationService().run();
    }

    /**
     * Orquestra o fluxo de execução principal, espelhando a PROCEDURE DIVISION do COBOL.
     */
    public void run() {
        // COBOL: DISPLAY "Program starts here...".
        System.out.println("Program starts here...");

        // COBOL: PERFORM 5 TIMES ... END-PERFORM
        this.executeInlineLoop();

        // COBOL: DISPLAY "Done with inline next stop out-of-line..."
        System.out.println("Done with inline next stop out-of-line...");

        // COBOL: PERFORM SecondVersion RepeatTimes TIMES.
        this.executeOutOfLineLoop();

        // COBOL: DISPLAY "Program execution ends here...".
        // COBOL: STOP RUN.
        System.out.println("Program execution ends here...");
    }

    /**
     * Etapa do fluxo que executa o loop "inline" do programa COBOL.
     * COBOL: PERFORM 5 TIMES DISPLAY "[+] This is inline version printed 5 times." END-PERFORM
     */
    private void executeInlineLoop() {
        final int inlineRepetitions = 5;
        loopPrintingService.printInlineMessage(inlineRepetitions);
    }

    /**
     * Etapa do fluxo que executa o loop "out-of-line", chamando o parágrafo correspondente.
     * COBOL: PERFORM SecondVersion RepeatTimes TIMES.
     */
    private void executeOutOfLineLoop() {
        loopPrintingService.printOutOfLineMessage(REPEAT_TIMES);
    }
}

/**
 * Serviço de domínio que encapsula a lógica de negócio de impressão de mensagens em loop.
 * <p>
 * Esta classe contém a implementação dos parágrafos da PROCEDURE DIVISION que
 * realizam as operações de impressão repetitiva.
 */
class LoopPrintingService {

    /**
     * Executa a lógica do loop inline do COBOL.
     * Imprime uma mensagem específica um número determinado de vezes.
     *
     * @param times O número de vezes que a mensagem deve ser impressa.
     */
    public void printInlineMessage(int times) {
        // Lógica correspondente a:
        // PERFORM 5 TIMES
        //     DISPLAY "[+] This is inline version printed 5 times."
        // END-PERFORM
        for (int i = 0; i < times; i++) {
            System.out.println("[+] This is inline version printed 5 times.");
        }
    }

    /**
     * Executa a lógica do parágrafo 'SecondVersion' do COBOL.
     * Imprime uma mensagem específica um número determinado de vezes.
     *
     * @param times O número de vezes que a mensagem deve ser impressa.
     */
    public void printOutOfLineMessage(int times) {
        // Lógica correspondente ao parágrafo:
        // SecondVersion.
        //     DISPLAY "[-] This is Out-of-line Perform printed 7 times.".
        for (int i = 0; i < times; i++) {
            System.out.println("[-] This is Out-of-line Perform printed 7 times.");
        }
    }
}