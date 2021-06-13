package pl.sda.zdjava46.zadanie1.exceptions;

public class addressNotFoundException extends RuntimeException {
    public addressNotFoundException(String message) {
        super(message);
    }
}
