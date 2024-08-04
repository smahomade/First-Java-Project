package com.Safee;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Key;

public class ControlPanel {
    private JButton pauseButton;
    private JButton quitButton;
    private JButton restartButton;
    private JPanel mainPanel;
    private JButton increaseMSButton;
    private JButton slowMSButton;
    private JButton normalMSButton;
    private Game game;
    boolean clicked = false;
    Human body;




    public ControlPanel(Game game) {

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicked) {
                    game.getWorld().start();
                    clicked = false;
                    pauseButton.setText("Pause");
                } else {
                    game.getWorld().stop();
                    clicked = true;
                    pauseButton.setText("Start");
                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Game();
            }
        });
        increaseMSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int NewSpeed = 30;
                KeyPad.MovementSpeed = NewSpeed;

                if (clicked) {
                    clicked = true;
                    body.startWalking(NewSpeed);
                }

            }
        });
        slowMSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int NewSpeed = 5;
                KeyPad.MovementSpeed = NewSpeed;

                if (clicked) {
                    clicked = true;
                    body.startWalking(NewSpeed);
                }

            }
        });
        normalMSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int NewSpeed = 15;
                KeyPad.MovementSpeed = NewSpeed;

                if (clicked) {
                    clicked = true;
                    body.startWalking(NewSpeed);
                }

            }
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}
