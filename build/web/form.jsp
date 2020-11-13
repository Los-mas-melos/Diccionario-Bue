<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="css/forms.css">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="css/fontawesome/css/all.css">
    <script defer src="css/fontawesome/js/all.js"></script>

    <title>Registro</title>
  </head>
  <body>
    <div class="modal-dialog text-center align-items-center justify-content-center">
      <div class="col-sm-8 formulario-contenedor formulario-registro">
        <div class="modal-content">
          <h1>Registro de usuario</h1>
          <form action="Crear_U" class="col-12">
            <div class="form-group" id="formulario-usuario">
                <input type="text" placeholder="Nombre de usuario" class="form-control" name="Nombre_U">
            </div>
            <div class="form-group" id="formulario-correo">
              <input type="email" placeholder="correo" class="form-control" name="Correo_U">
            </div>
            <div class="form-group" id="formulario-contrasena">
              <input type="password" placeholder="Contraseña" class="form-control" name="Clave_U">
            </div>
            <div class="form-group" id="formulario-contrasena">
              <input type="password" placeholder="Confirmar contraseña" class="form-control "name="Confirm_Clave">
            </div>
            <button type="submit" class="btn btn-primary"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-double-right" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z"/>
              <path fill-rule="evenodd" d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z"/>
            </svg>  Registrarse</button>
          </form>
          <div class="col-12 justify-content-center align-items-center text-center actions">
            <div>
              <a href="login.jsp">Ya tengo una cuenta</a>
            </div>
            <div>
              <a href="#">Soy nativo de la lengua Bue</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
  </body>
</html>