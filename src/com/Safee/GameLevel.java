package com.Safee;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevel extends World {


    public Human human;
    //private Coins coins;
    public Monster monster;
    //private Game world;
    //private Portal portal;
    private Game game;


    public void populate(Game game) {

        this.game = game;

        // make ground so we dont have to make it in each level class
        // added a loop feature to apply more images per body so the platform looks better
        int x = 35;
        for (int i = 0; i < 15; i = i + 1) {
            Shape groundShape = new BoxShape(5, 0.25f);
            Body ground = new StaticBody(this, groundShape);
            ground.setPosition(new Vec2(x, -18.75f));
            ground.addImage(new BodyImage("data/GrassFloor.png", 4f));
            x = x - 5;
        }

        // puts character inside the game
        human = new Human(this);
        human.setPosition(startPosition());

        // puts portal inside the game, used to go to the next levels
        Portal portal = new Portal(this, game);
        portal.setPosition(doorPosition());
        //portal.addCollisionListener(new PortalListener(game));

    }

    // Method makes bullets spawn on the right side
    public void makeRightBullet() {
        Bullet bullet = new Bullet(this);
        bullet.setPosition((human.getPosition().add(new Vec2(4.75f, 1.25f))));
        bullet.applyForce(new Vec2(1500, 0));
        bullet.addCollisionListener(new Destroy(human));

    }

    // Method makes bullets spawn on the left side
    public void makeLeftBullet() {
        Bullet bullet = new Bullet(this);
        bullet.setPosition((human.getPosition().sub(new Vec2(4.75f, -1.25f))));
        bullet.applyForce(new Vec2(-1500, 0));
        bullet.addCollisionListener(new Destroy(human));
    }



    /**
     * The initial position of the player.
     */
    public abstract Vec2 startPosition();

    /**
     * The position of the exit door.
     */
    public abstract Vec2 doorPosition();

    /**
     * Is this level complete?
     */
    public abstract boolean isCompleted();

    /**
     * Is this level complete?
     */
    public abstract Image getBackgroundImage();

    public abstract int getLevelNumber();

    public Human getHuman() {
        return human;
    }


}



