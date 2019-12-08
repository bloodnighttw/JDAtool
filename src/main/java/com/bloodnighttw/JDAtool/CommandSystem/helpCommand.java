package com.bloodnighttw.JDAtool.CommandSystem;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.HashMap;

public class helpCommand extends Command {

    helpCommand(HashMap<String,Command> hmap){

    }


    @Override
    public String getCommandName() {
        return "=help";
    }

    @Override
    public String getDescription() {
        return "Just A Test ";
    }

    @Override
    public void onCommand(GuildMessageReceivedEvent e, String[] args) {

    }
}
