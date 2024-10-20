

public class RGBAColor{
    private int red;
    private int green;
    private int blue;
    private int alpha;

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getAlpha() {
        return alpha;
    }

    public RGBAColor(int r,int g,int b, int a){
        setRed(r);
        setGreen(g);
        setBlue(b);
        setAlpha(a);
    }

    public void setRed(int red) {
        if (red >= 0 && red <= 255) {
            this.red = red;
        } else {
            throw new IllegalArgumentException("Le composant rouge doit être dans la plage [0, 255]");
        }
    }

    public void setGreen(int green) {
        if (green >= 0 && green <= 255) {
            this.green = green;
        } else {
            throw new IllegalArgumentException("Le composant vert doit être dans la plage [0, 255]");
        }
    }

    public void setBlue(int blue) {
        if (blue >= 0 && blue <= 255) {
            this.blue = blue;
        } else {
            throw new IllegalArgumentException("Le composant bleu doit être dans la plage [0, 255]");
        }
    }

    public void setAlpha(int alpha) {
        if (alpha >= 0 && alpha <= 255) {
            this.alpha = alpha;
        } else {
            throw new IllegalArgumentException("Le composant alpha doit être dans la plage [0, 255]");
        }
    }
}
