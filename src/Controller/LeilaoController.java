package Controller;

import Model.Leilao;

import java.util.ArrayList;

public class LeilaoController {

    public LeilaoController() {
    }

    public ArrayList<Leilao> getLeiloesAtivos(){
        ArrayList<Leilao> leiloes = new ArrayList<>();
        leiloes.add(new Leilao("Opa"));
        leiloes.add(new Leilao("Dos"));
        leiloes.add(new Leilao("Tripa"));

        return leiloes;
    }
}
