package exo1;

public class Poly {
    private int[] A;
    private int degree;

    public Poly(int[] coef) {
        this.A = coef;
        this.degree=A.length-1;
    }

    public int[] getCoefficients() {
        return A;
    }

    // Setter pour les coefficients
    public void setCoefficients(int[] coefficients) {
        this.A = coefficients;
    }

    public int getDegree() {
        return degree;
    }

    public String toString() {
        String t = "";
        for (int i = 0; i < degree +1; i++) {
            if (i == degree) {
                t += " + " + A[i] + "X^" + i;
            }else
            if (i ==0) {
                t += A[i] + "X^" + i ;
            }else{
                t += " + " +A[i] + "X^" + i ;
            }
        }
        return t;
    }
}