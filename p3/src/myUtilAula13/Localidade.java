package myUtilAula13;

import java.util.Objects;

public class Localidade extends  Regiao{
    private TipoLocalidade tipo;

    public Localidade(String nome, int populacao, TipoLocalidade tipo) {
        super(nome, populacao);
        this.tipo = tipo;
    }

    public TipoLocalidade getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidade that = (Localidade) o;
        return tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }

    @Override
    public String toString() {
        return "Localidade{" +
                "tipo=" + tipo +
                "} " + super.toString();
    }
}
