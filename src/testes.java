import DAO.AuctionDAO;
import DAO.UserDAO;

public class testes {

    public static void main (String args[]){
        AuctionDAO auctionDAO = new AuctionDAO();
        auctionDAO.criarLeilao(201, "Este é um item muito valioso");

    }

}
