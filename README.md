# ✈️ Padrão Prototype – Tema Aeroporto

Demonstração do padrão de projeto **Prototype** aplicado ao gerenciamento de voos em um aeroporto.

---

## 🎯 Objetivo

O padrão **Prototype** permite criar novos objetos copiando (clonando) um objeto existente, sem depender de sua classe concreta.  
Neste projeto, um `Voo` pode ser clonado para gerar rapidamente um novo voo com configurações similares, alterando apenas os campos necessários (ex.: código, destino ou portão), evitando a construção do objeto do zero.

---

## 🗂️ Estrutura do Projeto

```
prototype/
├── docs/
│   └── diagrama-classes.puml       # Diagrama de classes (PlantUML)
├── src/
│   ├── main/java/padroes/prototype/aeroporto/
│   │   ├── Voo.java                # Prototype concreto
│   │   ├── Terminal.java           # Objeto composto (deep copy)
│   │   └── Main.java               # Demonstração de uso
│   └── test/java/padroes/prototype/aeroporto/
│       └── VooTest.java            # Casos de teste (JUnit 5)
└── pom.xml
```

---

## 🧩 Classes

| Classe | Papel no padrão | Correspondência no exemplo base |
|---|---|---|
| `Voo` | **Prototype** concreto — implementa `Cloneable` e sobrescreve `clone()` com deep copy | `Aluno` |
| `Terminal` | Objeto composto dentro do Prototype — também implementa `Cloneable` | `Endereco` |

### `Voo`
Representa um voo com os atributos:
- `codigo` – código do voo (ex.: `"LA3456"`)
- `destino` – cidade/aeroporto de destino
- `terminal` – terminal e portão de embarque (`Terminal`)
- `companhia` – companhia aérea responsável

O método `clone()` realiza **deep copy**: além de copiar `Voo`, cria uma nova instância de `Terminal`, garantindo que alterações no clone não afetem o original.

### `Terminal`
Representa o terminal e portão de embarque:
- `nome` – nome do terminal (ex.: `"Terminal 2"`)
- `portao` – número do portão de embarque

---

## ▶️ Como executar

**Pré-requisito:** Java 17+ e Maven instalados.

```bash
# Compilar e rodar os testes
mvn test

# Executar a classe Main
mvn compile exec:java -Dexec.mainClass="padroes.prototype.aeroporto.Main"
```

---

## 🧪 Casos de Teste (`VooTest`)

| Teste | O que verifica |
|---|---|
| `clonarVooCriaNovoObjeto` | Clone é instância diferente do original |
| `clonarVooCopiaDadosPrimitivos` | Campos `codigo`, `destino` e `companhia` são copiados |
| `clonarVooFazDeepCopyDoTerminal` | `Terminal` do clone é instância separada |
| `alterarTerminalDoCloneNaoAfetaOriginal` | Deep copy isola mudanças no portão |
| `alterarCodigoDoCloneNaoAfetaOriginal` | Deep copy isola mudanças no código |
| `clonarTerminalCriaNovoObjeto` | Clone de `Terminal` é instância diferente |
| `clonarTerminalCopiaDados` | Dados de `Terminal` são copiados corretamente |
| `setterDe*` | Getters e setters funcionam corretamente |
| `toStringDeVoo*` / `toStringDeTerminal*` | `toString()` contém os campos esperados |

---

## 🗺️ Diagrama de Classes

> Arquivo fonte: [`docs/diagrama-classes.puml`](docs/diagrama-classes.puml)

```
┌─────────────────────────────────────────┐     ┌──────────────────────────────────┐
│                  Voo                    │     │            Terminal               │
├─────────────────────────────────────────┤     ├──────────────────────────────────┤
│ - codigo    : String                    │     │ - nome   : String                │
│ - destino   : String                    │1   1│ - portao : Integer               │
│ - terminal  : Terminal  ────────────────┼────>│                                  │
│ - companhia : String                    │     ├──────────────────────────────────┤
├─────────────────────────────────────────┤     │ + Terminal(nome, portao)         │
│ + Voo(codigo, destino, terminal,        │     │ + getNome()  : String            │
│        companhia)                       │     │ + setNome(String) : void         │
│ + getCodigo()    : String               │     │ + getPortao() : Integer          │
│ + setCodigo()    : void                 │     │ + setPortao(Integer) : void      │
│ + getDestino()   : String               │     │ + clone()    : Object            │
│ + setDestino()   : void                 │     │ + toString() : String            │
│ + getTerminal()  : Terminal             │     └──────────────────────────────────┘
│ + setTerminal()  : void                 │              implements
│ + getCompanhia() : String               │           «Cloneable»
│ + setCompanhia() : void                 │
│ + clone()        : Voo                  │
│ + toString()     : String               │
└─────────────────────────────────────────┘
              implements
           «Cloneable»
```
