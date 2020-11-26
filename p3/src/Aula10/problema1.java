package Aula10;

import myUtilAula10.VectorGeneric;
import myUtilAula3.Circulo;
import myUtilAula3.Figura;
import myUtilAula3.Quadrado;
import myUtilAula3.Retangulo;
import myUtilAula5.Pessoa;
import myUtilAula10.ListaGeneric;

import java.util.Date;
import java.util.Iterator;

import static myUtilAula10.Util.printSet;
import static myUtilAula10.Util.sumArea;

public class problema1 {
    public static void main(String[] args) {
        VectorGeneric<Pessoa> vp = new VectorGeneric<Pessoa>();
        for (int i = 0; i < 10; i++)
            vp.addElem(new Pessoa("Bebé no Vector " + i,
                    "" + 1000 + i, "10/2/200"));
        Iterator<Pessoa> vec = vp.iterator();
        printSet(vp.iterator());
        ListaGeneric<Pessoa> lp = new ListaGeneric<Pessoa>();
        while (vec.hasNext())
            lp.addElem(vec.next());
        Iterator<Pessoa> lista = lp.iterator();
        while (lista.hasNext())
            System.out.println(lista.next());
        ListaGeneric<Figura> figList = new ListaGeneric<Figura>();
        figList.addElem(new Circulo(1, 3, 1));
        figList.addElem(new Quadrado(3, 4, 2));
        figList.addElem(new Retangulo(1, 2, 2, 5));
        printSet(figList.iterator());
        System.out.println("Soma da Area de Lista de Figuras: " +
                sumArea(figList.iterator()));
// Partindo do principio que Quadrado extends Retangulo:
        ListaGeneric<Retangulo> quadList =
                new ListaGeneric<Retangulo>();
        quadList.addElem(new Quadrado(3, 4, 2));
        quadList.addElem(new Retangulo(1, 2, 2, 5));
        System.out.println("Soma da Area de Lista de Quadrados: " +
                sumArea(quadList.iterator()));
    }
}
