package bullscows;

public class ErrorValidInput extends Exception {
    String message;

    public ErrorValidInput(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
