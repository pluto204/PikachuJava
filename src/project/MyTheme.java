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
public class MyTheme extends JPanel {

    Image theme = new ImageIcon("images/theme.jpg").getImage();
    Image menu = new ImageIcon("images/menu.jpg").getImage();
    int i;
    
    public MyTheme(int i) {
        setSize(800, 650);
        setLocation(0, 0);
        setLayout(null);
        this.i = i;
    }

    public void paint(Graphics g) {
        if(i == 0){
            g.drawImage(theme, 0, 0, this);
        }
        if(i == 1){
            g.drawImage(menu, 0, 0, this);
        }
    }
}
