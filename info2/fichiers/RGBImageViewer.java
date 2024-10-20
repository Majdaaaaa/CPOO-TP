import javax.swing.JFrame;

class RGBImageViewer extends JFrame {
    private RGBImage image;

    public RGBImageViewer(RGBImage image) {
        this.image = image;
        this.add(new RGBImageCanvas(this.image));
        this.setSize(image.getWidth() + 10, image.getHeight() + 35);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new RGBImageViewer((new RGBImageReader(args[0])).read());
    }
}