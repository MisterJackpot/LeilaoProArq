package Servlet;

import BO.AuctionBO;
import BO.LeilaoFacade;
import DTO.UsuarioDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/criarLeilao")
public class CriarLeilaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDTO usuarioDTO = (UsuarioDTO) req.getSession().getAttribute("cliente");
        String desc = req.getParameter("desc");
        String serv = req.getParameter("serv");
        LeilaoFacade leilaoFacade = new LeilaoFacade();





        boolean valid = leilaoFacade.criarLeilao(usuarioDTO.getId(),desc);


        if(valid) {
            req.setAttribute("leilao", leilaoFacade.getLeilaoDTO());
            req.setAttribute("lance", leilaoFacade.getLanceDTO());
            req.getRequestDispatcher("/view/LeilaoPropio.jsp").include(req, resp);
        }
    }


}
