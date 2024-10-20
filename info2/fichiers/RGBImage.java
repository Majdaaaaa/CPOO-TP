import java.util.ArrayList;

/**
 * Cette classe représente une image RGB avec une largeur, une hauteur et des les couleurs de chaques pixels.
 */
public class RGBImage {
    private int width;
    private int height;
    private ArrayList<RGBColor> pixels;

    public RGBImage(int width, int height, ArrayList<RGBColor> pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    /**
     * Récupère la largeur de l'image.
     *
     * @return La largeur de l'image.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Récupère la hauteur de l'image.
     *
     * @return La hauteur de l'image.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Récupère le pixel à la position (x, y) dans l'image.
     *
     * @param x La coordonnée x du pixel.
     * @param y La coordonnée y du pixel.
     * @return Le pixel à la position (x, y).
     * @throws IllegalArgumentException Si les coordonnées (x, y) sont en dehors des limites de l'image.
     */
    public RGBColor getPixel(int x, int y) {
        if (x < 0 || x >= this.width) {
            throw new IllegalArgumentException("Les coordonnées x sont en dehors des limites de l'image.");
        }
        if (y < 0 || y >= this.height) {
            throw new IllegalArgumentException("Les coordonnées y sont en dehors des limites de l'image.");
        }
        return this.pixels.get(y * this.width + x);
    }
}