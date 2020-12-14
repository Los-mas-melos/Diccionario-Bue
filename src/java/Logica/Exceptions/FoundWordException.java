package Logica.Exceptions;

public class FoundWordException extends Exception {
    public FoundWordException() {
        super("La palabra ya se encuentra ingresada");
    }
}
