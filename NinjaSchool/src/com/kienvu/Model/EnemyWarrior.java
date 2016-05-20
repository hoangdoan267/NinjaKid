package com.kienvu.Model;

/**
 * Created by Trà Đá on 5/15/2016.
 */
public class EnemyWarrior extends GameObjectWithHP {
    public EnemyWarrior(int x, int y, int width, int height, int hp, int damage) {
        super(x, y, width, height, hp, damage);
        this.setLifeState(LifeState.RUN_LEFT);
    }
}
