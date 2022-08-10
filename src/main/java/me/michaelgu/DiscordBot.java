package me.michaelgu;

import commands.Commands;
import commands.Compliment;
import commands.Introduction;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.time.Instant;

public class DiscordBot {
    public static Instant start = Instant.now();

    public static void main(String[] args) throws LoginException, InterruptedException {
        // time passes


        JDA bot = JDABuilder.createLight("MTAwNjQ0OTg3NjQxNjA3MzgzOA.GetJAj.xIyzXbvHb8FDQdHzxXhrs-bwWKzookuP6Ln-Xc", GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .setActivity(Activity.playing("with your heart <3"))
                .addEventListeners(new Introduction())
                .addEventListeners(new Commands())
                .addEventListeners(new Compliment())
                .build().awaitReady();

        Guild guild = bot.getGuildById("1006450720167428116");

        if (guild != null) {
            bot.upsertCommand("comp", "Gives compliment!").queue();
            bot.upsertCommand("piss", "you don't wanna know.").queue();
            bot.upsertCommand("spicy", "over nine thousand scovilles").queue();
            bot.upsertCommand("lover", "uwu blushes")
                    .addOption(OptionType.STRING, "lovername","the name of your lover", true)
                    .queue();
            bot.upsertCommand("rps", "rock-paper-scissors game!")
                    .addOption(OptionType.STRING, "input","choose rock, paper, or scissors", true)
                    .queue();
        }

    }

}
