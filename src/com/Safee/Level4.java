package com.Safee;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;



public class Level4 extends GameLevel{

    private Image background;
    private static final int NUM_COINS = 10;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // i added 1 coin and added a collision listener so the human can get in contact with the coin
        for (int i = 0; i < 1; i++) {
            Body coins = new Coins(this);
            coins.setPosition(new Vec2(25 , 7.5f));
            coins.addCollisionListener(new Grab(human));
            coins.addImage(new BodyImage("data/Coins.png", 3f));
        }

        // adds a new background image for this elvel
        background = new ImageIcon("data/Background4.jpg").getImage();

        /* i added a jump buff that increases the jump speed for the character for that level because the coin is far up
           i had to make a shape and body for the jump buff and make sure it gets destroyed during the collision
           also it will apply the new jump speed before getting destroyed */
        Shape jumpBuffShape = new BoxShape(1.3f,1.3f);
        Body jumpBuff = new StaticBody(this, jumpBuffShape);
        jumpBuff.setPosition(new Vec2(10,-13));
        jumpBuff.addImage(new BodyImage("data/UpArrowBuff.gif",4f));
        jumpBuff.addCollisionListener(new Grab2(human));

        // Adds a platform on the top, had to add a body,shape,image and position allowing you to be able to pass this level
        Shape platformShape = new BoxShape(3, 0.8f);
        Body platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2( 25, 5));
        platform.addImage(new BodyImage("data/Platform1.png", 2f));

        /* adds the Poison gas for this level, everything is already done by the PoisonGas class
        so we just have to call it for this level */
        new PoisonGas(this);

    }


    // position of your human character for this level
    @Override
    public Vec2 startPosition() {
        return new Vec2(0, -14f);
    }

    // position of the door for this level
    @Override
    public Vec2 doorPosition() {
        return new Vec2(-29, -14);
    }

    /* This code gives a requirement in order for the game to go to the next level
       You need 10 or more coins to get to the next level*/
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
        return 4;
    }
}
