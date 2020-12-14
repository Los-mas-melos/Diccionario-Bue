package Servlet;

import Logica.Exceptions.NotFoundWordException;
import Logica.LastWords;
import Logica.Word;
import Logica.Words;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BuscarEntrada", urlPatterns = {"/Buscar_E"})
public class BuscarEntrada extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        LastWords lastWords = (LastWords)request.getSession().getAttribute("ultimasPalabras");
        Words words = (Words)request.getSession().getAttribute("palabras");
        String query = request.getParameter("Word_Query").toLowerCase();
        String translation = "Traduccion";
        String category = request.getParameter("Categoria_Palabra");
        Word result = null;
        try {
            result = words.search(query);
            if (result != null) {
                translation = result.getTranslation().getName();
            } else {
                query = "";
            }
        } catch (NotFoundWordException notFoundWordException) {
            query = "";
        }   
        
        if(!query.equals("")) {
            lastWords.addWord(query);
        }
                
        request.getSession().setAttribute("palabraEncontrada", query);
        request.getSession().setAttribute("palabraTraducida", translation);
        request.getSession().setAttribute("ultimasPalabras", lastWords);
        response.sendRedirect("result.jsp");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }

}
