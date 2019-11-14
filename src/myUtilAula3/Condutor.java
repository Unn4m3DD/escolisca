package myUtilAula3;

public class Condutor extends Person{
    private Carta carta;
    public Condutor(String nome, int cc, Carta carta) {
        super(nome, cc);
        this.carta = carta;
    }
    public boolean podeConduzir(Veiculo v){
        return carta.podeConduzir(v);
    }
}
