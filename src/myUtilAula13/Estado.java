package myUtilAula13;

import java.util.Objects;

public class Estado extends Regiao {
    private Capital capital;

    public Estado(String nome, int populacao, Capital capital){
        super(nome, populacao);
        this.capital = capital;

    }

    public Capital getCapital() {
        return capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(capital, estado.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capital);
    }

    @Override
    public String toString() {
        return "Estado{" +
                "capital=" + capital +
                "} " + super.toString();
    }
}
