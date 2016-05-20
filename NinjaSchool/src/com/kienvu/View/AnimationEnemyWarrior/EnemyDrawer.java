package com.kienvu.View.AnimationEnemyWarrior;

import com.kienvu.Model.GameObject;
import com.kienvu.Model.GameObjectWithHP;
import com.kienvu.View.GameDrawer;

import java.awt.*;

/**
 * Created by Trà Đá on 5/15/2016.
 */
public class EnemyDrawer extends GameDrawer {
    private AttackEnemyDrawer attackEnemyDrawer;
    private DyingEnemyDrawer dyingEnemyDrawer;
    private LeftEnemyDrawer leftEnemyDrawer;

    public EnemyDrawer(AttackEnemyDrawer attackEnemyDrawer, DyingEnemyDrawer dyingEnemyDrawer, LeftEnemyDrawer leftEnemyDrawer) {
        this.attackEnemyDrawer = attackEnemyDrawer;
        this.dyingEnemyDrawer = dyingEnemyDrawer;
        this.leftEnemyDrawer = leftEnemyDrawer;
    }

    @Override
    public void paint(Graphics g, GameObject gameObject) {
        GameObjectWithHP gameObjectWithHP = (GameObjectWithHP)gameObject;
        switch (gameObjectWithHP.getLifeState()){
            case DYING_LEFT:
                /*if(dyingEnemyDrawer == null){
                    gameObjectWithHP.setALive(false);
                    System.out.println("die");
                }
                else */
                    dyingEnemyDrawer.paint(g,gameObject);
                break;
            case RUN_LEFT:T:
                leftEnemyDrawer.paint(g,gameObject);
                break;
            case ATTACK_LEFT:
                attackEnemyDrawer.paint(g,gameObject);
                break;
        }
    }
}
