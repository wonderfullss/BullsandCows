package bullscows;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

public class BullAndCows {
    StringBuilder code;
    int bulls = 0, cows = 0;
    boolean winner = false;
    int number;
    final static Scanner scan = new Scanner(System.in);
    List<String> symbols = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g",
            "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));

    public void randomizer(int number, int charter) {
        code = new StringBuilder();
        List<String> secret = symbols.subList(0, charter);
        if (number > 10) {
            System.out.println("Error: can't generate a secret number with a length of " + number + " because there aren't enough unique digits.");
            winner = true;
        } else {
            while (secret.get(0).equals("0")) {
                Collections.shuffle(secret);
            }
            for (int i = 0; i < number; i++) {
                code.append(secret.get(i));
            }
        }
    }

    public void startGame() {
        System.out.println("Please, enter the secret code's length:");
        number = Integer.parseInt(scan.nextLine());
        System.out.println("Input the number of possible symbols in the code:");
        int temp = Integer.parseInt(scan.nextLine());
        temp -= 1;
        randomizer(number, temp);
        if (temp <= 10) {
            System.out.println("The secret is prepared: " + secretPrepared() + " (0-" + symbols.get(temp) + ").");
        } else {
            System.out.println("The secret is prepared: " + secretPrepared() + " (0-9, a-" + symbols.get(temp) + ").");
        }
        if (!winner)
            System.out.println("Okay, let's start a game!");
        game();
    }

    public void countBullsAndCows(String answer) {
        for (int i = 0; i < String.valueOf(code).length(); i++) {
            if (String.valueOf(code).charAt(i) == answer.charAt(i)) {
                bulls++;
            } else if (String.valueOf(code).contains(String.valueOf(answer.charAt(i)))) {
                cows++;
            }
        }
    }

    public void game() {
        int _try = 1;
        StringBuilder answer;
        while (!winner) {
            bulls = 0;
            cows = 0;
            System.out.println("Turn " + _try + ":");
            answer = new StringBuilder(scan.nextLine());
            countBullsAndCows(String.valueOf(answer));
            testWinner();
            _try++;
        }
    }

    public void testWinner() {
        if (bulls == number) {
            System.out.println("Congratulations! You guessed the secret code.");
            winner = true;
            System.out.println("Grade:" + bulls + " bull(s) and " + cows + " cow(s).");
        } else if (bulls > 0 && cows > 0) {
            System.out.println("Grade:" + bulls + " bull(s) and " + cows + " cow(s).");
        } else if (cows > 0 && bulls == 0) {
            System.out.println("Grade:" + cows + " cow(s).");
        } else if (bulls > 0 && cows == 0) {
            System.out.println("Grade:" + bulls + " bull(s).");
        } else if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        }
    }

    public StringBuilder secretPrepared() {
        StringBuilder secretCode = new StringBuilder(code);
        for (int i = 0; i < secretCode.length(); i++) {
            secretCode.setCharAt(i, '*');
        }
        return secretCode;
    }
}
