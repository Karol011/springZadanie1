package pl.sda.zdjava46.zadanie1.exceptions;

public class userAlreadyExistsException extends RuntimeException {
    public userAlreadyExistsException(String message) {
        super(message);
    }
}
