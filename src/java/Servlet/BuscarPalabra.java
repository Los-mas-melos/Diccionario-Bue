package Servlet;

import Logica.AVLTree;
import Logica.Exceptions.NotFoundWordException;
import Logica.Word;
import Logica.Words;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BuscarPalabra", urlPatterns = {"/Buscar_P"})
public class BuscarPalabra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NotFoundWordException {
        response.setContentType("text/html;charset=UTF-8");
        
        AVLTree<Word> AvlTreeBue = (AVLTree<Word>)request.getSession().getAttribute("arbolBue");
        AVLTree<Word> AvlTreeSpanish = (AVLTree<Word>)request.getSession().getAttribute("arbolBue");
        Words words = (Words)request.getSession().getAttribute("palabras");
        String query = request.getParameter("Word_Query").toLowerCase();
        String translation = "";
        String category = request.getParameter("Categoria_Palabra");
        Word result = null;
        try{
            result = words.search(query);
            translation = result.getTranslation().getName();
            
        } catch(NotFoundWordException notFoundWordException){
            query = "";
        }
        
//        if(category.equals("Espanol-Bue")) {
//            //result = words.search(query);
//            if(result != null) {
//                translation = result.getTranslation().getName();
//            } else {
//                query = "";
//            }
//        } else if(category.equals("Bue-Espanol")) {
//            //result = words.search(query);
//            if(result != null) {
//                translation = result.getTranslation().getName();
//            } else {
//                query = "";
//            }
            
//        }
        
        request.getSession().setAttribute("palabraEncontrada", query);//query
        request.getSession().setAttribute("palabraTraducida", translation);//query
        response.sendRedirect("result.jsp");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
