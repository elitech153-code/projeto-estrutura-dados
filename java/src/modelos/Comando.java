package modelos;

/**
 * Representa uma ação executada pelo usuário e que pode ser desfeita.
 *
 * Guardamos o estado ANTERIOR para que o "desfazer" saiba
 * exatamente para qual estado voltar.
 */
public class Comando {

    private final String descricao;
    private final EstadoMissao estadoAnterior;
    private final EstadoMissao estadoNovo;

    public Comando(String descricao, EstadoMissao estadoAnterior, EstadoMissao estadoNovo) {
        this.descricao = descricao;
        this.estadoAnterior = estadoAnterior;
        this.estadoNovo = estadoNovo;
    }

    public String getDescricao() {
        return descricao;
    }

    public EstadoMissao getEstadoAnterior() {
        return estadoAnterior;
    }

    public EstadoMissao getEstadoNovo() {
        return estadoNovo;
    }
}
