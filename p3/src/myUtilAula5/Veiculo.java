package myUtilAula5;

public class Veiculo implements Comparable<Veiculo> {
    private static int idCount = 1;
    private int id, ano, nRodas, velocidadeMaxima;
    private String cor;

    public Veiculo(int ano, int nRodas, int velocidadeMaxima, String cor) {
        this.id = idCount++;
        this.ano = ano;
        this.nRodas = nRodas;
        this.velocidadeMaxima = velocidadeMaxima;
        this.cor = cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return id == veiculo.id &&
                ano == veiculo.ano &&
                nRodas == veiculo.nRodas &&
                velocidadeMaxima == veiculo.velocidadeMaxima &&
                cor.equals(veiculo.cor);
    }


    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", ano=" + ano +
                ", nRodas=" + nRodas +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", cor='" + cor + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public int getnRodas() {
        return nRodas;
    }


    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }


    public String getCor() {
        return cor;
    }


    @Override
    public int compareTo(Veiculo v) {
        if (this.ano > v.ano) return 1;
        if (this.ano < v.ano) return -1;
        return 0;
    }
}
