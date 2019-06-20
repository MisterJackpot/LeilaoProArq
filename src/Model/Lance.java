package Model;

public class Lance {
    private AbstractCliente cliente;
    private double value;

    public Lance(AbstractCliente cliente, double value) {
        this.cliente = cliente;
        this.value = value;
    }

    public AbstractCliente getCliente() {
        return cliente;
    }

    public void setCliente(AbstractCliente cliente) {
        this.cliente = cliente;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
