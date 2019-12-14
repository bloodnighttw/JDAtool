package com.bloodnighttw.JDAtool.MusicSystem;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;

import java.util.LinkedList;
import java.util.Queue;

public class TrackScheduler extends AudioEventAdapter {

    private final AudioPlayer player;
    private final Queue<AudioTrack> trackList;
    private boolean enableLoop=false;

    public TrackScheduler(AudioPlayer player){
        this.player=player;
        trackList=new LinkedList<AudioTrack>();
    }

    public void queue(AudioTrack at){
        if(!player.startTrack(at,true))
            trackList.add(at);
    }

    public void nextTrack(){
        if(!enableLoop)
            player.startTrack(trackList.poll(),false);
    }

    public void delAll(){
        trackList.clear();
    }

    public Queue<AudioTrack> getList(){
        return trackList;
    }

    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason){
        if (endReason.mayStartNext) {
            nextTrack();
        }

    }
}
