package myUtilAula9;

public class GeladoSimples extends Gelado {
    String name;
    public GeladoSimples(String name) {
        this.name = name;
    }

    @Override
    public String baseS(int n) {
        return super.baseS(n) + "de " + name + " ";
    }
    @Override
    public void base(int n) {
        System.out.println(baseS(n));;
    }
}
