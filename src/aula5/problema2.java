package aula5;

import myUtilAula5.*;

import java.util.Arrays;

public class problema2 {
    public static void main(String[] args) {

        Bicicleta b1 = new Bicicleta(1, 1, "");
        BicicletaPolicia b2 = new BicicletaPolicia(3, 1, "");
        Automovel a1 = new Automovel(5, 1, "", 2, "", 1, 1);
        CarroPolicia c1 = new CarroPolicia(5, 1, "", 2, "", CarroPolicia.Tipo.Bombeiros, 1, 1);
        Moto m1 = new Moto(412, 1, "", 1, "", 1, 1);
        MotoPolicia m2 = new MotoPolicia(132, 1, "", 1, "", 1, 2);
        Veiculo[] vs = {a1, b1, m2, b2, c1, m1};
        System.out.println(Arrays.toString(vs));
        UtilCompare.sortArray(vs);
        System.out.println(Arrays.toString(vs));


    }
}
