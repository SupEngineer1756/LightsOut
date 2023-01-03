/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightsoutversionmatricielle;

/**
 *
 * @author houariac
 */
public class Testls {

    private LinearSolver lsolver = new LinearSolver("mumu");

    /**
     * @param args the command line arguments
     */
    public Testls() {
        double[][] A = new double[3][3];
        A[0][0] = 1;
        A[0][1] = 1;
        A[0][2] = 2;
        A[1][0] = 1;
        A[1][1] = 2;
        A[1][2] = 1;
        A[2][0] = 2;
        A[2][1] = 1;
        A[2][2] = 1;
        double[] B = new double[3];
        B[0] = 3;
        B[1] = 1;
        B[2] = 0;
        String AtoS = "";
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                AtoS += A[i][j] + " ";
            }
            AtoS += "\n";
        }
        System.out.println(AtoS);
        String btoS = "";

        for (int j = 0; j < B.length; j++) {
            btoS += B[j] + " ";
        }
        btoS += "\n";
        System.out.println(btoS);
        for (int i = 0; i < A.length; i++) {

            for (int k = i + 1; k < A.length; k++) {
                double tmp = 0;
                tmp = A[k][i];
                for (int l = 0; l < A.length; l++) {

                    A[k][l] = A[k][l] - (tmp / A[i][i]) * A[i][l];
                    System.out.println(A[k][l] + " = " + A[k][l] + " - " + "(" + tmp + " / " + A[i][i] + ") * " + A[i][l]);
                    
                }
                B[k] = B[k] - (tmp / A[i][i]) * B[i];
            }
        }
        String MtoS = "";
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                MtoS += A[i][j] + " ";
            }
            MtoS += "\n";
        }
        System.out.println(MtoS);
        String b = "";

        for (int j = 0; j < B.length; j++) {
            b += B[j] + " ";
        }
        b += "\n";
        System.out.println(b);
        double[] X = new double[A.length];
        X[A.length - 1] = B[A.length - 1] / A[A.length - 1][A.length - 1];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < A.length; j++) {
                B[i] = B[i] - A[i][j] * X[j];
            }
            X[i] = B[i] / A[i][i];
        }
        String vtoS = "";

        for (int j = 0; j < X.length; j++) {
            vtoS += X[j] + " ";
        }
        vtoS += "\n";
        System.out.println(vtoS);

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Testls ts = new Testls();
    }

}
