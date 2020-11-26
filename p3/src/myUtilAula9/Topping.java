package myUtilAula9;

public class Topping extends GeladoDecorator {
    private final String name;

    public Topping(Gelado g, String name) {
        super(g);
        this.name = name;
    }

    @Override
    public String baseS(int n){
        return g.baseS(n) + "com " + name + " ";
    }

    @Override
    public void base(int n){
        System.out.println(baseS(n));
    }
}
