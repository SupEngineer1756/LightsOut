/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightsout;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * @author houariac
 */
public class Lightsout  {
    GameFrame gameframe;
    //
    public Lightsout(String titre) {
        gameframe = new GameFrame();
        Graphics g = this.gameframe.getGraphics();
        this.gameframe.paint(g);
        this.gameframe.addMouseListener(this.gameframe);
     }


    public static void main(String[] args) {
        new Lightsout("Lightsout");
    }

}
