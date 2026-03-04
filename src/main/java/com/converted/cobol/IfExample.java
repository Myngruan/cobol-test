package com.converted.cobol;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Serviço de aplicação principal que orquestra a lógica do programa COBOL if-example.
 * Este serviço é responsável pelo fluxo de alto nível: interagir com o usuário,
 * processar a entrada e exibir o resultado.
 *
 * COBOL Source: PROGRAM-ID. if-example.
 */
public class IfExampleApplicationService {

    private final UserInterface userInterface;

    /**
     * Constrói o serviço de aplicação, inicializando suas dependências.
     * Neste caso, a dependência é o manipulador de interface do console.
     */
    public IfExampleApplicationService() {
        this.userInterface = new UserInterface();
    }

    /**
     * Ponto de entrada para a execução da lógica de negócio.
     * Orquestra a interação com o usuário e a geração da saudação.
     *
     * COBOL Source: PROCEDURE DIVISION.
     */
    public void run() {
        // COBOL: DISPLAY "Please enter your name in upper-case: ".
        userInterface.promptForName();

        // COBOL: ACCEPT UserInput.
        String rawInput = userInterface.readUserInput();

        // Cria um Value Object para representar o nome do usuário, encapsulando as regras.
        UserName userName = UserName.of(rawInput);

        // A lógica de saudação é obtida do próprio Value Object.
        String greeting = userName.generateGreetingMessage();

        // Exibe o resultado final.
        userInterface.displayMessage(greeting);
    }

    /**
     * Ponto de entrada principal da aplicação Java (main).
     * Sua única responsabilidade é instanciar e executar o serviço de aplicação.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new IfExampleApplicationService().run();
    }
}

/**
 * Value Object que representa o nome de um usuário.
 * Encapsula o valor do nome e as regras de negócio associadas a ele,
 * como validação de formato e geração de mensagens de saudação.
 * Esta classe é imutável.
 *
 * COBOL Source: 01 UserInput PIC X(20).
 */
final class UserName {

    private static final int MAX_LENGTH = 20;
    private static final Pattern ALPHABETIC_LOWER_PATTERN = Pattern.compile("^[a-z]+$");

    private final String value;

    private UserName(String value) {
        this.value = value;
    }

    /**
     * Factory method para criar uma instância de UserName a partir de uma String bruta.
     * Garante que o valor não seja nulo e trunca para o tamanho máximo definido
     * no COBOL (PIC X(20)).
     *
     * @param rawValue A entrada de texto do usuário.
     * @return Uma instância de UserName.
     */
    public static UserName of(String rawValue) {
        if (rawValue == null) {
            rawValue = "";
        }
        if (rawValue.length() > MAX_LENGTH) {
            rawValue = rawValue.substring(0, MAX_LENGTH);
        }
        return new UserName(rawValue);
    }

    /**
     * Gera a mensagem de saudação apropriada com base no conteúdo do nome.
     * Esta é a implementação da lógica principal do programa COBOL.
     *
     * COBOL Source: IF UserInput IS ALPHABETIC-LOWER ... ELSE ... END-IF.
     *
     * @return A string de saudação formatada.
     */
    public String generateGreetingMessage() {
        // COBOL: IF UserInput IS ALPHABETIC-LOWER
        if (isAllLowerCase()) {
            // COBOL: MOVE FUNCTION UPPER-CASE (UserInput) TO UserInput
            String fixedName = this.value.toUpperCase();
            // COBOL: DISPLAY "Plz uppercase. Fixed it, ", UserInput
            return "Plz uppercase. Fixed it, " + fixedName;
        } else {
            // COBOL: ELSE DISPLAY "Hello, ", UserInput
            return "Hello, " + this.value;
        }
    }

    /**
     * Verifica se o nome consiste exclusivamente em letras minúsculas.
     * Emula a verificação `IS ALPHABETIC-LOWER` do COBOL, que é rigorosa
     * e não permite espaços, números ou outros caracteres.
     *
     * @return true se todos os caracteres forem letras minúsculas, false caso contrário.
     */
    private boolean isAllLowerCase() {
        if (value.isEmpty()) {
            return false;
        }
        return ALPHABETIC_LOWER_PATTERN.matcher(this.value).matches();
    }
}

/**
 * Classe auxiliar responsável por toda a interação com o console.
 * Separa as preocupações de I/O (entrada/saída) da lógica de negócio principal.
 */
class UserInterface {

    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Exibe o prompt inicial para o usuário.
     * COBOL Source: DISPLAY "Please enter your name in upper-case: ".
     */
    public void promptForName() {
        System.out.print("Please enter your name in upper-case: ");
    }

    /**
     * Lê a entrada do usuário do console.
     * COBOL Source: ACCEPT UserInput.
     * @return A string digitada pelo usuário.
     */
    public String readUserInput() {
        return scanner.nextLine();
    }

    /**
     * Exibe uma mensagem final no console.
     * COBOL Source: DISPLAY ...
     * @param message A mensagem a ser exibida.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }
}