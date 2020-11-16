<%@page import="java.io.File"%>
<%@page import="Logica.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="css/stylesheet.css">

    <title>Diccionario Bue</title>
  </head>
  <body>
    <%
        FileManagment fileUsers = new FileManagment();
        File archivo = new File("Usuarios.bin");
        SimplyLinkedList listUsers = new SimplyLinkedList();
        if (archivo.exists()) {
            listUsers = (SimplyLinkedList)fileUsers.readObject("Usuarios.bin");
            if (archivo.isFile()) {
                System.out.println("Es un archivo");
            }
        } else {
            fileUsers.writeObject(listUsers, "Usuarios.bin");
            System.out.println("No existe el archivo");
        }
        session.setAttribute("listaUsuarios", listUsers);
    %>
    <header>
      <nav class="nav nav-pills flex-column flex-sm-row barra-navegacion">
        <a class="flex-sm-fill text-sm-center nav-link active" href="index.html">Inicio</a>
        <a class="flex-sm-fill text-sm-center nav-link boton-navegacion" href="#">Gramática</a>
        <a class="flex-sm-fill text-sm-center nav-link boton-navegacion" href="login.jsp">Iniciar sesión</a>
        <a class="flex-sm-fill text-sm-center nav-link boton-navegacion" href="form.jsp">Registro</a>
      </nav>
    </header>
    <main>
      <div class="container align-items-center">
        <div class="row justify-content-center">
          <div class="badge badge-primary text-wrap titulo" style="width: 20rem;">
            Diccionario Bue
          </div>
        </div>
          <div class="row justify-content-center">
            <div class="input-group col-8 mb-3 barra-busqueda">
              <div class="input-group-prepend">
                <button class="btn btn-outline-primary" type="button" id="button-addon1">Buscar</button>
              </div>
              <input type="text" class="form-control" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
            </div>
          </div>
      </div>
    </main>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
  </body>
</html>