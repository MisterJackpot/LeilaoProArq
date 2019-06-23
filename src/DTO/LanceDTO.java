package DTO;

public class LanceDTO {

    private int id;
    private int leilaoId;
    private int bidOwner;
    private double valor;

    public LanceDTO(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeilaoId() {
        return leilaoId;
    }

    public void setLeilaoId(int leilaoId) {
        this.leilaoId = leilaoId;
    }

    public int getBidOwner() {
        return bidOwner;
    }

    public void setBidOwner(int bidOwner) {
        this.bidOwner = bidOwner;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
