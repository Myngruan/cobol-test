package com.converted.cobol;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Serviço de aplicação principal que orquestra a conversão do programa COBOL Increment.
 * Este é o ponto de entrada e coordena a interação do usuário, a lógica de negócio e a exibição dos resultados.
 * Segue o padrão de ter um método `run()` para o fluxo e um `main()` mínimo para inicialização.
 */
public class IncrementApplicationService {

    private final UserInterface ui;
    private final IncrementService incrementService;

    /**
     * Constrói o serviço de aplicação com suas dependências (Injeção de Dependência manual).
     * @param ui O handler para interação com o usuário (infraestrutura).
     * @param incrementService O serviço de domínio que contém a lógica de negócio pura.
     */
    public IncrementApplicationService(UserInterface ui, IncrementService incrementService) {
        this.ui = ui;
        this.incrementService = incrementService;
    }

    /**
     * Ponto de entrada principal para a execução da aplicação.
     * Apenas instancia o serviço de aplicação e o executa.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Configuração e injeção de dependências.
        // Em uma aplicação maior, um framework de DI (ex: Spring, Guice) seria usado.
        UserInterface ui = new UserInterface(new Scanner(System.in));
        IncrementService incrementService = new IncrementService();
        IncrementApplicationService app = new IncrementApplicationService(ui, incrementService);
        
        app.run();
    }

    /**
     * Executa o fluxo principal da aplicação, correspondendo à PROCEDURE DIVISION do COBOL.
     * 1. Exibe o cabeçalho.
     * 2. Solicita um valor limite ao usuário.
     * 3. Invoca o serviço de domínio para processar e exibir os incrementos.
     * 4. Garante que os recursos de I/O sejam fechados no final.
     */
    public void run() {
        try {
            ui.displayHeader();
            
            // Corresponde a: ACCEPT A.
            int limit = ui.promptForLimit();
            
            // Corresponde a: PERFORM UNTIL I GREATER THAN A ...
            // A lógica do loop é delegada ao serviço de domínio.
            incrementService.processAndDisplayIncrements(limit, ui::displayValue);

        } catch (IllegalStateException | IllegalArgumentException e) {
            ui.displayError("Erro de entrada: " + e.getMessage());
        } catch (Exception e) {
            ui.displayError("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            ui.close();
        }
    }
}

/**
 * Serviço de domínio que encapsula a lógica de negócio de incremento.
 * Esta classe contém a lógica pura, sem dependências de I/O ou outros detalhes de infraestrutura.
 * É o coração do comportamento do programa original.
 */
class IncrementService {

    /**
     * Processa a lógica de incremento e invoca um consumer para cada valor gerado.
     * Este método é uma tradução direta do parágrafo PERFORM da PROCEDURE DIVISION.
     *
     * @param limit O valor limite para o incremento (variável 'A' do COBOL).
     * @param displayer Uma função para consumir o valor gerado (abstrai o 'DISPLAY' do COBOL).
     */
    public void processAndDisplayIncrements(int limit, Consumer<String> displayer) {
        // Corresponde a: MOVE 0 TO I.
        // A variável 'I' do COBOL é o contador do loop.
        int counter = 0;

        // Corresponde a: PERFORM UNTIL I GREATER THAN A
        // O loop executa enquanto o contador for menor ou igual ao limite.
        while (counter <= limit) {
            // Corresponde a: COMPUTE X = I + 1
            // A variável 'X' do COBOL armazena o resultado para exibição.
            int result = counter + 1;

            // A formatação PIC Z(9)9 suprime zeros à esquerda. Em Java,
            // a conversão padrão para String é suficiente para a lógica de exibição no console.
            String formattedResult = String.valueOf(result);

            // Corresponde a: DISPLAY X
            // Invoca o consumer passado como parâmetro, desacoplando a lógica da exibição.
            displayer.accept(formattedResult);

            // Corresponde a: ADD 1 TO I
            counter++;
        }
    }
}

/**
 * Classe auxiliar para lidar com a interação com o usuário (console I/O).
 * Abstrai as operações de 'DISPLAY' e 'ACCEPT' do COBOL, isolando-as da lógica de negócio
 * e do serviço de aplicação.
 */
class UserInterface {
    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Exibe o cabeçalho do programa.
     * Corresponde aos primeiros comandos DISPLAY da PROCEDURE DIVISION.
     */
    public void displayHeader() {
        System.out.println("This is an example using increment.");
        System.out.println("-----------------------------------");
    }

    /**
     * Solicita um valor numérico ao usuário e o valida.
     * Corresponde a: DISPLAY "Please enter a value:" e ACCEPT A.
     *
     * @return O valor inteiro inserido pelo usuário.
     * @throws IllegalArgumentException se a entrada for inválida ou fora do intervalo.
     * @throws IllegalStateException se o scanner já estiver fechado.
     */
    public int promptForLimit() {
        System.out.println("Please enter a value:");
        try {
            int value = scanner.nextInt();
            
            // A variável 'A' do COBOL é PIC 99(9), que suporta até 9 dígitos.
            // Validamos para manter a restrição do programa original.
            final int MAX_VALUE = 999_999_999;
            if (value < 0 || value > MAX_VALUE) {
                throw new IllegalArgumentException("Value must be a positive integer up to " + MAX_VALUE + ".");
            }
            return value;
        } catch (InputMismatchException e) {
            // Limpa o buffer do scanner em caso de entrada inválida para evitar loop infinito.
            scanner.next(); 
            throw new IllegalArgumentException("Invalid input. Please enter a whole number.");
        }
    }

    /**
     * Exibe um valor no console.
     * Corresponde ao comando 'DISPLAY X'.
     *
     * @param value A string a ser exibida.
     */
    public void displayValue(String value) {
        System.out.println(value);
    }

    /**
     * Exibe uma mensagem de erro no console de erro padrão.
     * @param message A mensagem de erro a ser exibida.
     */
    public void displayError(String message) {
        System.err.println(message);
    }

    /**
     * Fecha os recursos de I/O subjacentes. Essencial para evitar vazamento de recursos.
     * Corresponde implicitamente ao 'STOP RUN' que finaliza o programa e libera recursos.
     */
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}