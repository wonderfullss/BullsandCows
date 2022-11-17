package bullscows;

public class Main {
    public static void main(String[] args) throws ErrorValidInput, ErrorPossibleSymbols, ErrorInputValidSecretCode {
        BullAndCows game = new BullAndCows();
        try {
            game.startGame();
        } catch (ErrorValidInput | ErrorPossibleSymbols | ErrorInputValidSecretCode error) {
            System.out.println(error.getMessage());
        } catch (NumberFormatException error){
            System.out.println(error.getMessage());
        }
    }
}