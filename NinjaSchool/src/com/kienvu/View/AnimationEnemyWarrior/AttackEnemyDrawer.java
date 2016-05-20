package com.kienvu.View.AnimationEnemyWarrior;

import com.kienvu.View.AnimationGameDrawer;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Trà Đá on 5/15/2016.
 */
public class AttackEnemyDrawer extends AnimationGameDrawer {
    private static int DELAY_ATTACK = 50;
    public AttackEnemyDrawer(Vector<BufferedImage> imageVect) {
        super(imageVect);
        this.delay = DELAY_ATTACK;
    }
}
