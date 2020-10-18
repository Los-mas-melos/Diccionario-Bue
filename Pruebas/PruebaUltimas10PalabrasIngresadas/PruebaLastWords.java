package com.company;

import java.util.Scanner;

public class PruebaLastWords
{
    private LastWords lastWords;
    private Scanner in;

    public PruebaLastWords(){
        lastWords = new LastWords();
        in = new Scanner(System.in);
    }

    public void runPrueba(){
        long ti, tf;
        String word = "";
        while(true){
            word = in.next();
            ti = System.nanoTime();
            lastWords.addWord(word);
            tf = System.nanoTime();
            System.out.println("Tiempo de inserción: " + ((tf-ti)/1000000.0));
            System.out.println(lastWords.getArrayQueue());
        }
    }

    public LastWords getLastWords() {
        return lastWords;
    }

    public void setLastWords(LastWords lastWords) {
        this.lastWords = lastWords;
    }
}
