package myUtilAula5;

public class CarroPolicia extends Automovel {
    public static enum Tipo {
        INEM, Bombeiros, GNR, PSP, PJ
    }

    private Tipo tipo;

    public CarroPolicia(int ano, int velocidadeMaxima, String cor, int cilindrada, String matricula, Tipo tipo, int combustivel, int consumo) {
        super(ano, velocidadeMaxima, cor, cilindrada, matricula, combustivel, consumo);
        this.tipo = tipo;
    }

    public String getID() {
        return this.matricula;
    }

    public String getTipo() {
        return tipo.name();
    }
}
