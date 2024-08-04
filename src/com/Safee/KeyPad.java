package com.Safee;
import city.cs.engine.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.Key;

public class KeyPad extends KeyAdapter {

    // More clean to use float for the speed
    public static float MovementSpeed = 15;
    public static float JumpSpeed = 17;

    // bullet body is a walker so i can use "startwalking" to make it smoother
    private Bullet bullet;
    // Rather use Human than walker just in case i get another walker class so keys wont get mixed up
    private Human body;

    // explained in Game class
    private GameLevel world;
    private GameLevel currentLevel;
    private Game game;

    // need this boolean for the bullet so if it faces left it shoots left if it face right it shoots right
    boolean facingLeft;


    // allows KeyPad class to be called by addKeyListener
    public KeyPad(Human body, GameLevel world,GameLevel level, Game game)
    {
        this.body = body;
        this.world = world;
        currentLevel = level;
        this.game = game;

    }

    @Override
    public void keyPressed(KeyEvent key) {

            /* break is used in a loop so loop is used only once when the key is pressed.
               if break is not there, it will loop constantly after one press */
            int code = key.getKeyCode();

            // if right key is pressed start walking right because X IS POSITIVE IN RIGHT SIDE
             if (code == KeyEvent.VK_RIGHT) {
                 facingLeft = false;
                 body.startWalking(MovementSpeed);
                 body.removeAllImages();
                 BodyImage image1 = (new BodyImage("data/WalkingHuman.gif", 9f));
                 body.addImage(image1);

            // if left key is pressed start walking left because X IS NEGATIVE IN LEFT SIDE
            } else if (code == KeyEvent.VK_LEFT) {
                 facingLeft = true;
                 body.startWalking(-MovementSpeed);
                 body.removeAllImages();
                 BodyImage image1 = (new BodyImage("data/BackWalkingHuman.gif", 9f));
                 body.addImage(image1);

            /* if space bar is pressed,character will jump by the speed given, however as there is a force of gravity you will
                not jump high enough */
            } if (code == KeyEvent.VK_UP){
                 body.jump(JumpSpeed);
                 body.setGravityScale(2.5f);
            }

             /* had to add a boolean so if the character is facing left he shoots left, if he is facing right he shoots right.
                The changing of the shooting positions are methods called from GameLevel and each method is called depending on
                the boolean, and i based the boolean from the left and right keys, which is how he shoots either left or right.
              */
           if (code == KeyEvent.VK_SPACE){

                if(facingLeft == false)
                    world.makeRightBullet();

                if (facingLeft == true)
                    world.makeLeftBullet();
            }

           if (code == KeyEvent.VK_S){
               GameSaver gameSaver = new GameSaver("data/sample.txt");
               try {
                   gameSaver.saveGame(currentLevel);
               }
               catch (IOException ex){
                   ex.printStackTrace();
               }
           }

           if (code == KeyEvent.VK_L){
               GameLoader gameLoader = new GameLoader("data/sample.txt",game);
               try {
                   GameLevel loadGame = gameLoader.loadGame();
                   game.goToLevel(loadGame);
               }
               catch (IOException ex){
                   ex.printStackTrace();
               }
           }
    }

    @Override
    public void keyReleased(KeyEvent key) {

            int code = key.getKeyCode();

            // if right key is released will become stationary
            if (code == KeyEvent.VK_RIGHT) {

                body.startWalking(0);
                body.removeAllImages();
                BodyImage image1 = (new BodyImage("data/StandingHuman.png", 9f));
                body.addImage(image1);

            }

            // if left key is released will become stationary
            else if (code == KeyEvent.VK_LEFT) {

                body.startWalking(0);
                body.removeAllImages();
                BodyImage image2 = (new BodyImage("data/BackStandingHuman.png", 9f));
                body.addImage(image2);

            }

            // if up key is released gravity scale is still applies and by physics Walker will drop on its own
            else if (code == KeyEvent.VK_UP) {
                body.setGravityScale(2.5f);

            }

    }

    // so my Human can be called in the next world with the key controls
    public void setBody(Human body) {
        this.body = body;
    }

    /* used for my bullet, because the methods are created depending on the KeyPad class
       i have to make sure that the controller class is based on which level i am on
       so the bullets wont stay in the first level */
    public void setWorld(GameLevel world,GameLevel level) {
        this.world = world;
        this.currentLevel = level;
    }
}


