package Front.Controller;

public class LoginController {

    public LoginController(){

    }

    public boolean login(String usuario, String senha){
        //chamar serviço para criar conexão com servidor e realizar login
        System.out.println(usuario + " - " + senha);
        return true;
    }

}
