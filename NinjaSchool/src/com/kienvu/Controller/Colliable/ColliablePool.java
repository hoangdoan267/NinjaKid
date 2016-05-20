package com.kienvu.Controller.Colliable;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by vukien on 14/05/2016.
 */
public class ColliablePool {
    private Vector<Colliable> colliableVector;

    private ColliablePool() {
        colliableVector = new Vector<>();
    }

    public void add(Colliable c) {
        this.colliableVector.add(c);
    }

    public void run() {
        Iterator<Colliable> iterator = colliableVector.iterator();
        while (iterator.hasNext()) {
            Colliable c = iterator.next();
            if(!c.getGameObject().isALive()) {
                iterator.remove();
            }
        }

        for (int i = 0; i < colliableVector.size() - 1; i++) {
            for (int j = i + 1; j < colliableVector.size(); j++) {
                Colliable ci = colliableVector.get(i);
                Colliable cj = colliableVector.get(j);
                Rectangle ri = ci.getGameObject().getRectangle();
                Rectangle rj = cj.getGameObject().getRectangle();
                if (ri.intersects(rj)) {
                    ci.onCollide(cj);
                    cj.onCollide(ci);
                }
            }
        }
    }

    private static ColliablePool inst;
    public static ColliablePool getInst() {
        if(inst == null ) {
            inst = new ColliablePool();
        }

        return inst;
    }
}
