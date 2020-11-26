package aula2.Ex10;

import java.util.HashSet;

public class MyHashSet extends HashSet<String> {
    @Override
    public String toString() {
        return "{" + super.toString().substring(1, super.toString().length() - 1) + "}";
    }
}