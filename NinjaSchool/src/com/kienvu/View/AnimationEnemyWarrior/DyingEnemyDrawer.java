package com.kienvu.View.AnimationEnemyWarrior;

import com.kienvu.Model.GameObject;
import com.kienvu.View.AnimationGameDrawer;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Trà Đá on 5/15/2016.
 */
public class DyingEnemyDrawer extends AnimationGameDrawer {
    private static int DELAY_DEFAULT = 50;
    public DyingEnemyDrawer(Vector<BufferedImage> imageVect) {
        super(imageVect);
        this.delay = DELAY_DEFAULT;
    }

    @Override
    protected void onEndVector(GameObject gameObject) {
        gameObject.setALive(false);
    }
}
