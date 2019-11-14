package myUtilAula7;

public class Voo {
    private String id, origem ;
    private Hora hora, atraso;

    public Voo(Hora hora, String id, String origem, Hora atraso) {
        this.hora = hora;
        this.id = id;
        this.origem = origem;
        this.atraso = atraso;
    }
    public Voo(Hora hora, String id, String origem) {
        this(hora,id, origem, new Hora("00:00"));
    }

    public Hora getHora() {
        return hora;
    }

    public String getId() {
        return id;
    }

    public String getOrigem() {
        return origem;
    }

    public Hora getAtraso() {
        return atraso;
    }

    @Override
    public String toString() {
        return hora + "  " + id + "  " + origem + "  " + atraso + "\n";
    }
}
