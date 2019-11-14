package myUtilAula3;

public class Quadrado extends Retangulo{
    public Quadrado(Retangulo r) {
        super(r);
    }

    public Quadrado(double side) {
        super(side, side);
    }

    public Quadrado(int x, int y, double side) {
        super(x, y, side, side);
    }

    public Quadrado(Ponto centro, double side) {
        super(centro, side, side);
    }

    @Override
    public String toString() {
        return "Quadrado{" +
                "side=" + width +
                ", centro=" + centro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && getClass() == o.getClass();
    }
}
