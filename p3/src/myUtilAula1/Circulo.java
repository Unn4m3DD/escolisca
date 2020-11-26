package myUtilAula1;

public class Circulo implements Figura{
    private Point centro;
    private double raio;

    public Circulo(Point centro, double raio) {
        this.centro = centro;
        this.raio = raio;
    }
    public Circulo(double x, double y, double raio) {
        this.centro = new Point(x,y);
        this.raio = raio;
    }
    @Override
    public double area() {
        return Math.pow(Math.PI,2) * raio;
    }

    @Override
    public double perimetro() {
        return Math.PI * 2 * raio;
    }

    @Override
    public String toString() {
        return "Circulo de centro = " + centro + ", e raio = " + raio;
    }

    public boolean intercepts(Circulo c){
        return c.centro.distance(centro) < raio || c.centro.distance(centro) < c.raio;
    }

    public boolean equals(Circulo c) {
        return c.raio == raio && c.centro.equals(centro);
    }

    public Point getCentro() {
        return centro;
    }
    public double getRaio() {
        return raio;
    }

}
