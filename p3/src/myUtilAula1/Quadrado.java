package myUtilAula1;

public class Quadrado extends Retangulo {
    private double side;
    public Quadrado(double side, Point topLeftCorner) {
        super(side, side, topLeftCorner);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public boolean equals(Quadrado q) {
        return super.equals(q);
    }

    @Override
    public String toString() {
        return "Retangulo, Canto Superior Esquerdo = " + getTopLeftCorner() + ", width = " + getWidth() + ", height = " + getHeight();
    }
}
