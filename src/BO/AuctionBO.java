package BO;

import DAO.AuctionDAO;
import DTO.LanceDTO;
import DTO.LeilaoDTO;

import java.util.ArrayList;

public class AuctionBO {

    private AuctionDAO auctionDAO = new AuctionDAO();

    public void criarLeilao(int ownerId, String descricao){

        auctionDAO.criarLeilao(ownerId, descricao);

    }

    public LeilaoDTO buscarLeilaoPorId(int id) {

        return auctionDAO.buscarLeilaoPorId(id);

    }

    public ArrayList<LeilaoDTO> listarLeiloes(){

        return auctionDAO.listarLeiloes();

    }

    public ArrayList<LeilaoDTO> listarLeiloesAtivos(){

        return auctionDAO.listarLeiloesAtivos();

    }

    public ArrayList<LeilaoDTO> listarLeiloesPorDono(int ownerId){

        return auctionDAO.listarLeiloesPorDono(ownerId);

    }

    public void fecharLeilao(int id){

        auctionDAO.fecharLeilao(id);

    }

    public void cancelarLeilao(int id){

        auctionDAO.fecharLeilao(id);

    }

    public void definirComprador(int leilaoId, int compradorId){

        auctionDAO.definirComprador(leilaoId, compradorId);

    }

    public boolean encerrarLeilao(int leilaoId){

        try {
            LeilaoDTO leilaoDTO = buscarLeilaoPorId(leilaoId);
            if(leilaoDTO == null) return false;
            BidBO bidBO = new BidBO();
            LanceDTO maiorLance = bidBO.buscarMaiorLanceDeLeilao(leilaoDTO.getId());
            if (maiorLance == null) return false;
            definirComprador(leilaoDTO.getId(), maiorLance.getBidOwner());
            fecharLeilao(leilaoDTO.getId());
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;

    }

}
