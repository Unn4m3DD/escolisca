package myUtilAula1;

public class Pessoa{
    private String nome;
    private int cc;
    private Data dataNasc;
    private int id;
    private static int g_id = 0;
    public Pessoa(String nome, int cc, Data dataNasc) {
        this.id = g_id;
        g_id++;
        this.nome = nome;
        this.cc = cc;
        this.dataNasc = dataNasc;
    }

    public String toString() {
        return "Id: " + id + ", Nome: " + nome + ", Data de Nascimento: " + dataNasc + ", Número CC: " + cc;
    }

    public String getNome() {
        return nome;
    }

    public int getCc() {
        return cc;
    }

    public Data getDataNasc() {
        return dataNasc;
    }
    public int id() {
        return id;
    }

}
