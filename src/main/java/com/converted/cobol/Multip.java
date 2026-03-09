package com.converted.cobol;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Serviço de aplicação principal para o programa COBOL Multip.
 * Orquestra a interação com o usuário e o cálculo de multiplicação.
 * Esta é a ÚNICA classe public do arquivo. Nome do arquivo: Multip.java
 */
public class Multip {

    // Colaboradores declarados como package-private abaixo neste mesmo arquivo
    private final UserInteractionService userInteractionService;
    private final CalculationService calculationService;

    /**
     * Construtor do serviço de aplicação. Inicializa os serviços colaboradores.
     */
    public Multip() {
        // O Scanner é um recurso que precisa ser fechado, então é gerenciado aqui.
        Scanner scanner = new Scanner(System.in);
        this.userInteractionService = new UserInteractionService(scanner);
        this.calculationService = new CalculationService();
    }

    /**
     * Orquestra o fluxo de alto nível, espelhando a lógica do PERFORM UNTIL do COBOL.
     * Este método não contém regras de negócio, apenas coordena as chamadas.
     */
    public void run() {
        boolean continueOperation;
        do {
            // Corresponde ao parágrafo 100-INICIO
            Operands operands = userInteractionService.getOperands();

            // Corresponde ao parágrafo 200-PROCESSAMENTO
            BigDecimal result = calculationService.multiply(operands);
            userInteractionService.displayResult(result);

            // Corresponde ao parágrafo 300-FINAL
            continueOperation = userInteractionService.askToContinue();

        } while (continueOperation);

        userInteractionService.close();
        System.out.println("Programa finalizado.");
    }

    /**
     * Ponto de entrada da aplicação Java.
     * Apenas instancia e executa o serviço de aplicação.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new Multip().run();
    }
}

// ── Value Object ── SEM "public" (package-private) ────────────────────────
/**
 * Representa os dois números de entrada para a operação de multiplicação.
 * É um Value Object, pois seu valor é definido por seus atributos.
 * Corresponde a WS-NUM1 e WS-NUM2 da WORKING-STORAGE.
 */
class Operands {
    private final BigDecimal number1;
    private final BigDecimal number2;

    Operands(BigDecimal number1, BigDecimal number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    BigDecimal getNumber1() {
        return number1;
    }

    BigDecimal getNumber2() {
        return number2;
    }
}

// ── Serviço de Domínio ── SEM "public" (package-private) ──────────────────
/**
 * Encapsula a regra de negócio principal: a multiplicação.
 * Corresponde à lógica do parágrafo 200-PROCESSAMENTO.
 */
class CalculationService {

    /**
     * Realiza a multiplicação dos dois operandos.
     * Mapeia a instrução COBOL: COMPUTE WS-RESULTADO = WS-NUM1 * WS-NUM2.
     * @param operands O objeto contendo os dois números a serem multiplicados.
     * @return O resultado da multiplicação como um BigDecimal.
     */
    BigDecimal multiply(Operands operands) {
        return operands.getNumber1().multiply(operands.getNumber2());
    }
}

// ── Serviço de Infraestrutura/Auxiliar ── SEM "public" (package-private) ──
/**
 * Responsável por toda a interação com o console (entrada e saída de dados).
 * Isola os detalhes de I/O (DISPLAY, ACCEPT) do resto da aplicação.
 */
class UserInteractionService {
    private final Scanner scanner;

    UserInteractionService(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Solicita e lê os dois números do usuário.
     * Corresponde às instruções DISPLAY/ACCEPT do parágrafo 100-INICIO.
     * @return Um objeto Operands contendo os números lidos.
     */
    Operands getOperands() {
        BigDecimal num1 = readNumber("DIGITE O PRIMEIRO NUMERO : ");
        BigDecimal num2 = readNumber("DIGITE O SEGUNDO NUMERO  : ");
        return new Operands(num1, num2);
    }

    /**
     * Exibe o resultado da multiplicação no console.
     * Corresponde à instrução DISPLAY do parágrafo 200-PROCESSAMENTO.
     * @param result O resultado a ser exibido.
     */
    void displayResult(BigDecimal result) {
        // O COBOL PIC 9(10) preencheria com zeros à esquerda.
        // Para simplicidade, exibimos o número diretamente.
        System.out.println("RESULTADO DA MULTIPLICACAO : " + result.toPlainString());
    }

    /**
     * Pergunta ao usuário se deseja realizar uma nova operação.
     * Corresponde às instruções DISPLAY/ACCEPT do parágrafo 300-FINAL.
     * @return true se o usuário desejar continuar, false caso contrário.
     */
    boolean askToContinue() {
        System.out.print("NOVA OPERACAO (S/N) ? ");
        String input = scanner.nextLine().trim();
        // A lógica COBOL era `PERFORM UNTIL WS-OPERACAO = 'N'`.
        // Qualquer coisa diferente de 'N' (ou 'n') continuará.
        return !"N".equalsIgnoreCase(input);
    }

    /**
     * Fecha o recurso Scanner para evitar vazamentos de recursos.
     */
    void close() {
        scanner.close();
    }

    /**
     * Método auxiliar privado para ler um número do console com validação.
     * @param prompt A mensagem a ser exibida para o usuário.
     * @return O número lido como BigDecimal.
     */
    private BigDecimal readNumber(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = scanner.nextLine();
                // Valida se a entrada contém apenas dígitos, como em PIC 9(5).
                if (line != null && line.matches("\\d{1,5}")) {
                    return new BigDecimal(line);
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número com até 5 dígitos.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro de formato. Por favor, digite um número válido.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }
}