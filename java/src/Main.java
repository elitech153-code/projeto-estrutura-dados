import estruturas.Pilha;
import modelos.Comando;
import modelos.EstadoMissao;
import modelos.Modulo;
import modelos.TipoModulo;
import util.Entrada;
import util.OperacoesModulos;

/**
 * Missão Estelar - Gerenciador de Missões Espaciais (Entrega N1)
 *
 * Integra: ARRAY (módulos), ENUM (estado e tipo) e PILHA (desfazer comandos).
 * O programa começa pelo método main, mostra um menu e repete até o usuário sair.
 */
public class Main {

    private static final int CAPACIDADE_HISTORICO = 20;

    // Estado do programa (compartilhado entre os métodos)
    private static Modulo[] modulos = criarModulosIniciais();
    private static EstadoMissao estadoAtual = EstadoMissao.PLANEJADA;
    private static final Pilha historico = new Pilha(CAPACIDADE_HISTORICO);

    public static void main(String[] args) {
        System.out.println("=== MISSÃO ESTELAR - Gerenciador de Missões Espaciais ===");

        int opcao;
        do {
            exibirMenu();
            opcao = Entrada.lerInteiro("Escolha: ", 0, 7);
            System.out.println();
            executarOpcao(opcao);
        } while (opcao != 0);
    }

    // ---------- Menu ----------

    private static void exibirMenu() {
        System.out.println("\nEstado atual da missão: " + estadoAtual.getDescricao());
        System.out.println("1) Listar módulos");
        System.out.println("2) Buscar módulo por nome");
        System.out.println("3) Ordenar módulos");
        System.out.println("4) Mudar estado da missão");
        System.out.println("5) Desfazer último comando");
        System.out.println("6) Ver último comando");
        System.out.println("7) Ver tamanho do histórico");
        System.out.println("0) Sair");
    }

    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> OperacoesModulos.listar(modulos);
            case 2 -> buscarModulo();
            case 3 -> ordenarModulos();
            case 4 -> mudarEstado();
            case 5 -> desfazerComando();
            case 6 -> verUltimoComando();
            case 7 -> System.out.println("Comandos no histórico: " + historico.tamanho()
                    + " de " + CAPACIDADE_HISTORICO);
            case 0 -> System.out.println("Encerrando a missão. Até a próxima!");
        }
    }

    // ---------- Array ----------

    private static void buscarModulo() {
        String termo = Entrada.lerTexto("Nome (ou parte do nome) do módulo: ");
        Modulo[] encontrados = OperacoesModulos.buscarPorNome(modulos, termo);
        if (encontrados.length == 0) {
            System.out.println("Nenhum módulo encontrado para \"" + termo + "\".");
        } else {
            OperacoesModulos.listar(encontrados);
        }
    }

    private static void ordenarModulos() {
        System.out.println("1) Por peso (menor primeiro)");
        System.out.println("2) Por prioridade (mais urgente primeiro)");
        int criterio = Entrada.lerInteiro("Critério: ", 1, 2);
        if (criterio == 1) {
            OperacoesModulos.ordenarPorPeso(modulos);
        } else {
            OperacoesModulos.ordenarPorPrioridade(modulos);
        }
        System.out.println("Módulos ordenados:");
        OperacoesModulos.listar(modulos);
    }

    // ---------- Enum + Pilha ----------

    private static void mudarEstado() {
        EstadoMissao[] opcoes = EstadoMissao.values(); // todos os valores do enum
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i + 1) + ") " + opcoes[i].getDescricao());
        }
        int escolha = Entrada.lerInteiro("Novo estado: ", 1, opcoes.length);
        EstadoMissao novoEstado = opcoes[escolha - 1];

        if (novoEstado == estadoAtual) {
            System.out.println("A missão já está nesse estado.");
            return;
        }

        Comando comando = new Comando("Mudar estado para " + novoEstado.getDescricao(),
                estadoAtual, novoEstado);

        // Só muda o estado se o comando couber no histórico
        if (historico.empilhar(comando)) {
            estadoAtual = novoEstado;
            System.out.println("Estado alterado para: " + estadoAtual.getDescricao());
        } else {
            System.out.println("Histórico cheio! Desfaça algum comando antes de continuar.");
        }
    }

    private static void desfazerComando() {
        Comando desfeito = historico.desempilhar();
        if (desfeito == null) {
            System.out.println("Nada para desfazer: o histórico está vazio.");
            return;
        }
        estadoAtual = desfeito.getEstadoAnterior(); // volta ao estado de antes
        System.out.println("Desfeito: " + desfeito.getDescricao());
        System.out.println("Estado atual: " + estadoAtual.getDescricao());
    }

    private static void verUltimoComando() {
        Comando topo = historico.consultarTopo();
        if (topo == null) {
            System.out.println("Nenhum comando executado ainda.");
        } else {
            System.out.println("Último comando: " + topo.getDescricao()
                    + " (de " + topo.getEstadoAnterior().getDescricao()
                    + " para " + topo.getEstadoNovo().getDescricao() + ")");
        }
    }

    // ---------- Dados iniciais ----------

    /** Cria o array já preenchido com módulos de exemplo. */
    private static Modulo[] criarModulosIniciais() {
        return new Modulo[] {
            new Modulo("Motor Principal", TipoModulo.PROPULSAO, 1200.0, 1),
            new Modulo("Painel Solar", TipoModulo.ENERGIA, 350.5, 2),
            new Modulo("Antena de Comunicação", TipoModulo.COMUNICACAO, 85.0, 3),
            new Modulo("Módulo Habitacional", TipoModulo.HABITACAO, 2400.0, 1),
            new Modulo("Propulsor de Manobra", TipoModulo.PROPULSAO, 480.0, 2),
            new Modulo("Bateria Reserva", TipoModulo.ENERGIA, 150.0, 4)
        };
    }
}
