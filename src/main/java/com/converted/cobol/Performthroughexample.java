package com.converted.cobol;

/**
 * Serviço de aplicação principal que orquestra o fluxo do programa COBOL PerformThroughExample.
 * <p>
 * Este serviço demonstra a conversão da lógica procedural do COBOL para uma estrutura
 * orientada a objetos, separando o fluxo de controle das ações específicas.
 */
public class PerformthroughexampleApplicationService {

    /**
     * Constante que representa a variável 'RepeatTimes' do COBOL.
     * <p>
     * Origem COBOL:
     * <pre>
     * 01 RepeatTimes PIC 9 VALUE 7.
     * </pre>
     */
    private static final int REPEAT_TIMES = 7;

    /**
     * Ponto de entrada da aplicação Java.
     * <p>
     * A responsabilidade do método main é apenas instanciar e iniciar o serviço de aplicação,
     * mantendo-o livre de qualquer lógica de negócio.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        PerformthroughexampleApplicationService app = new PerformthroughexampleApplicationService();
        app.run();
    }

    /**
     * Orquestra a execução principal do programa, seguindo a lógica da PROCEDURE DIVISION.
     * <p>
     * Este método atua como o coordenador central, chamando métodos privados para cada
     * etapa do processo, tornando o fluxo de alto nível claro e legível.
     */
    public void run() {
        // Corresponde a: DISPLAY "Program starts here...".
        displayStartMessage();

        // Corresponde a: PERFORM 5 TIMES ... END-PERFORM
        performInlineLoop();

        // Corresponde a: DISPLAY "Done with inline next stop out-of-line..."
        displayTransitionMessage();

        // Corresponde a: PERFORM SecondVersion RepeatTimes TIMES.
        performOutOfLineLoop();

        // Corresponde a: DISPLAY "Program execution ends here...".
        // e STOP RUN.
        displayEndMessage();
    }

    /**
     * Exibe a mensagem inicial do programa.
     */
    private void displayStartMessage() {
        System.out.println("Program starts here...");
    }

    /**
     * Executa o loop "inline" que se repete por um número fixo de vezes.
     * <p>
     * Origem COBOL:
     * <pre>
     * PERFORM 5 TIMES
     *     DISPLAY "[+] This is inline version printed 5 times."
     * END-PERFORM
     * </pre>
     */
    private void performInlineLoop() {
        for (int i = 0; i < 5; i++) {
            System.out.println("[+] This is inline version printed 5 times.");
        }
    }

    /**
     * Exibe a mensagem de transição entre os dois loops.
     */
    private void displayTransitionMessage() {
        System.out.println("Done with inline next stop out-of-line...");
    }

    /**
     * Executa o loop que chama um método separado, simulando o "PERFORM" de um parágrafo.
     * O número de repetições é controlado pela constante {@link #REPEAT_TIMES}.
     * <p>
     * Origem COBOL:
     * <pre>
     * PERFORM SecondVersion RepeatTimes TIMES.
     * </pre>
     */
    private void performOutOfLineLoop() {
        for (int i = 0; i < REPEAT_TIMES; i++) {
            // A chamada a este método é análoga a executar o parágrafo 'SecondVersion'.
            executeSecondVersionLogic();
        }
    }

    /**
     * Contém a lógica do parágrafo 'SecondVersion' do COBOL.
     * <p>
     * Este método encapsula a ação que era realizada dentro do parágrafo,
     * promovendo a reutilização e a clareza.
     * <p>
     * Origem COBOL:
     * <pre>
     * SecondVersion.
     *     DISPLAY "[-] This is Out-of-line Perform printed 7 times.".
     * </pre>
     */
    private void executeSecondVersionLogic() {
        System.out.println("[-] This is Out-of-line Perform printed 7 times.");
    }

    /**
     * Exibe a mensagem final do programa, indicando sua conclusão.
     */
    private void displayEndMessage() {
        System.out.println("Program execution ends here...");
    }
}