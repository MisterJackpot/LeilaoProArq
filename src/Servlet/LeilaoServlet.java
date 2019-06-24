package Servlet;

import BO.LeilaoFacade;
import DTO.UsuarioDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/leilao")
public class LeilaoServlet extends HttpServlet {


    public LeilaoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("serv","detalhe");

        this.doPost(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDTO usuarioDTO = (UsuarioDTO) req.getSession().getAttribute("cliente");

        String value = req.getParameter("id");
        String lance = req.getParameter("lance");

        if(value == null){
            value = req.getParameter("id");
        }
        int idLeilao = Integer.parseInt(value);

        LeilaoFacade leilaoFacade = new LeilaoFacade();
        leilaoFacade.iniciarFacade(idLeilao);

        if(lance != null){
            if(!leilaoFacade.darLance(lance,usuarioDTO.getId())){
                req.setAttribute("erro","ERRO");
            }
        }


        req.setAttribute("leilao",leilaoFacade.getLeilaoDTO());
        req.setAttribute("lance",leilaoFacade.getLanceDTO());
        req.getRequestDispatcher("/view/LeilaoDetalhado.jsp").include(req,resp);
    }
}
