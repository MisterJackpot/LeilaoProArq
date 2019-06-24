package BO;

import DAO.UserDAO;
import DTO.UsuarioDTO;

public class UserBO {

    private UserDAO userDAO = new UserDAO();

    public void criarUsuario(String nickname, String senha){

        this.userDAO.criarUsuario(nickname, senha);

    }

    public UsuarioDTO buscarUsuarioPorNickname(String nickname){

        return this.userDAO.buscarUsuarioPorNickname(nickname);

    }

    public UsuarioDTO buscarUsuarioPorId(int id){

        return this.userDAO.buscarUsuarioPorId(id);

    }

    public UsuarioDTO efetuarLogin(String nickname, String senha){

        try{
            UsuarioDTO usuarioDTO = userDAO.buscarUsuarioPorNickname(nickname);
            if (usuarioDTO.getSenha().equals(senha)) return usuarioDTO;
            else return null;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
