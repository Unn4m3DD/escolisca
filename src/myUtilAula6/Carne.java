package myUtilAula6;

import java.util.Objects;

public class Carne extends Alimento {
    public enum Variedade {vaca, porco, peru, frango, outra}

    Variedade variedade;

    public Carne(double proteinas, double calorias, double peso, Variedade variedade) {
        super(proteinas, calorias, peso);
        this.variedade = variedade;
    }

    public Variedade getVariedade() {
        return variedade;
    }

    @Override
    public String toString() {
        return super.toString() + ", variedade = " + variedade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Carne carne = (Carne) o;
        return variedade == carne.variedade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(variedade);
    }
}
