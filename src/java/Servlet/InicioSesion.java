package Servlet;

import Logica.ListNode;
import Logica.SimplyLinkedList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InicioSesion", urlPatterns = {"/Iniciar"})
public class InicioSesion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String correo = request.getParameter("Mail");
        String clave = request.getParameter("Pass");
        SimplyLinkedList listUsers = (SimplyLinkedList)request.getSession().getAttribute("listaUsuarios");
        
        ListNode aux = listUsers.getByMail(correo);
        //Falta hacer validacion con los datos de la lista enlazada de usuarios para cualquier usuario
        if (aux != null && aux.value.getMail().equals(correo) && aux.value.getPassword().equals(clave)){
            response.sendRedirect("index.jsp");
        } else{
            response.sendRedirect("login.jsp");
        }
    }

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
