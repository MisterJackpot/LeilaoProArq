package Servlet;

import BO.LeilaoFacade;
import DTO.UsuarioDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/adminDetalhes")
public class AdminDetalhesServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDTO usuarioDTO = (UsuarioDTO) req.getSession().getAttribute("cliente");
        int idLeilao = Integer.parseInt(req.getParameter("id"));

        LeilaoFacade leilaoFacade = new LeilaoFacade();
        leilaoFacade.iniciarFacade(idLeilao);

        req.setAttribute("leilao",leilaoFacade.getLeilaoDTO());
        req.setAttribute("lance",leilaoFacade.getLanceDTO());
        req.getRequestDispatcher("/view/AdminDetalhes.jsp").include(req,resp);
    }
}
