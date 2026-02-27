# Cobol Tes

Projeto Java 21 convertido automaticamente de código COBOL legado.

## Descrição

Serviço de aplicação principal que orquestra a execução do programa COBOL legado

## Funcionalidades

- Processamento de tabelas/arrays de dados
- Processamento em lote de registros

## Origem COBOL

| Item | Valor |
|------|-------|
| **Arquivos COBOL convertidos** | PerformTimes.cbl, Message.cbl, HelloWorld.cbl, IF-Example.cbl, UserInput.cbl, NestedIFExample.cbl, IncrementExample.cbl, Multiply.cbl, SeqFileExample.cbl, PerformExample.cbl |
| **Data da conversão** | 2026-02-27 16:54:47 |
| **Ferramenta** | Agente de Conversão COBOL → Java 21 |
| **Método de conversão** | LLM (Gemini/GPT - código completo) |

## Como Executar

### Pré-requisitos

- Java 21 ou superior
- Maven 3.8 ou superior

### Compilação

```bash
mvn clean compile
```

### Execução

```bash
# Via Maven
mvn exec:java -Dexec.mainClass="com.converted.cobol.Performthroughexample"

# Ou via Java diretamente
java -cp target/classes com.converted.cobol.Performthroughexample
```



## Estrutura do Projeto

```
cobol-tes/
├── pom.xml                    # Configuração Maven
├── README.md                  # Este arquivo
├── conversion-report.json     # Relatório de conversão
└── src/
    └── main/
        └── java/
            └── com/converted/cobol/
                └── *.java     # Classes Java geradas
```



## Notas de Conversão

- Conversão automática via Agente de Conversão COBOL → Java 21
- Código gerado via LLM (Gemini/GPT) para máxima qualidade
- Estrutura do programa COBOL preservada fielmente
- Features Java 21 aplicadas (records, pattern matching, etc.)
- BigDecimal usado para valores monetários (precisão garantida)
- Nomenclatura convertida de COBOL-STYLE para camelCase

## TODOs e Revisão Manual

Nenhum TODO encontrado. O código foi convertido completamente pela LLM.

---

*Gerado automaticamente pelo Agente de Conversão COBOL → Java 21*
