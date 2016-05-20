package com.kienvu.Model;

/**
 * Created by vukien on 14/05/2016.
 */
public class GameObjectWithHP extends GameObject {
    private int hp;
    private int damage;
    private LifeState lifeState;

    public LifeState getLifeState() {
        return lifeState;
    }

    public void setLifeState(LifeState lifeState) {
        this.lifeState = lifeState;
    }

    public GameObjectWithHP(int x, int y, int width, int height, int hp, int damage) {
        super(x, y, width, height);
        this.hp = hp;
        this.damage = damage;


    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void inscreaseHP(int delta) {
        this.hp += delta;
    }

    public void descrease(int delta) {
        this.hp -= delta;
    }
}
