package com.kienvu.View.AnimationNinja;

import com.kienvu.View.AnimationGameDrawer;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by vukien on 19/05/2016.
 */
public class ThrowLeftNinjaDrawer extends AnimationGameDrawer {
    private static int DELAY_DEFAULT = 50;
    public ThrowLeftNinjaDrawer(Vector<BufferedImage> imageVect) {
        super(imageVect);
        this.delay = DELAY_DEFAULT;
    }
}
