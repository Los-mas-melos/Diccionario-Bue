package com.company;

import Prototipo2.Dialect;
import Prototipo2.Pruebas;
import Prototipo2.Word;
import Prototipo2.Words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        AVLTree<Word> AvlTreeBue = new AVLTree();
        AVLTree<Word> AvlTreeSpanish = new AVLTree();

        Words words = new Words();
        words.setStorageWordsSpanish(AvlTreeSpanish);
        words.setStorageWordsBue(AvlTreeBue);

        Pruebas pruebas = new Pruebas();
        pruebas.setWords(words);
        long ti, tf;

        ti = System.currentTimeMillis();
        pruebas.inyectarDatos(1000000);
        tf = System.currentTimeMillis();

        System.out.println("Tiempo: " + ((tf - ti)/1000) + " s");


        Scanner in = new Scanner(System.in);

        System.out.println("Ingrese I para insertar B para buscar R para remover E para salir");

        String op = in.next();
        while(!op.equals("E"))
        {
            switch (op)
            {
                case "I":
                    ti = System.currentTimeMillis();
                    words.insertWord(in.next(), in.next());
                    tf = System.currentTimeMillis();
                    break;
                case "B":
                    ti = System.currentTimeMillis();
                    System.out.println(words.search(in.next()));
                    tf = System.currentTimeMillis();
                    break;
                case "R":
                    ti = System.currentTimeMillis();
                    words.remove(in.next());
                    tf = System.currentTimeMillis();
                    break;
                default:
                    op = "E";
            }

            System.out.println("Tiempo: " + ((tf - ti)) + " ms");
            System.out.println("Ingrese I para insertar B para buscar R para remover E para salir");

            op = in.next();
        }
    }
}
