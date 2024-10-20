import java.awt.Canvas;
import java.awt.Graphics;

public class RGBImageCanvas extends Canvas {
    private RGBImage image;

    public RGBImageCanvas(RGBImage image) {
        this.image = image;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for(int x = 0; x < this.image.getWidth(); x++) {
            for(int y = 0; y < this.image.getHeight(); y++) {
                RGBColor c = this.image.getPixel(x, y);
                g.setColor(new java.awt.Color(c.getRed(), c.getGreen(), c.getBlue()));
                g.drawLine(x, y, x, y);
            }
        }
    }
}