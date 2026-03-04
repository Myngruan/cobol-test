package com.converted.cobol;

import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra o fluxo do programa COBOL 'UserInput'.
 * <p>
 * Este serviço é responsável por coordenar a interação com o usuário e a exibição
 * da mensagem de saudação, substituindo a PROCEDURE DIVISION do programa original.
 * Segue o padrão de ter um método {@code run()} para o fluxo principal e um
 * método {@code main()} estático apenas para inicialização.
 */
public class UserinputApplicationService {

    private final UserInteractionService userInteractionService;

    /**
     * Constrói o serviço de aplicação, inicializando suas dependências.
     * Neste caso, cria uma instância do serviço de interação com o usuário.
     */
    public UserinputApplicationService() {
        this.userInteractionService = new UserInteractionService();
    }

    /**
     * Ponto de entrada principal para a execução da lógica de negócio.
     * Este método executa a sequência de operações definida na PROCEDURE DIVISION do COBOL.
     * 1. Solicita o nome do usuário.
     * 2. Exibe uma saudação personalizada.
     */
    public void run() {
        // O fluxo aqui reflete a PROCEDURE DIVISION do COBOL.
        UserName userName = userInteractionService.askForUserName();
        userInteractionService.displayGreeting(userName);
        // A conclusão deste método é análoga ao 'STOP RUN' do COBOL.
    }

    /**
     * O ponto de entrada da aplicação Java (main).
     * Sua única responsabilidade é instanciar e executar o serviço de aplicação.
     * Nenhuma lógica de negócio deve ser colocada aqui, conforme as boas práticas de OO.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new UserinputApplicationService().run();
    }
}

/**
 * Um serviço de infraestrutura responsável por toda a interação com o console.
 * <p>
 * Esta classe encapsula as operações de 'DISPLAY' e 'ACCEPT' do COBOL,
 * separando os detalhes de I/O da lógica de orquestração principal. Isso melhora
 * a testabilidade e a separação de responsabilidades.
 */
class UserInteractionService {

    private final Scanner scanner;

    /**
     * Construtor que inicializa o leitor de entrada do sistema.
     */
    public UserInteractionService() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Solicita e lê o nome do usuário do console.
     * <p>
     * Corresponde às instruções COBOL:
     * <pre>
     * DISPLAY "What is your name?".
     * ACCEPT UserName.
     * </pre>
     *
     * @return Um Value Object {@link UserName} contendo o nome inserido.
     */
    public UserName askForUserName() {
        // Corresponde a: DISPLAY "What is your name?".
        System.out.println("What is your name?");
        
        // Corresponde a: ACCEPT UserName.
        String input = scanner.nextLine();
        
        return new UserName(input);
    }

    /**
     * Exibe a mensagem de saudação final no console.
     * <p>
     * Corresponde à instrução COBOL:
     * <pre>
     * DISPLAY "It's nice to meet you" SPACE Name.
     * </pre>
     *
     * @param userName O nome do usuário a ser saudado.
     */
    public void displayGreeting(UserName userName) {
        // Corresponde a: DISPLAY "It's nice to meet you" SPACE Name.
        System.out.println("It's nice to meet you " + userName.value());
    }
}

/**
 * Value Object que representa o nome de um usuário.
 * <p>
 * Substitui a estrutura de dados COBOL '01 UserName'.
 * <pre>
 * 01 UserName.
 *    02 Name PIC X(10).
 * </pre>
 * Como um Value Object, é imutável e sua identidade é definida pelo seu valor.
 * Usar um {@code record} do Java 21 é ideal para este propósito, pois fornece
 * imutabilidade, construtor, getters, equals, hashCode e toString automaticamente.
 *
 * @param value O valor do nome.
 */
record UserName(String value) {
    /**
     * Construtor canônico que garante a validade do estado do objeto.
     * O nome é validado para não ser nulo/vazio e é normalizado (removendo
     * espaços em branco no início e fim).
     *
     * @param value O nome bruto inserido pelo usuário.
     * @throws IllegalArgumentException se o nome for nulo ou em branco.
     */
    public UserName {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("User name cannot be null or blank.");
        }
        // A cláusula COBOL 'PIC X(10)' define um tamanho máximo. Em uma aplicação
        // moderna, essa validação poderia ser feita aqui. Para manter a simplicidade
        // e robustez, apenas normalizamos o valor com trim().
        value = value.trim();
    }
}