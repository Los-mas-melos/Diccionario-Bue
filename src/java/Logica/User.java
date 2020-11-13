package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class User {
    
    final String archivoUsuarios = "src/java/Datos/Usuarios.txt";
    Path rutaUsuarios = Paths.get(archivoUsuarios);
    
    public boolean find(String user) {
        File fichero = rutaUsuarios.toFile();

        String busqueda;
        String respuesta;
        
        boolean encontrado = false;

        try {
            
            BufferedReader fil = new BufferedReader(new FileReader(fichero));
            String usuario = user; //Aqui se pone la entrada desde la parte visual
            busqueda = usuario;

            String linea;
            while ((linea = fil.readLine()) != null) {

                if (linea.toUpperCase().equalsIgnoreCase(busqueda)) {

                    respuesta = "Usuario\n" + linea + "\n";
                    for (int i = 0; i < 6; i++) {
                        respuesta += fil.readLine() + "\n";
                    }
                    //System.out.println("Usuario encontrado");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                //Aqui se permite el acceso al app
                //System.out.println("El susuario no se ha encontrado");
            }
        } catch (IOException e) {

            System.out.println("Ha ocurrido un Error" + e);
        }
        return encontrado;
    }
    
    public void read() {
        
        SimplyLinkedList<String> myList = new SimplyLinkedList<>();

        File f = rutaUsuarios.toFile();
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new FileReader(f));
            String linea;
            while(entrada.ready()){
                linea = entrada.readLine();
                myList.insert(linea);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            try{
                entrada.close();
            }catch(IOException e){}
        }
        //System.out.println(myList.toString()); Pillar bien
        //search_User busqueda = new search_User();
        //busqueda.buscar();
    }
    public void create_user(String usuario){
        //Un texto cualquiera guardado en una variable
        //usuario = "Hola";

        try
        {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = rutaUsuarios.toFile();
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo,true);
            
            //Escribimos en el archivo con el metodo write
            escribir.write("\n"+usuario);

            //Cerramos la conexion
            //System.out.println(rutaUsuarios.toAbsolutePath().toString());
            escribir.close();
        }
            //Si existe un problema al escribir cae aqui
        catch(Exception e)
        {
            System.out.println("Error al insertar usuario");
        }
    }
}
