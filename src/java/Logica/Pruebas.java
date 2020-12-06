package Logica;

//import com.company.AVLTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Pruebas
{
    private Words words;
    private Scanner in;

    public Pruebas()
    {
        words = new Words();
        try {
            in = new Scanner(new BufferedReader(new FileReader("C:\\\\Users\\\\sonny\\\\Desktop\\\\Palabras.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void probarInsercion()
    {
        long ti, tf;
        System.out.println(" Corriendo prueba de insercion de 5000 datos");
        ti = System.nanoTime();
        inyectarDatos(10000);
        tf = System.nanoTime();

        System.out.println("  Tiempo: " + ((tf-ti)/1000000000.0));

        words.removeAll();

        System.out.println(" Corriendo prueba de insercion de 50000 datos");
        ti = System.nanoTime();
        inyectarDatos(100000);
        tf = System.nanoTime();
        System.out.println("  Tiempo: " + ((tf-ti)/1000000000.0));

        words.removeAll();

        System.out.println(" Corriendo prueba de insercion de 500000 datos");
        ti = System.nanoTime();
        inyectarDatos(1000000);
        tf = System.nanoTime();
        System.out.println("  Tiempo: " + ((tf-ti)/1000000000.0));

        words.removeAll();

        System.out.println(" Corriendo prueba de insercion de 5000000 datos");
        ti = System.nanoTime();
        inyectarDatos(10000000);
        tf = System.nanoTime();
        System.out.println("  Tiempo: " + ((tf-ti)/1000000000.0));

        words.removeAll();

        System.out.println(" Corriendo prueba de insercion de 50000000 datos");
        ti = System.nanoTime();
        inyectarDatos(100000000);
        tf = System.nanoTime();
        System.out.println("  Tiempo: " + ((tf-ti)/1000000000.0));
    }

    public void inyectarDatos(int n)
    {
        for(int i = 1; i <= n; ++i){
            words.insertWord(in.next(), in.next());
        }

        in.reset();
    }

    public void getDatosInsercion()
    {
        long tf, ti = System.currentTimeMillis();
        for(int i = 1; i <= 5000000; ++i)
        {
           words.insertWord(in.next(), in.next());
           if(i % 100000 == 0)
           {
               tf = System.currentTimeMillis();
               System.out.println((tf-ti));
           }
        }
        in.reset();
    }

    public void getDatosBusqueda()
    {
        long ti, tf;
        for(int i  = 0; i <= 5000000; ++i)
        {
            String wordBue = in.next();
            String wordSpanish = in.next();
            words.insertWord(wordBue, wordSpanish);
            if(i % 100000 == 0)
            {
                ti = System.nanoTime();
                words.search(wordSpanish);
                tf = System.nanoTime();
                System.out.println((tf - ti));
            }
        }
        in.reset();
    }

    public void getDatosEliminacion()
    {
        long ti, tf;
        for(int i  = 0; i <= 5000000; ++i)
        {
            String wordBue = in.next();
            String wordSpanish = in.next();
            words.insertWord(wordBue, wordSpanish);
            if(i % 100000 == 0)
            {
                ti = System.nanoTime();
                words.remove(wordSpanish);
                tf = System.nanoTime();
                System.out.println((tf - ti));
            }
        }
        in.reset();

    }








    public Words getWords() {
        return words;
    }

    public void setWords(Words words) {
        this.words = words;
    }

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }
}
