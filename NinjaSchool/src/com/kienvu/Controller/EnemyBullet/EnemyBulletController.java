package com.kienvu.Controller.EnemyBullet;

import com.kienvu.Controller.Colliable.Colliable;
import com.kienvu.Controller.Colliable.ColliablePool;
import com.kienvu.Controller.SingleController;
import com.kienvu.GameConfig;
import com.kienvu.Model.EnemyBullet;
import com.kienvu.Model.GameObject;
import com.kienvu.Model.GameVector;
import com.kienvu.View.GameDrawer;

import java.awt.*;

/**
 * Created by NGUYEN DINH QUAN on 5/19/2016.
 */
public class EnemyBulletController extends SingleController implements Colliable {
    public EnemyBulletController(GameObject gameObject, GameDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer, gameVector);
        ColliablePool.getInst().add(this);
    }
    public EnemyBulletController(EnemyBullet gameObject,
                                 GameDrawer gameDrawer,
                                 GameVector gameVector) {
        super(gameObject, gameDrawer, gameVector);
//        System.out.println(gameObject.getClass().toString());
        ColliablePool.getInst().add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.isALive()) {
            if (!GameConfig.getInst().isScreen(this.gameObject)) ;
            {
                this.gameObject.setALive(false);
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        if (gameObject.isALive()) {
            super.paint(g);
        }

    }

    @Override
    public void onCollide(Colliable c) {

    }
}
