package Logica;

import Logica.Exceptions.*;

public interface StorageWords<T>
{
    public void insert(T item) throws FoundWordException;
    public void remove(T item) throws NotFoundWordException;
    public Node search(T value) throws NotFoundWordException;
    public void removeAll();
}
