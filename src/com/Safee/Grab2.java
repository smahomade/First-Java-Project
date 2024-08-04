package com.Safee;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class Grab2 implements CollisionListener {

    private Human human;

    public Grab2(Human human) {this.human = human;}


    // if the jump image is grabbed increase JumpSpeed
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == human){
            KeyPad.JumpSpeed = 37.5f;
            e.getReportingBody().destroy();
        }

    }
}
