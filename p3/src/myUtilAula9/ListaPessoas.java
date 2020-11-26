package myUtilAula9;

import myUtilAula5.Pessoa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListaPessoas implements Iterable {
    LinkedList<Pessoa> list = new LinkedList<Pessoa>();
    public boolean addPessoa(Pessoa p){
        return list.add(p);
    }
    public boolean removePessoa(Pessoa p){
        return list.remove(p);
    }
    public int totalPessoas(Pessoa p){
        return list.size();
    }

    @Override
    public Iterator iterator() {
        return new Iter(list);
    }
    class Iter implements Iterator {
        LinkedList list;
        int currentItem = 0;
        Iter(LinkedList list){
            this.list = list;
        }
        @Override
        public boolean hasNext() {
            return list.size() > (currentItem);
        }

        @Override
        public Object next() {
            return list.get(currentItem++);
        }

        @Override
        public void remove() {
            list.remove(currentItem);
        }
    }
}
