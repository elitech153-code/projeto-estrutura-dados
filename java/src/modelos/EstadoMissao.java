package modelos;

/**
 * ENUM: conjunto fixo de valores permitidos para o estado da missão.
 *
 * Em vez de usar texto solto ("orbita", "Órbita"...), o Java só aceita
 * um destes valores, o que evita erros de digitação.
 */
public enum EstadoMissao {

    // Cada valor chama o construtor passando um texto amigável
    PLANEJADA("Planejada"),
    EM_ORBITA("Em órbita"),
    POUSANDO("Pousando"),
    EM_MANUTENCAO("Em manutenção"),
    CONCLUIDA("Concluída");

    private final String descricao;

    // Construtor de enum é sempre privado (chamado só pelos valores acima)
    EstadoMissao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
