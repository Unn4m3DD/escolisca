package myUtilAula6;

import java.util.Objects;

public class Peixe extends Alimento{
    public enum Tipo {congelado, fresco}
    Tipo tipo;

    public Peixe(double proteinas, double calorias, double peso, Tipo tipo) {
        super(proteinas, calorias, peso);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", tipo = " + tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Peixe peixe = (Peixe) o;
        return tipo == peixe.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }

    public Tipo getTipo() {
        return tipo;
    }
}
