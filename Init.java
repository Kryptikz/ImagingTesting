import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
public class Init {
    public static void main(String[] args) {
        try {
            //JFrame frame = new JFrame("window");
            //frame.setVisible(true);
            //frame.setSize(1000,1000);
            //Display d = new Display(1000,1000);
            File f = new File("text.png");
            BufferedImage image = ImageIO.read(f);
            JFrame frame = new JFrame("window");
            frame.setSize(image.getWidth(), image.getHeight());
            frame.setVisible(true);
            Display d = new Display(image);
            
            frame.add(d);
            d.setVisible(true);
            /*for(int i=100;i>=1;i--) {
                d.redraw(i);
                try {
                    Thread.sleep((140/i)*10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            while(true) {
                d.redraw(1);
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }*/
            /*while(true) {
                d.redraw(1);
            }*/
            d.redraw(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}