package myUtilAula6;

import java.io.Serializable;

public class PratoVegetariano extends Prato {
    public PratoVegetariano(String nome) {
        super(nome);
    }

    @Override
    public boolean addIngrediente(Alimento a) {
        if (a instanceof Vegetariano)
            return super.addIngrediente(a);
        return false;
    }
}
