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
public class MyButton extends JPanel{
    
    Image button = new ImageIcon("images/button.png").getImage();
    Image help = new ImageIcon("images/help.png").getImage();
    Image back = new ImageIcon("images/back.png").getImage();
    String s;
    
    public MyButton(String s){
        setSize(200, 50);
        setLayout(null);
        this.s = s;
    }
    
    public void paint(Graphics g){
        if(s == "RESUME"){
            g.drawImage(button, 0, 0, this);
        }
        if(s == "NEW GAME"){
            g.drawImage(button, 0, -50, this);
        }
        if(s == "SCORE"){
            g.drawImage(button, 0, -100, this);
        }
        if(s == "QUIT"){
            g.drawImage(button, 0, -150, this);
        }        
        if(s == "help"){
            this.setSize(50, 50);
            g.drawImage(help, 0, 0, this);
        }
        if(s == "back"){
            this.setSize(50, 50);
            g.drawImage(back, 0, 0, this);
        }
    }    
}
