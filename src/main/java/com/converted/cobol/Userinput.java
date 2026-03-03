package com.converted.cobol;

import java.util.Objects;
import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra a lógica do programa COBOL UserInput.
 * Este serviço coordena a interação com o usuário, a criação de objetos de domínio
 * e a geração da saudação final, seguindo os princípios de DDD light.
 *
 * COBOL Source: PROGRAM-ID. UserInput.
 */
public class UserinputApplicationService {

    private final UserInteractionService userInteractionService;
    private final GreetingService greetingService;

    /**
     * Constrói o serviço de aplicação, inicializando suas dependências.
     * Em um sistema real, isso seria feito por um framework de injeção de dependência.
     */
    public UserinputApplicationService() {
        this.userInteractionService = new UserInteractionService();
        this.greetingService = new GreetingService();
    }

    /**
     * Ponto de entrada para a execução da lógica de negócio.
     * Orquestra o fluxo: pedir o nome, processar e exibir a saudação.
     *
     * COBOL Source: PROCEDURE DIVISION.
     */
    public void run() {
        String inputName = userInteractionService.askUserName();
        UserName userName = new UserName(inputName);
        String greetingMessage = greetingService.generateGreetingMessage(userName);
        userInteractionService.displayMessage(greetingMessage);
    }

    /**
     * Método principal da aplicação Java.
     * Sua única responsabilidade é instanciar e executar o serviço de aplicação.
     * Nenhuma lógica de negócio deve residir aqui.
     *
     * COBOL Source: STOP RUN (fim da execução).
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new UserinputApplicationService().run();
    }
}

/**
 * Serviço de domínio responsável por encapsular a lógica de negócio
 * relacionada a saudações.
 */
class GreetingService {

    /**
     * Gera uma mensagem de saudação para um determinado nome de usuário.
     *
     * COBOL Source: DISPLAY "It's nice to meet you" SPACE Name.
     * @param userName O objeto de valor representando o nome do usuário.
     * @return A string de saudação formatada.
     */
    public String generateGreetingMessage(UserName userName) {
        return "It's nice to meet you " + userName.getValue();
    }
}

/**
 * Serviço de infraestrutura responsável por toda a interação com o console (entrada e saída).
 * Isola a lógica de negócio dos detalhes de I/O do sistema, tornando o domínio mais puro.
 */
class UserInteractionService {

    private final Scanner scanner;

    public UserInteractionService() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Exibe um prompt e lê o nome do usuário do console.
     *
     * COBOL Source:
     * DISPLAY "What is your name?".
     * ACCEPT UserName.
     *
     * @return O nome inserido pelo usuário como uma String.
     */
    public String askUserName() {
        System.out.println("What is your name?");
        return scanner.nextLine();
    }

    /**
     * Exibe uma mensagem genérica no console.
     *
     * COBOL Source: DISPLAY ...
     * @param message A mensagem a ser exibida.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }
}

/**
 * Objeto de Valor (Value Object) que representa o nome de um usuário.
 * É imutável e sua identidade é definida pelo seu valor.
 * Encapsula o valor e as regras associadas a ele, como o comprimento máximo.
 *
 * COBOL Source:
 * 01 UserName.
 *    02 Name PIC X(10).
 */
final class UserName {

    private final String value;

    /**
     * Constrói um objeto UserName.
     * O nome é truncado para 10 caracteres para manter a fidelidade à regra
     * COBOL 'PIC X(10)', que descarta caracteres excedentes.
     *
     * @param name O nome bruto inserido pelo usuário. Não pode ser nulo.
     */
    public UserName(String name) {
        Objects.requireNonNull(name, "Name cannot be null");
        // Emula o comportamento de PIC X(10), que trunca a entrada se for maior.
        if (name.length() > 10) {
            this.value = name.substring(0, 10);
        } else {
            this.value = name;
        }
    }

    /**
     * @return O valor do nome, garantido que não exceda 10 caracteres.
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return value.equals(userName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}