package myUtilAula3;

public abstract class Figura implements Comparable<Figura> {
    protected Ponto centro;

    public Figura(Ponto centro) {
        this.centro = centro;
    }

    public abstract double perimetro();
    public abstract double area();

    public Ponto getCentro() {
        return centro;
    }
    public int getXCentro() {
        return centro.getX();
    }
    public int getYCentro() {
        return centro.getY();
    }

    @Override
    public String toString() {
        return "Figura{" +
                "centro=" + centro +
                '}';
    }

    @Override
    public int compareTo(Figura f) {
        if(this.area() > f.area()) return 1;
        if(this.area() < f.area()) return -1;
        return 0;
    }
}
