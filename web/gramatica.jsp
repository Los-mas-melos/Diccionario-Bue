<%@page import="Logica.LastWords"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="css/open-iconic-master/font/css/open-iconic-bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="css/result.css">

        <title>Diccionario Bue</title>
    </head>
    <body>
        <%
            LastWords lastWords = (LastWords) session.getAttribute("ultimasPalabras");
        %>
        <header>
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-auto hidden-sm-down justify-content-center logo">
                        <a href="index.jsp" class="">Diccionario Bue</a>
                    </div>
                    <div class="col-12 col-sm-8 col-lg-8 buscar">
                        <form action="Buscar_E">
                            <div class="row no-gutters align-items-center">
                                <div class="col-6">
                                    <input type="text" id="" placeholder="Buscar" name="Word_Query">
                                </div>
                                <div class="col-2">
                                    <button type="submit"><span class="oi oi-magnifying-glass"></span></button>
                                </div>
                                <div class="dropdown col-4 ml-auto">
                                    <select class="custom-select btn btn-primary dropdown-toggle language" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" name="Categoria_Palabra">
                                        <option value="Espanol-Bue">Español-Bue</option>
                                        <option value="Bue-Espanol">Bue-Español</option>
                                    </select>
                                </div>

                            </div>
                        </form>
                    </div>
                    <nav class="col-8 col-lg-1 d-flex justify-content-between menu">
                        <a href="gramatica.jsp" title="Gramática"><span class="oi oi-book"></span></a>
                        <a href="#" title="Palabras favoritas"><span class="oi oi-bookmark"></span></a>
                        <a href="#" title="Usuario"><span class="oi oi-person"></span></a>
                    </nav>
                </div>
            </div>
        </header>
        <main class="container">
            <div class="row justify-content-center">
                <div class="col-10 col-md-3 col-lg-2 left-sidebar">
                    <nav>

                        <h6>Historial de palabras</h6>
                        <% for (int j = 0; j < 10; j++) {


                        %>
                        <a href="#"><%= lastWords.getArrayQueue().toString()%></a>
                        <%
                            }
                        %>
                    </nav>

                </div>
                    <div class="col-10 col-md-9 col-lg-10 main-content">
                    <div class="row justify-content-center">
                        <div class="col-10 title-word">
                            <h1>Gramática</h1>
                            Categoría gramatical
                            <h4>Palabras</h4>  
                        </div>
                        <div class="row justify-content-center">
                            <div class="col-10 meaning">
                                Ejemplo: Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem dolor ex, odio, architecto, quos a eum mollitia consectetur quia voluptas voluptates nesciunt libero autem quas! Natus tempore dolorem velit unde.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
