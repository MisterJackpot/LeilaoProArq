package Model;

import java.util.ArrayList;

public class Leilao implements LeilaoInterface{
    private int sala;
    private Objeto objeto;
    private ArrayList<Lance> lances;

    public Leilao(int sala, Objeto objeto) {
        this.sala = sala;
        this.objeto = objeto;
        this.lances = new ArrayList<Lance>();
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

    public ArrayList<Lance> getLances() {
        return lances;
    }

    public void addLances(Lance lance) {
        this.lances.add(lance);
    }
}
