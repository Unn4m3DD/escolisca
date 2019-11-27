package myUtilAula9;

import myUtilAula5.Pessoa;

import java.util.ArrayList;
import java.util.Iterator;

public class VectorPessoas implements Iterable {
    ArrayList<Pessoa> list = new ArrayList<Pessoa>();
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
    public BFIterator iterator() {
        return new Iter(list);
    }
    class Iter implements BFIterator {
        ArrayList list;
        int currentItem = 0;
        Iter(ArrayList list){
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

        @Override
        public boolean hasPrevious() {
            return 0 < (currentItem);
        }

        @Override
        public Object previous() {
            return list.get(--currentItem);
        }
    }
}
