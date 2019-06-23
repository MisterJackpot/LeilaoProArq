package DTO;

public class UsuarioDTO {

    private int id;
    private String nickname;
    private String senha;

    public UsuarioDTO() {
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
