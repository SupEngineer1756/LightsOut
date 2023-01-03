/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightsoutversionmatricielle;

/**
 *
 * @author houariac
 */
public class Z2 {
    private int classZ;
    public Z2(int a){
        if (a==1||a==0){
            this.classZ=a;
        }
    }

    public int getClassZ() {
        return classZ;
    }

    public void setClassZ(int classZ) {
        this.classZ = classZ;
    }
    
    public Z2 add(Z2 b){
        if (this.classZ+b.classZ==2){
            return (new Z2(0));
        }
        else{
        return(new Z2(this.classZ+b.classZ));
        }
    }
        
    public Z2 mult(Z2 b){
        return(new Z2(this.classZ*b.classZ));
    }
    public Z2 sus(Z2 b){
        return(new Z2(Math.abs(this.classZ-b.classZ)));
    }
}
