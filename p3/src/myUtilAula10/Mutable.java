package myUtilAula10;

public class Mutable<T> {
    private T elem;
    public Mutable(T elem){
        this.elem = elem;
    }

    public void set(T elem) {
        this.elem = elem;
    }

    public T get() {
        return elem;
    }
}
