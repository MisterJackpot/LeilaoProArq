package DAO;

import DTO.LeilaoDTO;
import Database.SingletonConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuctionDAO {

    public boolean criarLeilao(int ownerId, String descricao){

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;

        try
        {
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO AUCTIONS (OWNER_ID, ITEM_DESCRIPTION, STATUS) VALUES (" + ownerId + ", '" + descricao + "', 'A')");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
            return false;
        }

        return true;

    }

    public LeilaoDTO buscarLeilaoPorId(int id){

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;
        LeilaoDTO leilaoDTO = new LeilaoDTO();

        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM AUCTIONS WHERE ID = " + id);
            results.next();
            try {
                leilaoDTO.setId(results.getInt(1));
                leilaoDTO.setOwnerId(results.getInt(2));
                leilaoDTO.setDescricao(results.getString(3));
                leilaoDTO.setStatus(results.getString(4));
                leilaoDTO.setComprador(results.getInt(5));
            }
            catch (Exception e){
                e.printStackTrace();
                results.close();
                stmt.close();
                return null;
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
            return null;
        }

        return leilaoDTO;

    }

}