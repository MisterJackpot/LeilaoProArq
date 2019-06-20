package Model;

public class Vendedor extends AbstractCliente {

    private Leilao leilao;

    public Vendedor(int id, String nome) {
        super(id, nome);
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }
}
