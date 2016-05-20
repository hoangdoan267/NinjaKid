package com.kienvu.Model;

/**
 * Created by NGUYEN DINH QUAN on 5/19/2016.
 */
public class EnemyBullet extends GameObjectWithHP {
public static final int WIDTH = 16;
public static final int HEIGTH = 16;
public static final int DAMAGE = 16;
private int damage = DAMAGE;

    public void setDamage(int Damage) {
        this.damage = Damage;
    }

    public static int getDAMAGE() {
        return DAMAGE;
    }

    public EnemyBullet(int x, int y, int width, int height, int hp, int damage) {
        super(x, y, width, height, hp, damage);
        this.damage = damage;
    }

}
