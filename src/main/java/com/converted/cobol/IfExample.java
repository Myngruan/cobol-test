package com.converted.cobol;

import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra a lógica do programa COBOL if-example.
 * Este serviço coordena a interação com o usuário, a aplicação das regras de negócio
 * e a exibição do resultado final, seguindo os princípios de design orientado a objetos.
 *
 * COBOL Origin: PROGRAM-ID. if-example.
 */
public class IfExampleApplicationService {

    private final ConsoleHandler consoleHandler;
    private final GreetingService greetingService;

    /**
     * Constrói o serviço de aplicação, inicializando suas dependências.
     * As dependências (serviços e handlers) são criadas aqui para garantir
     * que o serviço de aplicação esteja pronto para ser executado.
     */
    public IfExampleApplicationService() {
        this.consoleHandler = new ConsoleHandler();
        this.greetingService = new GreetingService();
    }

    /**
     * Ponto de entrada principal para a execução da lógica de negócio.
     * Este método orquestra o fluxo:
     * 1. Solicita e lê a entrada do usuário.
     * 2. Processa a entrada para criar um objeto de domínio (UserName).
     * 3. Usa um serviço de domínio para gerar a mensagem de saudação apropriada.
     * 4. Exibe a mensagem final ao usuário.
     *
     * COBOL Origin: PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: DISPLAY "Please enter your name in upper-case: ".
        consoleHandler.promptForName();

        // COBOL: ACCEPT UserInput.
        String rawInput = consoleHandler.readUserInput();

        // A criação do Value Object encapsula a primeira parte da lógica condicional.
        // COBOL: IF UserInput IS ALPHABETIC-LOWER ...
        UserName userName = UserName.fromInput(rawInput);

        // O serviço de domínio encapsula a lógica de qual mensagem gerar.
        String message = greetingService.generateGreetingMessage(userName);

        // COBOL: DISPLAY "..."
        consoleHandler.displayMessage(message);
    }

    /**
     * O método main é o ponto de entrada da aplicação Java.
     * Sua única responsabilidade é instanciar e executar o serviço de aplicação.
     * Nenhuma lógica de negócio reside aqui.
     *
     * COBOL Origin: STOP RUN (fim da execução).
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new IfExampleApplicationService().run();
    }
}

/**
 * Serviço de domínio responsável por gerar mensagens de saudação.
 * Encapsula a regra de negócio sobre qual mensagem exibir com base
 * no estado do nome do usuário (se foi corrigido ou não).
 */
class GreetingService {

    /**
     * Gera uma mensagem de saudação com base nas propriedades do objeto UserName.
     *
     * COBOL Origin: Lógica dentro do IF/ELSE para DISPLAY.
     *
     * @param userName O objeto de valor UserName contendo o nome e o estado da correção.
     * @return Uma string contendo a mensagem de saudação formatada.
     */
    public String generateGreetingMessage(UserName userName) {
        if (userName.wasCorrected()) {
            // COBOL: DISPLAY "Plz uppercase. Fixed it, ", UserInput
            return "Plz uppercase. Fixed it, " + userName.getValue();
        } else {
            // COBOL: ELSE DISPLAY "Hello, ", UserInput
            return "Hello, " + userName.getValue();
        }
    }
}

/**
 * Representa o nome de um usuário como um Value Object.
 * É imutável e encapsula a lógica de validação e normalização
 * relacionada ao nome, conforme definido no programa COBOL.
 *
 * COBOL Origin: 01 UserInput PIC X(20).
 */
final class UserName {

    private final String value;
    private final boolean wasCorrected;

    private UserName(String value, boolean wasCorrected) {
        // Garante que o valor não exceda o limite original do COBOL PIC X(20)
        this.value = (value != null && value.length() > 20) ? value.substring(0, 20) : value;
        this.wasCorrected = wasCorrected;
    }

    /**
     * Factory method para criar uma instância de UserName a partir da entrada bruta do usuário.
     * Contém a lógica de negócio para verificar se a entrada está em minúsculas e
     * corrigi-la, se necessário.
     *
     * COBOL Origin: IF UserInput IS ALPHABETIC-LOWER
     *               MOVE FUNCTION UPPER-CASE (UserInput) TO UserInput
     *
     * @param rawInput A string de entrada fornecida pelo usuário.
     * @return Uma nova instância de UserName, potencialmente com o valor corrigido.
     */
    public static UserName fromInput(String rawInput) {
        if (isAllLowerCaseAlphabetic(rawInput)) {
            return new UserName(rawInput.toUpperCase(), true);
        } else {
            return new UserName(rawInput, false);
        }
    }

    /**
     * Verifica se uma string contém apenas caracteres alfabéticos minúsculos.
     * Replica a verificação `IS ALPHABETIC-LOWER` do COBOL.
     *
     * @param s A string a ser verificada.
     * @return true se todos os caracteres forem letras minúsculas, false caso contrário.
     */
    private static boolean isAllLowerCaseAlphabetic(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    public String getValue() {
        return value;
    }

    public boolean wasCorrected() {
        return wasCorrected;
    }
}

/**
 * Classe auxiliar para lidar com a entrada e saída do console.
 * Isola as operações de I/O do resto da aplicação, promovendo
 * uma melhor separação de responsabilidades.
 */
class ConsoleHandler {

    private final Scanner scanner;

    public ConsoleHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Exibe o prompt inicial para o usuário.
     * COBOL Origin: DISPLAY "Please enter your name in upper-case: ".
     */
    public void promptForName() {
        System.out.print("Please enter your name in upper-case: ");
    }

    /**
     * Lê uma linha de texto da entrada padrão do console.
     * COBOL Origin: ACCEPT UserInput.
     * @return A string inserida pelo usuário.
     */
    public String readUserInput() {
        return scanner.nextLine();
    }

    /**
     * Exibe uma mensagem final no console.
     * COBOL Origin: DISPLAY "..."
     * @param message A mensagem a ser exibida.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }
}