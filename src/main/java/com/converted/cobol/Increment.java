package com.converted.cobol;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra a execução do programa COBOL Increment.
 * Este serviço coordena a interação com o usuário, a execução da lógica de negócio
 * e a exibição dos resultados, seguindo o fluxo original do programa COBOL.
 *
 * COBOL Source: PROCEDURE DIVISION.
 */
public class IncrementApplicationService {

    private final IncrementDomainService incrementDomainService;
    private final ConsoleUI consoleUI;

    /**
     * Constrói o serviço de aplicação, inicializando suas dependências.
     * As dependências (serviço de domínio e UI) são criadas aqui,
     * emulando uma forma simples de injeção de dependência.
     */
    public IncrementApplicationService() {
        this.incrementDomainService = new IncrementDomainService();
        this.consoleUI = new ConsoleUI();
    }

    /**
     * Ponto de entrada principal para a aplicação.
     * Instancia o serviço de aplicação e inicia a execução.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Apenas instancia e executa o serviço de aplicação.
        // Nenhuma lógica de negócio reside aqui.
        new IncrementApplicationService().run();
    }

    /**
     * Orquestra o fluxo de alto nível da aplicação, espelhando a PROCEDURE DIVISION.
     * 1. Exibe uma mensagem de boas-vindas.
     * 2. Solicita um valor limite ao usuário.
     * 3. Invoca o serviço de domínio para gerar a sequência de números.
     * 4. Exibe os resultados gerados.
     */
    public void run() {
        // COBOL: DISPLAY "This is an example using increment.".
        // COBOL: DISPLAY "-----------------------------------".
        consoleUI.displayWelcomeMessage();

        // COBOL: DISPLAY "Please enter a value:".
        // COBOL: ACCEPT A.
        IncrementLimit limit = consoleUI.promptForLimit();

        // COBOL: PERFORM UNTIL I GREATER THAN A ... END-PERFORM.
        List<Integer> resultSequence = incrementDomainService.generateSequence(limit);

        // COBOL: DISPLAY X (dentro do loop)
        consoleUI.displayResults(resultSequence);
    }
}

/**
 * Serviço de domínio responsável pela lógica de negócio principal do programa.
 * Encapsula a regra de como a sequência de incremento é gerada,
 * mantendo-se completamente independente de I/O (entrada/saída).
 */
class IncrementDomainService {

    /**
     * Gera uma sequência de números com base em um limite fornecido.
     * A lógica é uma tradução direta do laço PERFORM do COBOL.
     * Para cada valor de um contador 'i' de 0 até o limite, calcula-se 'i + 1'.
     *
     * COBOL Source:
     * MOVE 0 TO I.
     * PERFORM UNTIL I GREATER THAN A
     *     COMPUTE X = I + 1
     *     ADD 1 TO I
     * END-PERFORM.
     *
     * @param limit O Value Object {@link IncrementLimit} que define o valor máximo do contador.
     * @return Uma lista de inteiros representando a sequência calculada.
     */
    public List<Integer> generateSequence(IncrementLimit limit) {
        // Corresponde à inicialização de 'I' e à lista que armazenará os valores de 'X'.
        List<Integer> sequence = new ArrayList<>();
        int limitValue = limit.value(); // COBOL: A

        // O laço '