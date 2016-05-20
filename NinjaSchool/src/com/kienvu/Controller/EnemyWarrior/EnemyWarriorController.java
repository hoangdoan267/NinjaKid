package com.kienvu.Controller.EnemyWarrior;

import com.kienvu.Controller.Colliable.Colliable;
import com.kienvu.Controller.Colliable.ColliablePool;
import com.kienvu.Controller.EnemyBullet.EnemyBulletController;
import com.kienvu.Controller.EnemyBullet.EnemyBulletControllerManager;
import com.kienvu.Controller.EnemyBullet.EnemyBulletDiagonBehavior;
import com.kienvu.Controller.EnemyBullet.EnemyBulletShotBehavior;
import com.kienvu.Controller.Ninja.NinjaController;
import com.kienvu.Controller.SingleController;
import com.kienvu.GameConfig;
import com.kienvu.Model.*;
import com.kienvu.Utils;
import com.kienvu.View.AnimationEnemyWarrior.AttackEnemyDrawer;
import com.kienvu.View.AnimationEnemyWarrior.DyingEnemyDrawer;
import com.kienvu.View.AnimationEnemyWarrior.EnemyDrawer;
import com.kienvu.View.AnimationEnemyWarrior.LeftEnemyDrawer;
import com.kienvu.View.GameDrawer;

import java.awt.*;

/**
 * Created by Trà Đá on 5/15/2016.
 */
public class EnemyWarriorController extends SingleController implements Colliable {
    public static int SPEED_ENEMY = 5;
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_DAMAGE = 10;
    private int c = 0;
    private int count = 0;
    private EnemyBulletShotBehavior enemyBulletShotBehavior;

    public EnemyWarriorController(EnemyWarrior gameObject,
                                  GameDrawer gameDrawer,
                                  GameVector gameVector,
                                  EnemyBulletShotBehavior enemyBulletShotBehavior) {
        super(gameObject, gameDrawer, gameVector);
        this.gameVector = gameVector;
        this.enemyBulletShotBehavior = enemyBulletShotBehavior;
        ColliablePool.getInst().add(this);
    }

    @Override
    public void run() {

        super.run();
        count++;
        if(GameConfig.getInst().durationInSeconds(count) > 1){
            count = 0;
            shot();
        }
//        if (((GameObjectWithHP) gameObject).getLifeState() != LifeState.DEAD) {
//            super.run();
//            if (gameObject.getY() > GameConfig.getInst().getCellar() - gameObject.getY()) {
//                ((GameObjectWithHP) gameObject).setLifeState(LifeState.RUN);
//                System.out.println("run");
//            }
////        } else {
////            gameVector = new GameVector(2, 0);
////            gameObject.move(gameVector);
//        }
//        super.run();

        if (!GameConfig.getInst().isScreen(this.gameObject)) {
            this.gameObject.setALive(false);


        }
    }
    private void shot(){
        if(enemyBulletShotBehavior != null){
            EnemyBulletController enemyBulletController = enemyBulletShotBehavior.doshot(
                    gameObject.getX() + gameObject.getWidth() / 2 - EnemyBullet.WIDTH / 2,
                    gameObject.getY() + gameObject.getHeight()
            );
            System.out.println(enemyBulletController.getGameObject().isALive());

            EnemyBulletControllerManager.getInst().add(enemyBulletController);
//            System.out.println(String.valueOf(EnemyBulletControllerManager.getInst().size()));
        }
    }
    public void die() {
        /* Effect */
        /* Play sound */
//        Utils.playSound("resources/arrow_x.wav", false);
        this.gameObject.setALive(false);
    }
    @Override
    public void paint(Graphics g) {
            super.paint(g);

    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof NinjaController) {
            // int s = c.getGameObject().getX() + c.getGameObject().getWidth();

            this.gameVector.dx = 0;
            ((GameObjectWithHP) gameObject).setLifeState(LifeState.ATTACK_LEFT);
            if (((GameObjectWithHP) c.getGameObject()).getLifeState() != LifeState.ATTACK_LEFT) {
                this.c++;
                if (GameConfig.getInst().durationInSeconds(this.c) > 0) {
                    this.c = 0;
                    ((GameObjectWithHP) c.getGameObject()).descrease(((GameObjectWithHP) gameObject).getDamage());
                    System.out.println("hp enemy: " + ((GameObjectWithHP) c.getGameObject()).getHp());
                }
            } else {
                ((GameObjectWithHP) gameObject).setLifeState(LifeState.DYING_LEFT);
            }

            if (((GameObjectWithHP) c.getGameObject()).getHp() <= 0) {
                ((GameObjectWithHP) c.getGameObject()).setLifeState(LifeState.DYING_LEFT);
            }

        }
    }
