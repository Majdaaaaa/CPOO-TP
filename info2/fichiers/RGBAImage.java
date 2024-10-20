

import java.util.ArrayList;


public class RGBAImage {
    private int width;
    private int height;
    private ArrayList<RGBAColor> pixels; // couleur et opacité de chaque pixels

    public RGBAImage(int width, int height, ArrayList<RGBAColor> pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public RGBAColor getPixel(int x, int y) {
        if (x < 0 || x >= this.width) {
            throw new IllegalArgumentException("Les coordonnées x sont en dehors des limites de l'image.");
        }
        if (y < 0 || y >= this.height) {
            throw new IllegalArgumentException("Les coordonnées y sont en dehors des limites de l'image.");
        }
        return this.pixels.get(y * this.width + x);
    }
    
}
