package com.kienvu.View;

import com.kienvu.Model.GameObject;

import java.awt.*;

/**
 * Created by vukien on 14/05/2016.
 */
public abstract class GameDrawer {
    public abstract void paint(Graphics g, GameObject gameObject);
    //public abstract void paint(Graphics g, GameObject gameObject, int delay);
}
