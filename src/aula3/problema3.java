package aula3;

import myUtilAula3.*;

public class problema3 {
    public static void main(String[] args) {
        Condutor cA = new Condutor("A", 123124, new Carta(new boolean[]{true, false, false, false}));
        Condutor cB = new Condutor("B", 123124, new Carta(new boolean[]{false, true, false, false}));
        Condutor cC = new Condutor("C", 123124, new Carta(new boolean[]{false, false, true, false}));
        Condutor cD = new Condutor("D", 123124, new Carta(new boolean[]{false, false, false, true}));
        Veiculo[] vs = new Veiculo[]{
                new Ligeiro(10, 10, 1, 1),
                new Motociclo(123,1,23123,21),
                new PesadoDeMercadorias(123,12311,123,3231),
                new PesadoDePassageiros(123,322,12,3)
        };
        for(Veiculo v: vs){
            System.out.println("Condutor A pode conduzir " + v + " = " + cA.podeConduzir(v));
            System.out.println("Condutor B pode conduzir " + v + " = " + cB.podeConduzir(v));
            System.out.println("Condutor C pode conduzir " + v + " = " + cC.podeConduzir(v));
            System.out.println("Condutor D pode conduzir " + v + " = " + cD.podeConduzir(v));
        }
    }
}
