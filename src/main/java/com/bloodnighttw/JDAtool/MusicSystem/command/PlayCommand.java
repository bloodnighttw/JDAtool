package com.bloodnighttw.JDAtool.MusicSystem.command;

import com.bloodnighttw.JDAtool.CommandSystem.Command;
import com.bloodnighttw.JDAtool.MusicSystem.GuildMusicManager;
import com.bloodnighttw.JDAtool.MusicSystem.PlayerManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.managers.GuildManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayCommand extends Command {

    private Logger log= LoggerFactory.getLogger(this.getClass());

    @Override
    public String getCommandName() {
        return "=play";
    }

    @Override
    public String getDescription() {
        return "play command";
    }

    @Override
    public void onCommand(GuildMessageReceivedEvent e, String[] args) {

        AudioManager am=e.getGuild().getAudioManager();

        try {
            if (!am.isConnected()) {
                am.openAudioConnection(e.getMember().getVoiceState().getChannel());
            }
        }catch(Exception expection){
            e.getChannel().sendMessage("** 是在哈嘍 你沒有加入 **").queue();
            return;
        }

        PlayerManager pm=PlayerManager.getInstance();

        try{
            pm.loadAndPlay(e.getChannel(), args[1]);
        }catch (ArrayIndexOutOfBoundsException exception) {
            pm.getGuildMusicManager(e.getGuild()).player.setPaused(false);
            return;
        }

        GuildMusicManager gmmm=pm.getGuildMusicManager(e.getGuild());
        //gmmm.player.setVolume(10);
        //e.getChannel().sendMessage(gmmm.player.getPlayingTrack().toString()).queue();

    }
}
