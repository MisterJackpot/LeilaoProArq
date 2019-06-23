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

}
