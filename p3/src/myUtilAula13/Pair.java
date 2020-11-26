package myUtilAula13;

import myUtilAula5.UtilCompare;

import java.util.Objects;

public class Pair<T1, T2> implements Comparable<Pair<String, String>> {
    private T1 elem1;

    public T1 getElem1() {
        return elem1;
    }

    public T2 getElem2() {
        return elem2;
    }

    private T2 elem2;

    public Pair(T1 elem1, T2 elem2) {
        this.elem1 = elem1;
        this.elem2 = elem2;
    }

    @Override
    public String toString() {
        return "(" + elem1 +
                ", " + elem2 +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        boolean result = Objects.equals(elem1, pair.elem1) &&
                Objects.equals(elem2, pair.elem2);
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elem1, elem2);
    }

    @Override
    public int compareTo(Pair<String, String> o) {
        int result = 0;
        if(elem1 instanceof Comparable)
            result = ((Comparable) elem1).compareTo(o.getElem1());

        if(result == 0 && elem2 instanceof Comparable)
            result = ((Comparable) elem2).compareTo(o.getElem2());
        return result;
    }
}
