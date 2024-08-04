package com.Safee;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class PoisonGas extends Walker implements SensorListener {



    // making the PoisonGas Shape and BodyImage
    public Shape poisonGasShape = new CircleShape(4);
    public BodyImage poisonGasImage = new BodyImage("data/PoisonGas.png",9);


    /*
    this class will already have everything ready for it to be called in the level class
    i added the GhostlyFixture, Sensor, Gravity set to 0, the position and make the gas walk.
     */
    public PoisonGas(GameLevel world) {
        super(world);
        addImage(poisonGasImage);
        new GhostlyFixture(this, poisonGasShape);
        Sensor sensor = new Sensor(this, poisonGasShape);
        sensor.addSensorListener(this);
        setGravityScale(0);
        setPosition(new Vec2(-26,-11f));
        startWalking(5);

    }


    /* because its a ghostly fixture i needed to add a sensor to the class
       as a ghostly fixture doesnt collide with other bodies it can only sensor it.
     */
    @Override
    public void beginContact(SensorEvent sensorEvent) {
        /*
        if the ghostly fixture gets incontact with the Human the life will decrease by 1
         */
        if (sensorEvent.getContactBody() instanceof Human) {
            Human human = (Human)sensorEvent.getContactBody();
            human.decrementLifeCount();

            // Added Coughing sound so when the poisons gas gets incontact with the Human he coughs
            File CoughingSound = new File("data/CoughingSound.wav");
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(CoughingSound));
                clip.start();
            }
            catch (Exception ignored) {
            }
            if(human.getLifeCount() == 0) {
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
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }



}
