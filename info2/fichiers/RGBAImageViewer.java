public class RGBAImageViewer {
    public static void main(String[] args) {
        new Adapter((new RGBAImageReader(args[0])).read());
    }
}
//javac RGBColor.java RGBIm*.java RGBAImageViewer.java
//java RGBAImageViewer ./dices.rgba