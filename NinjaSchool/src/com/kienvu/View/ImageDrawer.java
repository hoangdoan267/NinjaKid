package com.kienvu.View;

import com.kienvu.Model.GameObject;
import com.kienvu.Model.GameVector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

/**
 * Created by vukien on 14/05/2016.
 */
public class ImageDrawer extends GameDrawer {
    public BufferedImage image;



    public ImageDrawer (BufferedImage image) {
        this.image = image;
    }


    public ImageDrawer(String imageName) {
        try {
            image = ImageIO.read(new File( imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public void paint(Graphics g, GameObject gameObject) {
        g.drawImage(image, gameObject.getX(), gameObject.getY(), gameObject.getWidth(), gameObject.getHeight(), null);
    }




}
