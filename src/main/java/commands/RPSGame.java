package commands;

import java.util.Random;

public class RPSGame {
    public static String userInput(String input) {
        Random rand = new Random();
        int randInt = rand.nextInt(2) + 1;
        int playerInt;
        String playerChoice;
        String computerChoice = "";
        String result;

        if (input.equalsIgnoreCase("rock") || input.equalsIgnoreCase("r")) {
            playerChoice = "You have chosen: ROCK";
            playerInt = 1;
        } else if (input.equalsIgnoreCase("paper") || input.equalsIgnoreCase("p")) {
            playerChoice = "You have chosen: PAPER";
            playerInt = 2;
        } else if (input.equalsIgnoreCase("scissors") || input.equalsIgnoreCase("s")) {
            playerChoice = "You have chosen: SCISSORS";
            playerInt = 3;
        } else {
            return "Invalid input!";
        }

        if (randInt == 1) {
            computerChoice = "The computer has chosen: ROCK";
        } else if (randInt == 2) {
            computerChoice = "The computer has chosen: PAPER";
        } else if (randInt == 3) {
            computerChoice = "The computer has chosen: SCISSORS";
        }

        if (playerInt == 1 && randInt == 1 || playerInt == 2 && randInt == 2 || playerInt == 3 && randInt == 3) {
            result = "You and the computer have tied!";

        } else if (playerInt == 1 && randInt == 3 || playerInt == 2 && randInt == 1 || playerInt == 3 && randInt == 2) {
            result = "You have won! Congratulations!";

        } else {
            result = "You have lost. Better luck next time!";
        }
        return playerChoice + "\n" + computerChoice + "\n" + result;
    }
}
