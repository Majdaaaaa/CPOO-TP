package exo2;

public class PolyImmuable extends Poly {
    private final int[] coef;
    private final int degree;

    public PolyImmuable (int[] c){
        super();
        this.coef=c;
        this.degree=c.length-1;

    }


    @Override
    public int getDegree() {
        return this.degree;
    }

    @Override
    public int[] getCoefficients() {
        return this.coef;
    }

    public PolyImmuable setCoefficients(int[] c){
        return new PolyImmuable(c);
    }

    public PolyImmuable setAk(int i, int v){
        int[] c=this.coef;
        c[i]=v;
        return new PolyImmuable(c);
    }
    

    public String toString() {
        String t = "";
        t+="Degré du polynôme : " + this.getDegree()+"\n";
        for (int i = 0; i < degree +1; i++) {
            if (i == degree) {
                t += " + " + coef[i] + "X^" + i;
            }else
            if (i ==0) {
                t += coef[i] + "X^" + i ;
            }else{
                t += " + " +coef[i] + "X^" + i ;
            }
        }
        return t;
    }
}
