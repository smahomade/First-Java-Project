package com.Safee;

import city.cs.engine.*;
import java.awt.*;




public class BackGround extends UserView {

    Human human;

    public BackGround(World w, Human human, int width, int height) {
        super(w,width,height);
        this.human = human;
    }

    /* method allows me to draw the background image DEPENDING on the level aswell as getting the height and width of the game itself.
       So basically i dont have to change the image size when i add an image, so i can add an image with ease.
       Also can add different images for each level */
    @Override
    public void paintBackground(Graphics2D graphics) {
        super.paintBackground(graphics);

        graphics.drawImage(((GameLevel)this.getWorld()).getBackgroundImage(),0 , 0, getWidth(),getHeight(),null);

    }

    // displaying on the foreground of the game
    @Override
    public void paintForeground (Graphics2D graphics){
        super.paintForeground(graphics);


        // Score displayed on the screen
        graphics.setFont(new Font("Courgette",Font.BOLD,24));
        graphics.setColor(new Color(255,255,255));
        graphics.drawString("Score: " + human.getCoinsCount() ,30,40);

        // Lives displayed on the screen
        graphics.setFont(new Font("Courgette",Font.BOLD,24));
        graphics.setColor(new Color(255,255,255));
        graphics.drawString("Lives: " + human.getLifeCount() ,30,70);

        // Kills displayed on the screen
        graphics.setFont(new Font("Courgette",Font.BOLD,24));
        graphics.setColor(new Color(255,255,255));
        graphics.drawString("Kills: " + human.getKillCount() ,30,100);

    }

}


