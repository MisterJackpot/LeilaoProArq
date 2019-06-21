package Model;

public class Header {
    private String servico;
    private int clienteID;

    public Header(String servico, int clienteID) {
        this.servico = servico;
        this.clienteID = clienteID;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }
}
