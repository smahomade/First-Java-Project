package com.Safee;

import city.cs.engine.*;

import javax.swing.text.View;

public class Portal extends StaticBody implements SensorListener{

    /**
     * Initialise a new door.
     * @param world The world.
     */

    // making the Portal Shape and BodyImage
    private static final Shape portalShape = new BoxShape(1.5f,3f);
    private static final BodyImage portalImage = new BodyImage("data/BluePortal.gif", 7f);

    private Game game;
    private GameLevel world;

    /* The portal is being called from GameLevel and the method also need Game so it can be displayed on every level.
       also added the ghostly fixture so monsters can go through the portal and because it is a ghostly fixture
       i also had to add a sensor listener as a replacement for a collision listener */
    public Portal(GameLevel world, Game game) {
        super(world);
        this.game = game;
        this.world = world;
        addImage(portalImage);
        new GhostlyFixture(this,portalShape);
        Sensor sensor = new Sensor(this, portalShape);
        sensor.addSensorListener(this);

    }


    /* sensor for the portal because its a ghostly fixture that allows the monsters to go through it
    once it contact with the portal after getting the required coins you can go tot he next level */
    @Override
    public void beginContact(SensorEvent sensorEvent) {

        if (sensorEvent.getContactBody() == world.getHuman())
        {
            if (world.isCompleted()){
                game.goNextLevel();
            }

        }

    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
