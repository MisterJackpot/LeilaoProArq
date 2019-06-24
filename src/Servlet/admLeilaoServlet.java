package Servlet;

import BO.LeilaoFacade;
import DTO.UsuarioDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admLeilao")
public class admLeilaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDTO usuarioDTO = (UsuarioDTO) req.getSession().getAttribute("cliente");

        String op = req.getParameter("op");
        int id = Integer.parseInt(req.getParameter("id"));

        LeilaoFacade leilaoFacade = new LeilaoFacade();
        leilaoFacade.iniciarFacade(id);

        boolean valid = leilaoFacade.administrarLeilao(op);

        if(valid){
            req.getRequestDispatcher("Login").include(req,resp);
        }


    }
}
