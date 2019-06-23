package Model;

public class Leilao {
    private String nome;
    private double utlimoLance;

    public Leilao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getUtlimoLance() {
        return utlimoLance;
    }

    public void setUtlimoLance(double utlimoLance) {
        this.utlimoLance = utlimoLance;
    }
}
