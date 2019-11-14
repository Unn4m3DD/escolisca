package myUtilAula6;

import java.io.Serializable;
import java.util.Objects;

public class Alimento  implements Serializable {
    private double proteinas, calorias, peso;

    public Alimento(double proteinas, double calorias, double peso) {
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "proteinas = " + proteinas + ", calorias = " + calorias + ", peso = " + peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alimento alimento = (Alimento) o;
        return Double.compare(alimento.proteinas, proteinas) == 0 &&
                Double.compare(alimento.calorias, calorias) == 0 &&
                Double.compare(alimento.peso, peso) == 0;
    }

}
