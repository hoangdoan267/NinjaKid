package com.kienvu.Model;

/**
 * Created by vukien on 14/05/2016.
 */
public class Ninja extends GameObjectWithHP {
    public static final int DEFAULT_HP = 600;
    public static final int DEFAULT_DAMAGE = 30;
    public static final int SPEED = 5;
    private HPbar hPbar;
    public Ninja(int x, int y, int width, int height, int hp, int damage, HPbar hPbar) {
        super(x, y, width, height, hp, damage);
        this.setLifeState(LifeState.STAND_RIGHT);
        this.hPbar = hPbar;
    }

    public HPbar gethPbar() {
        return hPbar;
    }
}
