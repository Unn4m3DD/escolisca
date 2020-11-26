package aula1;

import myUtilAula1.Pessoa;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class ListaPessoas {
    LinkedList<Pessoa> lista = new LinkedList<>();
    LinkedList<Pessoa> sortedList = new LinkedList<>();

    private void show(LinkedList<Pessoa> list) {
        for (Iterator i = list.iterator(); i.hasNext(); ) {
            System.out.println(i.next());
        }
    }

    void showOrdered() {
        sortedList = (LinkedList) lista.clone();
        sortedList.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa p1, Pessoa p2) {
                if (p1.getCc() > ((Pessoa) p2).getCc())
                    return 1;
                if (p1.getCc() < ((Pessoa) p2).getCc())
                    return -1;
                return 0;
            }
        });
        show(sortedList);
    }

    void showUnordered() {
        show(lista);
    }

    void insert(Pessoa p) throws Exception {
        lista.add(p);
    }

    void delete(int idToDelete) throws Exception {
        for (Iterator i = lista.iterator(); i.hasNext(); ) {
            Object p = i.next();
            if (((Pessoa) p).id() == idToDelete) {
                lista.remove(p);
                return;
            }
        }
    }
}
