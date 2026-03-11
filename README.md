# Cobol Tes

Projeto Java 21 convertido automaticamente de código COBOL legado.

## Descrição

Este projeto contém código Java 21 convertido automaticamente de programas COBOL legados.

## Funcionalidades

- Funcionalidades do programa COBOL original convertidas

## Origem COBOL

| Item | Valor |
|------|-------|
| **Arquivos COBOL convertidos** | NestedIFExample.cbl, IF-Example.cbl, PerformTimes.cbl, HelloWorld.cbl, SeqFileExample.cbl, Message.cbl, Multiply.cbl, UserInput.cbl, IncrementExample.cbl, PerformExample.cbl |
| **Data da conversão** | 2026-03-11 11:08:03 |
| **Ferramenta** | Agente de Conversão COBOL → Java 21 |
| **Método de conversão** | Regras básicas (requer revisão) |

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
mvn exec:java -Dexec.mainClass="com.converted.cobol.NestedIfs"

# Ou via Java diretamente
java -cp target/classes com.converted.cobol.NestedIfs
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
- Código gerado via regras básicas de conversão
- **Recomenda-se revisão manual do código**
- Features Java 21 aplicadas (records, pattern matching, etc.)
- BigDecimal usado para valores monetários (precisão garantida)
- Nomenclatura convertida de COBOL-STYLE para camelCase

## TODOs e Revisão Manual

Nenhum TODO encontrado. O código foi convertido completamente pela LLM.

---

*Gerado automaticamente pelo Agente de Conversão COBOL → Java 21*
