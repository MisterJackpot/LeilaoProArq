package DAO;

import DTO.LeilaoDTO;
import Database.SingletonConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AuctionDAO {

    public int criarLeilao(int ownerId, String descricao) {

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        PreparedStatement stmt;
        int id = -1;

        try {
            stmt = conn.prepareStatement("INSERT INTO AUCTIONS (OWNER_ID, ITEM_DESCRIPTION, STATUS) VALUES (? ,?, 'A')",Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,ownerId);
            stmt.setString(2,descricao);
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
            return -1;
        }

        return id;

    }

    public LeilaoDTO buscarLeilaoPorId(int id) {

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;
        LeilaoDTO leilaoDTO = new LeilaoDTO();

        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM AUCTIONS WHERE ID = " + id);
            results.next();
            try {
                leilaoDTO.setId(results.getInt(1));
                leilaoDTO.setOwnerId(results.getInt(2));
                leilaoDTO.setDescricao(results.getString(3));
                leilaoDTO.setStatus(results.getString(4));
                leilaoDTO.setComprador(results.getInt(5));
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

        return leilaoDTO;

    }

    public ArrayList<LeilaoDTO> listarLeiloes() {

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;
        ArrayList<LeilaoDTO> leiloes = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM AUCTIONS ");
            while (results.next()) {
                try {
                    LeilaoDTO leilaoDTO = new LeilaoDTO();
                    leilaoDTO.setId(results.getInt(1));
                    leilaoDTO.setOwnerId(results.getInt(2));
                    leilaoDTO.setDescricao(results.getString(3));
                    leilaoDTO.setStatus(results.getString(4));
                    leilaoDTO.setComprador(results.getInt(5));
                    leiloes.add(leilaoDTO);
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

        return leiloes;
    }

    public ArrayList<LeilaoDTO> listarLeiloesAtivos() {

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;
        ArrayList<LeilaoDTO> leiloes = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM AUCTIONS WHERE STATUS = 'A'");
            while (results.next()) {
                try {
                    LeilaoDTO leilaoDTO = new LeilaoDTO();
                    leilaoDTO.setId(results.getInt(1));
                    leilaoDTO.setOwnerId(results.getInt(2));
                    leilaoDTO.setDescricao(results.getString(3));
                    leilaoDTO.setStatus(results.getString(4));
                    leilaoDTO.setComprador(results.getInt(5));
                    leiloes.add(leilaoDTO);
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

        return leiloes;

    }

    public ArrayList<LeilaoDTO> listarLeiloesPorDono(int ownerId) {

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;
        ArrayList<LeilaoDTO> leiloes = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM AUCTIONS WHERE OWNER_ID = " + ownerId);
            while (results.next()) {
                try {
                    LeilaoDTO leilaoDTO = new LeilaoDTO();
                    leilaoDTO.setId(results.getInt(1));
                    leilaoDTO.setOwnerId(results.getInt(2));
                    leilaoDTO.setDescricao(results.getString(3));
                    leilaoDTO.setStatus(results.getString(4));
                    leilaoDTO.setComprador(results.getInt(5));
                    leiloes.add(leilaoDTO);
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

        return leiloes;

    }

    public boolean fecharLeilao(int id){

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;

        try {
            stmt = conn.createStatement();
            stmt.execute("UPDATE AUCTIONS SET STATUS = 'F' WHERE ID = " + id);
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
            return false;
        }

        return true;

    }

    public boolean cancelarLeilao(int id){

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;

        try {
            stmt = conn.createStatement();
            stmt.execute("UPDATE AUCTIONS SET STATUS = 'C' WHERE ID = " + id);
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
            return false;
        }

        return true;

    }

    public boolean definirComprador(int leilaoId, int compradorId){

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;

        try {
            stmt = conn.createStatement();
            stmt.execute("UPDATE AUCTIONS SET BUYER_ID = " + compradorId + " WHERE ID = " + leilaoId);
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
            return false;
        }

        return true;

    }

}
