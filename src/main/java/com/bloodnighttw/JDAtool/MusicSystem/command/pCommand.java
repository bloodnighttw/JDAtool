package com.bloodnighttw.JDAtool.MusicSystem.command;

import com.bloodnighttw.JDAtool.CommandSystem.Command;
import com.bloodnighttw.JDAtool.MusicSystem.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class pCommand extends Command {

    private Logger log= LoggerFactory.getLogger(this.getClass());

    @Override
    public String getCommandName() {
        return "=p";
    }

    @Override
    public String getDescription() {
        return "play pause and play a link";
    }

    @Override
    public void onCommand(GuildMessageReceivedEvent e, String[] args) {

        PlayerManager pm=PlayerManager.getInstance();

        if(args.length==1)
            PlayerManager.getInstance().getGuildMusicManager(e.getGuild()).player.setPaused(!PlayerManager.getInstance().getGuildMusicManager(e.getGuild()).player.isPaused());

        if(args.length>=2)
            for(int i=1;i<args.length;i++) {
                pm.loadAndPlay(e.getChannel(), args[i]);
                pm.getGuildMusicManager(e.getGuild()).player.setPaused(false);
            }
    }
}
