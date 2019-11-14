package myUtilAula1;

public class Point {
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Point p){
        return p.x == x && p.y == y;
    }
    public double distance(Point p) {
        return Math.sqrt(x * p.x + y * p.y);
    }
    public void add(Point p){
        this.x += p.x;
        this.y += p.y;
    }
    public void sub(Point p){
        this.x -= p.x;
        this.y -= p.y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
