package Aula11;

import myUtilAula10.VectorGeneric;
import myUtilAula3.Circulo;
import myUtilAula3.Figura;
import myUtilAula3.Quadrado;
import myUtilAula3.Retangulo;
import myUtilAula5.Pessoa;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import static myUtilAula10.Util.printSet;
import static myUtilAula10.Util.sumArea;

public class problema1 {
    public static void main(String[] args) {
        ArrayList<Pessoa> vp = new ArrayList<Pessoa>();
        for (int i = 0; i < 10; i++)
            vp.add(new Pessoa("Bebé no Vector " + i,
                    "" + 1000 + i, "10/2/200"));
        Iterator<Pessoa> vec = vp.iterator();
        printSet(vp.iterator());
        LinkedList<Pessoa> lp = new LinkedList<Pessoa>();
        while (vec.hasNext())
            lp.add(vec.next());
        Iterator<Pessoa> lista = lp.iterator();
        while (lista.hasNext())
            System.out.println(lista.next());
        LinkedList<Figura> figList = new LinkedList<Figura>();
        figList.add(new Circulo(1, 3, 1));
        figList.add(new Quadrado(3, 4, 2));
        figList.add(new Retangulo(1, 2, 2, 5));
        printSet(figList.iterator());
        System.out.println("Soma da Area de Lista de Figuras: " +
                sumArea(figList.iterator()));
// Partindo do principio que Quadrado extends Retangulo:
        LinkedList<Retangulo> quadList =
                new LinkedList<Retangulo>();
        quadList.add(new Quadrado(3, 4, 2));
        quadList.add(new Retangulo(1, 2, 2, 5));
        System.out.println("Soma da Area de Lista de Quadrados: " +
                sumArea(quadList.iterator()));


    }
}
