package com.kienvu.View.AnimationNinja;

import com.kienvu.Model.GameObject;
import com.kienvu.View.AnimationGameDrawer;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by NGUYEN DINH QUAN on 5/15/2016.
 */
public class DyingRightNinjaDrawer extends AnimationGameDrawer {
    private static int DELAY_DYING = 20;
    public DyingRightNinjaDrawer(Vector<BufferedImage> imageVect) {
        super(imageVect);
        this.delay = DELAY_DYING;
    }

    @Override
    protected void onEndVector(GameObject gameObject) {
        gameObject.setALive(false);
    }
}
