package src;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Conta implements Comparable<Conta> {
    private int nConta;
    private double saldo;
    private static int numeroDeContas = 0;
    private Cliente cliente;
    private List<Movimento> movimentos;

    public Conta(double saldo, Cliente cliente) {
        numeroDeContas++;
        this.nConta = numeroDeContas;
        this.saldo = saldo;
        this.cliente = cliente;
        movimentos = new LinkedList<>(); // poderia ser um arraylist caso existam estatisticas sobre o tamanho medio de lista de movimentos
    }

    @Override
    public String toString() {
        return "N: " + nConta +
                ", Cliente: " + cliente +
                ", Saldo: " + saldo +
                ", Movimentos: " + (movimentos.size() > 0 ? movimentos : ""); // para tornar o output identico ao do enunciado
    }

    public Conta(Cliente cliente) {
        this(0, cliente);
    }

    public boolean add(Movimento mov) {
        saldo += mov.getMontante();
        return movimentos.add(mov);
    }


    public int getnConta() {
        return nConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public static int getNumeroDeContas() {
        return numeroDeContas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return nConta == conta.nConta &&
                Double.compare(conta.saldo, saldo) == 0 &&
                Objects.equals(cliente, conta.cliente) &&
                Objects.equals(movimentos, conta.movimentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nConta, saldo, cliente, movimentos);
    }

    @Override // o metodo foi implementado para utilização de treeset, apesar de a especificação nao indicar, o output exemplo está ordenado por numero de conta.
    public int compareTo(Conta o) {
        return Integer.compare(nConta, o.nConta);
    }
}
