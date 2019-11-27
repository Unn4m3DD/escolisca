package Aula9;

import myUtilAula1.Data;
import myUtilAula5.Pessoa;
import myUtilAula5.ListaPessoas;
import myUtilAula9.BFIterator;
import myUtilAula9.VectorPessoas;

import java.util.Date;
import java.util.Iterator;

public class problema3 {
    public static void main(String[] args) throws Exception{
        VectorPessoas vp = new VectorPessoas();
        for (int i = 0; i < 10; i++)
            vp.addPessoa(new Pessoa("Bebé no Vector " + i,
                    "" + (1000 + i), "2/4/2001"));
        BFIterator vec = vp.iterator();
        while (vec.hasNext()) {
            System.out.println(vec.next());
            System.out.println(vec.previous());
            System.out.println(vec.next());
        }
        ListaPessoas lp = new ListaPessoas();
        for (int i = 0; i < 10; i++)
            lp.addPessoa(new Pessoa("Bebé na Lista " + i,
                    "2000" + i, "10/10/2000"));
        Iterator lista = lp.iterator();
        while (lista.hasNext())
            System.out.println(lista.next());
    }
}
