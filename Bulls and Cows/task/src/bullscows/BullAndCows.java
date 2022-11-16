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

    public void randomizer(int number) {
        this.code = new StringBuilder();
        List<String> symbols = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        if (number > 10) {
            System.out.println("Error: can't generate a secret number with a length of " + number + " because there aren't enough unique digits.");
            winner = true;
        } else {
            while (symbols.get(0).equals("0")) {
                Collections.shuffle(symbols);
            }
            for (int i = 0; i < number; i++) {
                this.code.append(symbols.get(i));
            }
        }
    }

    public void startGame() {
        System.out.println("Please, enter the secret code's length:");
        number = Integer.parseInt(scan.nextLine());
        randomizer(number);
        if (!winner)
            System.out.println("Okay, let's start a game!");
        game();
    }

    public void countBullsAndCows(String answer) {
        for (int i = 0; i < String.valueOf(this.code).length(); i++) {
            if (String.valueOf(this.code).charAt(i) == answer.charAt(i)) {
                this.bulls++;
            } else if (String.valueOf(this.code).contains(String.valueOf(answer.charAt(i)))) {
                this.cows++;
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
        } else if (bulls > 0 && number > 0) {
            System.out.println("Grade:" + bulls + " bull(s) and " + cows + " cow(s).");
        } else if (cows > 0 && bulls == 0) {
            System.out.println("Grade:" + cows + " cow(s).");
        } else if (bulls > 0 && cows == 0) {
            System.out.println("Grade:" + bulls + " bull(s).");
        } else if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        }
    }
}
