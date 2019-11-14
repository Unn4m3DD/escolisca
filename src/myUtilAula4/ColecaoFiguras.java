package myUtilAula4;

import myUtilAula3.Figura;
import myUtilAula3.Ponto;

import java.util.ArrayList;

public class ColecaoFiguras extends ArrayList<Figura> {
    double maxArea;

    public ColecaoFiguras(double maxArea) {
        this.maxArea = maxArea;
    }

    public boolean addFigura(Figura f) {
        if ((f.area() + areaTotal()) < maxArea && !this.contains(f)) {
            this.add(f);
            return true;
        }
        return false;
    }

    public boolean delFigura(Figura f) {
        return this.remove(f);
    }

    public double areaTotal() {
        double result = 0;
        for (Figura f : this) {
            result += f.area();
        }
        return result;
    }

    public boolean exists(Figura f) {
        return this.contains(f);
    }

    public Figura[] getFiguras() {
        Figura[] result = new Figura[this.size()];
        result = this.toArray(result);
        return result;
    }

    public Ponto[] getCentros() {
        Ponto[] result = new Ponto[this.size()];
        int counter = 0;
        for (Figura f : this) {
            result[counter] = f.getCentro();
            counter++;
        }
        return result;
    }
}
