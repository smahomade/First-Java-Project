package com.Safee;


import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Destroy implements CollisionListener {
    private Human human;

    public Destroy(Human human)  {
        this.human = human;
    }

    @Override
    public void collide(CollisionEvent e) {
        // if the monster touches the human the monster gets destroyed and the life for the human reduces by one.
        if (e.getReportingBody() instanceof Monster && e.getOtherBody() == human) {
            human.decrementLifeCount();
            e.getReportingBody().destroy();

            // Added files for sound when the zombie attacks the human, human makes the sound
            File GruntingSound = new File("data/GruntingSound.wav");
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(GruntingSound));
                clip.start();
            }
            catch (Exception ignored) {
            }

            // if the humans lives ends up at 0 the game will end
            if(human.getLifeCount() == 0){
                System.out.println("GAME OVER!!!");
                TimerTask task = new TimerTask(){
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task,750);

                // Added a GAME OVER sound so when the life is at 0 there will be a GameOver sound effect
                File GameOver = new File("data/GameOverSound.wav");
                try {
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(GameOver));
                    clip.start();
                }
                catch (Exception ignored) {
                }
            }
        }

        // if the bullet touches the Monster the bullet and monster get destroyed and the human gets a +1 on the kill per monster destroyed
        if (e.getReportingBody() instanceof Monster && e.getOtherBody() instanceof Bullet) {

            e.getReportingBody().destroy();
            e.getOtherBody().destroy();
            human.incrementkillCount();

            // Added the sound when the zombie gets kill by the Bullet
            File ZombieDeathSound = new File("data/ZombieDeathSound.wav");
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(ZombieDeathSound));
                clip.start();
            }
            catch (Exception ignored) {
            }
        }

        // if the bullet touches the coin it destroys the coin and and bullet so you cant get to the next level.
        if (e.getReportingBody() instanceof Bullet && e.getOtherBody() instanceof Coins) {

            e.getReportingBody().destroy();
            e.getOtherBody().destroy();
        }



    }
}
