package com.kienvu.Controller.Colliable;

import com.kienvu.Model.GameObject;

/**
 * Created by vukien on 14/05/2016.
 */
public interface Colliable {
    void onCollide(Colliable c);
    GameObject getGameObject();
}
