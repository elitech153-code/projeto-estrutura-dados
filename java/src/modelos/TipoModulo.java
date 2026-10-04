package modelos;

/**
 * ENUM: categorias possíveis de um módulo da nave.
 */
public enum TipoModulo {

    PROPULSAO("Propulsão"),
    ENERGIA("Energia"),
    COMUNICACAO("Comunicação"),
    HABITACAO("Habitação");

    private final String descricao;

    TipoModulo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
