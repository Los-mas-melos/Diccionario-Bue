package Servlet;

import Logica.AVLTree;
import Logica.Word;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BuscarPalabra", urlPatterns = {"/Buscar_P"})
public class BuscarPalabra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        AVLTree<Word> AvlTreeBue = (AVLTree<Word>)request.getSession().getAttribute("arbolBue");
        AVLTree<Word> AvlTreeSpanish = (AVLTree<Word>)request.getSession().getAttribute("arbolBue");
        String query = request.getParameter("Word_Query");
        String translation = "traducción";
        request.getSession().setAttribute("palabraEncontrada", query);//query
        request.getSession().setAttribute("palabraTraducida", translation);//query
        response.sendRedirect("result.jsp");
        
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
