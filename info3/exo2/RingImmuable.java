package exo2;

public class RingImmuable {

    public abstract sealed class Poly permits PolyImmuable2, UpolyImmuable2 {
        public abstract int getDegree();

        public abstract int[] getCoefficients();

    }
    
    private final class PolyImmuable2 extends Poly {
        private final int[] coef;
        private final int degree;
    
        public PolyImmuable2 (int[] c){
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
            return this.coef.clone();
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
    
    private final class UpolyImmuable2 extends Poly {

        private final int[] coef;
        private final int degree;
    
        public UpolyImmuable2(int[] c) {
            super();
            this.coef=c;
            this.degree=c.length-1;
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
            return this.coef.clone();
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

    public PolyImmuable2 factoryPoly(int[] c){
        return new PolyImmuable2(c.clone());
    }

    public UpolyImmuable2 factoryUPoly(int[] c){
        return new UpolyImmuable2(c.clone());
    }


}
