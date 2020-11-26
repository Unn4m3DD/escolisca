package src;

public class Credito extends Movimento {
    public Credito(double montante, String data) throws Exception {
        super(montante, data);
        if(montante < 0){
            throw new Exception("Creditos devem ser de montantes positivos");
        }
    }

    @Override
    public String toString() {
        return "Credito > " + super.toString();
    }
}
