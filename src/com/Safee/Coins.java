package com.Safee;

import city.cs.engine.*;

public class Coins extends DynamicBody {

    // making the  Coin shape
    private static float coinSize = (float) 0.85;
    public static CircleShape shape = new CircleShape(coinSize);

    public Coins(GameLevel world) {
        // its a super for GameLevel so the methods that call the coin wont need the Shape
        super(world,shape);
        setGravityScale(0);
    }



}