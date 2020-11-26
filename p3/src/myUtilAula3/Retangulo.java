package myUtilAula3;

import java.util.Objects;

public class Retangulo extends Figura {

    protected double width, height;

    public Retangulo(Retangulo r) {
        this(new Ponto(r.getXCentro(), r.getYCentro()), r.getWidth(), r.getHeight());
    }

    public Retangulo(double width, double height) {
        this(new Ponto(0, 0), width, height);
    }

    public Retangulo(int x, int y, double width, double height) {
        this(new Ponto(x, y), width, height);
    }

    public Retangulo(Ponto centro, double width, double height) {
        super(centro);
        this.width = width;
        this.height = height;
    }

    @Override
    public double perimetro() {
        return 2 * width + 2 * height;
    }

    @Override
    public double area() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Retangulo{" +
                "width=" + width +
                ", height=" + height +
                ", centro=" + centro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Retangulo retangulo = (Retangulo) o;
        return centro.equals(((Retangulo) o).centro) &&
                Double.compare(retangulo.width, width) == 0 &&
                Double.compare(retangulo.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
