package src;

import java.util.Objects;

public class Cliente {
    private String nome, numContribuinte;

    public enum TipoCliente {
        Balcao, Online
    }
    private TipoCliente tipo;

    public Cliente(String nome, String numContribuinte, TipoCliente tipo) {
        this.nome = nome;
        this.numContribuinte = numContribuinte;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public String getNumContribuinte() {
        return numContribuinte;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) &&
                Objects.equals(numContribuinte, cliente.numContribuinte) &&
                tipo == cliente.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numContribuinte, tipo);
    }
}
