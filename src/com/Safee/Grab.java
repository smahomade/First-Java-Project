package com.Safee;

import city.cs.engine.*;

public class Grab implements CollisionListener {

    private Human human;


    public Grab(Human human) {
        this.human = human;
    }

    // if the coin is grabbed it increments the coin count
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == human) {
            human.incrementCoinCount();
            e.getReportingBody().destroy();
        }
    }
}


