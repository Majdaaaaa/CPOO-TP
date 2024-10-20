import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * La classe RGBImageReader est responsable de la lecture d'images au format RGB depuis un fichier.
 */
public class RGBImageReader {
    private FileInputStream inputStream;

    /**
     * Constructeur de la classe RGBImageReader.
     *
     * @param path Le chemin du fichier à partir duquel lire l'image RGB.
     */
    public RGBImageReader(String path) {
        try {
            this.inputStream = new FileInputStream(path);
        } catch(Exception e) {}
    }

    /**
     * Lit et crée une image RGB à partir du fichier spécifié.
     *
     * @return Une instance de RGBImage représentant l'image lue, ou null en cas d'erreur.
     */
    public RGBImage read() {
        try {
            int width = this.inputStream.read();
            int height = this.inputStream.read();
            ArrayList<RGBColor> pixels = new ArrayList<RGBColor>();
            int r = -1;
            int g = -1;
            int b = -1;
            do {
                r = this.inputStream.read();
                g = this.inputStream.read();
                b = this.inputStream.read();
                if(r != -1 && g != -1 && b != -1) {
                    pixels.add(new RGBColor(r, g, b));
                }
            } while(r != -1 && g != -1 && b != -1);
            return new RGBImage(width, height, pixels);
        } catch(Exception e) {
            return null;
        }
    }
}