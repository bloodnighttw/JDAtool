package com.bloodnighttw.JDAtool.MusicSystem.command;

import com.bloodnighttw.JDAtool.CommandSystem.Command;
import com.bloodnighttw.JDAtool.MusicSystem.PlayerManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class NowPlayingCommand  extends Command {

    //private Logger log= LoggerFactory.getLogger(this.getClass());

    @Override
    public String getCommandName() {
        return  "=np";
    }

    @Override
    public String getDescription() {
        return "now playing command";
    }

    @Override
    public void onCommand(GuildMessageReceivedEvent e, String[] args) {
        PlayerManager pm=PlayerManager.getInstance();


        EmbedBuilder emb=new EmbedBuilder();

        emb.setTitle("Now Playing");
        emb.setColor(Color.GREEN);
        emb.setDescription(pm.getGuildMusicManager(e.getGuild()).player.getPlayingTrack().getInfo().title);
        e.getChannel().sendMessage(emb.build()).queue();
    }
}
