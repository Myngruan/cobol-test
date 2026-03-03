package com.converted.cobol;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.IntConsumer;

/**
 * Serviço de aplicação principal que orquestra a execução do programa COBOL Increment.
 * <p>
 * Esta classe é o ponto de entrada e coordena a interação com o usuário e a
 * execução da lógica de negócio, seguindo o padrão de um serviço de aplicação.
 *
 * @see <a href="file:Increment.cobol">Increment.cobol</a>
 */
public class IncrementApplicationService {

    /**
     * Ponto de entrada principal da aplicação Java.
     * <p>
     * Apenas instancia e executa o serviço de aplicação, mantendo a lógica de
     * negócio fora do método `main`.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new IncrementApplicationService().run();
    }

    /**
     * Executa o fluxo principal da aplicação.
     * <p>
     * Orquestra os passos de alto nível:
     * 1. Interagir com o usuário para obter os dados de entrada.
     * 2. Invocar o serviço de domínio para processar a lógica de negócio.
     * 3. Garantir que os recursos (como o Scanner) sejam liberados.
     */
    public void run() {
        // O try-with-resources garante que o Scanner no UserInteractionService seja fechado.
        try (UserInteractionService uiService = new UserInteractionService()) {
            
            // Instancia o serviço de domínio que contém a lógica de negócio pura.
            IncrementProcessor domainProcessor = new IncrementProcessor();

            // Corresponde aos comandos DISPLAY iniciais no COBOL.
            uiService.displayHeader();

            // Corresponde a 'ACCEPT A'.
            int limit = uiService.promptForLimit();

            // Corresponde a 'PERFORM UNTIL I GREATER THAN A'.
            // A lógica de processamento é delegada ao serviço de domínio.
            // A lógica de exibição (formatação) é passada como uma função (method reference),
            // desacoplando o domínio da apresentação.
            domainProcessor.processAndDisplay(limit, uiService::displayFormattedValue);

        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}

/**
 * Serviço de domínio que encapsula a lógica de negócio principal do programa.
 * <p>
 * Esta classe contém a regra de negócio de incrementar um contador até um limite,
 * isolada de qualquer detalhe de I/O (entrada/saída) ou infraestrutura.
 */
class IncrementProcessor {

    /**
     * Executa o laço de incremento e invoca uma ação para cada valor gerado.
     * <p>
     * Este método é a tradução direta do parágrafo `PERFORM` do COBOL.
     * Ele recebe o limite superior e um "consumidor" que sabe como lidar com
     * o valor gerado (neste caso, exibi-lo na tela).
     *
     * @param limit O valor máximo para o contador, análogo à variável 'A' do COBOL.
     * @param valueConsumer Ação a ser executada para cada valor calculado, análogo ao 'DISPLAY X'.
     */
    public void processAndDisplay(int limit, IntConsumer valueConsumer) {
        // COBOL: MOVE 0 TO I.
        // COBOL: PERFORM UNTIL I GREATER THAN A
        // A inicialização (int i = 0), a condição (i <= limit) e o incremento (i++)
        // correspondem à estrutura do laço COBOL.
        for (int i = 0; i <= limit; i++) {
            // COBOL: COMPUTE X = I + 1
            int valueToDisplay = i + 1;

            // COBOL: DISPLAY X
            // Invoca a função passada para exibir o valor, sem saber como ela o faz.
            valueConsumer.accept(valueToDisplay);
            
            // COBOL: ADD 1 TO I (realizado pelo i++ do laço for)
        }
    }
}

/**
 * Classe auxiliar responsável por toda a interação com o console (usuário).
 * <p>
 * Isola as operações de leitura (`ACCEPT`) e escrita (`DISPLAY`) do COBOL,
 * tratando-as como preocupações de infraestrutura, separadas da lógica de negócio.
 * Implementa {@link AutoCloseable} para gerenciar o ciclo de vida do {@link Scanner}.
 */
class UserInteractionService implements AutoCloseable {

    private final Scanner scanner;

    /**
     * Construtor que inicializa o leitor de entrada do console.
     */
    public UserInteractionService() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Exibe o cabeçalho inicial do programa.
     * <p>
     * Corresponde aos primeiros comandos `DISPLAY` do programa COBOL.
     */
    public void displayHeader() {
        System.out.println("This is an example using increment.");
        System.out.println("-----------------------------------");
    }

    /**
     * Solicita e lê o valor limite do usuário.
     * <p>
     * Corresponde ao `DISPLAY "Please enter a value:"` e `ACCEPT A`.
     * Inclui validação para garantir que um número inteiro válido seja fornecido.
     *
     * @return O valor inteiro fornecido pelo usuário.
     */
    public int promptForLimit() {
        System.out.println("Please enter a value:");
        while (true) {
            try {
                // A variável 'A' do COBOL é representada por este valor de retorno.
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next(); // Limpa o buffer do scanner.
            }
        }
    }

    /**
     * Exibe um valor numérico formatado no console.
     * <p>
     * Corresponde ao `DISPLAY X` e à formatação `PIC Z(9)9`.
     * A formatação Java `"%10d"` alinha o número à direita em um campo de 10
     * caracteres, preenchendo com espaços à esquerda, simulando o `Z(9)9`.
     *
     * @param value O valor a ser formatado e exibido.
     */
    public void displayFormattedValue(int value) {
        // A variável 'X' do COBOL com PIC Z(9)9 é representada por esta formatação.
        String formattedValue = String.format("%10d", value);
        System.out.println(formattedValue);
    }

    /**
     * Fecha o recurso {@link Scanner} para evitar vazamentos de recursos.
     * <p>
     * Este método é chamado automaticamente pelo bloco try-with-resources.
     */
    @Override
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}