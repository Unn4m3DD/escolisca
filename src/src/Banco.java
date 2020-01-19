package src;

import java.util.*;

public class Banco implements Iterable<Conta> {
    private String nome;
    TreeSet<Conta> contas;

    public Banco(String nome, TreeSet<Conta> contas) {
        this.nome = nome;
        this.contas = contas;
    }

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new TreeSet<>();
    }

    public boolean add(Conta c) {
        return contas.add(c);
    }

    public boolean add(int numConta, Movimento m) {
        for (var elem : contas) {
            if (elem.getnConta() == numConta) {
                elem.add(m);
                return true;
            }

        }
        return false;
    }

    @Override
    public String toString() {
        return "Banco: " +
                "nome: " + nome +
                ", contas: " + contas;

    }

    public String getNome() {
        return nome;
    }

    public Set<Conta> getContas() {
        return contas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return Objects.equals(nome, banco.nome) &&
                Objects.equals(contas, banco.contas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, contas);
    }

    @Override
    public Iterator<Conta> iterator() {
        return contas.iterator();
    }
}
