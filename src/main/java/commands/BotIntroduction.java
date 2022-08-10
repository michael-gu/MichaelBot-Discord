package commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BotIntroduction extends ListenerAdapter {

    public void botIntro(@NotNull MessageReceivedEvent event)
    {

        if (event.getAuthor().isBot()) {
            return;
        }
        System.out.println("Got Here");
        Message message = event.getMessage();
        String content = message.getContentRaw();


        System.out.println(content);
        if (content.equals("!ping"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage(message).queue();
        }

    }
}
