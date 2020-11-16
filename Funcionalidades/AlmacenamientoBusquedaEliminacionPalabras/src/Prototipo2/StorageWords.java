package Prototipo2;

import Prototipo2.Exceptions.FoundWordException;
import Prototipo2.Exceptions.NotFoundWordException;
import com.company.Node;

public interface StorageWords<T>
{
    void insert(T item) throws FoundWordException;
    void remove(T item) throws NotFoundWordException;
    Node search(T value) throws NotFoundWordException;
    void removeAll();
}
