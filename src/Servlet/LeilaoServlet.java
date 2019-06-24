package Servlet;

import BO.AuctionBO;
import BO.BidBO;
import DTO.LanceDTO;
import DTO.LeilaoDTO;
import DTO.UsuarioDTO;
import Model.Leilao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/leilao")
public class LeilaoServlet extends HttpServlet {

    private String s;

    public LeilaoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("GET");
        req.setAttribute("serv","detalhe");

        this.doPost(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("serv"));
        String values[] = req.getParameterValues("id");
        UsuarioDTO usuarioDTO = (UsuarioDTO) req.getSession().getAttribute("cliente");
        if(values[0] == null){
            values[0] = req.getParameter("id");
        }
        System.out.println(values[0]);
        s = values[0];
        int leilaoID = Integer.parseInt(s);
        AuctionBO auctionBO = new AuctionBO();
        BidBO bidBO = new BidBO();
        LeilaoDTO leilaoDTO = auctionBO.buscarLeilaoPorId(leilaoID);
        LanceDTO lanceDTO = bidBO.buscarMaiorLanceDeLeilao(leilaoID);
        String lance = req.getParameter("lance");
        if(lance != null){
            double lanceNumber = Double.parseDouble(lance);
            if(lanceDTO == null || lanceNumber > lanceDTO.getValor()){
                boolean valid = bidBO.darLance(leilaoID,lanceNumber, usuarioDTO.getId());
                lanceDTO = new LanceDTO();
                lanceDTO.setValor(Double.parseDouble(lance));
            }
        }

        System.out.println("POST");

        req.setAttribute("leilao",leilaoDTO);
        req.setAttribute("lance",lanceDTO);
        req.getRequestDispatcher("/view/LeilaoDetalhado.jsp").include(req,resp);
    }
}
