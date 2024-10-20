/**
 * Cette classe représente une couleur RGB avec des composants rouge, vert et bleu.
 */
public class RGBColor {
    private int red;
    private int green;
    private int blue;

    /**
     * Construit un objet RGBColor avec les composants rouge, vert et bleu spécifiés.
     *
     * @param red   Le composant rouge (0-255).
     * @param green Le composant vert (0-255).
     * @param blue  Le composant bleu (0-255).
     */
    public RGBColor(int red, int green, int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    /**
     * Récupère le composant rouge de la couleur RGB.
     *
     * @return Le composant rouge (0-255).
     */
    public int getRed() {
        return red;
    }

    /**
     * Définit le composant rouge de la couleur RGB.
     *
     * @param red Le composant rouge à définir (0-255).
     * @throws IllegalArgumentException Si la valeur n'est pas dans la plage [0, 255].
     */
    public void setRed(int red) {
        if (red >= 0 && red <= 255) {
            this.red = red;
        } else {
            throw new IllegalArgumentException("Le composant rouge doit être dans la plage [0, 255]");
        }
    }

    /**
     * Récupère le composant vert de la couleur RGB.
     *
     * @return Le composant vert (0-255).
     */
    public int getGreen() {
        return green;
    }

    /**
     * Définit le composant vert de la couleur RGB.
     *
     * @param green Le composant vert à définir (0-255).
     * @throws IllegalArgumentException Si la valeur n'est pas dans la plage [0, 255].
     */
    public void setGreen(int green) {
        if (green >= 0 && green <= 255) {
            this.green = green;
        } else {
            throw new IllegalArgumentException("Le composant vert doit être dans la plage [0, 255]");
        }
    }

    /**
     * Récupère le composant bleu de la couleur RGB.
     *
     * @return Le composant bleu (0-255).
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Définit le composant bleu de la couleur RGB.
     *
     * @param blue Le composant bleu à définir (0-255).
     * @throws IllegalArgumentException Si la valeur n'est pas dans la plage [0, 255].
     */
    public void setBlue(int blue) {
        if (blue >= 0 && blue <= 255) {
            this.blue = blue;
        } else {
            throw new IllegalArgumentException("Le composant bleu doit être dans la plage [0, 255]");
        }
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la couleur RGB.
     *
     * @return Une chaîne dans le format "RGB(<red>, <green>, <blue>)".
     */
    @Override
    public String toString() {
        return "RGB(" + red + ", " + green + ", " + blue + ")";
    }
}
