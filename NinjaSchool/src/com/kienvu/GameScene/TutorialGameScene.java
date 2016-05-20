package com.kienvu.GameScene;

import com.kienvu.GameConfig;
import com.kienvu.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Trà Đá on 5/18/2016.
 */
public class TutorialGameScene extends GameScene {

    Image image;

    public TutorialGameScene() {
        this.image = Utils.loadImage("resources/background/gameintro.jpg");
    }

    @Override
    public void run() {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.image, 0, 0,
                GameConfig.getInst().getScreenWidth(), GameConfig.getInst().getScreenHeight(), null);
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
        changeScene(SceneType.PLAY);
    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
}
