package com.Safee;

import city.cs.engine.*;

public class Monster extends Walker {

    // making the Monster shape
    private static final Shape monsterShape = new BoxShape(3.4f,3.4f);

    public Monster(GameLevel world) {
        // its a super for GameLevel so the methods that call the monster wont need the Shape
        super(world, monsterShape);
    }


}
