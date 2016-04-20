/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

/**
 *
 * @author Hai
 */
public class Project {

    MyFrame frame;    
    public Project(){
        frame = new MyFrame();
    }
    public static void main(String[] args) {
        new Project();
        Audio audio = new Audio("sound/pikachu.wav");
        audio.start();
    }
    
}
