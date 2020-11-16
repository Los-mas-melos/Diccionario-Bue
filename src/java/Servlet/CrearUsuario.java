package Servlet;

import Logica.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Crear_U"})
public class CrearUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String name = request.getParameter("Nombre_U");
        String mail = request.getParameter("Correo_U").toLowerCase();
        String password = request.getParameter("Clave_U");
        String validatePassword = request.getParameter("Confirm_Clave");
        SimplyLinkedList listUsers = (SimplyLinkedList)request.getSession().getAttribute("listaUsuarios");
        
        if (password.equals(validatePassword)) {
            User newUser = new User(name, mail, password);
            listUsers.insert(newUser);
            request.getSession().setAttribute("listaUsuarios", listUsers);
            FileManagment fileUsers = new FileManagment();
            fileUsers.writeObject(listUsers, "Usuarios.bin");
            response.sendRedirect("login.jsp");
        }
        else{
            response.sendRedirect("form.jsp");
        }
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
