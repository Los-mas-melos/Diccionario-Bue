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
    <link href="css/open-iconic-master/font/css/open-iconic-bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/stylesheet.css">

    <title>Administración de usuarios</title>
  </head>
  <body>
    <header>

    </header>
    <div class="container align-items-center">
      <div class="row justify-content-center">
        <div class="badge badge-primary text-wrap users-title" style="width: 20rem;">
          Usuarios
        </div>
      </div>
        <div class="row justify-content-center">
            <table class="table users-table">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Contraseña</th>
                    <th scope="col">Acciones</th>
                  </tr>
                </thead>
                <tbody>
                  <%
                      SimplyLinkedList listUsers = (SimplyLinkedList)session.getAttribute("listaUsuarios");
                      ListNode aux = listUsers.first;
                      boolean emptyList = false;
                      if(aux != null) {
                          int count = 1;
                          while(aux != null) {
                              
                  %>
                  <tr>
                    <th scope="row"><%= count%></th>
                    <td><%= aux.value.getName()%></td>
                    <td><%= aux.value.getMail()%></td>
                    <td><%= aux.value.getPassword()%></td>
                    <td>
                        <a href="editarUsuario.jsp?Id=<%=count%>&Nombre=<%=aux.value.getName()%>&Correo=<%=aux.value.getMail()%>&Contrasena=<%=aux.value.getPassword()%>" title="Editar" class="edit-user"><span class="oi oi-pencil"></span></a>
                        <a href="eliminarUsuario.jsp?Correo=<%=aux.value.getMail()%>" title="Eliminar" class="delete-user"><span class="oi oi-x"></span></a>
                    </td>
                  </tr>
                  <%
                                count++;
                                aux = aux.next;
                            }
                        } else {
                            emptyList = true;
                        }
                  %>
                </tbody>
            </table>
        </div>
        <%
            if(emptyList) {
        %>
        <div class="row justify-content-center">
            <div class="alert alert-danger no-users" role="alert">
                No hay usuarios registrados
            </div>
        </div>
        
        <%
            }
        %>
        <div class="row justify-content-center">
            <a class="btn btn-dark create-user" href="form.jsp" role="button">Crear nuevo usuario</a>
        </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
  </body>
</html>