package Servlet;

import BO.ListaFacade;
import DTO.UsuarioDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDTO usuarioDTO = (UsuarioDTO) req.getSession().getAttribute("cliente");

        ListaFacade listaFacade = new ListaFacade(usuarioDTO.getId());

        if(usuarioDTO.getId() != 201) {
            req.setAttribute("leiloes",listaFacade.getLeiloesAtivos());
            req.setAttribute("meusLeiloes",listaFacade.getMeusLeiloes());
            req.getRequestDispatcher("/view/PaginaInicial.jsp").include(req, resp);
        }else{
            req.setAttribute("leiloes",listaFacade.getTodosLeiloes());
            req.getRequestDispatcher("/view/AdminPrincipal.jsp").include(req, resp);
        }

    }
}
