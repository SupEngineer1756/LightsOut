/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightsoutversionmatricielle;

import java.awt.Graphics;

/**
 *
 * @author houariac
 */
public class LightsOutversionMatricielle {

    private Mainmenu mainmenu;
    private Solver solver;
    private LinearSolver Lsolver = new LinearSolver("t");

    //
    public LightsOutversionMatricielle(String titre) {
        mainmenu = new Mainmenu();

        
    }

    public static void main(String[] args) {
        new LightsOutversionMatricielle("Lightsoutmat");

    }

}
