package com.bloodnighttw.JDAtool.Demo;

import com.bloodnighttw.JDAtool.CommandSystem.CommandManager;
import com.bloodnighttw.JDAtool.MusicSystem.command.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {

        JDA jda=new JDABuilder(Token.getToken()).build();
        jda.getPresence().setActivity(Activity.playing("=JDATool=撰寫中"));

        CommandManager cm=new CommandManager(jda);

        cm.addCommand(new JoinCommand());
        cm.addCommand(new LeaveCommand());
        cm.addCommand(new PlayCommand());
        cm.addCommand(new pauseCommand());
        cm.addCommand(new StopCommand());
        cm.addCommand(new NowPlayingCommand());
        cm.addCommand(new skipCommand());
        cm.addCommand(new pCommand());



        cm.close();
    }
}
