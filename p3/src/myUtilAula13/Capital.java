package myUtilAula13;

public class Capital extends Localidade {
    public Capital(String nome, int populacao, TipoLocalidade tipo) throws Exception {
        super(nome, populacao, tipo);
        if(!tipo.equals(TipoLocalidade.CIDADE)) throw new Exception();
    }
}
