package DAO;

import DTO.UsuarioDTO;
import Database.SingletonConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    public boolean criarUsuario(String nickname, String senha){

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;
        nickname = nickname.toUpperCase();

        try
        {
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO USERS (NICKNAME, PASSWORD) VALUES ('" + nickname + "', '" + senha + "')");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
            return false;
        }

        return true;

    }

    public UsuarioDTO buscarUsuarioPorNickname(String nickname){

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        nickname = nickname.toUpperCase();

        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM USERS WHERE NICKNAME = '" + nickname + "'");
            results.next();
            try {
                usuarioDTO.setId(results.getInt(1));
                usuarioDTO.setNickname(results.getString(2));
                usuarioDTO.setSenha(results.getString(3));
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

        return usuarioDTO;

    }

    public UsuarioDTO buscarUsuarioPorId(int id){

        java.sql.Connection conn = SingletonConnection.getInstance().getConnection();
        Statement stmt;
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM USERS WHERE ID = " + id);
            results.next();
            try {
                usuarioDTO.setId(results.getInt(1));
                usuarioDTO.setNickname(results.getString(2));
                usuarioDTO.setSenha(results.getString(3));
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

        return usuarioDTO;

    }

}
