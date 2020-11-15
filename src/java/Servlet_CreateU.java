import Logica.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Crear_U"})
public class Servlet_CreateU extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("Nombre_U");
        String mail = request.getParameter("Correo_U");
        String password = request.getParameter("Clave_U");
        String validatePassword = request.getParameter("Confirm_Clave");
        SimplyLinkedList<User> listUsers = (SimplyLinkedList<User>)request.getSession().getAttribute("listaUsuarios");
        
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
    }  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
