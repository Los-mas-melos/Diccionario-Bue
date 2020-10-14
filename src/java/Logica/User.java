package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class User {
    public void find() {
        File fichero = new File("C:\\Users\\Julian Manosalva\\Desktop\\Usuarios.txt");

        String busqueda;
        String respuesta;

        try {
            BufferedReader fil = new BufferedReader(new FileReader(fichero));
            String usuario = "Lionel--LM--2021"; //Aqui se pone la entrada desde la parte visual
            busqueda = usuario;

            String linea;
            boolean encontrado = false;
            while ((linea = fil.readLine()) != null) {

                if (linea.toUpperCase().equalsIgnoreCase(busqueda)) {

                    respuesta = "Usuario\n" + linea + "\n";
                    for (int i = 0; i < 6; i++) {
                        respuesta += fil.readLine() + "\n";
                    }
                    System.out.println("Usuario encontrado");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                //Aqui se permite el acceso al app
                System.out.println("El susuario no se ha encontrado");
            }
        } catch (IOException e) {

            System.out.println("Ha ocurrido un Error" + e);
        }
    }
    
    public void read() {
        
        //SimpleLinkedList<String> myList = new SimpleLinkedList<>();

        File f = new File( "C:\\Users\\Julian Manosalva\\Desktop\\Usuarios.txt");// Cambiar por una ruta relativa
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader( new FileReader( f ) );
            String linea;
            while(entrada.ready()){
                linea = entrada.readLine();
                //myList.insert(linea);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            try{
                entrada.close();
            }catch(IOException e1){}
        }
        //System.out.println(myList.toString()); Pillar bien
        //search_User busqueda = new search_User();
        //busqueda.buscar();
    }
}
