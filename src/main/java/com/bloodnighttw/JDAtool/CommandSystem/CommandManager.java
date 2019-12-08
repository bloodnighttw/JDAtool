package com.bloodnighttw.JDAtool.CommandSystem;

import com.bloodnighttw.JDAtool.Register;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;

public class CommandManager  extends ListenerAdapter {

    private JDA jda;
    private boolean hasHelpCommand=false;
    private HashMap hMap =new HashMap<String ,Command>();

    public CommandManager(){
        try {
            Register.getJDA().addEventListener(this);
        }catch (NullPointerException expection){
            System.out.println("You have to REGISTE your JDA object");
            return;
        }
    }

    public CommandManager(JDA jda){
        this.jda =jda;
        jda.addEventListener(this);
    }

    public void addCommand(Command command){
        hMap.put(command.getCommandName(),command);

    }

    public void close(){
        if(!hasHelpCommand)
            addCommand(new helpCommand(hMap));
    }

    public final void onGuildMessageReceived(GuildMessageReceivedEvent e){

        String[] args=e.getMessage().getContentRaw().split(" ");
        Command cm= (Command) hMap.get(args[0]);
        try {
            cm.onCommand(e,args);
        }
        catch (NullPointerException event){
            return;
        }
    }
}