package com.converted.cobol;

import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra o fluxo do programa COBOL UserInput.
 * Este serviço coordena a interação com o usuário e a manipulação dos dados,
 * seguindo os princípios de design orientado a objetos e DDD light.
 * Corresponde ao programa COBOL como um todo.
 */
public class UserinputApplicationService {

    private final UserInteractionService userInteractionService;

    /**
     * Construtor que inicializa os serviços necessários para a aplicação.
     * Em um framework moderno, isso seria gerenciado por injeção de dependência.
     */
    public UserinputApplicationService() {
        this.userInteractionService = new UserInteractionService();
    }

    /**
     * Ponto de entrada para a lógica de negócio, executando o fluxo principal.
     * Este método orquestra as etapas que eram sequenciais na PROCEDURE DIVISION do COBOL.
     */
    public void run() {
        // Etapa 1: Solicitar e ler o nome do usuário.
        // Corresponde a: DISPLAY "What is your name?". ACCEPT UserName.
        String rawName = userInteractionService.promptAndReadUserName();

        // Etapa 2: Criar um objeto de valor para representar o nome do usuário,
        // aplicando as regras de formatação do COBOL (PIC X(10)).
        UserName userName = UserName.fromInput(rawName);

        // Etapa 3: Exibir a saudação final.
        // Corresponde a: DISPLAY "It's nice to meet you" SPACE Name.
        userInteractionService.displayGreeting(userName);
    }

    /**
     * Método main, o ponto de entrada do programa Java.
     * Sua única responsabilidade é instanciar e executar o serviço de aplicação,
     * mantendo a lógica de negócio fora do método estático.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new UserinputApplicationService().run();
    }
}

/**
 * Serviço de domínio responsável por toda a interação com o console (entrada e saída).
 * Isola os detalhes de I/O do fluxo principal da aplicação, promovendo a separação de responsabilidades.
 */
class UserInteractionService {

    private final Scanner scanner;

    public UserInteractionService() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Exibe um prompt no console e lê a linha de entrada do usuário.
     *
     * @return A string bruta digitada pelo usuário.
     */
    public String promptAndReadUserName() {
        System.out.println("What is your name?");
        return scanner.nextLine();
    }

    /**
     * Exibe a mensagem de saudação formatada no console.
     *
     * @param userName O objeto de valor UserName contendo o nome a ser exibido.
     */
    public void displayGreeting(UserName userName) {
        // A palavra-chave 'SPACE' do COBOL é traduzida para uma concatenação com um espaço.
        // Usamos userName.getDisplayName() para obter uma representação amigável (sem espaços à direita).
        System.out.println("It's nice to meet you " + userName.getDisplayName());
    }
}

/**
 * Representa o nome de um usuário como um Value Object (Objeto de Valor).
 * Corresponde à estrutura de dados '01 UserName' com '02 Name PIC X(10)' do COBOL.
 * Encapsula a regra de negócio de que o nome deve ter exatamente 10 caracteres
 * (seja por truncamento ou preenchimento com espaços).
 */
final class UserName {

    /**
     * Constante que define o tamanho fixo do campo, conforme 'PIC X(10)'.
     */
    private static final int FIXED_LENGTH = 10;

    private final String value;

    /**
     * Construtor privado para garantir que a criação passe pelo método de fábrica.
     *
     * @param value O valor formatado com 10 caracteres.
     */
    private UserName(String value) {
        this.value = value;
    }

    /**
     * Método de fábrica estático para criar uma instância de UserName a partir da entrada bruta do usuário.
     * Replica o comportamento do comando 'ACCEPT' do COBOL em um campo 'PIC X(10)':
     * - Trunca a entrada se for maior que 10 caracteres.
     * - Adiciona espaços à direita se for menor que 10 caracteres.
     *
     * @param rawInput A string de entrada não formatada.
     * @return Uma nova instância de UserName com o valor formatado.
     */
    public static UserName fromInput(String rawInput) {
        if (rawInput == null) {
            rawInput = "";
        }

        if (rawInput.length() > FIXED_LENGTH) {
            // Trunca a string se for muito longa
            return new UserName(rawInput.substring(0, FIXED_LENGTH));
        } else {
            // Preenche com espaços à direita para atingir o comprimento fixo
            String paddedValue = String.format("%-" + FIXED_LENGTH + "s", rawInput);
            return new UserName(paddedValue);
        }
    }

    /**
     * Retorna o valor bruto de 10 caracteres, incluindo espaços de preenchimento.
     * Útil para cenários que exigem o formato de dados exato do COBOL (ex: gravação em arquivo).
     *
     * @return O nome com exatamente 10 caracteres.
     */
    public String getRawValue() {
        return value;
    }

    /**
     * Retorna uma representação do nome para exibição, sem espaços em branco à direita.
     * Esta é uma melhoria de design em relação ao COBOL, que exibiria os espaços extras.
     *
     * @return O nome sem espaços de preenchimento à direita.
     */
    public String getDisplayName() {
        return value.stripTrailing();
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}