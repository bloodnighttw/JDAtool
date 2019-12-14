package com.bloodnighttw.JDAtool.MusicSystem.command;

import com.bloodnighttw.JDAtool.CommandSystem.Command;
import com.bloodnighttw.JDAtool.MusicSystem.PlayerManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class skipCommand extends Command {

    private Logger log= LoggerFactory.getLogger(this.getClass());

    @Override
    public String getCommandName() {
        return "=skip";
    }

    @Override
    public String getDescription() {
        return "skip the music";
    }

    @Override
    public void onCommand(GuildMessageReceivedEvent e, String[] args) {


        PlayerManager pm=PlayerManager.getInstance();
        pm.getGuildMusicManager(e.getGuild()).scheduler.nextTrack();

        EmbedBuilder em=new EmbedBuilder();


        em.setTitle("Now Playing")
            .setColor(Color.GREEN)
            .setDescription(pm.getGuildMusicManager(e.getGuild()).player.getPlayingTrack().getInfo().title);
            //.setThumbnail(pm.getGuildMusicManager(e.getGuild()).player.getPlayingTrack().getInfo().uri.split("watch?" + "")[1].split("v=")[1]);
        e.getChannel().sendMessage(em.build()).queue();

    }
}
