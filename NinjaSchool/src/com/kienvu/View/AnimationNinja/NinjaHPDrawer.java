package com.kienvu.View.AnimationNinja;

import com.kienvu.Model.GameObject;
import com.kienvu.Model.HPbar;
import com.kienvu.Model.Ninja;
import com.kienvu.View.GameDrawer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Trà Đá on 5/15/2016.
 */
public class NinjaHPDrawer extends GameDrawer {

    private final int X = 20;
    private final int Y = 20;
    private Vector<BufferedImage> imageVector;

    public NinjaHPDrawer(Vector<BufferedImage> imageVector) {
        this.imageVector = imageVector;
    }

    @Override
    public void paint(Graphics g, GameObject gameObject) {
        if(imageVector != null) {
            Ninja ninja = (Ninja)gameObject;
            HPbar hPbar = ninja.gethPbar();
            int hpTotalLevel = imageVector.size();

            int hp = ninja.getHp();

            int hpLevel = (int)(hpTotalLevel * (double)hp / Ninja.DEFAULT_HP);

            hpLevel = (hpLevel - 1) % hpTotalLevel;

            if(hpLevel >= 0){
                Image image = imageVector.get(hpLevel);
                g.drawImage(image, hPbar.getX(), hPbar.getY(), hPbar.getWidth(), hPbar.getHeight(), null);
            }



        }
    }

}
