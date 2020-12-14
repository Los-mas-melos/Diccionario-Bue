<%@page import="Logica.DoubleDataNodeList"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar palabra</title>
    </head>
    <body>
        <%
            String bue = request.getParameter("Bue");
            DoubleDataNodeList listBueEsp = (DoubleDataNodeList) session.getAttribute("listaPalabras");
            listBueEsp.deleteByBue(bue);
            request.getSession().setAttribute("listaPalabras", listBueEsp);
            response.sendRedirect("adminPalabras.jsp");
        %>
    </body>
</html>
