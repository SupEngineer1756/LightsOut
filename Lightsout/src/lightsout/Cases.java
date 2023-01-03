/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightsout;

/**
 *
 * @author houariac
 */
public class Cases {
    //attributs
    private boolean isallume;
    private int x;
    private int y;
    //constructeurs
    public Cases(int x, int y, boolean isallume){
        this.isallume=isallume;
        this.x=x;
        this.y=y;
    }
    public Cases(){
        this(0,0,false);
    }
    //methods
    public boolean isIsallume() {
        return isallume;
    }

    public void setIsallume(boolean isallume) {
        this.isallume = isallume;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
