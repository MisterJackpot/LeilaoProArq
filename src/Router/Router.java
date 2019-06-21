package Router;

import Model.Header;

import java.io.IOException;
import java.io.ObjectInputStream;
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
            Header header = (Header) entrada.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
