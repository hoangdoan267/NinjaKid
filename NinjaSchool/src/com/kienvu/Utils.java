package com.kienvu;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by vukien on 14/05/2016.
 */
public class Utils {
    public static void playSound(String audio, boolean repeat) {
        File soundFile = new File(audio);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            if(repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.loop(0);
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public static BufferedImage loadImage(String url) {
        try {
            BufferedImage image = ImageIO.read(new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static Vector<BufferedImage> loadImage(String s1, String s2, String s3) {
//        Vector<BufferedImage> bufferedImages = new Vector<>();
//        String s = "resources/" + s1 + "/" + s2  + "/";
//        for(int i = 0; i < 10; i++) {
//            String s4 = s3 + "__00" + i + " copy.png";
//            try {
//                BufferedImage image = ImageIO.read(new File(s + s4));
//                bufferedImages.add(image);
//            } catch (IOException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//        return bufferedImages;
//
//    }


//    public static Vector<BufferedImage> loadImag1(String t1, String t2, String t3) {
//        Vector<BufferedImage> bufferedImages = new Vector<>();
//        String s = "resources/" + t1 + "/" + t2  + "/";
//        for(int i = 1; i < 11; i++) {
//            String s4 = t3 + " (" + i + ") copy.png";
//            try {
//                BufferedImage image = ImageIO.read(new File(s + s4));
//                bufferedImages.add(image);
//            } catch (IOException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//        return bufferedImages;
//    }

    public static Vector<BufferedImage> loadImage(String s1, String s2, int n) {
        Vector<BufferedImage> bufferedImages = new Vector<>();
        String format = "resources/characters/%s/%s (%d).png";
        for (int i = 1; i <= n;i ++) {
            bufferedImages.add(loadImage(String.format(format,s1,s2,i)));
        }

        return bufferedImages;
    }

    public static Vector<BufferedImage> loadHPBarImages() {
        Vector<BufferedImage> bufferedImages = new Vector<>();
        String format = "resources/gamehelper/hpbar/hp_bar_%d.png";
        for (int i = 1 ; i < 13; i++) {
//            bufferedImages.add(
//                    loadImage(String.format(format, i))
//
//            );
            bufferedImages.insertElementAt(loadImage(String.format(format, i)), 0);
        }

        return bufferedImages;
    }

}
