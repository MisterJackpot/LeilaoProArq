package Model;

public class Leilao {
    private int sala;
    private Objeto objeto;

    public Leilao(int sala, Objeto objeto) {
        this.sala = sala;
        this.objeto = objeto;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }
}
