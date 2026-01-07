package exceptions;

public class DoNotWrongTextException extends Exception {
    public DoNotWrongTextException(String message) {
        super("ОШИБКА ТЕКСТА: " + message);
    }
}