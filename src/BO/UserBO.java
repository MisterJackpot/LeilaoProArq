package BO;

import DAO.UserDAO;

public class UserBO {

    private UserDAO userDAO = new UserDAO();

    public void criarUsuario(String nickname, String senha){

        this.userDAO.criarUsuario(nickname, senha);

    }

    public void buscarUsuarioPorNickname(String nickname){

        this.userDAO.buscarUsuarioPorNickname(nickname);

    }

    public void buscarUsuarioPorId(int id){

        this.userDAO.buscarUsuarioPorId(id);

    }

}
