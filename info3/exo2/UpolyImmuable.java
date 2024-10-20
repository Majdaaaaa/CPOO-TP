package exo2;

public class UpolyImmuable extends PolyImmuable {

    private int[] coef;
    private int degree;

    public UpolyImmuable(int[] c) {
        super(c);
        if (!checkUpoly()) {
            throw new IllegalArgumentException("C'est pas un polynome unitaire");
        }
    }

    private boolean checkUpoly() {
        if (this.getCoefficients()[getDegree()] != 1) {
            return false;
        }
        return true;
    }

    @Override
    public int getDegree() {
        return this.degree;
    }

    @Override
    public int[] getCoefficients() {
        return this.coef;
    }

    public PolyImmuable setCoefficients(int[] c) {
        if (c[this.degree] != 1) {
            return new PolyImmuable(c);
        } else {
            return new UpolyImmuable(c);
        }
    }

    public PolyImmuable setAk(int i, int v) {
        int[] c = this.coef;
        c[i] = v;

        if (i == this.degree && v != 1) {
            return new PolyImmuable(c);
        }else{
            return new UpolyImmuable(c);
        }

    }

}
