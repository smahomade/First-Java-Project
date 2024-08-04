package com.Safee;

import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

public class Game{


    // Declared GameLevel as world, so stuff like the platform/ground doesnt have to be repeated in each level
        private GameLevel world;

        // Declared the BackGround as view so i can change the background size and image by giving the view a class
        private BackGround view;

        // the int level will be changed when going to the next level
        private int level;

        // declared KeyPad as controller because every time we switch levels it will be a new "controller"
        private KeyPad controller;

        private int height = 750;
        private int width = 1250;


    public Game() {
        // make the world and start the first level
        level = 1;
        world = new Level1();
        world.populate(this);

        // make a view, this is based on BackGround class, and the human is linked to the score system
        view = new BackGround(world, world.getHuman(), width, height);


        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Gun Game");

        // Declare the ControlPanel class buttons while also making a new ControlPanel for each level then
        // add the buttons on the east side of the border layout of your game
        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(),BorderLayout.EAST);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);

        /* Allows focus on either control panel or the game depending on where you click with mouse,
        if i dont have this code the control panel will take full focus and i cant play the game */
        view.addMouseListener(new Focus(frame));
        frame.requestFocus();

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, width, height);

        // Detect key input
        controller = new KeyPad(world.getHuman(), getWorld(),world,this);
        frame.addKeyListener(controller);

        // start!
        world.start();
    }

    /** The player in the current level. */
    public Human getHuman() {
        return world.getHuman();
    }

    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    public void goToLevel (GameLevel lev){
        world.stop();
        level = lev.getLevelNumber();
        world = lev;
        // switch the keyboard control to the new player
        controller.setBody(world.getHuman());
        // bullets will appear in new world
        controller.setWorld(world,world);
        // show the new world in the view, ive changed the code so it will also set the background whilst setting new world in the view.
        view.setWorld(world);
        // starts Level 4
        world.start();

    }
    /** Advance to the next level of the game. */
    // Changes game level when you go step into the portal
    public void goNextLevel() {

            // Once you finish level 4 game will exit and the world will stop.
            world.stop();
           if (level == 4) {
            System.exit(0);
        } else if(level == 3){
            level++;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getHuman());
            // bullets will appear in new world, level will be incremented so i can save and load for every level
            controller.setWorld(world,world);
            // show the new world in the view, ive changed the code so it will also set the background whilst setting new world in the view.
            view.setWorld(world);
            // starts Level 4
            world.start();
        } else if(level == 2){
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getHuman());
            // bullets will appear in new world, level will be incremented so i can save and load for every level
            controller.setWorld(world,world);
            // show the new world in the view, ive changed the code so it will also set the background whilst setting new world in the view.
            view.setWorld(world);
            // starts Level 3
            world.start();
        }
        else {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getHuman());
            // bullets will appear in new world, level will be incremented so i can save and load for every level
            controller.setWorld(world,world);
            // show the new world in the view, ive changed the code so it will also set the background whilst setting new world in the view.
            view.setWorld(world);
            // starts Level 2
            world.start();
        }

    }



    public GameLevel getWorld() {
        return world;
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}


