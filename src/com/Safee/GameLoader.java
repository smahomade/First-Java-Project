package com.Safee;

import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameLoader {

    private String fileName;

    private Game game;

    public GameLoader(String fileName, Game game){
        this.fileName = fileName;
        game = game;
    }



    public GameLevel loadGame() throws IOException{
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            int levelNumber = Integer.parseInt(line);

            line = reader.readLine();
            String[] tokens = line.split(",");

            float xPlayer = Float.parseFloat(tokens[0]);
            float yPlayer = Float.parseFloat(tokens[1]);
            Vec2 posPlayer = new Vec2(xPlayer,yPlayer);

            GameLevel level = null;
            if (levelNumber == 1){
                level = new Level1();
                level.populate(game);
                level.getHuman().setPosition(posPlayer);
            }
            else if (levelNumber == 2){
                level = new Level2();
                level.populate(game);
                level.getHuman().setPosition(posPlayer);
            }
            else if (levelNumber == 3){
                level = new Level3();
                level.populate(game);
                level.getHuman().setPosition(posPlayer);
            }
            else if (levelNumber == 4){
                level = new Level4();
                level.populate(game);
                level.getHuman().setPosition(posPlayer);
            }
            return level;

//            while (line != null) {
//                String[] tokens = line.split(",");
//                String name = tokens[0];
//                int score = Integer.parseInt(tokens[1]);
//                System.out.println("Name: " + name + ", Score: " + score);
//                line = reader.readLine();
//
//            }
//
//            System.out.println("... done.");
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null){
                fr.close();

            }

        }
    }
}

