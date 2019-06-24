package Servlet;

import BO.ListaFacade;
import BO.UserBO;
import DTO.UsuarioDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.toString());

        UserBO userBO = new UserBO();
        UsuarioDTO cliente = userBO.efetuarLogin(req.getParameter("usuario"), req.getParameter("senha"));
        ListaFacade listaFacade = new ListaFacade(cliente.getId());


        if(cliente.getId() != 201) {
            req.getSession().setAttribute("cliente",cliente);
            req.setAttribute("leiloes",listaFacade.getLeiloesAtivos());
            req.setAttribute("meusLeiloes",listaFacade.getMeusLeiloes());
            req.getRequestDispatcher("/view/PaginaInicial.jsp").include(req, resp);
        }else{
            req.getSession().setAttribute("cliente",cliente);
            req.setAttribute("leiloes",listaFacade.getTodosLeiloes());
            req.getRequestDispatcher("/view/AdminPrincipal.jsp").include(req, resp);
        }
    }
}
