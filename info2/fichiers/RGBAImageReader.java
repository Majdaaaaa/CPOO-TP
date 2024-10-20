
import java.io.FileInputStream;
import java.util.ArrayList;
/**
 * La classe RGBAImageReader est responsable de la lecture d'images au format RGBA depuis un fichier.
 */
public class RGBAImageReader {
    private FileInputStream inputStream;

    /**
     * Constructeur de la classe RGBAImageReader.
     *
     * @param path Le chemin du fichier à partir duquel lire l'image RGB.
     */
    public RGBAImageReader(String path) {
        try {
        this.inputStream = new FileInputStream(path);
        } catch(Exception e) {
            
        }
    }

    /**
     * Lit et crée une image RGBA à partir du fichier spécifié.
     *
     * @return Une instance de RGBAImage représentant l'image lue, ou null en cas d'erreur.
     */
    public RGBAImage read() {
        try {
        int width = this.inputStream.read();
        int height = this.inputStream.read();
        ArrayList<RGBAColor> pixels = new ArrayList<RGBAColor>();
        int r = -1;
        int g = -1;
        int b = -1;
        int a = -1;
        do {
            r = this.inputStream.read();
            g = this.inputStream.read();
            b = this.inputStream.read();
            a = this.inputStream.read();
            if(r != -1 && g != -1 && b != -1 && a != -1) {
                pixels.add(new RGBAColor(r, g, b, a));
            }
        } while(r != -1 && g != -1 && b != -1 && a != -1);
        return new RGBAImage(width, height, pixels);
        } catch(Exception e) {
            return null;
        }
    }
}