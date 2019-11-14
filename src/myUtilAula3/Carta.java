package myUtilAula3;

import java.util.Arrays;

public class Carta {
    private boolean[] categorias = {false, false, false, false};

    public Carta(boolean[] categorias) {
        this.categorias = categorias;
    }

    public boolean podeConduzir(Veiculo v){
        if(v.getTipoCarta() == 'A'){
            return this.categorias[0];
        }

        if(v.getTipoCarta() == 'B'){
            return this.categorias[1];
        }

        if(v.getTipoCarta() == 'C'){
            return this.categorias[2];
        }

        if(v.getTipoCarta() == 'D'){
            return this.categorias[3];
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return Arrays.equals(categorias, carta.categorias);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(categorias);
    }

    public boolean getA(){
        return categorias[0];
    }
    public boolean getB(){
        return categorias[1];
    }
    public boolean getC(){
        return categorias[2];
    }
    public boolean getD(){
        return categorias[3];
    }
    @Override
    public String toString() {
        return "Carta{" +
                "categorias=[" +
                (categorias[0] ? " A ":"") +
                (categorias[1] ? " B ":"") +
                (categorias[2] ? " C ":"") +
                (categorias[3] ? " D ":"") +
                "]}";
    }
}
