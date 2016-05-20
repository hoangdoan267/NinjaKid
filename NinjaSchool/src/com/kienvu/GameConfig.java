package com.kienvu;

import com.kienvu.Model.GameObject;

import java.awt.*;

/**
 * Created by vukien on 14/05/2016.
 */
public class GameConfig {
    private static final int SREEN_WIDTH = 1280;
    private static final int SCREEN_HEIGHT = 720;
    private static int DELAY = 17;
    private static final int CELLAR = 600;
    private static final int CEILING = 100;

    private int screenWidth;
    private int screenHeight;
    private int threadDelay;
    private int cellar;
    private int ceiling;

    public static int getDELAY() {
        return DELAY;
    }

    private GameConfig(int screenWidth, int screenHeight, int threadDelay) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.threadDelay = threadDelay;
        ceiling = CEILING;
        cellar = CELLAR;
    }

    public int getCellar() {
        return cellar;
    }

    public int getCeiling() {
        return ceiling;
    }

    public int getThreadDelay() {
        return threadDelay;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int durationInMiliSeconds(int count) {
        return count * threadDelay;
    }

    public int durationInSeconds(int count) {
        return durationInMiliSeconds(count) / 1000;
    }

    public boolean isScreen(GameObject gameObject) {
        return gameObject.getX() > 0&& gameObject.getX() < this.screenWidth
                && gameObject.getY() > 0 && gameObject.getY() < this.screenHeight;
    }

    public boolean isScreen(Rectangle rectangle) {
        return rectangle.getX() > 0 && rectangle.getX() + rectangle.getWidth() < this.screenWidth
                && rectangle.getY() > 25 && rectangle.getY() + rectangle.getHeight() < this.screenHeight;
    }
    private static GameConfig inst;
    public static GameConfig getInst(){
        if(inst == null){
            inst = new GameConfig(SREEN_WIDTH, SCREEN_HEIGHT, DELAY);

        }
        return inst;
    }
}
