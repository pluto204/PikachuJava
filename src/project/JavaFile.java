/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

/**
 *
 * @author Hai
 */
public class JavaFile {

    public static Data a = new Data();

    public JavaFile() {
        
    }

    public static void writeFile(int[][]A, int lastScore, int time, int highScore) {
        a.A =A;
        a.lastScore = lastScore;
        a.time = time;
        a.highScore = highScore;
        try {
            FileOutputStream f = new FileOutputStream("data.txt");
            ObjectOutputStream oOT = new ObjectOutputStream(f);
            oOT.writeObject(a);
            oOT.close();
            f.close();
        } catch (IOException e) {
            System.out.println("Co loi xay ra");
        }
    }

    public static Data readFile() {
        Data a1 = null;
        try {
            FileInputStream f = new FileInputStream("data.txt");
            ObjectInputStream oIT = new ObjectInputStream(f); // Sử dụng để đọc file theo từng Object
            a1 = (Data) oIT.readObject();
            oIT.close();
            f.close();
        } catch (IOException io) {
            System.out.println("Có lỗi xảy ra!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Không tìm thấy class");
        }
//        System.out.println(a1.highScore);
        return a1;
    }
}
