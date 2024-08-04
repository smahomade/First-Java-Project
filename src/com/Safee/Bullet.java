package com.Safee;

import city.cs.engine.*;

public class Bullet extends DynamicBody {

    // making the bullets Shape and BodyImage
    private static final float radius = 0.5f;
    private static final Shape bulletShape = new CircleShape(radius);
    private static final BodyImage bulletImage = new BodyImage("data/Bullet.png", 3*radius);




    public Bullet(GameLevel world){
        // its a super for GameLevel so the methods that call the bullet wont need the Shape and BodyImage
        super(world,bulletShape);
        addImage(bulletImage);
        setGravityScale(0);
    }
}



