package myUtilAula9;

import java.util.Iterator;

public interface BFIterator<T> extends Iterator<T> {
    boolean hasPrevious();
    Object previous();
}
