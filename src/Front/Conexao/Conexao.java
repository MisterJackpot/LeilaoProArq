package Front.Conexao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Conexao {
    private static Conexao ourInstance = new Conexao();
    private Socket cliente;
    private ObjectInputStream entrada;
    private ObjectInputStream saida;

    public static Conexao getInstance() {
        return ourInstance;
    }

    private Conexao() {
        try {
            cliente = new Socket("localhost",3000);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(ObjectInputStream entrada) {
        this.entrada = entrada;
    }

    public ObjectInputStream getSaida() {
        return saida;
    }

    public void setSaida(ObjectInputStream saida) {
        this.saida = saida;
    }
}
