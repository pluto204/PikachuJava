/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hai
 */
public class MyFrame extends JFrame implements MouseListener {

    Menu menu = new Menu(this);
    MyTheme theme = new MyTheme(0);
    MyGame game = new MyGame(this);
    MyProgressBar time = new MyProgressBar();
    Thread t;
    MyButton help = new MyButton("help");
    MyButton back = new MyButton("back");
    JLabel score = new JLabel("0");
    JPanel panel = new JPanel();
    int i = 146;
    int temp = 0;
    Point p1, p2;
    Point p0 = new Point(0, 0);

    public MyFrame() {
        setTitle("PIKACHU");
        setResizable(false);
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        add(menu);

        score.setLocation(50, 565);
        score.setSize(100, 50);
        score.setFont(new Font("Serif", Font.BOLD, 50));
        score.setForeground(Color.white);
        add(score);

        back.setLocation(680, 565);
        back.addMouseListener(this);
        add(back);

        help.setLocation(740, 565);
        help.addMouseListener(this);
        add(help);

        add(game);
        add(time);
        panel.setLocation(i, 0);
        panel.setSize(500, 100);
        panel.setBackground(new Color(255, 0, 0));
        add(panel);

        add(theme);

        t = new Thread() {
            public void run() {
                while (true) {
                    try {
                        panel.setLocation(i--, 0);
                        if (i == -354) {
                            menu.setVisible(true);
                        }
                        score.setText(Integer.toString(game.score));
//                        JavaFile.writeFile(game.algorithm.getMatrix(), game.score, i, 0);
                        if(game.score >= JavaFile.readFile().highScore){
                            JavaFile.writeFile(game.algorithm.getMatrix(), game.score, i, game.score);
                        }else{
                            JavaFile.writeFile(game.algorithm.getMatrix(), game.score, i, JavaFile.readFile().highScore);
                        }
                        sleep(200);
                    } catch (Exception e) {

                    }
                }

            }
        };
    }

    public void reset() {
        i = 146;
        panel.setLocation(i, 0);
    }

    public void help() {
        for (int i = 1; i < 48; i++) {
            for (int j = 1; j < 48; j++) {
                if (i != j) {
                    p1 = new Point(i % 8, i / 8 + 1);
                    p2 = new Point(j % 8, j / 8 + 1);
                    if (game.algorithm.getMatrix()[p1.x][p1.y] != 0 && game.algorithm.getMatrix()[p2.x][p2.y] != 0) {
                        if (game.algorithm.checkTwoPoint(p1, p2) != null) {
                            game.algorithm.getMatrix()[p1.x][p1.y] = 0;
                            game.algorithm.getMatrix()[p2.x][p2.y] = 0;
                            game.cell[p1.x][p1.y].setVisible(false);
                            game.cell[p2.x][p2.y].setVisible(false);
                            System.out.println("(" + i % 8 + "," + (i / 8 + 1) + ")"
                                    + ",(" + j % 8 + "," + (j / 8 + 1) + ")");
                            return;
                        }
                    }

                }
            }
        }
        System.out.println("not found");
        game.newGame();        
        menu.setVisible(true);
        menu.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == back) {
            System.out.println("press back button");
            if (temp == 0) {
                temp = 1;
                t.suspend();
                menu.setVisible(true);
            }
        }
        if (e.getSource() == help) {

            System.out.println("press help button");
            help();
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
