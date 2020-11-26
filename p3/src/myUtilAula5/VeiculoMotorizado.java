package myUtilAula5;

public class VeiculoMotorizado extends Veiculo {
    protected int combustivel, cilindrada, consumo;
    protected String  matricula;

    public VeiculoMotorizado(int ano, int nRodas, int velocidadeMaxima, String cor, int cilindrada, String matricula, int combustivel, int consumo) {
        super(ano, nRodas, velocidadeMaxima, cor);
        this.cilindrada = cilindrada;
        this.matricula = matricula;
        this.combustivel = combustivel;
        this.consumo = consumo;
    }
}
