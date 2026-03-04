package com.converted.cobol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Serviço de aplicação principal que orquestra a lógica do programa COBOL SeqFileExample.
 * <p>
 * Este serviço gerencia o fluxo de alto nível:
 * 1. Coleta de dados do usuário via console.
 * 2. Persistência dos dados em um arquivo de formato fixo.
 * 3. Leitura dos dados do arquivo.
 * 4. Exibição dos dados lidos no console.
 * <p>
 * Corresponde à PROCEDURE DIVISION do programa COBOL.
 */
public class SeqfileexampleApplicationService {

    private final UserRepository userRepository;
    private final UserConsoleHandler userConsoleHandler;

    /**
     * Construtor que inicializa os serviços e repositórios necessários.
     */
    public SeqfileexampleApplicationService() {
        // Injeção de dependência manual para simplicidade.
        this.userRepository = new UserRepository();
        this.userConsoleHandler = new UserConsoleHandler();
    }

    /**
     * Ponto de entrada da aplicação. Instancia e executa o serviço de aplicação.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        new SeqfileexampleApplicationService().run();
    }

    /**
     * Executa o fluxo principal da aplicação, orquestrando as operações.
     * Este método é o equivalente moderno da PROCEDURE DIVISION principal.
     */
    public void run() {
        try {
            // Fase 1: Coletar dados do usuário e escrever no arquivo.
            // Corresponde a: OPEN OUTPUT, PERFORM GetUserRecord UNTIL UserRecord = SPACES, CLOSE.
            collectAndStoreUserData();

            // Fase 2: Ler os dados do arquivo e exibi-los.
            // Corresponde a: OPEN INPUT, PERFORM UNTIL EndOfUserDb, CLOSE.
            readAndDisplayUserData();

        } catch (IOException e) {
            System.err.println("Ocorreu um erro de I/O: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Orquestra a coleta de dados do usuário e sua gravação no arquivo.
     *
     * @throws IOException se ocorrer um erro de escrita no arquivo.
     */
    private void collectAndStoreUserData() throws IOException {
        List<User> users = userConsoleHandler.collectUsersFromInput();
        if (!users.isEmpty()) {
            userRepository.writeAll(users);
            System.out.println(users.size() + " registro(s) de usuário gravado(s) com sucesso.");
        } else {
            System.out.println("Nenhum dado de usuário foi inserido.");
        }
    }

    /**
     * Orquestra a leitura dos dados do arquivo e sua exibição no console.
     *
     * @throws IOException se ocorrer um erro de leitura do arquivo.
     */
    private void readAndDisplayUserData() throws IOException {
        System.out.println("\nLendo e exibindo dados do arquivo...");
        List<User> users = userRepository.readAll();
        if (users.isEmpty()) {
            System.out.println("O arquivo de dados está vazio ou não foi encontrado.");
        } else {
            userConsoleHandler.displayUsers(users);
        }
    }
}

// -----------------------------------------------------------------------------
// DOMAIN MODEL: Entidades e Value Objects
// Representam os conceitos de negócio (dados da WORKING-STORAGE e FILE SECTION)
// -----------------------------------------------------------------------------

/**
 * Entidade que representa um usuário.
 * <p>
 * Corresponde à estrutura `01 UserRecord` na FILE SECTION do COBOL.
 * A identidade é definida pelo `userId`.
 */
final class User {
    private final String userId; // PIC 9(5)
    private final Names names; // UserNames group
    private final HashedPassword password; // Password group
    private final String countryCode; // PIC XX

    public User(String userId, Names names, HashedPassword password, String countryCode) {
        // Validações poderiam ser adicionadas aqui para garantir a integridade dos dados.
        this.userId = Objects.requireNonNull(userId);
        this.names = Objects.requireNonNull(names);
        this.password = Objects.requireNonNull(password);
        this.countryCode = Objects.requireNonNull(countryCode);
    }

    public String getUserId() {
        return userId;
    }

    public Names getNames() {
        return names;
    }

    public HashedPassword getPassword() {
        return password;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
               "userId='" + userId + '\'' +
               ", names=" + names +
               ", password=[PROTECTED]" +
               ", countryCode='" + countryCode + '\'' +
               '}';
    }
}

/**
 * Value Object que representa os nomes de um usuário.
 * <p>
 * Corresponde ao grupo `02 UserNames` no COBOL. Sendo um record, é imutável
 * e sua igualdade é baseada em seu conteúdo.
 *
 * @param userName Corresponde a `03 UserName PIC X(5)`.
 * @param realName Corresponde a `03 RealName PIC X(10)`.
 */
record Names(String userName, String realName) {
}

/**
 * Value Object que representa a senha hasheada de um usuário.
 * <p>
 * Corresponde ao grupo `02 Password` no COBOL. Sendo um record, é imutável.
 *
 * @param salt Corresponde a `03 Salt PIC XX`.
 * @param hash Corresponde a `03 Hash PIC X(5)`.
 */
record HashedPassword(String salt, String hash) {
}


// -----------------------------------------------------------------------------
// INFRASTRUCTURE: Repositórios e Handlers de I/O
// Classes responsáveis por interagir com o mundo externo (sistema de arquivos, console).
// -----------------------------------------------------------------------------

/**
 * Repositório responsável pela persistência da entidade {@link User} em um arquivo.
 * <p>
 * Encapsula toda a lógica de I/O de arquivo, correspondendo às operações
 * `OPEN`, `CLOSE`, `READ`, `WRITE` do COBOL.
 */
class UserRepository {
    private static final Path FILE_PATH = Paths.get("USERS.DATA");
    private final UserRecordMapper mapper = new UserRecordMapper();

    /**
     * Lê todos os registros do arquivo e os converte em uma lista de objetos User.
     * <p>
     * Corresponde ao loop `READ UserDatabase AT END ... PERFORM UNTIL EndOfUserDb`.
     *
     * @return Uma lista de usuários.
     * @throws IOException se ocorrer um erro de leitura.
     */
    public List<User> readAll() throws IOException {
        if (!Files.exists(FILE_PATH)) {
            return Collections.emptyList();
        }
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(FILE_PATH)) {
            String line;
            while ((line = reader.readLine()) != null) {
                // A condição `EndOfUserDb` do COBOL é representada pelo fim do stream (retorno null).
                users.add(mapper.fromRecordString(line));
            }
        }
        return users;
    }

    /**
     * Escreve uma lista de objetos User no arquivo, sobrescrevendo o conteúdo existente.
     * <p>
     * Corresponde ao loop `WRITE UserRecord`.
     *
     * @param users A lista de usuários a ser persistida.
     * @throws IOException se ocorrer um erro de escrita.
     */
    public void writeAll(List<User> users) throws IOException {
        // O `OPEN OUTPUT` do COBOL recria ou trunca o arquivo, comportamento padrão aqui.
        try (BufferedWriter writer = Files.newBufferedWriter(FILE_PATH)) {
            for (User user : users) {
                writer.write(mapper.toRecordString(user));
                writer.newLine();
            }
        }
    }
}

/**
 * Classe auxiliar responsável pela interação com o console (entrada e saída de dados).
 * <p>
 * Isola a lógica de `DISPLAY` e `ACCEPT` do COBOL.
 */
class UserConsoleHandler {

    private final UserRecordMapper mapper = new UserRecordMapper();

    /**
     * Coleta dados de múltiplos usuários a partir da entrada do console.
     * <p>
     * Corresponde ao parágrafo `GetUserRecord` e ao loop `PERFORM UNTIL UserRecord = SPACES`.
     *
     * @return Uma lista de objetos User criados a partir da entrada do usuário.
     */
    public List<User> collectUsersFromInput() {
        List<User> users = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter user details using the template.");
            System.out.println("Enter no data to end.");

            while (true) {
                // Corresponde ao parágrafo `GetUserRecord`.
                System.out.println("IIIIIUUUUURRRRRRRRRRSSPPPPPCC"); // Template
                String line = scanner.nextLine(); // Corresponde ao `ACCEPT UserRecord`.

                // Corresponde à condição `UNTIL UserRecord = SPACES`.
                if (line == null || line.isBlank()) {
                    break;
                }

                try {
                    User user = mapper.fromRecordString(line);
                    users.add(user);
                } catch (IllegalArgumentException e) {
                    System.err.println("Entrada inválida: " + e.getMessage() + ". Por favor, tente novamente.");
                }
            }
        }
        return users;
    }

    /**
     * Exibe uma lista de usuários no console.
     * <p>
     * Corresponde à instrução `DISPLAY UserId SPACE UserName SPACE Password`.
     *
     * @param users A lista de usuários a ser exibida.
     */
    public void displayUsers(List<User> users) {
        System.out.println("\n--- User Data ---");
        for (User user : users) {
            String passwordString = user.getPassword().salt() + user.getPassword().hash();
            System.out.printf("ID: %s, UserName: %s, Password: %s%n",
                user.getUserId(),
                user.getNames().userName(),
                passwordString);
        }
        System.out.println("-----------------");
    }
}

/**
 * Mapper responsável por converter entre o objeto de domínio {@link User} e sua
 * representação em string de formato fixo, como no arquivo.
 * <p>
 * Esta classe é a ponte entre a estrutura de dados orientada a objetos e o
 * layout de registro sequencial do COBOL.
 */
class UserRecordMapper {

