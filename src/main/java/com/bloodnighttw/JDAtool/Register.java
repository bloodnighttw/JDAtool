package com.bloodnighttw.JDAtool;

import net.dv8tion.jda.api.JDA;

public class Register {

    public static JDA jda;

    public void registerJDA(JDA jda){
        Register.jda=jda;
    }

    public static JDA getJDA(){
        return jda;
    }
}
