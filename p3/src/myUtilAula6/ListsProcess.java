package myUtilAula6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListsProcess {
    public static <E> List<E> filter(List<E> l, Predicate<E> filter) {
        return l.stream().filter(filter).collect(Collectors.toList());
    }
}
