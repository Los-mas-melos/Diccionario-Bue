package Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Diccionario extends SimplyLinkedList {

    SimplyLinkedList diccionario = new SimplyLinkedList();
    Integer size = 0;

    public Diccionario() {
        super();
        SimplyLinkedList diccionario_ = new SimplyLinkedList();
        int index = 0;
        File file = new File("Diccionario(1k)ParaPruebas.txt");
        try (
                FileInputStream fichero = new FileInputStream(file);
                InputStreamReader wordList = new InputStreamReader(fichero, StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(wordList);) {
            String linea;

            while ((linea = in.readLine()) != null) {

                String[] entradas = linea.split("\\t");
                index = Integer.parseInt(entradas[0]);
                String bueEntrada = entradas[1];
                String espEntrada = entradas[2];
                Entrada palabraDiccionario = new Entrada(espEntrada, bueEntrada);
                diccionario_.insert(palabraDiccionario);

            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo de palabras.");
        }
        this.diccionario = diccionario_;
        size = index;
        this.length = size;
        

    }

    public Entrada ingresarEntrada(String bue, String español) {
        Entrada nuevaEntrada = new Entrada(español, bue);

        File file = new File("Diccionario(1k)ParaPruebas.txt");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true));) {
            int newSize = diccionario.length() + 1;
            out.newLine();
            out.write(Integer.toString(newSize));
            out.append("\t");
            out.write(bue);
            out.append("\t");
            out.write(español);
            diccionario.length++;
        } catch (IOException e) {
            Logger.getLogger(Diccionario.class.getName()).log(Level.SEVERE, null, e);
        }
        return nuevaEntrada;
    }

    public String buscarPalabra(String input) {
        
        String output = "";
            for (int i = 0; i < diccionario.length(); i++) {
                if (input.equalsIgnoreCase(diccionario.getK(i).getBue())) {
                    output = "Traducción al español: " + diccionario.getK(i).getEspañol();
                    i = diccionario.length();
                } else if (input.equalsIgnoreCase(diccionario.getK(i).getEspañol())) {
                    output = "Traducción al bue: " + diccionario.getK(i).getBue();
                    i = diccionario.length();
                }
            }
            if (output.equals("")) {
                output = "Palabra no encontrada.";
            }
        return output;
    }

}
