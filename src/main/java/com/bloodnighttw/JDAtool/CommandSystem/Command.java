package com.bloodnighttw.JDAtool.CommandSystem;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;



    public abstract class Command{

        //private Logger log;//= LoggerFactory.getLogger(this.getClass());

        //public static HashMap hMap=new HashMap<String,Command>();

        public abstract String getCommandName();

        public abstract String getDescription();

        public abstract void onCommand(GuildMessageReceivedEvent e, String[] args);

    }

