package myUtilAula3;

import java.util.Objects;

public class Circulo extends Figura {
    private int raio;

    public int getRaio() {
        return raio;
    }

    public Circulo(Circulo c1) {
        this(c1.getCentro().getX(), c1.getCentro().getY(), c1.getRaio());
    }

    public Circulo(int raio) {
        this(0, 0, raio);
    }

    public Circulo(int x, int y, int raio) {
        super(new Ponto(x, y));
        this.raio = raio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    public double area() {
        return Math.PI * raio * raio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "raio=" + raio +
                ", centro=" + centro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circulo circulo = (Circulo) o;
        return (centro.equals(circulo.centro) &&  raio == circulo.raio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raio);
    }
}
