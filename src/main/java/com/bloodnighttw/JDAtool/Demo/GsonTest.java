package com.bloodnighttw.JDAtool.Demo;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class GsonTest {

    private GsonExample gsonExample=null;

    static Logger logger= LoggerFactory.getLogger(GsonTest.class);

    public GsonTest() throws IOException {
        Gson gson=new Gson();
        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(GsonExample.class.getResource("").getPath().split("com")[0]+"setting.json"));

            gsonExample= gson.fromJson(br, GsonExample.class);

            //logger.info("ssss");

        }catch (FileNotFoundException e){

            FileWriter writer = new FileWriter(GsonExample.class.getResource("").getPath().split("com")[0]+"setting.json");
            writer.write(gson.toJson(new GsonExample()));
            writer.close();
            logger.warn("Can't find file setting.json.");
            logger.info("generaling file \" setting.json\"");
            logger.warn("because there is nothing in \"setting.json\". So Stoping thw JDA server");
            System.exit(0);

        }
    }

    public GsonExample getGsonExample() {
        return gsonExample;
    }
}
