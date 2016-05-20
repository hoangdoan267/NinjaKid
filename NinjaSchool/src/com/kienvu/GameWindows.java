package com.kienvu;

import com.kienvu.Controller.Colliable.ColliablePool;
import com.kienvu.Controller.EnemyWarrior.EnemyWarriorControllerManager;
import com.kienvu.Controller.Ninja.NinjaController;
import com.kienvu.Controller.Ninja.NinjaControllerType;
import com.kienvu.GameScene.*;
import com.kienvu.Model.LifeState;
import com.kienvu.Model.Ninja;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * Created by vukien on 14/05/2016.
 */
public class GameWindows extends Frame implements Runnable, SceneListener{
    Thread thread;
    Image backbufferImage;
    GameConfig gameConfig;
    GameScene gameScene;

//    NinjaController ninjaController;
//    EnemyWarriorControllerManager enemyWarriorControllerManager;
    //KunaiControllerManager kunaiControllerManager;
    public GameWindows(){
        this.gameConfig = GameConfig.getInst();
        this.setVisible(true);
        this.setTitle("Ninja School");
        gameScene = new GameWelcome();
        gameScene.setGameSceneListener(this);
        this.setSize(gameConfig.getScreenWidth(), gameConfig.getScreenHeight());

//        ninjaController = NinjaController.getNinjaController();
//
//        enemyWarriorControllerManager = EnemyWarriorControllerManager.getInst();
//        try {
//            background = ImageIO.read(new File("resources/background.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

//        Timer t1 = new Timer(150, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(ninjaController.getNinjaControllerType() == NinjaControllerType.RIGHT){
//                    ninjaController.move(LifeState.STAND_RIGHT);
//                } else {
//                    ninjaController.move(LifeState.STAND_LEFT);
//                }
//
//            }
//        });
//        t1.setRepeats(false);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //System.out.println("Typed");

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println("Pressed");
                gameScene.onKeyPressed(e);
//
//                switch (e.getKeyCode()) {
//                    case KeyEvent.VK_RIGHT:
//                        ninjaController.setNinjaControllerType(NinjaControllerType.RIGHT);
//                        ninjaController.move(LifeState.RUN_RIGHT);
//                        break;
//                    case KeyEvent.VK_LEFT:
//                        ninjaController.setNinjaControllerType(NinjaControllerType.LEFT);
//                        ninjaController.move(LifeState.RUN_LEFT);
//                        break;
//                    case KeyEvent.VK_UP:
////                        if(ninjaController.isJump) {
////                            ninjaControllerType = NinjaControllerType.JUMP_UP;
////                            ninjaController.move(ninjaControllerType);
////                            ninjaController.isJump = false;
////                        }
//                        if (ninjaController.getNinjaControllerType() == NinjaControllerType.RIGHT) {
//                            ninjaController.move(LifeState.JUMP_RIGHT);
//                        } else  {
//                            ninjaController.move(LifeState.JUMP_LEFT);
//                        }
//                        break;
//                    case KeyEvent.VK_SPACE:
//                        if (ninjaController.getNinjaControllerType() == NinjaControllerType.RIGHT) {
//                            ninjaController.move(LifeState.ATTACK_RIGHT);
//                        } else  {
//                            ninjaController.move(LifeState.ATTACK_LEFT);
//                        }
//                        break;
//
//
//                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameScene.onKeyReleased(e);
                //System.out.println("Released");
//                switch (e.getKeyCode()) {
//                    case KeyEvent.VK_LEFT:
//                        ninjaController.move(LifeState.STAND_LEFT);
//                        break;
//                    case KeyEvent.VK_RIGHT:
//                        ninjaController.move(LifeState.STAND_RIGHT);
//                        break;
//                    case KeyEvent.VK_UP:
//                        if (ninjaController.getNinjaControllerType() == NinjaControllerType.RIGHT) {
//                            ninjaController.move(LifeState.STAND_RIGHT);
//                        } else  {
//                            ninjaController.move(LifeState.STAND_LEFT);
//                        }
//                        break;
//                    case KeyEvent.VK_SPACE:
//                        t1.restart();
//                        //System.out.println("2");
//
//
//                        break;
//
//                }


            }
        });


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println("Clicked");
//                t2.restart();
                gameScene.mouseClicked(e);

            }

            @Override
            public void mousePressed(MouseEvent e) {
                gameScene.mousePressed(e);
//                if (e.getX() > ninjaController.getGameObject().getX() + ninjaController.getGameObject().getWidth()) {
//                    ninjaController.setNinjaControllerType(NinjaControllerType.RIGHT);
//                    ninjaController.move(LifeState.THROW_RIGHT);
//                    ninjaController.shot(e.getX(), e.getY());
//                } else if (e.getX() < ninjaController.getGameObject().getX()) {
//                    ninjaController.setNinjaControllerType(NinjaControllerType.LEFT);
//                    ninjaController.move(LifeState.THROW_LEFT);
//                    ninjaController.shot(e.getX(), e.getY());
//                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("Released");
                //t2.restart();


            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(Graphics g) {
        if(backbufferImage == null){
            backbufferImage = new BufferedImage(gameConfig.getScreenWidth(), gameConfig.getScreenHeight(), 1);
        }
        Graphics backbufferGraphics = backbufferImage.getGraphics();
//        backbufferGraphics.drawImage(background, 0 , 0, gameConfig.getScreenWidth(),gameConfig.getScreenHeight(), null );
        gameScene.paint(backbufferGraphics);

        g.drawImage(backbufferImage , 0, 0, null);

    }

    @Override
    public void run() {
        while (true){
            try {
                repaint();
//                ColliablePool.getInst().run();
//                enemyWarriorControllerManager.run();
//                ninjaController.run();
                gameScene.run();;

                thread.sleep(gameConfig.getThreadDelay());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void changeScene(SceneType sceneType) {
        switch (sceneType){
            case PLAY:
                gameScene = new GamePlayScene();
                gameScene.setGameSceneListener(this);
                break;
            case TUTORIAL:
                gameScene = new TutorialGameScene();
                gameScene.setGameSceneListener(this);
                break;
        }

    }
}
