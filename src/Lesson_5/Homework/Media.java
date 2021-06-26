package Lesson_5.Homework;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Media {
    private static Clip clip;

    public static void play() {
        File soundFile = new File("src/Lesson_5/Homework/files/sound.wav");

        boolean isProblem = false;
        AudioInputStream ais = null;

        try {
            ais = AudioSystem.getAudioInputStream(soundFile);
        } catch (IOException e) {
            isProblem = true;
            JOptionPane.showMessageDialog(null, "There is some problem with the file");
        } catch (UnsupportedAudioFileException e) {
            isProblem = true;
            JOptionPane.showMessageDialog(null, "This is not a sound file");
        }

        if (isProblem) return;

        isProblem = false;
        clip = null;

        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            isProblem = true;
            JOptionPane.showMessageDialog(null, "Can't open some construction sites");
        }

        if (isProblem) return;

        isProblem = false;

        try {
            clip.open(ais);
        } catch (IOException e) {
            isProblem = true;
            JOptionPane.showMessageDialog(null, "There is some problem with the file");
        } catch (LineUnavailableException e) {
            isProblem = true;
            JOptionPane.showMessageDialog(null, "Can't open some construction sites");
        }

        if (isProblem) return;

        clip.setFramePosition(0);
        clip.start();
    }

    public static void stop() {
        if (clip != null) {
            clip.stop();
        }
    }

    public static Clip getClip() {
        return clip;
    }
}
