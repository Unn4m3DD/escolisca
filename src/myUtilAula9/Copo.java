package myUtilAula9;

public class Copo extends GeladoDecorator {

    public Copo(Gelado g) {
        super(g);
    }

    @Override
    public String baseS(int n){
        return g.baseS(n) + "em copo ";
    }

    @Override
    public void base(int n){
        System.out.println(baseS(n));
    }
}
