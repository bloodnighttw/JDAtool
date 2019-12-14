package com.bloodnighttw.JDAtool.MusicSystem.command;

import com.bloodnighttw.JDAtool.CommandSystem.Command;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeaveCommand extends Command {

    private Logger log= LoggerFactory.getLogger(this.getClass());

    @Override
    public String getCommandName() {
        return "=leave";
    }

    @Override
    public String getDescription() {
        return "a leave command";
    }

    @Override
    public void onCommand(GuildMessageReceivedEvent e, String[] args) {

        AudioManager am=e.getGuild().getAudioManager();
        GuildVoiceState gvs=e.getMember().getVoiceState();
        TextChannel tc=e.getChannel();


        if(am.isConnected() && e.getGuild().getSelfMember().getVoiceState().getChannel().getIdLong()==gvs.getChannel().getIdLong()) {
            tc.sendMessage("**哈瞜?! 我已經離開了**").queue();
            am.closeAudioConnection();
            return;
        }
        else
            tc.sendMessage("**你在衝三小**").queue();
    }
}
