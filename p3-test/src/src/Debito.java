package src;

public class Debito extends  Movimento{

    public Debito(double montante, String data) throws Exception {
        super(montante, data);
        if(montante > 0){
            throw new Exception("Debitos devem ser de montantes negativos");
        }
    }

    @Override
    public String toString() {
        return "Debito > " + super.toString();
    }
}
