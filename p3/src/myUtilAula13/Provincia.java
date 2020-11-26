package myUtilAula13;

import java.util.Objects;

public class Provincia extends Regiao {
    private  String governador;

    public Provincia(String nome, int populacao, String governador) {
        super(nome, populacao);
        this.governador = governador;
    }

    public String getGovernador() {

        return governador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return Objects.equals(governador, provincia.governador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(governador);
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "governador='" + governador + '\'' +
                "} " + super.toString();
    }
}
