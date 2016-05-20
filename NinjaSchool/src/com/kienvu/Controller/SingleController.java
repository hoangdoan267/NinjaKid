package com.kienvu.Controller;

import com.kienvu.Model.GameObject;
import com.kienvu.Model.GameVector;
import com.kienvu.View.GameDrawer;

import java.awt.*;

/**
 * Created by vukien on 14/05/2016.
 */
public class SingleController implements Controller {
    protected GameObject gameObject;
    protected GameDrawer gameDrawer;
    protected GameVector gameVector;

    public SingleController(GameObject gameObject, GameDrawer gameDrawer, GameVector gameVector) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVector = gameVector;
    }

    @Override
    public void paint(Graphics g) {
        gameDrawer.paint(g, gameObject);
    }

    @Override
    public void run() {
        gameObject.move(gameVector);
    }

    public GameObject getGameObject() {
        return gameObject;
    }
}
