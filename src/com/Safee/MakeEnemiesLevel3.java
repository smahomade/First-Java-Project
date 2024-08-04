package com.Safee;

import city.cs.engine.Walker;

import java.util.Timer;
import java.util.TimerTask;


public class MakeEnemiesLevel3 extends Walker {


    private Monster monster;

    public MakeEnemiesLevel3(Level3 world, Monster monster) {
        super(world);
        this.monster = monster;

        // calls method from class Level3 and spawns monsters from left side
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                world.makeMonsterLeftSide(MakeEnemiesLevel3.this.monster);

            }
        };

        // calls method from class Level3 and spawns monsters from right side
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                world.makeMonsterRightSide(MakeEnemiesLevel3.this.monster);

            }


        };


        Timer timer = new Timer();

        // monsters on the left come every 2.5 seconds
        timer.schedule(task1, 0, 2500);

        //monsters on the right come every 3 seconds
        timer.schedule(task2, 0, 3000);

    }

}
