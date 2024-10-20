import exo1.Upoly;

public class TestExo {
    public static void main(String[] args) {
        int[] coefficients = {3, 2, 5,1};

        Upoly c = new Upoly(coefficients);

        System.out.println(c);

        c.setAk(c.getDegree(), 1);


        System.out.println(c);

        System.out.println(c instanceof Upoly);
        //OUI IL EST TOUJOURS DE TYPE UPOLY
    }
}
