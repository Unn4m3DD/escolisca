package src;

import java.util.Objects;

public class Movimento {
    private double montante;
    private String data;

    public Movimento(double montante, String data) {
        this.montante = montante;
        this.data = data;
    }

    @Override
    public String toString() {
        return "[amount=" + montante + ", data=" + data + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimento movimento = (Movimento) o;
        return Double.compare(movimento.montante, montante) == 0 &&
                Objects.equals(data, movimento.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(montante, data);
    }

    public double getMontante() {
        return montante;
    }

    public String getData() {
        return data;
    }
}
