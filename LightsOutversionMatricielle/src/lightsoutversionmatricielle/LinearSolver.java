/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightsoutversionmatricielle;

import java.awt.Graphics;

/**
 *
 * @author houariac
 */
public class LinearSolver {

    private String titre;
    Z2 zero = new Z2(0);
    Z2 one = new Z2(1);
    public LinearSolver(String titre) {
        this.titre = titre;
    }

    public String toString(Z2[][] M) {
        String MtoS = "";
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                MtoS += M[i][j].getClassZ() + " ";
            }
            MtoS += "\n";
        }
        return MtoS;
    }

    public String toStringv(Z2[] M) {
        String MtoS = "";

        for (int j = 0; j < M.length; j++) {
            MtoS += M[j].getClassZ() + " ";
        }
        MtoS += "\n";

        return MtoS;
    }

    public Z2[] tovector(Boolean[][] matrix) {
        Z2[] Bvector = new Z2[matrix.length * matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j]) {
                    Bvector[i * matrix.length + j] = new Z2(1);
                } else {
                    Bvector[i * matrix.length + j] = new Z2(0);
                }
            }
        }
        return Bvector;
    }

    public Z2[] fmatrixtovector(Z2[][] matrix) {
        Z2[] ourvector = new Z2[matrix.length * matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                ourvector[i * matrix.length + j] = new Z2(matrix[i][j].getClassZ());
            }
        }
        return ourvector;
    }

    public void assigni(Z2[][] matrice, int i, int j) {
        if (i < matrice.length - 1 && i > 0) {
            matrice[i + 1][j] = new Z2(1);
            matrice[i - 1][j] = new Z2(1);
        } else if (i == 0) {
            matrice[i + 1][j] = new Z2(1);
        } else {
            matrice[i - 1][j] = new Z2(1);
        }
    }

    public void assignj(Z2[][] matrice, int i, int j) {
        if (j < matrice.length - 1 && j > 0) {
            matrice[i][j + 1] = new Z2(1);
            matrice[i][j - 1] = new Z2(1);
        } else if (j == 0) {
            matrice[i][j + 1] = new Z2(1);
        } else {
            matrice[i][j - 1] = new Z2(1);
        }
    }

    public Z2[][] operatorij(int i, int j, int taille) {
        Z2[][] Aij = new Z2[taille][taille];
        for (int ii = 0; ii < taille; ii++) {
            for (int jj = 0; jj < taille; jj++) {
                Aij[ii][jj]=new Z2(0);
            }
        }
        Aij[i][j] = new Z2(1);
        this.assigni(Aij, i, j);
        this.assignj(Aij, i, j);
        return Aij;
    }

    public void swapm(Z2[][] A, int i, int j) {
        for (int k = 0; k < A.length; k++) {
            Z2 tmp = new Z2(A[i][k].getClassZ());
            A[i][k] = new Z2(A[j][k].getClassZ());
            A[j][k] = new Z2(tmp.getClassZ());
        }
    }

    public void swapv(Z2[] B, int i, int j) {
        Z2 tmp = new Z2(B[i].getClassZ());
        B[i] = new Z2(B[j].getClassZ());
        B[j] = new Z2(tmp.getClassZ());
    }

    public void Triangulate(Z2[][] A, Z2[] B) {
        for (int i = 0; i < A.length; i++) {
            Z2 sup = new Z2(0);
            int j = 0;
            for (int k = i; k < A.length; k++) {
                if (sup.getClassZ() < A[k][i].getClassZ()) {
                    sup = A[k][i];
                    j = k;
                }
            }
            if (sup.getClassZ()>0){
            swapm(A, i, j);
            swapv(B, i, j);
            for (int k = i + 1; k < A.length; k++) {
                Z2 tmp = new Z2(0);
                tmp = A[k][i];
                for (int l = 0; l < A.length; l++) {
                    A[k][l] = A[k][l].sus(tmp.mult(A[i][l]));
                }
                B[k] = B[k].sus(tmp.mult(B[i]));
            }
            }
        }

    }

    public Z2[] solveforx(Z2[][] A, Z2[] B) {
        this.Triangulate(A, B);
        //System.out.println(toString(A));
        Z2[] X = new Z2[A.length];
        X[A.length - 1] = B[A.length - 1];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < A.length; j++) {
                B[i] = B[i].sus(A[i][j].mult(X[j]));
            }
            X[i] = B[i];
        }
        return X;
    }

    public Z2[] LinearSolution(GameFrame gameframe) {
        Z2[][] A = new Z2[gameframe.getGame().getTaille() * gameframe.getGame().getTaille()][gameframe.getGame().getTaille() * gameframe.getGame().getTaille()];
        for (int ii = 0; ii < gameframe.getGame().getTaille(); ii++) {
            for (int jj = 0; jj < gameframe.getGame().getTaille(); jj++) {
                    Z2[][] Aiijj=operatorij(ii, jj, gameframe.getGame().getTaille());
                for (int j = 0; j < gameframe.getGame().getTaille() * gameframe.getGame().getTaille(); j++) {
                    A[ii * gameframe.getGame().getTaille() + jj][j] = new Z2(fmatrixtovector(Aiijj)[j].getClassZ());
                }
                
            }

        }
        //System.out.println(toString(A));
        Z2[] C = new Z2[gameframe.getGame().getTaille() * gameframe.getGame().getTaille()];
        C = this.tovector(gameframe.getGame().getBoard());

        //System.out.println(toStringv(C));
        Z2[] S1 = new Z2[gameframe.getGame().getTaille() * gameframe.getGame().getTaille()];
        S1 = this.solveforx(A, C);
        //System.out.println(toStringv(S1));
        
        return S1;
        
    }
    public Z2[][] Allsolutionsfor5(GameFrame gameframe){
        Z2[][] S = new Z2[4][25];
        Z2[] S1 = this.LinearSolution(gameframe);
        Z2[] v1={zero,one,one,one,zero,one,zero,one,zero,one,one,one,zero,one,one,one,zero,one,zero,one,zero,one,one,one,zero};
        Z2[] v2={one,zero,one,zero,one,one,zero,one,zero,one,zero,zero,zero,zero,zero,one,zero,one,zero,one,one,zero,one,zero,one};
        for (int i=0; i<25; i++){
        S[0][i]=S1[i];
        S[1][i]=S1[i].add(v1[i]);
        S[2][i]=S1[i].add(v2[i]);
        S[3][i]=S1[i].add(v1[i]).add(v2[i]);
        }
        return S;
    }
    public int Hammingdistozero(Z2[] u){
        int Hammingdisto=0;
        for (int i=0; i<u.length; i++){
            if (u[i].getClassZ()!=0){
                Hammingdisto++;
            }
        }
        return Hammingdisto;
    }
    public Z2[] optimalSolution(GameFrame gameframe){
        int[] Harray=new int[4];
        Z2[] OpS = new Z2[25];
        Z2[][] S=this.Allsolutionsfor5(gameframe);
        int H=0;
        for (int i=0; i<4;i++){
            Z2[] U = new Z2[25];
            for (int j=0; j<25;j++){
                U[j]=S[i][j];
            }
            Harray[i]=this.Hammingdistozero(U);
        }
        for (int k=0;k<4;k++){
            if (H>Harray[k]){
                H=k;
            }
        }
        for (int i=0; i<25; i++){
            OpS[i]=S[H][i];
        }
        return OpS;
    }
    public void Solvecurrgame(GameFrame gameframe1) throws InterruptedException {
        Graphics g = gameframe1.getGraphics();
        if(gameframe1.getGame().getTaille()!=5){
        for (int i = 0; i < gameframe1.getGame().getTaille(); i++) {
            for (int j = 0; j < gameframe1.getGame().getTaille(); j++) {
                if (this.LinearSolution(gameframe1)[gameframe1.getGame().getTaille() * i + j].getClassZ()==1) {
                    gameframe1.getGame().toggleall(i, j);
                    gameframe1.PaintXY(i, j, g);
                    Thread.sleep(500/gameframe1.getGame().getTaille());
                }
            }
        }
        }
        else {
            for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.optimalSolution(gameframe1)[gameframe1.getGame().getTaille() * i + j].getClassZ()==1) {
                    gameframe1.getGame().toggleall(i, j);
                    gameframe1.PaintXY(i, j, g);
                    Thread.sleep(100);
        }
    }

}
        }
    }
}
