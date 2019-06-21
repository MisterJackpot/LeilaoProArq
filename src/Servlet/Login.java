package Servlet;

import Controller.LeilaoController;
import Controller.LoginController;
import Model.AbstractCliente;
import Model.Leilao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.toString());

        LoginController loginController = new LoginController();
        LeilaoController leilaoController = new LeilaoController();
        AbstractCliente cliente = loginController.logar(req.getParameter("usuario"),req.getParameter("senha"));
        ArrayList<Leilao>  leiloes = leilaoController.getLeiloesAtivos();

        if(cliente != null) {
            req.setAttribute("cliente",cliente);
            req.getSession().setAttribute("cliente",cliente);
            req.setAttribute("leiloes",leiloes);
            req.getRequestDispatcher("/view/PaginaInicial.jsp").include(req, resp);
        }else{
            resp.sendError(1);
        }
    }
}
