package com.bloodnighttw.JDAtool.MusicSystem.command;

import com.bloodnighttw.JDAtool.CommandSystem.Command;
import com.bloodnighttw.JDAtool.MusicSystem.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StopCommand extends Command {

    private Logger log= LoggerFactory.getLogger(this.getClass());


    @Override
    public String getCommandName() {
        return "=stop";
    }

    @Override
    public String getDescription() {
        return "stop command";
    }

    @Override
    public void onCommand(GuildMessageReceivedEvent e, String[] args) {
        PlayerManager pm=PlayerManager.getInstance();
        pm.getGuildMusicManager(e.getGuild()).player.stopTrack();
        pm.getGuildMusicManager(e.getGuild()).scheduler.delAll();
    }
}
