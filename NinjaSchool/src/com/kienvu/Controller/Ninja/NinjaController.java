package com.kienvu.Controller.Ninja;

import com.kienvu.Controller.Colliable.Colliable;
import com.kienvu.Controller.Colliable.ColliablePool;
import com.kienvu.Controller.Kunai.KunaiController;
import com.kienvu.Controller.Kunai.KunaiControllerManager;
import com.kienvu.Controller.SingleController;
import com.kienvu.GameConfig;
import com.kienvu.Model.*;
import com.kienvu.Utils;
import com.kienvu.View.AnimationGameDrawer;
import com.kienvu.View.AnimationKunai.AnimationKunai;
import com.kienvu.View.AnimationNinja.*;
import com.kienvu.View.GameDrawer;
import com.sun.media.sound.UlawCodec;

import java.awt.*;

/**
 * Created by vukien on 14/05/2016.
 */
public class NinjaController extends SingleController implements Colliable {

    private float positionY;
    private float positionX;
    private float velocityY;
    private float velocityX;
    private float gravity = 0.5f;

    public boolean isJump = true;

    private NinjaControllerType ninjaControllerType = NinjaControllerType.RIGHT;

    private int c;
    private KunaiControllerManager kunaiControllerManager;


    private NinjaController(Ninja gameObject, GameDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer, gameVector);
        positionY = gameObject.getY();
        positionX = gameObject.getX();
        ColliablePool.getInst().add(this);
        kunaiControllerManager = new KunaiControllerManager();
    }

    public NinjaControllerType getNinjaControllerType() {
        return ninjaControllerType;
    }

    public void setNinjaControllerType(NinjaControllerType ninjaControllerType) {
        this.ninjaControllerType = ninjaControllerType;
    }

    public void move(LifeState lifeState) {
        switch (ninjaControllerType) {
            case LEFT:
                switch (lifeState) {
                    case STAND_LEFT:
                        this.gameVector.dx = 0;
                        ((GameObjectWithHP)gameObject).setLifeState(LifeState.STAND_LEFT);
                        break;
                    case RUN_LEFT:
                        this.gameVector.dx = -Ninja.SPEED;
                        ((GameObjectWithHP)gameObject).setLifeState(LifeState.RUN_LEFT);
                        break;
                    case JUMP_LEFT:
                        ((GameObjectWithHP)gameObject).setLifeState(LifeState.JUMP_LEFT);
                        break;
                    case ATTACK_LEFT:
                        ((GameObjectWithHP)gameObject).setLifeState(LifeState.ATTACK_LEFT);
                        this.gameVector.dx = 0;
                        break;
                    case THROW_LEFT:
                        ((GameObjectWithHP)gameObject).setLifeState(LifeState.THROW_LEFT);
                        break;
                }
                break;
            case RIGHT:
                switch (lifeState){
                    case STAND_RIGHT:
                        this.gameVector.dx = 0;
                        ((GameObjectWithHP)gameObject).setLifeState(LifeState.STAND_RIGHT);
                        break;
                    case RUN_RIGHT:
                        this.gameVector.dx = Ninja.SPEED;
                        ((GameObjectWithHP)gameObject).setLifeState(LifeState.RUN_RIGHT);
                        break;
                    case JUMP_RIGHT:
                        ((GameObjectWithHP)gameObject).setLifeState(LifeState.JUMP_RIGHT);
                        break;
                    case ATTACK_RIGHT:
                        this.gameVector.dx = 0;
                        ((GameObjectWithHP)gameObject).setLifeState(LifeState.ATTACK_RIGHT);
                        break;
                    case THROW_RIGHT:
                        ((GameObjectWithHP)gameObject).setLifeState(LifeState.THROW_RIGHT);
                        break;
                }
                break;

        }
    }

    private static NinjaController ninjaController;
    public static NinjaController getNinjaController() {
        if(ninjaController == null) {
            GameVector gameVector = new GameVector();
            //STAND_RIGHT
            StandRightNinjaDrawer standRightNinjaDrawer = new StandRightNinjaDrawer(Utils.loadImage("main", "Idle", 10));
            //STAND_LEFT
            StandLeftNinjaDrawer standLeftNinjaDrawer = new StandLeftNinjaDrawer(Utils.loadImage("main_2", "Idle", 10));
            //RUN_RIGHT
            RunRightNinjaDrawer runRightNinjaDrawer = new RunRightNinjaDrawer(Utils.loadImage( "main", "Run", 10));
            //RUN_LEFT
            RunLeftNinjaDrawer runLeftNinjaDrawer = new RunLeftNinjaDrawer(Utils.loadImage("main_2", "Run", 10));
            //JUMP_RIGHT
            JumpRightNinjaDrawer jumpRightNinjaDrawer = new JumpRightNinjaDrawer(Utils.loadImage("main", "Jump", 10));
            //JUMP_LEFT
            JumLeftNinjaDrawer jumLeftNinjaDrawer = new JumLeftNinjaDrawer(Utils.loadImage("main_2", "Jump", 10));
            //THROW_RIGHT
            ThrowRightNinjaDrawer throwRightNinjaDrawer = new ThrowRightNinjaDrawer(Utils.loadImage("main", "Throw", 10));
            //THROW_LEFT
            ThrowLeftNinjaDrawer throwLeftNinjaDrawer = new ThrowLeftNinjaDrawer(Utils.loadImage("main_2", "Throw", 10));
            //ATTACK_RIGHT
            AttackRightNinjaDrawer attackRightNinjaDrawer = new AttackRightNinjaDrawer(Utils.loadImage( "main", "Attack", 10));
            //ATTACK_LEFT
            AttackLeftNinjaDrawer attackLeftNinjaDrawer = new AttackLeftNinjaDrawer(Utils.loadImage("main_2", "Attack", 10));
            //DYING_RIGHT
            DyingRightNinjaDrawer dyingRightNinjaDrawer = new DyingRightNinjaDrawer(Utils.loadImage( "main", "Dead", 10));
            //DYING_LEFT
            DyingLeftNinjaDrawer dyingLeftNinjaDrawer = new DyingLeftNinjaDrawer(Utils.loadImage("main_2", "Dead", 10));
            HPbar hPbar = new HPbar(HPbar.X, HPbar.Y, HPbar.W, HPbar.H);
            Ninja ninja = new Ninja(
                    100
                    ,GameConfig.getInst().getCellar() - Utils.loadImage("main", "Idle", 10).get(0).getHeight()
                    ,Utils.loadImage( "main", "Idle", 10).get(0).getWidth(),Utils.loadImage("main", "Idle", 10).get(0).getHeight()
                    ,Ninja.DEFAULT_HP,
                    Ninja.DEFAULT_DAMAGE, hPbar);
            NinjaDrawer ninjaDrawer = new NinjaDrawer(
                    standRightNinjaDrawer, standLeftNinjaDrawer,
                    runRightNinjaDrawer, runLeftNinjaDrawer,
                    jumpRightNinjaDrawer, jumLeftNinjaDrawer,
                    throwRightNinjaDrawer, throwLeftNinjaDrawer,
                    attackRightNinjaDrawer, attackLeftNinjaDrawer,
                    dyingRightNinjaDrawer, dyingLeftNinjaDrawer
            );

            NinjaHPDrawer ninjaHPDrawer = new NinjaHPDrawer(
                    Utils.loadHPBarImages()
            );

            ninjaController = new NinjaController(ninja, new NinjaComboDrawer(ninjaDrawer, ninjaHPDrawer), gameVector);

        }
        return ninjaController;
    }

    @Override
    public void paint(Graphics g) {
        if (gameObject.isALive()) {
            super.paint(g);
            kunaiControllerManager.paint(g);
        }

    }

    @Override
    public void run() {
        if(gameObject.isALive()) {
            Rectangle rectangle = this.gameObject.getNextRect(this.gameVector);
            if (GameConfig.getInst().isScreen(rectangle)) {
                if (((GameObjectWithHP)gameObject).getLifeState() != LifeState.JUMP_RIGHT || ((GameObjectWithHP)gameObject).getLifeState() != LifeState.JUMP_LEFT) {
                    super.run();
                    kunaiControllerManager.run();
                } else {
                    updateJump(3);

                }

            }

        }
    }

    public void shot(int mousePosX, int mousePosY) {
        double delta;
        double rotate;
        int dx;
        int dy;
        Kunai kunai;
        GameVector gameVector;
        AnimationKunai animationKunai = new AnimationKunai(Utils.loadImage("main", "Kunai", 2));
        KunaiController kunaiController;

        if (((GameObjectWithHP)gameObject).getLifeState() == LifeState.THROW_RIGHT) {
            kunai = new Kunai(gameObject.getX() + gameObject.getWidth(), gameObject.getY(), 50, 50, 0, Kunai.DEFAULT_DAMAGE);
            delta = Math.sqrt((gameObject.getX() + gameObject.getWidth() - mousePosX)*(gameObject.getX() + gameObject.getWidth() - mousePosX) + (kunai.getY() - mousePosY)*(kunai.getY() - mousePosY));
            rotate = Math.asin((-gameObject.getY() + mousePosY)/delta);
            dx = (int)(Kunai.DEFAULT_SPEED*Math.cos(rotate));
            dy = (int)(Kunai.DEFAULT_SPEED*Math.sin(rotate));
            gameVector = new GameVector(dx, dy);
            kunaiController = new KunaiController(
                    kunai,
                    animationKunai,
                    gameVector
            );
            kunaiControllerManager.add(kunaiController);
        } else if (((GameObjectWithHP)gameObject).getLifeState() == LifeState.THROW_LEFT) {
            kunai = new Kunai(gameObject.getX(), gameObject.getY(), 50, 50, 0, Kunai.DEFAULT_DAMAGE);
            delta = Math.sqrt((gameObject.getX() - mousePosX)*(gameObject.getX() - mousePosX) + (gameObject.getY() - mousePosY)*(gameObject.getY() - mousePosY));
            rotate = Math.asin((-gameObject.getY() + mousePosY)/delta);
            dx = (int)(-Kunai.DEFAULT_SPEED*Math.cos(rotate));
            dy = (int)(Kunai.DEFAULT_SPEED*Math.sin(rotate));
            gameVector = new GameVector(dx, dy);
            kunaiController = new KunaiController(
                    kunai,
                    animationKunai,
                    gameVector
            );
            kunaiControllerManager.add(kunaiController);
        }
    }


    private void updateJump(float time) {
        positionX += velocityX * time;
        positionY += velocityY * time;
        velocityY += gravity * time;


        if (positionY > GameConfig.getInst().getCellar() - gameObject.getHeight()) {
            positionY = GameConfig.getInst().getCellar() - gameObject.getHeight();
            gameObject.setY((int)positionY);
            gameObject.setX((int)positionX);
            isJump = true;
            ((GameObjectWithHP)ninjaController.gameObject).setLifeState(LifeState.STAND_RIGHT);
            velocityX = 0.0f;
        } else {

            gameObject.setX((int)positionX);
            gameObject.setY((int)positionY);
        }


    }

    @Override
    public void onCollide(Colliable c) {
//

    }


}
