import DAO.AuctionDAO;
import DAO.UserDAO;
import DTO.LeilaoDTO;

import java.util.ArrayList;

public class testes {

    public static void main (String args[]){
        AuctionDAO auctionDAO = new AuctionDAO();
        //auctionDAO.criarLeilao(201, "Segundo leilao");
        ArrayList<LeilaoDTO> opa = auctionDAO.listarLeiloesAtivos();
        System.out.println("FIm");
    }

}
