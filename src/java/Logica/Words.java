package Logica;

import Logica.Exceptions.*;

public class Words {
    private StorageWords<Word> storageWordsBue;
    private StorageWords<Word> storageWordsSpanish;

    public Words() {
        storageWordsBue     = null;
        storageWordsSpanish = null;
    }

    public void insertWord(String strBue, String strSpanish) {
        Word wordBue     = new Word(Dialect.BUE, strBue);
        Word wordSpanish = new Word(Dialect.SPANISH, strSpanish);

        wordBue.setTranslation(wordSpanish);
        wordSpanish.setTranslation(wordBue);

        try {
            storageWordsBue.insert(wordBue);
        } catch (FoundWordException e) {
            //System.out.println("La palabra ya se encuentra");
        }
        try {
            storageWordsSpanish.insert(wordSpanish);
        } catch (FoundWordException e) {
            //System.out.println("La palabra ya se encuentra");
        }
    }

    private void removeBue(String strBue) throws NotFoundWordException {
        Word wordBue = searchBue(strBue);
        try {
            storageWordsBue.remove(wordBue);
        } catch (NotFoundWordException e) {
            e.printStackTrace();
        }
        try {
            storageWordsSpanish.remove(wordBue.getTranslation());
        } catch (NotFoundWordException e) {
            e.printStackTrace();
        }
    }

    private void removeSpanish(String strSpanish) throws NotFoundWordException {
        Word wordSpanish = searchSpanish(strSpanish);
        try {
            storageWordsSpanish.remove(wordSpanish);
        } catch (NotFoundWordException e) {
            e.printStackTrace();
        }
        try {
            storageWordsBue.remove(wordSpanish.getTranslation());
        } catch (NotFoundWordException e) {
            e.printStackTrace();
        }
    }

    public void remove(String strWord) {
        try {
            removeBue(strWord);
        } catch (NotFoundWordException e) {
            try {
                removeSpanish(strWord);
            } catch (NotFoundWordException notFoundWordException) {
                notFoundWordException.printStackTrace();
            }
        }
    }

    private Word searchBue(String strBue) throws NotFoundWordException {
        Word wordBue = new Word(Dialect.BUE, strBue);
        return (Word) storageWordsBue.search(wordBue).getData();
    }

    private Word searchSpanish(String strSpanish) throws NotFoundWordException {
        Word wordSpanish = new Word(Dialect.SPANISH, strSpanish);
        return (Word) storageWordsSpanish.search(wordSpanish).getData();
    }

    public Word search(String strWord)
    {
        Word word = null;
        try {
            word = searchBue(strWord);
        } catch (NotFoundWordException e) {
            try {
                word = searchSpanish(strWord);
            } catch (NotFoundWordException notFoundWordException) {
                notFoundWordException.printStackTrace();
            }
        }

        return word;
    }

    public void removeAll()
    {
        storageWordsBue.removeAll();
        storageWordsSpanish.removeAll();
    }

    public StorageWords<Word> getStorageWordsBue() {
        return storageWordsBue;
    }

    public void setStorageWordsBue(StorageWords<Word> storageWordsBue) {
        this.storageWordsBue = storageWordsBue;
    }

    public StorageWords<Word> getStorageWordsSpanish() {
        return storageWordsSpanish;
    }

    public void setStorageWordsSpanish(StorageWords<Word> storageWordsSpanish) {
        this.storageWordsSpanish = storageWordsSpanish;
    }
}