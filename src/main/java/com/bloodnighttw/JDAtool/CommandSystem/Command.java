package com.bloodnighttw.JDAtool.CommandSystem;

import com.bloodnighttw.JDAtool.MusicSystem.command.NowPlayingCommand;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.smartcardio.SunPCSC;

import java.util.HashMap;


    public abstract class Command{

        private Logger log;//= LoggerFactory.getLogger(this.getClass());

        //public static HashMap hMap=new HashMap<String,Command>();

        public abstract String getCommandName();

        public abstract String getDescription();

        public abstract void onCommand(GuildMessageReceivedEvent e, String[] args);

        protected Logger getLogger(Class<? extends NowPlayingCommand> classname){
            if(log==null)
                log= LoggerFactory.getLogger(classname);

            return log;
        }

    }

