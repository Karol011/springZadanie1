package pl.sda.zdjava46.zadanie1.exceptions;

public class userNotFoundException extends RuntimeException {
    public userNotFoundException(String message) {
        super(message);
    }
}
