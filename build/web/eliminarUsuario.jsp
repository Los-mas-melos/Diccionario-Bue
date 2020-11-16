<%@page import="Logica.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar usuario</title>
    </head>
    <body>
        <%
            String correo = request.getParameter("Correo");
            SimplyLinkedList listUsers = (SimplyLinkedList)session.getAttribute("listaUsuarios");
            listUsers.deleteByMail(correo);
            request.getSession().setAttribute("listaUsuarios", listUsers);
            FileManagment fileUsers = new FileManagment();
            fileUsers.writeObject(listUsers, "Usuarios.bin");
            response.sendRedirect("adminUsuarios.jsp");
        %>
    </body>
</html>
