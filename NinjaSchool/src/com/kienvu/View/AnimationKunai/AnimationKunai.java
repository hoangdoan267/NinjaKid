package com.kienvu.View.AnimationKunai;

import com.kienvu.View.AnimationGameDrawer;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by vukien on 19/05/2016.
 */
public class AnimationKunai extends AnimationGameDrawer {

    public AnimationKunai(Vector<BufferedImage> imageVect) {
        super(imageVect);
        this.delay = 10;
    }
}
