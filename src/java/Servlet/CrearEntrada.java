package Servlet;

import Logica.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CrearEntrada", urlPatterns = {"/Crear_E"})
public class CrearEntrada extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String bue = request.getParameter("Palabra_Bue");
        String spanish = request.getParameter("Palabra_Espanol");
        Words words = (Words)request.getSession().getAttribute("palabras");
        DoubleDataNodeList listBueEsp = (DoubleDataNodeList)request.getSession().getAttribute("listaPalabras");
        listBueEsp.insert(bue, spanish);
        words.insertWord(bue, spanish);
        request.getSession().setAttribute("listaPalabras", listBueEsp);
        request.getSession().setAttribute("palabras", words);
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
