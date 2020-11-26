package myUtilAula9;

public class Cone extends GeladoDecorator {

    public Cone(Gelado g) {
        super(g);
    }

    @Override
    public String baseS(int n){
        return g.baseS(n) + "em cone ";
    }

    @Override
    public void base(int n){
        System.out.println(baseS(n));
    }
}
