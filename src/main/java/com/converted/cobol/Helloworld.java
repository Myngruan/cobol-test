package com.converted.cobol;

import java.util.Scanner;

/**
 * Serviço de aplicação principal para o programa COBOL Helloworld.
 * Esta é a ÚNICA classe public do arquivo. Nome do arquivo: Helloworld.java
 */
public class Helloworld {

    private final UserInteractionService userInteractionService;
    private final GreetingService greetingService;

    /**
     * Construtor que inicializa os serviços colaboradores.
     * Em um design orientado a objetos, as responsabilidades são delegadas
     * a classes especializadas em vez de serem concentradas em parágrafos.
     */
    public Helloworld() {
        this.userInteractionService = new UserInteractionService();
        this.greetingService = new GreetingService();
    }

    /**
     * Orquestra o fluxo de alto nível, espelhando a MAIN-PROCEDURE do COBOL.
     * Este método não contém regras de negócio, apenas coordena as chamadas
     * aos serviços responsáveis por cada etapa.
     */
    public void run() {
        // Corresponde a: PERFORM 100-INITIALIZE-VARS
        Greeting greetingData = greetingService.initializeGreetingData();

        // Corresponde a: PERFORM 200-GET-USER-NAME
        String userName = userInteractionService.askForUserName();

        // Corresponde a: PERFORM 300-BUILD-MESSAGE
        String finalMessage = greetingService.buildFinalMessage(greetingData, userName);

        // Corresponde a: PERFORM 400-DISPLAY-MESSAGE UNTIL WS-COUNTER > 5
        // O contador em COBOL começa em 1 e o loop executa para 1, 2, 3, 4, 5.
        for (int counter = 1; counter <= 5; counter++) {
            userInteractionService.displayMessage(counter, finalMessage);
        }
    }

    /**
     * Ponto de entrada da aplicação Java.
     * A única responsabilidade deste método é instanciar e executar o serviço de aplicação.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Helloworld().run();
    }
}

// ── Value Object ── SEM "public" (package-private) ────────────────────────
/**
 * Representa os dados da mensagem, análogo ao grupo WS-MESSAGE em COBOL.
 * Como um Value Object, é imutável e representa um valor sem identidade própria.
 *
 * COBOL-ORIGIN:
 * 01 WS-MESSAGE.
 *    05 WS-MSG-PART1 PIC X(7).
 *    05 WS-MSG-PART2 PIC X(1).
 */
class Greeting {
    private final String part1;
    private final String part2;

    Greeting(String part1, String part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    String getPart1() {
        return part1;
    }

    String getPart2() {
        return part2;
    }
}

// ── Serviço de Domínio ── SEM "public" (package-private) ──────────────────
/**
 * Encapsula a lógica de negócio relacionada à criação de saudações.
 * Contém a lógica dos parágrafos 100-INITIALIZE-VARS e 300-BUILD-MESSAGE.
 */
class GreetingService {

    /**
     * Inicializa os dados da saudação com valores padrão.
     * Corresponde ao parágrafo 100-INITIALIZE-VARS.
     * @return um objeto Greeting com os valores padrão.
     */
    Greeting initializeGreetingData() {
        // COBOL-ORIGIN:
        // MOVE "Hello, " TO WS-MSG-PART1.
        // MOVE "!" TO WS-MSG-PART2.
        return new Greeting("Hello, ", "!");
    }

    /**
     * Constrói a mensagem final a ser exibida, combinando as partes da saudação
     * com o nome do usuário.
     * Corresponde ao parágrafo 300-BUILD-MESSAGE.
     * @param greetingData Os componentes da saudação.
     * @param userName O nome do usuário a ser inserido na mensagem.
     * @return A string da mensagem completa.
     */
    String buildFinalMessage(Greeting greetingData, String userName) {
        // COBOL-ORIGIN:
        // STRING WS-MSG-PART1 DELIMITED BY SIZE
        //        WS-USER-NAME DELIMITED BY SIZE
        //        WS-MSG-PART2 DELIMITED BY SIZE
        //   INTO WS-MESSAGE.
        // A concatenação de strings em Java é a operação equivalente.
        return greetingData.getPart1() + userName + greetingData.getPart2();
    }
}

// ── Serviço de I/O ── SEM "public" (package-private) ──────────────────────
/**
 * Isola as operações de entrada e saída do console (DISPLAY/ACCEPT).
 * Contém a lógica dos parágrafos 200-GET-USER-NAME e 400-DISPLAY-MESSAGE.
 * Esta classe lida com os detalhes de infraestrutura, mantendo o resto do
 * código focado na lógica de negócio.
 */
class UserInteractionService {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Pede e captura o nome do usuário no console.
     * Corresponde ao parágrafo 200-GET-USER-NAME.
     * @return O nome digitado pelo usuário.
     */
    String askForUserName() {
        // COBOL-ORIGIN:
        // DISPLAY "Please enter your name: ".
        // ACCEPT WS-USER-NAME.
        System.out.print("Please enter your name: ");
        return scanner.nextLine();
    }

    /**
     * Exibe a mensagem formatada no console, prefixada com um contador.
     * Corresponde à lógica de exibição no parágrafo 400-DISPLAY-MESSAGE.
     * @param counter O número da iteração atual (WS-COUNTER).
     * @param message A mensagem a ser exibida (WS-MESSAGE).
     */
    void displayMessage(int counter, String message) {
        // COBOL-ORIGIN:
        // DISPLAY WS-COUNTER " - " WS-MESSAGE.
        System.out.println(counter + " - " + message);
    }
}