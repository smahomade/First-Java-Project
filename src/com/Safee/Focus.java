package com.Safee;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// after implementing the MouseListener you should be able to get all MouseEvents
public class Focus implements MouseListener {

    private Component target;

    public Focus(Component target){
        this.target = target;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    // this allows me to get the focus of the game and the control panel depending on where my mouse is
    @Override
    public void mouseEntered(MouseEvent e) {
        target.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
