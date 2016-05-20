package com.kienvu.View.AnimationNinja;

import com.kienvu.Model.GameObject;
import com.kienvu.Model.GameObjectWithHP;
import com.kienvu.View.GameDrawer;

import java.awt.*;

/**
 * Created by NGUYEN DINH QUAN on 5/15/2016.
 */
public class NinjaDrawer extends GameDrawer {
    private GameDrawer standRightGameDrawer;
    private GameDrawer standLeftGameDrawer;
    private GameDrawer runRightGameDrawer;
    private GameDrawer runLeftGameDrawer;
    private GameDrawer jumpRightGameDrawer;
    private GameDrawer jumpLeftGameDrawer;
    private GameDrawer throwRightGameDrawer;
    private GameDrawer throwLeftGameDrawer;
    private GameDrawer attackRightGameDrawer;
    private GameDrawer attackLeftGameDrawer;
    private GameDrawer dyingRightGameDrawer;
    private GameDrawer dyingLeftGameDrawer;


    public NinjaDrawer(GameDrawer standRightGameDrawer, GameDrawer standLeftGameDrawer,
                       GameDrawer runRightGameDrawer, GameDrawer runLeftGameDrawer,
                       GameDrawer jumpRightGameDrawer, GameDrawer jumpLeftGameDrawer,
                       GameDrawer throwRightGameDrawer, GameDrawer throwLeftGameDrawer,
                       GameDrawer attackRightGameDrawer, GameDrawer attackLeftGameDrawer,
                       GameDrawer dyingRightGameDrawer, GameDrawer dyingLeftGameDrawer) {
        this.standRightGameDrawer = standRightGameDrawer;
        this.standLeftGameDrawer = standLeftGameDrawer;
        this.runRightGameDrawer = runRightGameDrawer;
        this.runLeftGameDrawer = runLeftGameDrawer;
        this.jumpRightGameDrawer = jumpRightGameDrawer;
        this.jumpLeftGameDrawer = jumpLeftGameDrawer;
        this.throwRightGameDrawer = throwRightGameDrawer;
        this.throwLeftGameDrawer = throwLeftGameDrawer;
        this.attackRightGameDrawer = attackRightGameDrawer;
        this.attackLeftGameDrawer = attackLeftGameDrawer;
        this.dyingRightGameDrawer = dyingRightGameDrawer;
        this.dyingLeftGameDrawer = dyingLeftGameDrawer;
    }

    @Override
    public void paint(Graphics g, GameObject gameObject) {
        GameObjectWithHP gameObjectWithHP = (GameObjectWithHP)gameObject;
        switch (gameObjectWithHP.getLifeState()){
            case STAND_RIGHT:
                standRightGameDrawer.paint(g,gameObject);
                break;
            case STAND_LEFT:
                standLeftGameDrawer.paint(g, gameObject);
                break;
            case RUN_RIGHT:
                runRightGameDrawer.paint(g,gameObject);
                break;
            case RUN_LEFT:
                runLeftGameDrawer.paint(g, gameObject);
                break;
            case JUMP_RIGHT:
                jumpRightGameDrawer.paint(g,gameObject);
                break;
            case JUMP_LEFT:
                jumpLeftGameDrawer.paint(g, gameObject);
                break;
            case THROW_RIGHT:
                throwRightGameDrawer.paint(g, gameObject);
                break;
            case THROW_LEFT:
                throwLeftGameDrawer.paint(g, gameObject);
                break;
            case ATTACK_RIGHT:
                attackRightGameDrawer.paint(g,gameObject);
                break;
            case ATTACK_LEFT:
                attackLeftGameDrawer.paint(g, gameObject);
                break;
            case DYING_RIGHT:
                if(dyingRightGameDrawer == null){
                    gameObjectWithHP.setALive(false);
                }
                else dyingRightGameDrawer.paint(g,gameObject);
                break;
            case DYING_LEFT:
                if(dyingLeftGameDrawer == null){
                    gameObjectWithHP.setALive(false);
                }
                else dyingLeftGameDrawer.paint(g,gameObject);
                break;
        }
    }


}
