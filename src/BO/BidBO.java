package BO;

import DAO.BidDAO;
import DTO.LanceDTO;

import java.util.ArrayList;

public class BidBO {

    private BidDAO bidDAO = new BidDAO();

    public void criarLance(int leilaoId, int bidOwner , double valor) {

        bidDAO.criarLance(leilaoId, bidOwner, valor);

    }

    public LanceDTO buscarLancePorId(int id) {

        return bidDAO.buscarLancePorId(id);

    }

    public ArrayList<LanceDTO> listarLances() {

        return bidDAO.listarLances();

    }

    public ArrayList<LanceDTO> listarLancesDeLeilao(int leilaoId) {

        return bidDAO.listarLancesDeLeilao(leilaoId);

    }

    public LanceDTO buscarMaiorLanceDeLeilao(int leilaoId){

        LanceDTO lanceDTO = null;
        ArrayList<LanceDTO> lances = bidDAO.listarLancesDeLeilao(leilaoId);

        for (LanceDTO l : lances){
            if (lanceDTO == null || lanceDTO.getValor() < l.getValor()) lanceDTO = l;
        }

        return lanceDTO;

    }

    public boolean darLance (int leilaoId, double valorLance, int bidOwnerId){

        try{
            LanceDTO maiorLance = buscarMaiorLanceDeLeilao(leilaoId);
            if (valorLance < maiorLance.getValor()) return false;
            else criarLance(leilaoId, bidOwnerId, valorLance);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;

    }

}
