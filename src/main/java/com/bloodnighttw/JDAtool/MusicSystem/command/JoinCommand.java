package com.bloodnighttw.JDAtool.MusicSystem.command;

import com.bloodnighttw.JDAtool.CommandSystem.Command;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoinCommand extends Command {

    private Logger log= LoggerFactory.getLogger(this.getClass());

    @Override
    public String getCommandName() {
        return "=join";
    }

    @Override
    public String getDescription() {
        return "A music bot join command";
    }

    @Override
    public void onCommand(GuildMessageReceivedEvent e, String[] args) {

        TextChannel tc=e.getChannel();
        AudioManager am=tc.getGuild().getAudioManager();

        GuildVoiceState gvs=e.getMember().getVoiceState();

        if(am.isConnected() && e.getGuild().getSelfMember().getVoiceState().getChannel().getIdLong()==gvs.getChannel().getIdLong()) {
            tc.sendMessage("**是在哈嘍?! 我已經在裡面了你還叫我加入**").queue();
            return;
        }

        if(!gvs.inVoiceChannel()){
            tc.sendMessage("**是在哈嘍?!  你沒在語音頻道裡你還叫我加入**").queue();
            return;
        }

        VoiceChannel vc=gvs.getChannel();
        Member botSelf=e.getGuild().getSelfMember();

        if(!botSelf.hasPermission(vc, Permission.VOICE_CONNECT)){
            tc.sendMessage("**是在哈嘍?!  我沒有權限你還叫我加入**").queue();
        }

        am.openAudioConnection(vc);
        tc.sendMessage("**哈嘍  我加入了你所在的語音頻道**").queue();

    }
}
