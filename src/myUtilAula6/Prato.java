package myUtilAula6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Prato implements Comparable<Prato>, Serializable {
    private String nome;
    ArrayList<Alimento> la = new ArrayList<Alimento>();

    public Prato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean addIngrediente(Alimento a) {
        return la.add(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prato prato = (Prato) o;
        return Objects.equals(nome, prato.nome) &&
                Objects.equals(la, prato.la);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, la);
    }

    public ArrayList<Alimento> getLa() {
        return la;
    }

    @Override
    public String toString() {
        return "Prato{" +
                "nome='" + nome + '\'' +
                ", la=" + la +
                '}';
    }

    public double getCalorias() {
        double calorias = 0;
        for (Alimento a : la) calorias += a.getCalorias();
        return calorias;
    }

    @Override
    public int compareTo(Prato o) {
        return Double.compare(getCalorias(), o.getCalorias());
    }

    public void add(Alimento a) {
        la.add(a);
    }
}
