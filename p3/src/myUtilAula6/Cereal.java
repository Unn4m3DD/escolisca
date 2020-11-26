package myUtilAula6;

import java.util.Objects;

public class Cereal extends Alimento implements Vegetariano {
    String nome;

    public Cereal(double proteinas, double calorias, double peso, String nome) {
        super(proteinas, calorias, peso);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return super.toString() + ", nome = '" + nome + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cereal cereal = (Cereal) o;
        return Objects.equals(nome, cereal.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public String getNome() {
        return nome;
    }
}
