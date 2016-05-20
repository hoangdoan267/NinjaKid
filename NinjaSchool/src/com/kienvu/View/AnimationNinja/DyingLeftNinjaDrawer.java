package com.kienvu.View.AnimationNinja;

import com.kienvu.View.AnimationGameDrawer;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by vukien on 19/05/2016.
 */
public class DyingLeftNinjaDrawer extends AnimationGameDrawer {
    private static int DELAY_DYING = 20;
    public DyingLeftNinjaDrawer(Vector<BufferedImage> imageVect) {
        super(imageVect);
        this.delay = DELAY_DYING;
    }
}
