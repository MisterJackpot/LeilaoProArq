package BO;

import DTO.LanceDTO;
import DTO.LeilaoDTO;

public class LeilaoFacade {
    private AuctionBO auctionBO;
    private BidBO bidBO;
    private LeilaoDTO leilaoDTO;
    private LanceDTO lanceDTO;


    public LeilaoFacade() {
        auctionBO = new AuctionBO();
        bidBO = new BidBO();
    }

    public void iniciarFacade(int idLeilao){
        leilaoDTO = auctionBO.buscarLeilaoPorId(idLeilao);
        lanceDTO = bidBO.buscarMaiorLanceDeLeilao(idLeilao);
    }

    public boolean darLance(String lance,int idUser){
        double lanceNumber = Double.parseDouble(lance);
        boolean valid = false;
        if(lanceDTO == null || lanceNumber > lanceDTO.getValor()){
            valid = bidBO.darLance(leilaoDTO.getId(),lanceNumber, idUser);
            lanceDTO = new LanceDTO();
            lanceDTO.setValor(Double.parseDouble(lance));
        }else{
            return valid;
        }
        return valid;
    }

    public boolean criarLeilao(int idUser, String desc){
        int valid = auctionBO.criarLeilao(idUser,desc);
        if (valid > 0) {
            iniciarFacade(valid);
            return true;
        }
        else return false;
    }

    public boolean administrarLeilao(String op){
        switch (op){
            case "Encerrar":
                auctionBO.encerrarLeilao(leilaoDTO.getId());
                break;
            case "Cancelar":
                auctionBO.cancelarLeilao(leilaoDTO.getId());
                break;
            default:
                return false;
        }
        return true;
    }

    public LeilaoDTO getLeilaoDTO() {
        return leilaoDTO;
    }

    public LanceDTO getLanceDTO() {
        return lanceDTO;
    }
}
