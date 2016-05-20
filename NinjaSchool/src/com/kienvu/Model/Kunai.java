package com.kienvu.Model;

/**
 * Created by vukien on 19/05/2016.
 */
public class Kunai extends GameObjectWithHP {
    public static int DEFAULT_DAMAGE = 5;
    public static int DEFAULT_SPEED = 10;

    public Kunai(int x, int y, int width, int height, int hp, int damage) {
        super(x, y, width, height, hp, damage);
    }

}
