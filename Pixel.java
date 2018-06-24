import java.awt.*;
public class Pixel {
    Color c;
    int x;
    int y;
    public Pixel(int xx, int yy, Color Co) {
        x=xx;
        y=yy;
        c=Co;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Color getColor() {
        return c;
    }
}