package com.kienvu.Controller.EnemyBullet;

import com.kienvu.Model.EnemyBullet;
import com.kienvu.Model.GameVector;
import com.kienvu.View.ImageDrawer;

/**
 * Created by NGUYEN DINH QUAN on 5/19/2016.
 */
public class EnemyBulletDiagonBehavior implements EnemyBulletShotBehavior {
    @Override
    public EnemyBulletController doshot(int x, int y) {

        EnemyBullet enemyBullet =
                new EnemyBullet(x, y,EnemyBullet.WIDTH
                        , EnemyBullet.HEIGTH, 1,10);
        ImageDrawer imageDrawer = new ImageDrawer("resources/characters/Bullet/enemy_bullet.png");
        EnemyBulletController enemyBulletController = new EnemyBulletController(
                enemyBullet,
                imageDrawer,
                new GameVector(-3,3)
        );
        return enemyBulletController;
    }
}

