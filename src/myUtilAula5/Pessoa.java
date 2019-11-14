package myUtilAula5;

public class Pessoa {
    private String nome, numero, dataNascimento;

    public Pessoa(String nome, String numero, String dataNascimento) {
        this.nome = nome;
        this.numero = numero;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return nome + "  " + numero + "  " + dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
}
