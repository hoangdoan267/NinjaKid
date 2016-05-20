package com.kienvu.Controller.EnemyBullet;

import com.kienvu.Controller.ControllerManager;

/**
 * Created by NGUYEN DINH QUAN on 5/19/2016.
 */
public class EnemyBulletControllerManager extends ControllerManager {


    private static EnemyBulletControllerManager inst;
    public static EnemyBulletControllerManager getInst () {
        if(inst == null) {
            inst = new EnemyBulletControllerManager();
        }
        return inst;
    }
}
