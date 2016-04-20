/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Hai
 */
public class Menu extends JPanel implements MouseListener {

    MyButton resume = new MyButton("RESUME");
    MyButton newGame = new MyButton("NEW GAME");
    MyButton score = new MyButton("SCORE");
    MyButton quit = new MyButton("QUIT");
    MyFrame frame;

    public Menu(MyFrame frame) {
        setBounds(0, 0, 800, 650);
        setBackground(Color.orange);
        setLayout(null);
        this.frame = frame;

        resume.setLocation(100, 300);
        resume.addMouseListener(this);
        add(resume);

        newGame.setLocation(100, 360);
        newGame.addMouseListener(this);
        add(newGame);

        score.setLocation(100, 420);
        score.addMouseListener(this);
        add(score);

        quit.setLocation(100, 480);
        quit.addMouseListener(this);
        add(quit);

        add(new MyTheme(1));

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == resume) {
            System.out.println(JavaFile.readFile().time);
            if (JavaFile.readFile().time <= -354) {
                System.out.println(JavaFile.readFile().time);
            } else {
                if (frame.temp == 1) {
                    setVisible(false);
                    frame.t.resume();
                    frame.temp = 0;
                } else {
                    setVisible(false);
                    frame.game.newGame(JavaFile.readFile().A);
                    frame.game.score = JavaFile.readFile().lastScore;
                    frame.i = JavaFile.readFile().time;
                    frame.t.start();
                }
            }
        }
        if (e.getSource() == newGame) {
            setVisible(false);
            frame.game.newGame();
            frame.reset();
            frame.game.score = 0;
            if (frame.temp == 1) {
                frame.t.resume();
                frame.temp = 0;
            } else {
                frame.t.start();
            }
        }
        if (e.getSource() == score) {
            String s = "HIGH SCORE: " + Integer.toString(JavaFile.readFile().highScore);
//            JOptionPane.showMessageDialog(this, s);
            JOptionPane.showMessageDialog(this, s, "HIGH SCORE", 1);
        }
        if (e.getSource() == quit) {
            System.exit(0);
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
