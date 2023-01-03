/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightsoutversionmatricielle;

/**
 *
 * @author houariac
 */
public class TestZ2 {

    private LinearSolver lsolver = new LinearSolver("uhuh");

    /**
     * @param args the command line arguments
     */
    public TestZ2() {
        Z2 one = new Z2(1);
        Z2[] tab = new Z2[2];
        tab[1] = one;
        tab[0] = new Z2(0);
        Z2 a, b, c;
        a = new Z2(1);
        b = new Z2(1);
        c = new Z2(0);

        Z2[][] A = new Z2[25][25];
        for (int ii = 0; ii < 5; ii++) {
            for (int jj = 0; jj < 5; jj++) {
                Z2[][] Aiijj = lsolver.operatorij(ii, jj, 5);
                for (int j = 0; j < 25; j++) {
                    A[ii * 5 + jj][j] = new Z2(lsolver.fmatrixtovector(Aiijj)[j].getClassZ());
                }
            }
        }
        System.out.println(lsolver.toString(A));
        for (int i = 0; i < A.length - 1; i++) {
            Z2 sup = new Z2(0);
            int j = 0;
            if (A[i][i].getClassZ() == 1) {
                sup.setClassZ(1);
                j=i;
            } 
            else {
                for (int k = i + 1; k < A.length; k++) {
                    if (sup.getClassZ() < A[k][i].getClassZ()) {
                        sup = new Z2(A[k][i].getClassZ());
                        j = k;
                    }
                }
            }

            if (sup.getClassZ() > 0) {
                lsolver.swapm(A, i, j);
                for (int k = i+1; k < A.length; k++) {
                    Z2 tmp = new Z2(0);
                    tmp = A[k][i];
                    if (A[k][i].getClassZ()==1){
                    for (int l = 0; l < A.length; l++) {
                        A[k][l] = A[k][l].add(A[i][l]);
                    }
                }
                }
            }
        }
        System.out.println(lsolver.toString(A));
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new TestZ2();
    }

}
