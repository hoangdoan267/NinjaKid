package com.kienvu.View.AnimationNinja;

import com.kienvu.View.AnimationGameDrawer;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by vukien on 18/05/2016.
 */
public class ThrowRightNinjaDrawer extends AnimationGameDrawer {
    private static int DELAY_DEFAULT = 50;
    public ThrowRightNinjaDrawer(Vector<BufferedImage> imageVect) {
        super(imageVect);
        this.delay = DELAY_DEFAULT;
    }
}
