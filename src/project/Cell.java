/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Hai
 */
public class Cell extends JPanel implements MouseListener {

    int i;
    int temp = 0;
    Image icon;
    Image border = new ImageIcon("images/border.png").getImage();
    public Point p;
    File wavFile = new File("sound/5028.wav");
    AudioClip sound; 

    public Cell(int i) {
        this.i = i;
        setSize(67, 67);
        setBackground(Color.red);
        setOpaque(false);
        icon = new ImageIcon("images/h" + i + ".png").getImage();
        
        try {
            sound = Applet.newAudioClip(wavFile.toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
        addMouseListener(this);
    }

    public void paint(Graphics g) {

        if (temp == 0) {
            g.drawImage(icon, 1, 1, this);
        } else {
            g.drawImage(icon, 1, 1, this);
            g.drawImage(border, 1, 1, this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this){
            System.out.println("click cell");
            sound.play();
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
