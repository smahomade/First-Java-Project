package com.Safee;

import city.cs.engine.*;

public class Human extends Walker {

    // static int allows the coin count, kill count and life count to not change when going to the next level
    private static int coinsCount = 0;
    private static int killCount = 0;
    private static int lifeCount = 3;


    // undo life count comment if you would like to reset health every level
    public Human(GameLevel world /*,int lifeCount*/) {
        super(world);
        //this.lifeCount = lifeCount;
        my_human();

    }

    public void my_human() {
        // make a character
        Shape humanShape = new BoxShape(4, 4);
        BodyImage image = (new BodyImage("data/StandingHuman.png", 9f));
        SolidFixture fixture = new SolidFixture(this, humanShape);
        addImage(image);
    }




    // used each level as a requirement to get to the next level and used for the foreground text
    public int getCoinsCount() { return coinsCount; }

//        public void setCoinsCount(int count) {
//        count = count;
//    }

    // used for the foreground text and when he gets hit by enemies
    public int getLifeCount(){
        return lifeCount;
    }

//    public void setLifeCount(int lifeCount) {
//        this.lifeCount = lifeCount;
//    }

    // used for the foreground text
    public int getKillCount() {
        return killCount;
    }


//    public void setKillCount(int killCount) {
//        this.killCount = killCount;
//    }


    // increases the coincount by 1 and prints out text on system to show your coin count
    public void incrementCoinCount() {
        coinsCount++;
        System.out.println("Coin Count = " + coinsCount);

    }

    // increases the killcount by 1 and prints out text on system to show your kill count
    public void incrementkillCount(){
        killCount++;
        System.out.println("Zombie Kill Number " + killCount);
    }

    // decreases the lifecount by 1 and prints out text on system to show your life count
    public void decrementLifeCount(){
        lifeCount--;
        System.out.println("Lives Remaining : " + lifeCount);
    }

}
