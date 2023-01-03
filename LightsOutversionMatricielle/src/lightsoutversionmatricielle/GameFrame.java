/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightsoutversionmatricielle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author houariac
 */
public class GameFrame extends JFrame implements MouseListener {

    private Game game;
    

    //
    public GameFrame(int taille) {
        super("LightsOut! by 7madox");
        this.setVisible(true);
        this.game = new Game(taille);
        this.setBounds(0, 0, 1000, 1200);
        this.addMouseListener(this);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.yellow);
        
        
        /*
        add panel for resolution
         */
    }

    public Game getGame() {
        return game;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            BufferedImage img = ImageIO.read(new File("Z:\\Mes documents\\NetBeansProjects\\LightsOutversionMatricielle\\UIimg\\Gbackground.jpg"));
            g.drawImage(img, 0, 0, null);
        } catch (IOException ex) {
            Logger.getLogger(Mainmenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Graphics2D g2 = (Graphics2D) g;
        for (double i = 0; Math.round(i) < 1000; i = i + (1000.0 / (double) game.getTaille())) {
            for (double j = 0; Math.round(j) < 1000; j = j + (1000.0 / (double) game.getTaille())) {
                System.out.println(i + j);
                g2.setColor(Color.black);
                g2.drawRoundRect((int) i, (int) j, (1000 / game.getTaille()), (1000 / game.getTaille()), (1000 / game.getTaille()) / 5, (1000 / game.getTaille()) / 5);
                if (this.game.getBoard()[(int) (i / (1000 / game.getTaille()))][(int) (j / (1000 / game.getTaille()))]) {
                    g2.setColor(Color.YELLOW);
                    g2.fillRoundRect((int) i, (int) j, (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) / 5, (1000 / game.getTaille()) / 5);
                    g2.fillRoundRect((int) i, (int) j, (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) / 5, (1000 / game.getTaille()) / 5);
                } else {
                    g2.setColor(Color.BLACK);
                    g2.fillRoundRect((int) i, (int) j, (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) / 5, (1000 / game.getTaille()) / 5);
                    g2.fillRoundRect((int) i, (int) j, (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) / 5, (1000 / game.getTaille()) / 5);
                }
            }
        }
    }

    public void PaintX(int i, int j, Graphics g) {
        if (i < this.game.getTaille() - 1 && i > 0) {
            this.Paint(i + 1, j, g);
            this.Paint(i - 1, j, g);
        } else if (i == 0) {
            this.Paint(i + 1, j, g);
        } else {
            this.Paint(i - 1, j, g);
        }
    }

    public void Paint(int i, int j, Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (this.game.getBoard()[i][j]) {
            g2.setColor(Color.YELLOW);
            g2.fillRoundRect((int) (i * (1000.0 / (double) game.getTaille())), (int) (j * (1000.0 / (double) game.getTaille())), (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) / 5, (1000 / game.getTaille()) / 5);
        } else {
            g2.setColor(Color.BLACK);
            g2.fillRoundRect((int) (i * (1000.0 / (double) game.getTaille())), (int) (j * (1000.0 / (double) game.getTaille())), (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) - 1, (1000 / game.getTaille()) / 5, (1000 / game.getTaille()) / 5);
        }
    }

    public void PaintY(int i, int j, Graphics g) {
        if (j < this.game.getTaille() - 1 && j > 0) {
            this.Paint(i, j + 1, g);
            this.Paint(i, j - 1, g);
        } else if (j == 0) {
            this.Paint(i, j + 1, g);
        } else {
            this.Paint(i, j - 1, g);
        }
    }

    public void PaintXY(int i, int j, Graphics g) {
        this.Paint(i, j, g);
        this.PaintX(i, j, g);
        this.PaintY(i, j, g);
    }

    public void mouseClicked(MouseEvent e) {
        int i = (int) (e.getX() / (1000 / game.getTaille()));
        int j = (int) (e.getY() / (1000 / game.getTaille()));
        Graphics g = getGraphics();
        this.game.toggleall(i, j);
        System.out.println(i + "," + j);
        System.out.println(e.getX() + "," + e.getY());
        this.PaintXY(i, j, g);
    }
    

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
    
}
