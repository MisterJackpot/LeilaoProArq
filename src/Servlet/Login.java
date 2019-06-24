package Servlet;

import BO.AuctionBO;
import BO.UserBO;
import Controller.LeilaoController;
import Controller.LoginController;
import DTO.LeilaoDTO;
import DTO.UsuarioDTO;
import Model.AbstractCliente;
import Model.Leilao;

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

        UserBO userBO = new UserBO();
        UsuarioDTO cliente;
        if(req.getSession().getAttribute("usuario") == null) {
             cliente = userBO.efetuarLogin(req.getParameter("usuario"), req.getParameter("senha"));
        }else{
             cliente = (UsuarioDTO) req.getSession().getAttribute("usuario");
        }
        AuctionBO auctionBO = new AuctionBO();
        ArrayList<LeilaoDTO> leiloes = auctionBO.listarLeiloesAtivos();
        ArrayList<LeilaoDTO> meusLeiloes = auctionBO.listarLeiloesPorDono(cliente.getId());

        if(cliente != null) {
            req.getSession().setAttribute("cliente",cliente);
            req.setAttribute("leiloes",leiloes);
            req.setAttribute("meusLeiloes",meusLeiloes);
            req.getRequestDispatcher("/view/PaginaInicial.jsp").include(req, resp);
        }else{
            resp.sendError(1);
        }
    }
}
