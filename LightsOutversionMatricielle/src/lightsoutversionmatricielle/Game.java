/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightsoutversionmatricielle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author houariac
 */
public class Game {

    private Boolean[][] board;
    private int Taille;

    public int getTaille() {
        return Taille;
    }

    public void setTaille(int Taille) {
        this.Taille = Taille;
    }

    public Game(int taille) {
        this.Taille = taille;
        this.board = new Boolean[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                this.board[i][j] = false;
                //randomhavetoadd
            }
        }
    }

    public void loadgame(String title) {
        try {
            File savefile = new File(title);
            Scanner myReader = new Scanner(savefile);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                for (int i = 0; i < this.Taille; i++) {
                    for (int j = 0; j < this.Taille; j++) {
                        this.board[i][j] = Boolean.parseBoolean(myReader.nextLine());
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void savegame(String userinput) {
        try {
            File savegamefile = new File(userinput);
            if (savegamefile.createNewFile()) {
                try {
                    FileWriter myWriter = new FileWriter(userinput);
                    myWriter.write(this.Taille + "\n");
                    for (int i = 0; i < getTaille(); i++) {
                        for (int j = 0; j < Taille; j++) {
                            myWriter.write(board[i][j].toString() + "\n");
                        }
                    }
                    myWriter.close();
                } catch (IOException g) {
                    System.out.println("An error occurred.");
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException f) {
            System.out.println("An error occurred.");
        }
    }

    public Boolean[][] getBoard() {
        return board;
    }

    public void setBoard(Boolean[][] board) {
        this.board = board;
    }

    public void toggle(int i, int j) {
        this.board[i][j] = !this.board[i][j];
    }

    public void togglevoisinX(int i, int j) {
        if (i < this.Taille - 1 && i > 0) {
            this.toggle(i + 1, j);
            this.toggle(i - 1, j);
        } else if (i == 0) {
            this.toggle(i + 1, j);
        } else {
            this.toggle(i - 1, j);
        }
    }

    public void togglevoisinY(int i, int j) {
        if (j < this.Taille - 1 && j > 0) {
            this.toggle(i, j + 1);
            this.toggle(i, j - 1);
        } else if (j == 0) {
            this.toggle(i, j + 1);
        } else {
            this.toggle(i, j - 1);
        }
    }

    public void toggleall(int i, int j) {
        this.toggle(i, j);
        this.togglevoisinX(i, j);
        this.togglevoisinY(i, j);
    }

    public String toString(Boolean[][] B) {
        String BtoS = "";
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (B[i][j]) {
                    BtoS += "1 ";
                } else {
                    BtoS += "0 ";
                }
            }
            BtoS += "\n";
        }
        return BtoS;
    }
}
