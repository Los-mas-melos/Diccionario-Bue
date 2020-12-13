package Servlet;

import Logica.DoubleDataNode;
import Logica.DoubleDataNodeList;
import Logica.SimplyLinkedList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditarEntrada", urlPatterns = {"/Editar_E"})
public class EditarEntrada extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String espanolA = request.getParameter("Espanol_A");
        String bueA = request.getParameter("Bue_A");
        DoubleDataNodeList listBueEsp = (DoubleDataNodeList)request.getSession().getAttribute("listaPalabras");
        DoubleDataNode aux = listBueEsp.getByBue(bueA);
        
            aux.bue = bueA;
            aux.espanol = espanolA;
            request.getSession().setAttribute("listaPalabras", listBueEsp);
            response.sendRedirect("adminPalabras.jsp");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
