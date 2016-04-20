/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Hai
 */
public class MyProgressBar extends JPanel {

    Image bar = new ImageIcon("images/bar.png").getImage();
    int i = 146;
    JPanel panel = new JPanel();
    Thread t;

    public MyProgressBar() {
        setSize(800, 123);
        setLocation(0, 0);
        
        
        
    }

    public void paint(Graphics g) {        
        g.drawImage(bar, 0, 0, this);
    }
}
