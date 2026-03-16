# Cobol Tes

Projeto Java 21 convertido automaticamente de código COBOL legado.

## Descrição

Este projeto contém código Java 21 convertido automaticamente de programas COBOL legados.

## Funcionalidades

- Funcionalidades do programa COBOL original convertidas

## Origem COBOL

| Item | Valor |
|------|-------|
| **Arquivos COBOL convertidos** | Multiply.cbl, NestedIFExample.cbl, IncrementExample.cbl, Message.cbl, PerformTimes.cbl, HelloWorld.cbl, UserInput.cbl, IF-Example.cbl, PerformExample.cbl, SeqFileExample.cbl |
| **Data da conversão** | 2026-03-16 08:26:20 |
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
mvn exec:java -Dexec.mainClass="com.converted.cobol.Multip"

# Ou via Java diretamente
java -cp target/classes com.converted.cobol.Multip
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
