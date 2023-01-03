/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightsout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author houariac
 */
public class GameFrame extends JFrame implements MouseListener {

    Game game= new Game(4,5);
    Graphics2D g2;

    //
    public GameFrame() {
        super();
        this.setVisible(true);
        this.setBounds(0, 0, 1000, 1000);
        this.addMouseListener(this);
    }

    public void paintXY(Cases case1, Graphics g) {
        this.g2 = (Graphics2D) g;
        int x = case1.getX();
        int y = case1.getY();
        if (this.game.getBoard()[x][y].isIsallume()) {
            g2.setColor(Color.GREEN);
            g2.fillRoundRect(x * 200, y * 200, 198, 198, 40, 40);
        } else {
            g2.setColor(Color.RED);
            g2.fillRoundRect(x * 200, y * 200, 198, 198, 40, 40);
        }
        this.paintX(case1, g);
        this.paintY(case1, g);
    }

    public void paintX(Cases case1, Graphics g) {
        this.g2 = (Graphics2D) g;
        int x = case1.getX();
        int y = case1.getY();
        if (x < this.game.getTaille() - 1 && x > 0) {
            if (this.game.getBoard()[x][y].isIsallume()) {
                g2.setColor(Color.GREEN);
                g2.fillRoundRect((x + 1) * 200, y * 200, 198, 198, 40, 40);
                g2.fillRoundRect((x - 1) * 200, y * 200, 198, 198, 40, 40);
            } else {
                g2.setColor(Color.RED);
                g2.fillRoundRect((x + 1) * 200, y * 200, 198, 198, 40, 40);
                g2.fillRoundRect((x - 1) * 200, y * 200, 198, 198, 40, 40);
            }
        }
        if (x == 0) {
            if (this.game.getBoard()[x][y].isIsallume()) {
                g2.setColor(Color.GREEN);
                g2.fillRoundRect((x + 1) * 200, y * 200, 198, 198, 40, 40);
            } else {
                g2.setColor(Color.RED);
                g2.fillRoundRect((x + 1) * 200, y * 200, 198, 198, 40, 40);
            }
        } else {
            if (this.game.getBoard()[x][y].isIsallume()) {
                g2.setColor(Color.GREEN);
                g2.fillRoundRect((x - 1) * 200, y * 200, 198, 198, 40, 40);
            } else {
                g2.setColor(Color.RED);
                g2.fillRoundRect((x - 1) * 200, y * 200, 198, 198, 40, 40);
            }
        }
    }

    public void paintY(Cases case1, Graphics g) {
        this.g2 = (Graphics2D) g;
        int x = case1.getX();
        int y = case1.getY();
        if (y < this.game.getTaille() - 1 && y > 0) {
            if (this.game.getBoard()[x][y].isIsallume()) {
                g2.setColor(Color.GREEN);
                g2.fillRoundRect(x * 200, (y + 1) * 200, 198, 198, 40, 40);
                g2.fillRoundRect(x * 200, (y - 1) * 200, 198, 198, 40, 40);
            } else {
                g2.setColor(Color.RED);
                g2.fillRoundRect(x * 200, (y + 1) * 200, 198, 198, 40, 40);
                g2.fillRoundRect(x * 200, (y - 1) * 200, 198, 198, 40, 40);
            }
        }
        if (y == 0) {
            if (this.game.getBoard()[x][y].isIsallume()) {
                g2.setColor(Color.GREEN);
                g2.fillRoundRect(x * 200, (y + 1) * 200, 198, 198, 40, 40);
            } else {
                g2.setColor(Color.RED);
                g2.fillRoundRect(x * 200, (y + 1) * 200, 198, 198, 40, 40);
            }
        } else {
            if (this.game.getBoard()[x][y].isIsallume()) {
                g2.setColor(Color.GREEN);
                g2.fillRoundRect(x * 200, (y - 1) * 200, 198, 198, 40, 40);
            } else {
                g2.setColor(Color.RED);
                g2.fillRoundRect(x * 200, (y - 1) * 200, 198, 198, 40, 40);
            }
        }
    }

    public void paint(Graphics g) {
        this.g2 = (Graphics2D) g;
        for (int i = 0; i < game.getTaille() * 200; i = i + 200) {
            for (int j = 0; j < game.getTaille() * 200; j = j + 200) {
                g2.setBackground(Color.white);
                g2.setColor(Color.black);
                g2.drawRoundRect(i, j, 200, 200, 40, 40);
                g2.setColor(Color.GREEN);
                g2.fillRoundRect(i, j, 198, 198, 40, 40);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = (int) (e.getX() / 200);
        int y = (int) (e.getY() / 200);
        System.out.println(e.getX()+","+e.getY());
        System.out.println(x+","+y);
        this.game.caseclicked(this.game.getBoard()[x][y]);
        Graphics g = getGraphics();
        this.paintXY(this.game.getBoard()[x][y], g);
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
