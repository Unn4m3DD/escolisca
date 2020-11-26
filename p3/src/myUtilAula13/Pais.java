package myUtilAula13;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pais {
    private String nome;
    private Localidade capital;
    private List<Regiao> regioes;

    public Pais(String nome, Localidade capital, List<Regiao> regioes) {
        this.nome = nome;
        this.capital = capital;
        this.regioes = regioes;
    }

    public Pais(String nome, Capital capital) throws Exception {
        this.nome = nome;
        if (capital.getTipo().equals(Regiao.TipoLocalidade.CIDADE))
            this.capital = capital;
        else
            throw new Exception();
        this.regioes = new ArrayList<>();
    }

    public Pais(String nome) {
        this.nome = nome;
        this.capital = null;
        this.regioes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Localidade getCapital() {
        return capital;
    }

    public List<Regiao> getRegioes() {
        return regioes;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                ", capital=" + capital +
                ", regioes=" + regioes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(nome, pais.nome) &&
                Objects.equals(capital, pais.capital) &&
                Objects.equals(regioes, pais.regioes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, capital, regioes);
    }

    public void addRegiao(Regiao est1) {
        regioes.add(est1);
    }
}
