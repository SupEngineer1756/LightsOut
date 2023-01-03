/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightsoutversionmatricielle;

import java.awt.Graphics;
import java.util.Arrays;

/**
 *
 * @author houariac
 */
public  class Solver {
    private String titre;
    
    Boolean[] Br1= {true,true,true,false,false};
    Boolean[] Br2= {true,true,false,true,true};
    Boolean[] Br3= {true,false,true,true,false};
    Boolean[] Br4= {true,false,false,false,true};
    Boolean[] Br5= {false,true,true,false,true};
    Boolean[] Br6= {false,true,false,true,false};
    Boolean[] Br7= {false,false,true,true,true};
    public  Solver(String titre){
        this.titre=titre;
    }
    public void Lightchaserwobot(Game game, GameFrame gameframe) throws InterruptedException  {
        if (game.getTaille()==5){
        for (int j = 1; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                if (game.getBoard()[i][j - 1]) {
                    game.toggleall(i, j);
                    Graphics g = gameframe.getGraphics();
                    gameframe.PaintXY(i, j, g);
                    Thread.sleep(500);
                }
            }
        }
        }
    }
    public void Lightchaser(Game game, GameFrame gameframe) throws InterruptedException{
        Graphics g = gameframe.getGraphics();
        this.Lightchaserwobot(game,gameframe);
        Boolean[] BottomRow = new Boolean[5];
        for (int i=0; i<5;i++){
            BottomRow[i]=game.getBoard()[i][4];
        }
        System.out.println(Arrays.toString(BottomRow));
        if(Arrays.equals(Br1, BottomRow)){
            game.toggleall(1, 0);
            gameframe.PaintXY(1, 0, g);
            Thread.sleep(500);
            this.Lightchaserwobot(game,gameframe);
        }
        if(Arrays.equals(Br2, BottomRow)){
            game.toggleall(2, 0);
            gameframe.PaintXY(2, 0, g);
            Thread.sleep(500);
            this.Lightchaserwobot(game,gameframe);
        }
        if(Arrays.equals(Br3, BottomRow)){
            game.toggleall(4, 0);
            gameframe.PaintXY(4, 0, g);
            Thread.sleep(500);
            this.Lightchaserwobot(game,gameframe);
        }
        if(Arrays.equals(Br4, BottomRow)){
            game.toggleall(0, 0);
            gameframe.PaintXY(0, 0, g);
            Thread.sleep(500);
            game.toggleall(1, 0);
            gameframe.PaintXY(1, 0, g);
            Thread.sleep(500);
            this.Lightchaserwobot(game,gameframe);
        }
        if(Arrays.equals(Br5, BottomRow)){
            game.toggleall(0, 0);
            gameframe.PaintXY(0, 0, g);
            Thread.sleep(500);
            this.Lightchaserwobot(game,gameframe);
        }
        if(Arrays.equals(Br6, BottomRow)){
            game.toggleall(0, 0);
            gameframe.PaintXY(0, 0, g);
            Thread.sleep(500);
            game.toggleall(3, 0);
            gameframe.PaintXY(3, 0, g);
            Thread.sleep(500);
            this.Lightchaserwobot(game,gameframe);
        }
        if(Arrays.equals(Br7, BottomRow)){
            game.toggleall(3, 0);
            gameframe.PaintXY(3, 0, g);
            Thread.sleep(500);
            this.Lightchaserwobot(game,gameframe);
        }
    }
}
