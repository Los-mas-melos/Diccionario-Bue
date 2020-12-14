package Logica;

import java.util.function.Function;
import java.io.Serializable;

public class Word implements Comparable<Word>, Serializable {
    private Dialect dialect;

    private String name;
    private Word   translation;
    
    public Word() {
    }

    public Word(Dialect dialect, String name) {
        this.dialect = dialect;
        this.name    = name;
    }

    public Dialect getDialect() {
        return dialect;
    }

    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Word getTranslation() {
        return translation;
    }

    public void setTranslation(Word translation) {
        this.translation = translation;
    }

    public int compareTo(Word w)
    {
        int result = 0;
        if(name.compareTo(w.name) <= -1)
            result = -1;
        else if(name.compareTo(w.name) == 0)
            result = 0;
        else if(name.compareTo(w.name) >= 1)
            result = 1;

        return result;
    }

    @Override
    public String toString() {
        String name = this.name.substring(0,1) + this.name.substring(1).toLowerCase();
        String translation = this.translation.getName().substring(0,1) + this.translation.getName().substring(1).toLowerCase();
        return String.format("%nDialecto: %s%nPalabra: %s%nTraduccion: %s%n", dialect, name, translation);
    }
}