package myUtilAula6;

public class PratoDieta extends Prato {
    double maxCalorias;

    public PratoDieta(String nome, double maxCalorias) {
        super(nome);
        this.maxCalorias = maxCalorias;
    }

    @Override
    public boolean addIngrediente(Alimento a) {
        if (super.getCalorias() + a.getCalorias() < maxCalorias)
            return super.addIngrediente(a);
        return false;
    }
}
