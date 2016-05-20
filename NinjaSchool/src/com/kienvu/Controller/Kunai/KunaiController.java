package com.kienvu.Controller.Kunai;

import com.kienvu.Controller.Colliable.Colliable;
import com.kienvu.Controller.Colliable.ColliablePool;
import com.kienvu.Controller.SingleController;
import com.kienvu.GameConfig;
import com.kienvu.Model.GameObject;
import com.kienvu.Model.GameVector;
import com.kienvu.Model.Kunai;
import com.kienvu.Utils;
import com.kienvu.View.AnimationKunai.AnimationKunai;
import com.kienvu.View.GameDrawer;
import com.kienvu.View.ImageDrawer;

import java.awt.*;

/**
 * Created by vukien on 19/05/2016.
 */
public class KunaiController extends SingleController implements Colliable {
    public KunaiController(GameObject gameObject, GameDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer, gameVector);
        ColliablePool.getInst().add(this);
    }




    @Override
    public void run() {
        if (gameObject.isALive()) {
            super.run();
            //System.out.println("dx = " + gameObject.getX());
            if (!GameConfig.getInst().isScreen(this.gameObject)) {
                this.gameObject.setALive(false);
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        if(gameObject.isALive()) {
            super.paint(g);
        }

    }

    @Override
    public void onCollide(Colliable c) {

    }
}
