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
        String category = request.getParameter("Categoria_Palabra");
        String description = request.getParameter("Descripcion");
        
        AVLTree<Word> AvlTreeBue = (AVLTree<Word>)request.getSession().getAttribute("arbolBue");
        AVLTree<Word> AvlTreeSpanish = (AVLTree<Word>)request.getSession().getAttribute("arbolEspanol");
        Words words = (Words)request.getSession().getAttribute("palabras");
        
        FileManagment fileBueWords = new FileManagment();
        FileManagment fileSpanishWords = new FileManagment();
        
        words.insertWord(bue, spanish);
        request.getSession().setAttribute("arbolBue", AvlTreeBue);
        request.getSession().setAttribute("arbolEspanol", AvlTreeSpanish);
        request.getSession().setAttribute("palabras", words);
        fileBueWords.writeObject(AvlTreeBue, "Bue.bin");
        fileSpanishWords.writeObject(AvlTreeBue, "Espanol.bin");
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
