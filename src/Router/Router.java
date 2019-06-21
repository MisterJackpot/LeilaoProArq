package Router;

import Controller.LoginController;
import Model.AbstractCliente;
import Model.Header;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Router {
    private ServerSocket server = null;
    public Router(){
        try {
             server = new ServerSocket(3000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(this::routing).start();
    }

    public void routing(){
        Socket client = null;
        try {
            client = server.accept();

            System.out.println("Cliente conectado: " + client.getInetAddress().getHostAddress());

            ObjectInputStream entrada = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream saida = new ObjectOutputStream(client.getOutputStream());
            Header header = (Header) entrada.readObject();



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public boolean rout(String servico,ObjectInputStream entrada, ObjectOutputStream saida) throws IOException, ClassNotFoundException {
        switch (servico){
            case "Login":
                String usuario = (String) entrada.readObject();
                String senha = (String) entrada.readObject();
                //Chamar controller de login
                LoginController loginController = new LoginController();
                AbstractCliente cliente = loginController.logar(usuario,senha);
                saida.flush();
                saida.writeObject(cliente);
                break;
            default:
                System.out.println("Serviço Invalido");
                return false;
        }




        return true;
    }

}
