package com.Safee;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level2 extends GameLevel{

    private Image background;
    private static final int NUM_COINS = 4;



    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // i added 3 coins and added a collision listener so the human can get in contact with the coin
        for (int i = 0; i < 3; i++) {
            Body coins = new Coins(this);
            coins.setPosition(new Vec2( i * 20 - 20, -6));
            coins.addCollisionListener(new Grab(human));
            coins.addImage(new BodyImage("data/Coins.png", 3f));
        }

        // Calls the class to make the enemies for this level
        new MakeEnemiesLevel2(this, monster);

        // adds a different background for this level
        background = new ImageIcon("data/Background2.jpg").getImage();
    }

    // makes monsters on left side method is called by MakeEnemiesLevel2 class
    public void makeMonsterLeftSide(Monster monster){
        this.monster = monster;
        monster = new Monster(this);
        monster.setPosition(new Vec2(-35,-14.25f));
        monster.addCollisionListener(new Destroy(human));
        monster.startWalking(2.5f);
        monster.addImage(new BodyImage("data/ZombieWalkingRight.gif",8));

    }

    // makes monsters on right side method is called by MakeEnemiesLevel2 class
    public void makeMonsterRightSide(Monster monster){
        this.monster = monster;
        monster = new Monster(this);
        monster.setPosition(new Vec2(35,-14.25f));
        monster.addCollisionListener(new Destroy(human));
        monster.startWalking(-2.5f);
        monster.addImage(new BodyImage("data/ZombieWalkingLeft.gif",8));
    }

    // position of your human character for this level
    @Override
    public Vec2 startPosition() {
        return new Vec2(0, -14);
    }

    // position of the door for this level
    @Override
    public Vec2 doorPosition() {
        return new Vec2(-29, -14);
    }

    /* This code gives a requirement in order for the game to go to the next level
    You need 4 or more coins to get to the next level*/
    @Override
    public boolean isCompleted() {
        return getHuman().getCoinsCount() >= NUM_COINS;
    }

    // adds the background image
    @Override
    public Image getBackgroundImage() {
        return background;
    }

    @Override
    public int getLevelNumber() {
        return 2;
    }
}
