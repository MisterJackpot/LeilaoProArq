package Controller;

import Model.AbstractCliente;
import Model.Vendedor;

public class LoginController {

    public LoginController(){

    }

    public AbstractCliente logar(String usuario, String senha){
        System.out.println(usuario + " - " + senha);

        //Pegar do DAO e validar senha
        Vendedor vendedor = new Vendedor(usuario,1);
        return vendedor;
    }

}
