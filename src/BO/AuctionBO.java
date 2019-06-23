package BO;

import DAO.AuctionDAO;
import DTO.LeilaoDTO;

import java.util.ArrayList;

public class AuctionBO {

    private AuctionDAO auctionDAO = new AuctionDAO();

    public void criarLeilao(int ownerId, String descricao){

        auctionDAO.criarLeilao(ownerId, descricao);

    }

    public ArrayList<LeilaoDTO> listarLeiloes(){

        return auctionDAO.listarLeiloes();

    }

    public ArrayList<LeilaoDTO> listarLeiloesAtivos(){

        return auctionDAO.listarLeiloesAtivos();

    }

}
