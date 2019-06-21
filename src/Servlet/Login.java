package Servlet;

import Controller.LoginController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        boolean validation = loginController.logar(req.getParameter("usuario"),req.getParameter("senha"));

        if(validation) {
            req.getRequestDispatcher("/view/MenuGeral.jsp").include(req, resp);
        }else{
            resp.sendError(1);
        }
    }
}
