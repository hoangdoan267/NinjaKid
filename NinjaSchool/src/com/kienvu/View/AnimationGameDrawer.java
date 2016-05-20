package com.kienvu.View;

import com.kienvu.GameConfig;
import com.kienvu.Model.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by NGUYEN DINH QUAN on 5/15/2016.
 */
public class AnimationGameDrawer extends GameDrawer {
    private int index = 0;
    private int count = 0;
    Vector<BufferedImage> imageVector;

    protected int delay;

    public AnimationGameDrawer(Vector<BufferedImage> imageVect) {
        this.imageVector = imageVect;

    }

    @Override
    public void paint(Graphics g, GameObject gameObject) {
        BufferedImage image = imageVector.get(index);
        g.drawImage(image,gameObject.getX(), gameObject.getY(), image.getWidth(), image.getHeight(), null);
        count++;
        if(GameConfig.getInst().durationInMiliSeconds(count) > delay){
            count = 0;
            index++;
            if(index >= imageVector.size())
                onEndVector(gameObject);

        }

    }


    protected void onEndVector(GameObject gameObject){
        index = 0;
    }
}
