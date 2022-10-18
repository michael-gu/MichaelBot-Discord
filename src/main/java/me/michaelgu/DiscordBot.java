package me.michaelgu;

import commands.SlashCommands;
import commands.TextCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.time.Instant;

//Worker: java src/main/java/me/michaelgu/DiscordBot.java
public class DiscordBot {
    public static Instant start = Instant.now();

    public static void main(String[] args) throws LoginException, InterruptedException {
        // time passes
        //JDA bot = JDABuilder.createLight(System.getenv("TOKEN"), GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
        JDA bot = JDABuilder.createLight("MTAwNjQ0OTg3NjQxNjA3MzgzOA.GZALHa.yl_4LGn1XwP7v2FaczDjIv3PlLdt8OIkJpBKTA", GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .setActivity(Activity.playing("around on IntelliJ"))
                .addEventListeners(new SlashCommands())
                .addEventListeners(new TextCommands())
                .build().awaitReady();

        Guild guild = bot.getGuildById("1006450720167428116");
        if (guild != null) {
            bot.upsertCommand("comp", "Gives compliment!").queue();
            bot.upsertCommand("love", "makes someone feel loved!")
                    .addOption(OptionType.STRING, "name", "enter a name", true)
                    .queue();
            bot.upsertCommand("nerf", "Hits target with nerf gun!")
                    .addOption(OptionType.STRING, "mortal_enemy", "the name of your next target", true)
                    .queue();
            bot.upsertCommand("gifsearch", "powered by Tenor")
                    .addOption(OptionType.STRING, "search", "gif search", true)
                    .queue();
            bot.upsertCommand("zoomies", "goes super fast!").queue();
            bot.upsertCommand("rps", "rock-paper-scissors game!")
                    .addOption(OptionType.STRING, "input", "choose rock, paper, or scissors", true)
                    .queue();
        }
    }
}
