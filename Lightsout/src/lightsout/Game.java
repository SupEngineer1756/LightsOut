/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightsout;

/**
 *
 * @author houariac
 */
public class Game {
    //attributs
    private Cases[][] board;
    private int casesallumes;
    private int taille;
    //Constructeurs
    public Game(int casesallumes, int taille) {
        this.board = new Cases[taille][taille];
        this.casesallumes = casesallumes;
        this.taille = taille;
        for (int i=0; i<taille; i++){
            for (int j=0; j<taille;j++){
                this.board[i][j]= new Cases(i,j,false);
            }
        }
    }
    //methods

    public int getCasesallumes() {
        return casesallumes;
    }

    public void setCasesallumes(int casesallumes) {
        this.casesallumes = casesallumes;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
    
    public void casechetatX(Cases case1){
        if (case1.getX()<taille-1 && case1.getX()>0){
            this.board[case1.getX()+1][case1.getY()].setIsallume(!case1.isIsallume());
            this.board[case1.getX()-1][case1.getY()].setIsallume(!case1.isIsallume());
        }
        else if (case1.getX()==0){
            this.board[case1.getX()+1][case1.getY()].setIsallume(!case1.isIsallume());
        }
        else {
            this.board[case1.getX()-1][case1.getY()].setIsallume(!case1.isIsallume());
        }
    }
    public void casechetatY(Cases case1){
        if (case1.getY()<taille-1 && case1.getY()>0){
            this.board[case1.getX()][case1.getY()+1].setIsallume(!case1.isIsallume());
            this.board[case1.getX()][case1.getY()-1].setIsallume(!case1.isIsallume());
        }
        else if (case1.getY()==0){
            this.board[case1.getX()][case1.getY()+1].setIsallume(!case1.isIsallume());
        }
        else {
            this.board[case1.getX()][case1.getY()-1].setIsallume(!case1.isIsallume());
        }
    }
    public void caseclicked(Cases case1){
        this.board[case1.getX()][case1.getY()].setIsallume(!case1.isIsallume());
        this.casechetatX(case1);
        this.casechetatY(case1);
    }

    public Cases[][] getBoard() {
        return board;
    }
    
}
