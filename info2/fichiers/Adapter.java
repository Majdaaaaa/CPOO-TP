import java.util.ArrayList;

public class Adapter extends RGBImageViewer {

    public Adapter(RGBAImage image) {
        super(convertToRGBImage(image));
    }

    private static RGBImage convertToRGBImage(RGBAImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        ArrayList<RGBColor> rgbPixels = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width ; j++) {
                System.out.println("ICI"+i+" "+j);
                RGBAColor c = image.getPixel(j, i);
                rgbPixels.add(new RGBColor(c.getRed(), c.getGreen(), c.getBlue()));
            }
        }

        return new RGBImage(width, height, rgbPixels);
    }

}
