package Prototipo2.Exceptions;

public class NotFoundWordException extends Exception
{
    public NotFoundWordException()
    {
        super("La palabra no se encontro");
    }
}
