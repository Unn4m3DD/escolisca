package myUtilAula7;

public class Hora {
    int hora;

    public Hora(String s) {
        this.hora = Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
    }

    public String add(Hora other) {
        int h = (this.hora + other.hora) % (60 * 24);
        return String.format("%2.2s:%2.2s", h / 60, h % 60).replace(" ", "0");
    }

    @Override
    public String toString() {
        return String.format("%2.2s:%2.2s", hora / 60, hora % 60).replace(" ", "0");
    }

    public int getHora() {
        return hora;
    }
}
