package myUtilAula3;

public class Veiculo {
    private int cilindrada, potencia, lotacao, peso;
    private char tipoCarta;

    public Veiculo(int cilindrada, int potencia, int lotacao, int peso, char tipoCarta) {
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.lotacao = lotacao;
        this.peso = peso;
        this.tipoCarta = tipoCarta;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getLotacao() {
        return lotacao;
    }

    public int getPeso() {
        return peso;
    }

    public char getTipoCarta() {
        return tipoCarta;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "cilindrada=" + cilindrada +
                ", potencia=" + potencia +
                ", lotacao=" + lotacao +
                ", peso=" + peso +
                ", carta=" + tipoCarta +
                '}';
    }
}
