<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="Logica.*"%>
<%@page contentType="text/html; charset=UTF-8"%>
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
            //Lista de usuarios
            FileManagment fileUsers = new FileManagment();
            File binUsers = new File("Usuarios.bin");
            SimplyLinkedList listUsers = new SimplyLinkedList();
            if (binUsers.exists()) {
                listUsers = (SimplyLinkedList) fileUsers.readObject("Usuarios.bin");
                System.out.println("Existe el archivo de usuarios");
            } else {
                fileUsers.writeObject(listUsers, "Usuarios.bin");
                System.out.println("No existe el archivo de usuarios");
            }
            session.setAttribute("listaUsuarios", listUsers);

            //Lectura archivo palabras
            DoubleDataNodeList listBueEsp = new DoubleDataNodeList();
            String cadena;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Estudiante\\Documents\\Estructuras de datos\\Diccionario-Bue\\Transcripción_Bue-Esp.txt"), "utf-8"));

            while ((cadena = br.readLine()) != null) {
                String[] partes;
                partes = cadena.split("\t\t");
                String part1 = partes[0];
                String part2 = partes[1];

                listBueEsp.insert(part1, part2);
            }
            br.close();

            //Arreglo circular de palabras
            LastWords lastWords = new LastWords();
            for (int i = 0; i < 10; i++) {
                lastWords.addWord("");
            }
            //Arboles de palabras
            AVLTree<Word> AvlTreeBue = new AVLTree();
            AVLTree<Word> AvlTreeSpanish = new AVLTree();
            Words words = new Words();
            words.setStorageWordsSpanish(AvlTreeSpanish);
            words.setStorageWordsBue(AvlTreeBue);

            DoubleDataNode aux = listBueEsp.first;
            while (aux != null) {
                words.insertWord(aux.bue, aux.espanol);
                aux = aux.next;
            }

            session.setAttribute("ultimasPalabras", lastWords);
            session.setAttribute("listaPalabras", listBueEsp);
            session.setAttribute("palabras", words);

        %>
        <header>
            <nav class="nav nav-pills flex-column flex-sm-row barra-navegacion">
                <a class="flex-sm-fill text-sm-center nav-link active" href="index.jsp">Inicio</a>
                <a class="flex-sm-fill text-sm-center nav-link boton-navegacion" href="gramatica.jsp">Gramática</a>
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
                <form action="Buscar_E">
                    <div class="row justify-content-center no-gutters">
                        <div class="input-group col-8 col-lg-6 barra-busqueda">
                            <div class="input-group-prepend">
                                <button class="btn btn-outline-primary" type="submit" id="button-addon1">Buscar</button>
                            </div>
                            <input type="text" class="form-control" placeholder="" aria-label="Busqueda" aria-describedby="button-addon1" name="Word_Query">
                        </div>
                        <div class="dropdown col-4 col-md-3 col-lg-2 barra-busqueda">
                            <select class="custom-select btn btn-primary dropdown-toggle language" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" name="Categoria_Palabra">
                                <option value="Espanol-Bue">Español-Bue</option>
                                <option value="Bue-Espanol">Bue-Español</option>
                            </select>
                        </div>

                    </div>
                </form>

            </div>
        </main>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>