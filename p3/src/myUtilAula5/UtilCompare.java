package myUtilAula5;

import myUtilAula3.Figura;

public class UtilCompare {
    public static <T> Comparable<T> findMax(Comparable<T>[] arr) {
        Comparable<T> result = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo((T) result) < 0) result = arr[i];
        }
        return result;
    }

    public static <T> Comparable<T>[] sortArray(Comparable<T>[] arr) {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].compareTo((T) arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    changed = true;
                }
            }

        }
        return arr;
    }

    private static <T> void swap(Comparable<T>[] result, int a, int b) {
        Comparable<T> tmp = result[a];
        result[a] = result[b];
        result[b] = tmp;
    }
}
