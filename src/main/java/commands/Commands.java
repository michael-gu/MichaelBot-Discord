package commands;


import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;
import java.io.*;
import java.util.Random;

public class Commands extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("piss")) {
            event.reply("*pisses on you* (i bet you liked that huh)").queue();
        }
        else if (event.getName().equals("spicy")) {
            File file = new File("C:\\Users\\jiang\\IdeaProjects\\java-discord-bot\\src\\main\\java\\images\\spicy.jpg");
            event.reply("***why so spicy***").addFile(file).queue();
        }
        else if(event.getName().equals("lover")) {
            event.deferReply().queue();

            OptionMapping option = event.getOption("lovername");
            if (option == null) {
                event.reply("a name was not provided").queue();
                return;
            }
            String lovername = option.getAsString();
            User user = event.getUser();
            String userId = user.toString();


            File file = new File("C:\\Users\\jiang\\IdeaProjects\\java-discord-bot\\src\\main\\java\\images\\flush.jpg");

            event.getHook().sendMessage("***" + userId.substring(2,userId.length() - 20) + " likes " + lovername + ". How cute!***").addFile(file).queue();


        }
        else if (event.getName().equals("rps")) {
            event.deferReply().queue();

            OptionMapping option = event.getOption("input");
            if (option == null) {
                event.reply("invalid input").queue();
                return;
            }

            String input = option.getAsString();
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
                event.getHook().sendMessage("invalid input!").queue();
                return;
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
            event.getHook().sendMessage(playerChoice + "\n" + computerChoice + "\n" + result).queue();
        }

    }

}
