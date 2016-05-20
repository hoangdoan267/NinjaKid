package com.kienvu.GameScene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Trà Đá on 5/18/2016.
 */
public abstract class GameScene {


        private SceneListener gameSceneListener;

        public void setGameSceneListener(SceneListener gameSceneListener) {
            this.gameSceneListener = gameSceneListener;
        }

        protected void changeScene(SceneType gameScenceType) {
            if(gameSceneListener != null) {
                gameSceneListener.changeScene(gameScenceType);
            }
        }

        public abstract void run();

        public abstract void paint(Graphics g);

        public abstract void onKeyPressed(KeyEvent e);

        public abstract void onKeyReleased(KeyEvent e);

        public abstract void mouseClicked(MouseEvent e);

        public abstract void mousePressed(MouseEvent e);




}
