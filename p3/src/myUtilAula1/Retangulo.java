package myUtilAula1;

public class Retangulo implements Figura {
    private double width, height;
    private Point topLeftCorner;

    public Retangulo(double width, double height, Point topLeftCorner) {
        this.width = width;
        this.height = height;
        this.topLeftCorner = topLeftCorner;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimetro() {
        return width + width + height + height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Point getTopLeftCorner() {
        return topLeftCorner;
    }

    public boolean equals(Retangulo r) {
        return r.width == width && r.height == height && r.topLeftCorner.equals(topLeftCorner);
    }

    @Override
    public String toString() {
        return "Retangulo, Canto Superior Esquerdo = " + topLeftCorner + ", width = " + width + ", height = " + height;
    }
}
