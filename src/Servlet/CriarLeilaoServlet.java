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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDTO usuarioDTO = (UsuarioDTO) req.getSession().getAttribute("cliente");
        String desc = req.getParameter("desc");
        String id = req.getParameter("id");
        LeilaoFacade leilaoFacade = new LeilaoFacade();





        if(id != null){
            int idN = Integer.parseInt(id);
            leilaoFacade.iniciarFacade(idN);
        }else {
            leilaoFacade.criarLeilao(usuarioDTO.getId(), desc);
        }

        req.setAttribute("leilao", leilaoFacade.getLeilaoDTO());
        req.setAttribute("lance", leilaoFacade.getLanceDTO());
        req.getRequestDispatcher("/view/LeilaoPropio.jsp").include(req, resp);

    }


}
