package modelos;

/**
 * Representa um módulo da nave (um "tipo de dado estruturado").
 *
 * Uma classe agrupa os dados de uma entidade em um só lugar.
 * Aqui, um módulo tem nome, tipo, peso e prioridade.
 */
public class Modulo {

    private final String nome;
    private final TipoModulo tipo;
    private final double pesoKg;
    private final int prioridade; // 1 = mais urgente ... 5 = menos urgente

    public Modulo(String nome, TipoModulo tipo, double pesoKg, int prioridade) {
        this.nome = nome;
        this.tipo = tipo;
        this.pesoKg = pesoKg;
        this.prioridade = prioridade;
    }

    // Getters: permitem LER os dados de fora da classe
    public String getNome() {
        return nome;
    }

    public TipoModulo getTipo() {
        return tipo;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public int getPrioridade() {
        return prioridade;
    }
}
