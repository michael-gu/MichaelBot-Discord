package commands;



import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class SlashCommands extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("comp")) {
            Random rand = new Random();
            int randInt = rand.nextInt(ComplimentList.complimentLibrary.length);
            event.reply(ComplimentList.complimentLibrary[randInt]).queue();
        } else if(event.getName().equals("love")) {
            event.deferReply().queue();
            OptionMapping option = event.getOption("name");
            if (option == null) {
                event.reply("an input was not provided").queue();
                return;
            }
            String name = option.getAsString();
            User user = event.getUser();
            String userId = user.toString();
            event.getHook().sendMessage(userId.substring(2,userId.length() - 20) + " likes " + name + ". How cute!\n" +
                    "https://tenor.com/view/panda-love-heart-cute-in-love-love-gif-12434276").queue();
        } else if (event.getName().equals("nerf")) {
            event.deferReply().queue();

            User user = event.getUser();
            String userId = user.toString();
            OptionMapping option = event.getOption("mortal_enemy");
            if (option == null) {
                event.reply("an input was not provided").queue();
                return;
            }

            String target = option.getAsString();
            event.getHook().sendMessage(userId.substring(2,userId.length() - 20) + " hit " + target + " with a nerf gun! **pew pew**\n" +
                    "https://tenor.com/view/child-9gag-gif-no-noo-gif-18262281").queue();

        } else if (event.getName().equals("gifsearch")) {
            event.deferReply().queue();
            OptionMapping option = event.getOption("search");
            if (option == null) {
                event.reply("a valid search was not provided").queue();
                return;
            }
            String text = TenorGIFSearch.searchGIF(option.getAsString());
            event.getHook().sendMessage(text).queue();

        } else if (event.getName().equals("rps")) {
            event.deferReply().queue();

            OptionMapping option = event.getOption("input");
            if (option == null) {
                event.reply("invalid input").queue();
                return;
            }

            String message = RPSGame.userInput(option.getAsString());
            event.getHook().sendMessage(message).queue();
        } else if (event.getName().equals("zoomies")) {
            User user = event.getUser();
            String userId = user.toString();

            event.reply(userId.substring(2,userId.length() - 20) + " do be zoomin\n" + "https://tenor.com/view/kamen-rider-zero-one-kamen-rider_01-kamen-rider-thouser-thouser-gai-amatsu-gif-21402763").queue();
        }


    }

}
