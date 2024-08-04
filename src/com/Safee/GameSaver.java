package com.Safee;

import java.io.FileWriter;
import java.io.IOException;

public class GameSaver {
    private String fileName;

    public GameSaver(String fileName)   {this.fileName = fileName;}

    public void saveGame (GameLevel gameLevel) throws IOException{
        //boolean append = true;
        FileWriter writer = null;
        try{
            writer = new FileWriter(fileName);

            writer.write(gameLevel.getLevelNumber() + "\n");
            writer.write(gameLevel.getHuman().getPosition().x + "," + gameLevel.getHuman().getPosition().y + "," + "\n");

        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }
}
