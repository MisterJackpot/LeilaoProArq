package Servlet;

import BO.LeilaoFacade;
import BO.ListaFacade;
import DTO.UsuarioDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admLeilao")
public class AdmLeilaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDTO usuarioDTO = (UsuarioDTO) req.getSession().getAttribute("cliente");

        String op = req.getParameter("op");
        int id = Integer.parseInt(req.getParameter("id"));

        LeilaoFacade leilaoFacade = new LeilaoFacade();
        leilaoFacade.iniciarFacade(id);

        boolean valid = leilaoFacade.administrarLeilao(op);

        ListaFacade listaFacade = new ListaFacade(usuarioDTO.getId());

        if(valid){
            req.setAttribute("leiloes",listaFacade.getLeiloesAtivos());
            req.setAttribute("meusLeiloes",listaFacade.getMeusLeiloes());
            req.getRequestDispatcher("/view/PaginaInicial.jsp").include(req, resp);
        }


    }
}
