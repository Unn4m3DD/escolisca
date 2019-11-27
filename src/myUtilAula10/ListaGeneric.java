package myUtilAula10;

import myUtilAula9.BFIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListaGeneric<T> implements Iterable<T> {
    LinkedList<T> list = new LinkedList<T>();

    public boolean addElem(T p) {
        return list.add(p);
    }

    public boolean removeElem(T p) {
        return list.remove(p);
    }

    public int totalElems(T p) {
        return list.size();
    }

    @Override
    public BFIterator<T> iterator() {
        return new Iter(list);
    }

    class Iter implements BFIterator<T> {
        LinkedList<T> list;
        int currentItem = 0;

        Iter(LinkedList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return list.size() > (currentItem);
        }

        @Override
        public T next() {
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
        public T previous() {
            return list.get(--currentItem);
        }
    }
}
