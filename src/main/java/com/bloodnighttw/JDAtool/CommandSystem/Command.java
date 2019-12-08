package com.bloodnighttw.JDAtool.CommandSystem;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.HashMap;


    public abstract class Command{

        //public static HashMap hMap=new HashMap<String,Command>();

        public abstract String getCommandName();

        public abstract String getDescription();

        public abstract void onCommand(GuildMessageReceivedEvent e, String[] args);

    }

