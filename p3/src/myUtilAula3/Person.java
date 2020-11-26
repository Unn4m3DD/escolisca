package myUtilAula3;

public class Person {
    protected String nome;
    protected int cc;
    public Person(String nome, int cc) {
        this.nome = nome;
        this.cc = cc;
    }

    public String getNome() {
        return nome;
    }

    public int getCc() {
        return cc;
    }
}
