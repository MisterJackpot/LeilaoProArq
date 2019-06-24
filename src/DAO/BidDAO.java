package DAO;

import DTO.LanceDTO;
import DTO.LeilaoDTO;
import Database.SingletonConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BidDAO {

    public boolean criarLance(int leilaoId, int bidOwner , double valor) {

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;

        try {
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO BIDS (AUCTION_ID, BID_OWNER, BID_AMOUNT) VALUES (" + leilaoId + ", " + bidOwner + ", " + valor + ")");
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
            return false;
        }

        return true;

    }

    public LanceDTO buscarLancePorId(int id) {

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;
        LanceDTO lanceDTO = new LanceDTO();

        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM BIDS WHERE ID = " + id);
            results.next();
            try {
                lanceDTO.setId(results.getInt(1));
                lanceDTO.setLeilaoId(results.getInt(2));
                lanceDTO.setBidOwner(results.getInt(3));
                lanceDTO.setValor(results.getDouble(4));
            } catch (Exception e) {
                e.printStackTrace();
                results.close();
                stmt.close();
                return null;
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
            return null;
        }

        return lanceDTO;

    }

    public ArrayList<LanceDTO> listarLances() {

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;
        ArrayList<LanceDTO> lances = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM BIDS ");
            while (results.next()) {
                try {
                    LanceDTO lanceDTO = new LanceDTO();
                    lanceDTO.setId(results.getInt(1));
                    lanceDTO.setLeilaoId(results.getInt(2));
                    lanceDTO.setBidOwner(results.getInt(3));
                    lanceDTO.setValor(results.getDouble(4));
                    lances.add(lanceDTO);
                } catch (Exception e) {
                    e.printStackTrace();
                    results.close();
                    stmt.close();
                    return null;
                }
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
            return null;
        }

        return lances;
    }

    public ArrayList<LanceDTO> listarLancesDeLeilao(int leilaoId) {

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;
        ArrayList<LanceDTO> lances = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM BIDS WHERE ID = " + leilaoId);
            while (results.next()) {
                try {
                    LanceDTO lanceDTO = new LanceDTO();
                    lanceDTO.setId(results.getInt(1));
                    lanceDTO.setLeilaoId(results.getInt(2));
                    lanceDTO.setBidOwner(results.getInt(3));
                    lanceDTO.setValor(results.getDouble(4));
                    lances.add(lanceDTO);
                } catch (Exception e) {
                    e.printStackTrace();
                    results.close();
                    stmt.close();
                    return null;
                }
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
            return null;
        }

        return lances;
    }

}
