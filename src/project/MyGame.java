/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Hai
 */
public class MyGame extends JPanel implements MouseListener {

    Cell[][] cell;
    Algorithm algorithm;
    Point p1 = null, p2 = null;
    ArrayList<Cell> listCell;
    MyLine line = null;
    MyFrame frame;
    int score = 0;

    public MyGame(MyFrame frame) {
        setSize(670, 536);
        setLocation(0, 0);
        setLayout(null);
        setOpaque(false);
        setLocation(60, 100);
        this.frame = frame;
    }

    public void newGame() {
        removeAll();
        algorithm = new Algorithm(10, 8);

        listCell = new ArrayList<Cell>();
        cell = new Cell[10][8];
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 7; j++) {
                cell[i][j] = new Cell(algorithm.getMatrix()[i][j]);
                cell[i][j].p = new Point(i, j);
                cell[i][j].setLocation(i * 67, j * 67);
                cell[i][j].addMouseListener(this);
                add(cell[i][j]);
                listCell.add(cell[i][j]);
            }

        }
    }
    
    public void newGame(int[][] A){
        removeAll();
        algorithm = new Algorithm(10, 8);
        algorithm.setMatrix(A);
        listCell = new ArrayList<Cell>();
        cell = new Cell[10][8];
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 7; j++) {
                cell[i][j] = new Cell(algorithm.getMatrix()[i][j]);
                cell[i][j].p = new Point(i, j);
                cell[i][j].setLocation(i * 67, j * 67);
                cell[i][j].addMouseListener(this);
                add(cell[i][j]);
                listCell.add(cell[i][j]);
            }

        }
    }

    public void help(){
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {

        int x = e.getComponent().getX() / 67;
        int y = e.getComponent().getY() / 67;

        if (p1 == null) {
            p1 = new Point(x, y);
            cell[x][y].temp = 1;
            cell[x][y].repaint();
        } else {
            p2 = new Point(x, y);
            line = algorithm.checkTwoPoint(p1, p2);
            if (line != null) {
                score++;
                algorithm.getMatrix()[p1.x][p1.y] = 0;
                algorithm.getMatrix()[p2.x][p2.y] = 0;
                cell[p1.x][p1.y].setVisible(false);
                cell[p2.x][p2.y].setVisible(false);
                line = null;
            }
            cell[p1.x][p1.y].temp = 0;
            cell[p1.x][p1.y].repaint();
            p1 = null;
            p2 = null;
        }

        if(algorithm.checkWin() ==  true){
            removeAll();
            newGame();
            frame.i = 146;
            setVisible(false);
            setVisible(true);
            
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
