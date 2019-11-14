package myUtilAula6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ListsProcess {
    public static <E> List<E> filter(List<E> l, Predicate<E> filter){
        List<E> result = new ArrayList<>();
        for(E elem: l){
            if(filter.test(elem))
            result.add(elem);
        }
        return result;
    }
}
