import exo1.Poly;

public class TestExo {
    public static void main(String[] args) {
        int[] coefficients = {3, 2, 5,4};

        // Création d'un objet Poly
        Poly polynome = new Poly(coefficients);

        // Affichage des coefficients
        System.out.println(polynome);

        // Affichage du degré du polynôme
        System.out.println("Degré du polynôme : " + polynome.getDegree());
    }
}
