# Missão Estelar — Gerenciador de Missões Espaciais

**Aluna:** Nathiele Santos Silva Santos
**Disciplina:** Estrutura de Dados I — Projeto Integrador
**Tema:** Gerenciador de missões espaciais (programa de console)

## Descrição

A **Missão Estelar** é um programa de console em Java que simula o controle de uma missão espacial.
O usuário consulta e organiza os módulos da nave, acompanha o estado da missão e pode desfazer
as mudanças de estado já realizadas.

## Itens da ementa cobertos até o momento (Entrega N1)

| Item | Onde está | Como é aplicado |
|------|-----------|-----------------|
| **Array** | `modelos/Modulo.java`, `util/OperacoesModulos.java`, `Main.java` | Vetor `Modulo[]` com os módulos da nave: criação, percurso (listagem), busca por nome e ordenação (Selection Sort por peso e Bubble Sort por prioridade) |
| **Enum** | `modelos/EstadoMissao.java`, `modelos/TipoModulo.java` | `EstadoMissao` (PLANEJADA, EM_ORBITA, POUSANDO, EM_MANUTENCAO, CONCLUIDA) e `TipoModulo` (PROPULSAO, ENERGIA, COMUNICACAO, HABITACAO) |
| **Pilha** | `estruturas/Pilha.java` | Pilha própria (sobre array, capacidade 20) com `empilhar`, `desempilhar` e `consultarTopo`. Guarda os comandos executados para permitir "desfazer" |

Os três elementos são integrados no menu de console: cada mudança de estado (enum) vira um comando
empilhado (pilha), e o desfazer volta ao estado anterior. O array de módulos pode ser listado, buscado e ordenado.

Os demais itens da ementa (recursividade, listas, filas, ponteiros, alocação dinâmica e uniões) serão
entregues na N2.

## Estrutura do projeto

```
projeto-estrutura-dados/
├── java/
│   ├── src/
│   │   ├── Main.java                     # menu e fluxo do programa
│   │   ├── modelos/                      # Modulo, Comando, EstadoMissao, TipoModulo
│   │   ├── estruturas/Pilha.java         # pilha implementada do zero
│   │   └── util/                         # Entrada (leitura segura) e OperacoesModulos (array)
│   └── README.md
└── README.md
```

## Como compilar e executar (Java)

Requisito: JDK 17 ou superior. A partir da pasta `java/src`:

```bash
javac -encoding UTF-8 -d ../out -sourcepath . Main.java
java -cp ../out Main
```

Execute sempre pelo **terminal** (para poder digitar as opções do menu).
Se aparecerem arquivos `.class` dentro de `src` (gerados por algumas extensões), apague-os antes de compilar.

## Menu do programa

```
1) Listar módulos
2) Buscar módulo por nome
3) Ordenar módulos
4) Mudar estado da missão
5) Desfazer último comando
6) Ver último comando
7) Ver tamanho do histórico
0) Sair
```
