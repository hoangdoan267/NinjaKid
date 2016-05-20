package com.kienvu.Model;

/**
 * Created by vukien on 14/05/2016.
 */
public class EnemyNinja extends GameObjectWithHP {
    public EnemyNinja(int x, int y, int width, int height, int hp, int damage) {
        super(x, y, width, height, hp, damage);
        this.setLifeState(LifeState.RUN_RIGHT);
    }
}