    // Constantes que definem o layout do registro, espelhando as cláusulas PIC.
    private static final int USER_ID_LEN = 5;
    private static final int USER_NAME_LEN = 5;
    private static final int REAL_NAME_LEN = 10;
    private static final int SALT_LEN = 2;
    private static final int HASH_LEN = 5;
    private static final int COUNTRY_CODE_LEN = 2;
    private static final int TOTAL_LEN = USER_ID_LEN + USER_NAME_LEN + REAL_NAME_LEN + SALT_LEN + HASH_LEN + COUNTRY_CODE_LEN;

    /**
     * Converte uma linha de string de formato fixo em um objeto {@link User}.
     *
     * @param record A string de 29 caracteres lida do arquivo ou console.
     * @return Um objeto User preenchido.
     * @throws IllegalArgumentException se a string do registro tiver um comprimento inesperado.
     */
    public User fromRecordString(String record) {
        if (record.length() < TOTAL_LEN) {
            throw new IllegalArgumentException("O registro deve ter pelo menos " + TOTAL_LEN + " caracteres. Comprimento recebido: " + record.length());
        }

        int offset = 0;
        String userId = record.substring(offset, offset += USER_ID_LEN);
        String userName = record.substring(offset, offset += USER_NAME_LEN);
        String realName = record.substring(offset, offset += REAL_NAME_LEN);
        String salt = record.substring(offset, offset += SALT_LEN);
        String hash = record.substring(offset, offset += HASH_LEN);
        String countryCode = record.substring(offset, offset + COUNTRY_CODE_LEN);

        return new User(
            userId.trim(),
            new Names(userName.trim(), realName.trim()),
            new HashedPassword(salt, hash),
            countryCode.trim()
        );
    }

    /**
     * Converte um objeto {@link User} em sua representação de string de formato fixo.
     *
     * @param user O objeto User a ser convertido.
     * @return Uma string de 29 caracteres formatada.
     */
    public String toRecordString(User user) {
        return padRight(user.getUserId(), USER_ID_LEN) +
               padRight(user.getNames().userName(), USER_NAME_LEN) +
               padRight(user.getNames().realName(), REAL_NAME_LEN) +
               padRight(user.getPassword().salt(), SALT_LEN) +
               padRight(user.getPassword().hash(), HASH_LEN) +
               padRight(user.getCountryCode(), COUNTRY_CODE_LEN);
    }

    /**
     * Preenche ou trunca uma string para um comprimento específico, alinhando à esquerda.
     *
     * @param s      A string de entrada.
     * @param length O comprimento desejado.
     * @return A string formatada.
     */
    private String padRight(String s, int length) {
        return String.format("%-" + length + "s", s).substring(0, length);
    }
}