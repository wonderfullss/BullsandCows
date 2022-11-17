package bullscows;

public class ErrorPossibleSymbols extends Exception{
    String message;

    public ErrorPossibleSymbols(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
