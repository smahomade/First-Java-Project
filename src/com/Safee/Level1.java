package com.Safee;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level1 extends GameLevel{

    private Image background;
    public int NUM_COINS = 1;



    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // i added 1 coin and added a collision listener so the human can get in contact with the coin
        for (int i = 0; i < 1; i++) {
            Body coins = new Coins(this);
            coins.setPosition(new Vec2(25, -2.5f));
            coins.addCollisionListener(new Grab(human));
            coins.addImage(new BodyImage("data/Coins.png", 3f));
        }

        // added a platform for the coin so the human can actually grab it
        Shape platformShape = new BoxShape(3, 0.8f);
        Body platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2( 25, -14.75f));
        platform.addImage(new BodyImage("data/Platform1.png", 2f));

        // adds a different background for this level
        background = new ImageIcon("data/Background.jpg").getImage();

    }


    // position of your human character for this level
    @Override
    public Vec2 startPosition() {
        return new Vec2(0, -14f);
    }

    // position of the door for this level
    @Override
    public Vec2 doorPosition() {
        return new Vec2(-29,-14);
    }

    /* This code gives a requirement in order for the game to go to the next level
    You need 1 or more coins to get to the next level*/
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
        return 1;
    }


}

