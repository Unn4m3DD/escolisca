package src;

public class eConta extends Conta implements Eletronica {
    public eConta(double saldo, Cliente cliente) throws Exception {
        super(saldo, cliente);
        if (!cliente.getTipo().equals(Cliente.TipoCliente.Online)) {
            throw new Exception("eContas devem ter clientes online");
        }
    }

    @Override
    public String toString() {
        return "[Online] " + super.toString();
    }

    public eConta(Cliente cliente) throws Exception {
        this(0, cliente);

    }

}
