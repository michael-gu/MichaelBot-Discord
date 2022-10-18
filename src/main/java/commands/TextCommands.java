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

public class TextCommands extends ListenerAdapter {
    int numChar = 0;
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message msg = event.getMessage();
        numChar += msg.getContentRaw().length();

        if (msg.getContentRaw().equals("!comp")) {
            MessageChannel channel = event.getChannel();
            Random rand = new Random();
            channel.sendMessage(ComplimentList.complimentLibrary[rand.nextInt(ComplimentList.complimentLibrary.length)]).queue();
        } else if (msg.getContentRaw().equals("!messages")) {
            MessageChannel channel = event.getChannel();
            Instant end = Instant.now();

            Duration timeElapsed = Duration.between(DiscordBot.start, end);
            String strTime = Double.toString(timeElapsed.getSeconds());

            String message = "Processed " + numChar + " characters in " + strTime + " seconds during this instance";
            numChar -= message.length();
            channel.sendMessage(message).queue();
        } else if (msg.getContentRaw().equals("!michaelbot")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("I am MichaelBot! I was created on 08/17/2022 by Michael Gu.\n" +
                    "Still currently in development! Version 2.0.1").queue();
        } else if (msg.getContentRaw().equals("!vibin")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("vibin out like usual!").queue();
            channel.sendMessage("https://tenor.com/view/cat-cat-dance-cat-vibe-cat-vibing-leila-gif-24155594").queue();
        } else if (msg.getContentRaw().equals("!wakuwaku")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("https://tenor.com/view/waku-waku-excited-cute-anya-spy-family-gif-25751852").queue();
        }
    }
}
