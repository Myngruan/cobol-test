package com.converted.cobol;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Serviço de aplicação principal para o programa COBOL USERINPT.
 * Esta é a ÚNICA classe public do arquivo. Nome do arquivo: Userinput.java
 * O programa original, USERINPT, interage com o usuário para coletar nome e idade
 * e os exibe de volta, repetindo o processo até que o usuário decida parar.
 */
public class Userinput {

    // Colaborador para lidar com a interação do usuário (console I/O)
    private final UserInteractionService userInteractionService;

    /**
     * Construtor do serviço de aplicação. Inicializa seus colaboradores.
     */
    public Userinput() {
        // A injeção de dependência é simulada aqui para clareza.
        // O serviço de interação precisa de uma fonte de entrada (System.in).
        this.userInteractionService = new UserInteractionService(new Scanner(System.in));
    }

    /**
     * Orquestra o fluxo de alto nível, correspondendo à PROCEDURE DIVISION.
     * Este método contém o loop principal do programa.
     */
    public void run() {
        // Corresponde a: PERFORM 200-PROCESS-USER-INPUT UNTIL WS-CONTINUE-FLAG = 'N'.
        try {
            boolean continueProcessing;
            do {
                processSingleUserInput();
                continueProcessing = userInteractionService.askToContinue();
            } while (continueProcessing);
        } finally {
            // Garante que os recursos (Scanner) sejam fechados ao final da execução.
            userInteractionService.close();
        }
        // Corresponde a: STOP RUN.
        System.out.println("Programa finalizado.");
    }

    /**
     * Executa um único ciclo de coleta e exibição de dados do usuário.
     * Corresponde à lógica dentro do parágrafo 200-PROCESS-USER-INPUT.
     */
    private void processSingleUserInput() {
        try {
            UserInputData data = userInteractionService.gatherData();
            userInteractionService.displayResult(data);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado durante a entrada de dados: " + e.getMessage());
            // Em uma aplicação real, um tratamento de erro mais robusto seria necessário.
        }
    }

    /**
     * Ponto de entrada da aplicação Java.
     * Apenas instancia o serviço de aplicação e inicia a execução.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Userinput().run();
    }
}

// ── Value Object ── SEM "public" (package-private) ──────────────────────────
/**
 * Representa os dados coletados do usuário em uma única interação.
 * Corresponde à estrutura de dados 'WS-USER-INPUT' na WORKING-STORAGE SECTION.
 * É um Value Object porque representa um valor (os dados de uma sessão) sem identidade própria.
 */
class UserInputData {
    private final String name; // Corresponde a WS-NAME PIC X(30)
    private final int age;     // Corresponde a WS-AGE PIC 9(03)

    UserInputData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}

// ── Serviço de Domínio ── SEM "public" (package-private) ───────────────────
/**
 * Encapsula a lógica de negócio de interagir com o usuário no console.
 * Isola as operações de I/O (ACCEPT/DISPLAY do COBOL) do fluxo principal da aplicação.
 */
class UserInteractionService {
    private final Scanner scanner;

    UserInteractionService(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Coleta o nome e a idade do usuário.
     * Corresponde aos verbos DISPLAY de prompt e ACCEPT de entrada em 200-PROCESS-USER-INPUT.
     * @return um objeto UserInputData com as informações coletadas.
     */
    UserInputData gatherData() {
        // Corresponde a: DISPLAY "Digite seu nome..." e ACCEPT WS-NAME.
        System.out.print("Digite seu nome (ate 30 caracteres): ");
        String name = scanner.nextLine();
        if (name.length() > 30) {
            name = name.substring(0, 30); // Emula o comportamento de PIC X(30)
        }

        // Corresponde a: DISPLAY "Digite sua idade..." e ACCEPT WS-AGE.
        int age = -1;
        while (age < 0) {
            try {
                System.out.print("Digite sua idade: ");
                age = scanner.nextInt();
                if (age < 0 || age > 999) { // Validação para PIC 9(03)
                    System.out.println("Idade inválida. Por favor, digite um número entre 0 e 999.");
                    age = -1; // Força a repetição do loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro para a idade.");
                scanner.next(); // Limpa o buffer de entrada inválida
                age = -1; // Força a repetição do loop
            }
        }
        scanner.nextLine(); // Consome o caractere de nova linha restante após nextInt()

        return new UserInputData(name, age);
    }

    /**
     * Exibe os dados do usuário de forma formatada.
     * Corresponde aos verbos MOVE e DISPLAY para WS-OUTPUT-LINE e WS-OUTPUT-LINE-2.
     * @param data Os dados do usuário a serem exibidos.
     */
    void displayResult(UserInputData data) {
        // Corresponde a: MOVE WS-NAME TO WS-OUT-NAME e DISPLAY WS-OUTPUT-LINE.
        // O FILLER "Nome: " é incorporado diretamente na string de saída.
        System.out.println("Nome:      " + data.getName());

        // Corresponde a: MOVE WS-AGE TO WS-OUT-AGE e DISPLAY WS-OUTPUT-LINE-2.
        // O FILLER "Idade: " é incorporado. PIC Z(03) suprime zeros à esquerda,
        // que é o comportamento padrão da conversão de int para String em Java.
        System.out.println("Idade:     " + data.getAge());
    }

    /**
     * Pergunta ao usuário se deseja continuar a execução.
     * Corresponde ao prompt final e ACCEPT para WS-CONTINUE-FLAG.
     * @return true se o usuário desejar continuar, false caso contrário.
     */
    boolean askToContinue() {
        // Corresponde a: DISPLAY "Deseja continuar? (S/N): "
        System.out.print("Deseja continuar? (S/N): ");
        // Corresponde a: ACCEPT WS-CONTINUE-FLAG
        String response = scanner.nextLine().trim().toUpperCase();
        // A lógica do loop COBOL é "UNTIL WS-CONTINUE-FLAG = 'N'".
        // Portanto, continuamos para qualquer resposta que não seja "N".
        return !response.equals("N");
    }

    /**
     * Libera os recursos utilizados pelo serviço, como o Scanner.
     */
    void close() {
        if (this.scanner != null) {
            this.scanner.close();
        }
    }
}