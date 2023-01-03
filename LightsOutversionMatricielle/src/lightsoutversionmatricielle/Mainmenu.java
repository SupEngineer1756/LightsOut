/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightsoutversionmatricielle;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author houariac
 */
public class Mainmenu extends JFrame {

    private GameFrame gameframe;
    JButton Play, Load;
    JLabel Label;
    private LinearSolver solver;
    private Solver nsolver;

    public Mainmenu() {
        super("LightsOut! by 7madox");
        this.setLayout(null);
        this.setVisible(true);
        this.setBounds(1000, 200, 600, 600);
        Graphics g = getGraphics();
        paintComponent(g);
        Icon playbutton = new ImageIcon("Z:\\Mes documents\\NetBeansProjects\\LightsOutversionMatricielle\\UIimg\\Play-button.png");
        Icon loadbutton = new ImageIcon("Z:\\Mes documents\\NetBeansProjects\\LightsOutversionMatricielle\\UIimg\\Load-button.png");
        Play = new JButton(playbutton);
        Play.setBounds(0, 200, 600, 100);
        Play.setVisible(true);
        Play.setBorderPainted(false);
        Load = new JButton(loadbutton);
        Load.setBounds(0, 300, 600, 100);
        Load.setVisible(true);
        Load.setBorderPainted(false);
        //setboundsand graphics
        this.add(Play);
        this.add(Load);
        Load.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showOpenDialog(Load);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    String userinput = chooser.getSelectedFile().getName();
                    int taille=0;
                    File savefile = new File(userinput);
                    Scanner myReader;
                    try {
                        myReader = new Scanner(savefile);
                        taille = Integer.parseInt(myReader.nextLine());
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Mainmenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    gameframe = new GameFrame(taille);
                    gameframe.getGame().loadgame(userinput);
                    Graphics g = gameframe.getGraphics();
                    gameframe.paint(g);
                    System.out.println(gameframe.getGame().toString(gameframe.getGame().getBoard()));
                    Icon savebutton = new ImageIcon("Z:\\Mes documents\\NetBeansProjects\\LightsOutversionMatricielle\\UIimg\\Save-Button.png");
                    Icon resolvebrutally = new ImageIcon("Z:\\Mes documents\\NetBeansProjects\\LightsOutversionMatricielle\\UIimg\\Resolve-Brutally.png");
                    Icon resolveLA = new ImageIcon("Z:\\Mes documents\\NetBeansProjects\\LightsOutversionMatricielle\\UIimg\\Resolve-LA.png");
                    JButton Resolve = new JButton(resolveLA);
                    JButton NResolve = new JButton(resolvebrutally);
                    JButton Save = new JButton(savebutton);
                    Resolve.setBounds(0, 970, 333, 100);
                    Resolve.setVisible(true);
                    Resolve.setBorderPainted(false);
                    gameframe.add(Resolve);
                    NResolve.setBounds(334, 970, 333, 100);
                    NResolve.setVisible(true);
                    NResolve.setBorderPainted(false);
                    gameframe.add(NResolve);
                    Save.setBounds(667, 970, 333, 100);
                    Save.setVisible(true);
                    Save.setBorderPainted(false);
                    gameframe.add(Save);
                    Resolve.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            solver = new LinearSolver("Lsolver");
                            try {
                                solver.Solvecurrgame(gameframe);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Mainmenu.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    });
                    NResolve.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            nsolver = new Solver("Nsolver");
                            try {
                                nsolver.Lightchaser(gameframe.getGame(), gameframe);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Mainmenu.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    });
                    Save.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String userinput = JOptionPane.showInputDialog(null, "Name?");
                            gameframe.getGame().savegame(userinput);

                        }
                    });

                }

            }
        });
        Play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int taille = parseInt(JOptionPane.showInputDialog(null, "Taille?"));
                gameframe = new GameFrame(taille);
                Graphics g = gameframe.getGraphics();
                gameframe.paint(g);
                System.out.println(gameframe.getGame().toString(gameframe.getGame().getBoard()));
                Icon savebutton = new ImageIcon("Z:\\Mes documents\\NetBeansProjects\\LightsOutversionMatricielle\\UIimg\\Save-Button.png");
                Icon resolvebrutally = new ImageIcon("Z:\\Mes documents\\NetBeansProjects\\LightsOutversionMatricielle\\UIimg\\Resolve-Brutally.png");
                Icon resolveLA = new ImageIcon("Z:\\Mes documents\\NetBeansProjects\\LightsOutversionMatricielle\\UIimg\\Resolve-LA.png");
                JButton Resolve = new JButton(resolveLA);
                JButton NResolve = new JButton(resolvebrutally);
                JButton Save = new JButton(savebutton);
                Resolve.setBounds(0, 970, 333, 100);
                Resolve.setVisible(true);
                Resolve.setBorderPainted(false);
                gameframe.add(Resolve);
                NResolve.setBounds(334, 970, 333, 100);
                NResolve.setVisible(true);
                NResolve.setBorderPainted(false);
                gameframe.add(NResolve);
                Save.setBounds(667, 970, 333, 100);
                Save.setVisible(true);
                Save.setBorderPainted(false);
                gameframe.add(Save);
                Resolve.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        solver = new LinearSolver("Lsolver");
                        try {
                            solver.Solvecurrgame(gameframe);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Mainmenu.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });
                NResolve.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nsolver = new Solver("Nsolver");
                        try {
                            nsolver.Lightchaser(gameframe.getGame(), gameframe);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Mainmenu.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });
                Save.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String userinput = JOptionPane.showInputDialog(null, "Name?");
                        gameframe.getGame().savegame(userinput);

                    }
                });

            }
        });

    }

    public void paintComponent(Graphics g) {
        try {
            BufferedImage img = ImageIO.read(new File("Z:\\Mes documents\\NetBeansProjects\\LightsOutversionMatricielle\\UIimg\\background.jpg"));
            g.drawImage(img, 0, 0, null);
        } catch (IOException ex) {
            Logger.getLogger(Mainmenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
