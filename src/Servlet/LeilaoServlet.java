package Servlet;

import Model.Leilao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/leilao")
public class LeilaoServlet extends HttpServlet {

    private String s;

    public LeilaoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("GET");

        this.doPost(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getQueryString());
        String values[] = req.getParameterValues("nome");
        if(values[0] == null){
            values[0] = (String) req.getAttribute("nome");
        }
        System.out.println(values[0]);
        s = values[0];
        String lance = req.getParameter("lance");
        Leilao l = new Leilao(s);
        l.setUtlimoLance(250.5);
        if(lance != null){
            float lanceNumber = Float.parseFloat(lance);
            if(lanceNumber > 250.5){
                l.setUtlimoLance(lanceNumber);
            }
        }

        System.out.println("POST");

        req.setAttribute("leilao",l);
        req.getRequestDispatcher("/view/LeilaoDetalhado.jsp").include(req,resp);
    }
}
