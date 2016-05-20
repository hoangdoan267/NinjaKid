package com.kienvu.Model;

import java.awt.*;

/**
 * Created by vukien on 14/05/2016.
 */
public class GameObject {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isALive = true;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isALive() {
        return isALive;
    }

    public void setALive(boolean ALive) {
        isALive = ALive;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public Rectangle getNextRect(GameVector gameVector) {
        return new Rectangle(x + gameVector.dx, gameVector.dy + y, width, height);
    }

    public void move(GameVector gameVector) {
        x += gameVector.dx;
        y += gameVector.dy;
    }

}
