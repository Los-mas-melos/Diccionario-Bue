package Servlet;

import Logica.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Editar_U"})
public class EditarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nameA = request.getParameter("Nombre_U_A");
        String mailA = request.getParameter("Correo_U_A").toLowerCase();
        String passwordA = request.getParameter("Clave_U_A");
        String validatePasswordA = request.getParameter("Confirm_Clave_A");
        SimplyLinkedList listUsers = (SimplyLinkedList)request.getSession().getAttribute("listaUsuarios");
        ListNode aux = listUsers.getByMail(mailA);
        
        if (passwordA.equals(validatePasswordA)) {
            aux.value.setName(nameA);
            aux.value.setPassword(passwordA);
            aux.value.setMail(mailA);
            request.getSession().setAttribute("listaUsuarios", listUsers);
            FileManagment fileUsers = new FileManagment();
            fileUsers.writeObject(listUsers, "Usuarios.bin");
            response.sendRedirect("adminUsuarios.jsp");
        }
        else{
            response.sendRedirect("adminUsuarios.jsp");
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
