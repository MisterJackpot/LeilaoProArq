package DTO;

public class LeilaoDTO {

    private int id;
    private int ownerId;
    private String descricao;
    private String status;
    private int comprador;

    public LeilaoDTO(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getComprador() {
        return comprador;
    }

    public void setComprador(int comprador) {
        this.comprador = comprador;
    }
}
