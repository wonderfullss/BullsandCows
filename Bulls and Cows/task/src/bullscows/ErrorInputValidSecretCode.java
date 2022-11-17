package bullscows;

public class ErrorInputValidSecretCode extends Exception {
    String message;

    public ErrorInputValidSecretCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