//    public float jump(){
//        float positionY = gameObject.getY();
//        float positionX;
//        float velocityX;
//        float velocityY = -6.0f;
//        float g = 0.25f;
//        positionY += positionY;
//        velocityY += g;
//        return positionY;
//
//    }

    public static EnemyWarriorController create(int x, int y, EnemyWarriorType enemyWarriorType) {
        EnemyWarriorController enemyWarriorController = null;
        switch (enemyWarriorType) {
            case LINH:

                    //ATTACK
                    AttackEnemyDrawer attackEnemyDrawer = new AttackEnemyDrawer(Utils.loadImage("enemywarrior", "Attack", 10));
                    //LEFT
                    LeftEnemyDrawer leftEnemyDrawer = new LeftEnemyDrawer(Utils.loadImage("enemywarrior", "Walk", 10));
                    //DYING
                    DyingEnemyDrawer dyingEnemyDrawer = new DyingEnemyDrawer(Utils.loadImage("enemywarrior", "Dead", 10));
                    GameVector gameVector = new GameVector(-2, 0);
                    EnemyWarrior enemyWarrior = new EnemyWarrior(
                            x,
                            y,
                            Utils.loadImage("enemywarrior", "Attack", 10).get(0).getWidth(),
                            Utils.loadImage("enemywarrior", "Attack", 10).get(0).getHeight(),
                            DEFAULT_HP,
                            DEFAULT_DAMAGE);
                    enemyWarriorController = new EnemyWarriorController(enemyWarrior,
                            new EnemyDrawer(attackEnemyDrawer, dyingEnemyDrawer, leftEnemyDrawer),
                            gameVector,
                    new EnemyBulletDiagonBehavior());

                    break;
            case DRAGON:

                    //ATTACK
                    AttackEnemyDrawer attackEnemyDragonDrawer = new AttackEnemyDrawer(Utils.loadImage("enemywarrior", "Attack", 10));
                    //LEFT
                    LeftEnemyDrawer leftEnemyDragonDrawer = new LeftEnemyDrawer(Utils.loadImage("DRAGON", "frame", 4));
                    //DYING
                    DyingEnemyDrawer dyingEnemyDragonDrawer = new DyingEnemyDrawer(Utils.loadImage("enemywarrior", "Dead", 10));
                    GameVector gameVectorDragon = new GameVector(-2, 0);
                    EnemyWarrior enemyWarriorDragon = new EnemyWarrior(
                            x,
                            y,
                            Utils.loadImage("enemywarrior", "Attack", 10).get(0).getWidth(),
                            Utils.loadImage("enemywarrior", "Attack", 10).get(0).getHeight(),
                            DEFAULT_HP,
                            DEFAULT_DAMAGE);
                    enemyWarriorController = new EnemyWarriorController(enemyWarriorDragon,
                            new EnemyDrawer(attackEnemyDragonDrawer, dyingEnemyDragonDrawer, leftEnemyDragonDrawer),
                            gameVectorDragon, new EnemyBulletDiagonBehavior());

                    break;

        }

        return enemyWarriorController;
    }
}

