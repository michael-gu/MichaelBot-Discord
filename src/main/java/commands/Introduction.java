package commands;

import me.michaelgu.DiscordBot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Introduction extends ListenerAdapter {
    int numChar = 50;
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message msg = event.getMessage();
        numChar += msg.getContentRaw().length();
        if (msg.getContentRaw().equals("!michaelbot")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("i am michael bot!").queue();
        }
        else if (msg.getContentRaw().equals("!messages")) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(DiscordBot.start, end);
            MessageChannel channel = event.getChannel();
            String strTime = Double.toString(timeElapsed.getSeconds());
            String extra = "Processed " + Integer.toString(numChar) + " characters in " + strTime + " seconds during this instance";
            numChar -= extra.length();

            channel.sendMessage("Processed " + Integer.toString(numChar) + " characters in " + strTime + " seconds during this instance").queue();
        }
        else if (msg.getContentRaw().equals("!wakuwaku")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("https://tenor.com/view/waku-waku-excited-cute-anya-spy-family-gif-25751852").queue();
        }
        else if (msg.getContentRaw().equals("!comp")) {
            MessageChannel channel = event.getChannel();
            Random rand = new Random();
            channel.sendMessage(Compliment.list[rand.nextInt(Compliment.list.length)]).queue();
        }
        else if (msg.getContentRaw().equals("!rps")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Use the slash command /rps to play!").queue();
        }
    }
}
