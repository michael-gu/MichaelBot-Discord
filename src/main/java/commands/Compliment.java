package commands;



import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import java.util.Random;

public class Compliment extends ListenerAdapter {
    public static String[] list = new String[] {"Your smile is contagious.",
            "I bet you make babies smile.",
            "You have the best laugh.",
            "You light up the room.",
            "You have a great sense of humor.",
            "You're like sunshine on a rainy day.",
            "You bring out the best in other people.",
            "I bet you sweat glitter.",
            "Colors seem brighter when you're around.",
            "Jokes are funnier when you tell them.",
            "You're like a breath of fresh air.",
            "You're someone's reason to smile.",
            "You are the most perfect you there is.",
            "You should be proud of yourself.",
            "You've got an awesome sense of humor!",
            "You have a great sense of humor.",
            "You're even more beautiful on the inside than you are on the outside.",
            "Hanging out with you is always a blast.",
            "You're wonderful.",
            "That thing you don't like about yourself is what makes you so interesting.",
            "You could survive a Zombie apocalypse.",
            "Babies and small animals probably love you.",
            "You’re a natural at whatever you do!",
            "You’re the bravest person I know! I wish I was more like you.",
            "You're better than a triple-scoop ice cream cone…with sprinkles",
            "Your energy is infectious!",
            "You’re so kind that you make everyone around you a better person",
            "I love how you can turn even the most simple situation into something fun.",
            "Your creativity is on another level!",
            "When you get famous, I want to be the president of your fan club.",
            "You’re irreplaceable.",
            "I love your confidence. Can you send some of it my way?",
            "Everyone needs a friend like you in their life.",
            "Talking to you always puts me in a good mood.",
            "You radiate from head to toe.",
            "If only everyone was as sweet as you.",
            "u r so seggsy",
            "you are the toothpaste to my toothbrush",
            "I think moto moto likes you",
            "if I could ask you any question in the world I'd ask you to be my girl"
    };

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        event.deferReply().queue();


        if (event.getName().equals("comp")) {
            Random rand = new Random();
            int randInt = rand.nextInt(list.length);
            event.getHook().sendMessage(list[randInt]).queue();
        }

    }
    /*
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getName().equals("comp")) {
            Random rand = new Random();
            int randInt = rand.nextInt(list.length);
            event.getHook().sendMessage(list[randInt]).queue();
        }
    }

     */

}