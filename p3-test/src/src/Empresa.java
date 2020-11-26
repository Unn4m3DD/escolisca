package src;

import java.util.Objects;

public class Empresa extends Cliente {
    Cliente gerente;

    public Empresa(String nome, String numContribuinte, TipoCliente tipo, Cliente gerente) {
        super(nome, numContribuinte, tipo);
        this.gerente = gerente;
    }


    public Cliente getGerente() {
        return gerente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(gerente, empresa.gerente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gerente);
    }
}
