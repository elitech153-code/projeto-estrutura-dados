package util;

import modelos.Modulo;

/**
 * Operações sobre o ARRAY de módulos: percorrer, buscar e ordenar.
 *
 * Tudo aqui é "static": podemos chamar sem criar um objeto,
 * por exemplo OperacoesModulos.listar(modulos).
 */
public class OperacoesModulos {

    /** PERCURSO: passa por todas as posições do array e imprime uma tabela. */
    public static void listar(Modulo[] modulos) {
        if (modulos.length == 0) {
            System.out.println("Nenhum módulo para exibir.");
            return;
        }
        System.out.printf("%-3s %-24s %-14s %10s %11s%n", "Nº", "Nome", "Tipo", "Peso (kg)", "Prioridade");
        System.out.println("-".repeat(66));
        for (int i = 0; i < modulos.length; i++) {
            Modulo m = modulos[i];
            System.out.printf("%-3d %-24s %-14s %10.1f %11d%n",
                    i + 1, m.getNome(), m.getTipo().getDescricao(), m.getPesoKg(), m.getPrioridade());
        }
    }

    /**
     * BUSCA LINEAR: devolve um novo array com todos os módulos cujo nome
     * contém o termo digitado (sem diferenciar maiúsculas de minúsculas).
     */
    public static Modulo[] buscarPorNome(Modulo[] modulos, String termo) {
        String busca = termo.toLowerCase();

        // 1ª passada: conta quantos módulos combinam (para saber o tamanho do array novo)
        int quantidade = 0;
        for (Modulo m : modulos) {
            if (m.getNome().toLowerCase().contains(busca)) {
                quantidade++;
            }
        }

        // 2ª passada: copia os módulos que combinam
        Modulo[] encontrados = new Modulo[quantidade];
        int posicao = 0;
        for (Modulo m : modulos) {
            if (m.getNome().toLowerCase().contains(busca)) {
                encontrados[posicao] = m;
                posicao++;
            }
        }
        return encontrados;
    }

    /**
     * ORDENAÇÃO por peso (crescente) usando SELECTION SORT:
     * a cada rodada, acha o menor elemento do restante e o coloca na posição certa.
     */
    public static void ordenarPorPeso(Modulo[] modulos) {
        for (int i = 0; i < modulos.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < modulos.length; j++) {
                if (modulos[j].getPesoKg() < modulos[menor].getPesoKg()) {
                    menor = j;
                }
            }
            trocar(modulos, i, menor);
        }
    }

    /**
     * ORDENAÇÃO por prioridade (1 primeiro) usando BUBBLE SORT:
     * compara vizinhos e troca se estiverem fora de ordem; repete até não haver trocas.
     */
    public static void ordenarPorPrioridade(Modulo[] modulos) {
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < modulos.length - 1; i++) {
                if (modulos[i].getPrioridade() > modulos[i + 1].getPrioridade()) {
                    trocar(modulos, i, i + 1);
                    trocou = true;
                }
            }
        }
    }

    /** Troca dois elementos de posição no array (usado pelas duas ordenações). */
    private static void trocar(Modulo[] modulos, int a, int b) {
        Modulo temporario = modulos[a];
        modulos[a] = modulos[b];
        modulos[b] = temporario;
    }
}
