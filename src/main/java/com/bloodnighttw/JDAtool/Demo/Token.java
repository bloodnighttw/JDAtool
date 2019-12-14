package com.bloodnighttw.JDAtool.Demo;

public class Token {

    static String token1="NDc=yXalKkV=S2Hq2Q";
    static String token2="5OTg1NDI1MTUxNDI2NTcz.XezlbA.Q9--";
    static String token3="zpp39dgKQj"

    static String getToken(){
        return token1.split("=")[0]+token2+token1.split("=")[1]+token3+token1.split("=")[2];
    }

}
