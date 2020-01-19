package src;

import java.util.Objects;

public class Individual extends Cliente {
    private String numeroDeTelefone;

    public Individual(String nome, String numContribuinte, TipoCliente tipo, String numeroDeTelefone) {
        super(nome, numContribuinte, tipo);
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public Individual(String nome, String numContribuinte, TipoCliente tipo) {
        this(nome, numContribuinte, tipo, "");
    }

    public String getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Individual that = (Individual) o;
        return Objects.equals(numeroDeTelefone, that.numeroDeTelefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroDeTelefone);
    }
}
