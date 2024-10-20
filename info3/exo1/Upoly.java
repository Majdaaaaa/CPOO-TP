package exo1;

public class Upoly extends Poly{

    public Upoly(int[] coef) {
        super(coef);
        if(!checkUpoly()){
            throw new IllegalArgumentException("C'est pas un polynome unitaire");
        }
        
    }

    private boolean checkUpoly(){
        if(this.getCoefficients()[getDegree()]!=1){
            return false;
        }
        return true;
    }

    @Override
    public void setCoefficients(int[] coefficients) {
        if(coefficients[this.getDegree()]!=1){
            throw new IllegalArgumentException("Ca fera pas un polynome unitaire");
        }
        this.setCoefficients(coefficients);
    }

    public void setAk(int i,int coef){
        if(i==this.getDegree() && coef!=1){
            throw new IllegalArgumentException("Ca fera pas un polynome unitaire");
        }
        super.setAk(i, coef);
    }

     
}
