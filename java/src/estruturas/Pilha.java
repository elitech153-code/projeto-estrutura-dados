package estruturas;

import modelos.Comando;

/**
 * PILHA (Stack) implementada do zero, sobre um array de capacidade fixa.
 *
 * Regra LIFO (Last In, First Out): o ÚLTIMO que entra é o PRIMEIRO que sai.
 * Pense numa pilha de pratos: só se mexe no prato do topo.
 *
 * A variável "topo" guarda o índice do elemento que está no topo.
 * Pilha vazia => topo = -1.
 */
public class Pilha {

    private final Comando[] dados; // onde os itens ficam guardados
    private int topo;              // índice do último item empilhado

    public Pilha(int capacidade) {
        this.dados = new Comando[capacidade];
        this.topo = -1; // começa vazia
    }

    /** Empilhar (push): coloca um item no topo. Retorna false se a pilha estiver cheia. */
    public boolean empilhar(Comando comando) {
        if (estaCheia()) {
            return false;
        }
        topo++;                 // sobe o topo uma posição
        dados[topo] = comando;  // guarda o item nessa posição
        return true;
    }

    /** Desempilhar (pop): remove e devolve o item do topo. Retorna null se estiver vazia. */
    public Comando desempilhar() {
        if (estaVazia()) {
            return null;
        }
        Comando removido = dados[topo];
        dados[topo] = null;     // limpa a posição
        topo--;                 // desce o topo uma posição
        return removido;
    }

    /** Consultar o topo (peek): devolve o item do topo SEM remover. */
    public Comando consultarTopo() {
        if (estaVazia()) {
            return null;
        }
        return dados[topo];
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == dados.length - 1;
    }

    public int tamanho() {
        return topo + 1;
    }
}
