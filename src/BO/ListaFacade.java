package BO;

import DTO.LeilaoDTO;

import java.util.ArrayList;

public class ListaFacade {
    private AuctionBO auctionBO;
    private ArrayList<LeilaoDTO> leiloesAtivos;
    private ArrayList<LeilaoDTO> meusLeiloes;
    private ArrayList<LeilaoDTO> todosLeiloes;

    public ListaFacade(int idUSer) {
        auctionBO = new AuctionBO();
        leiloesAtivos = auctionBO.listarLeiloesAtivos();
        meusLeiloes = auctionBO.listarLeiloesPorDono(idUSer);
        todosLeiloes = auctionBO.listarLeiloes();
    }

    public ArrayList<LeilaoDTO> getLeiloesAtivos() {
        return leiloesAtivos;
    }

    public ArrayList<LeilaoDTO> getMeusLeiloes() {
        return meusLeiloes;
    }

    public ArrayList<LeilaoDTO> getTodosLeiloes() {
        return todosLeiloes;
    }
}
