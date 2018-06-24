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
            String FILENAME = "noise";
            String EXTENSION = ".jpg";
            File f = new File(FILENAME+EXTENSION);
            BufferedImage image = ImageIO.read(f);
            JFrame frame = new JFrame("window");
            frame.setSize(image.getWidth(), image.getHeight());
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            while(!d.genComplete()) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            BufferedImage out = d.getOut();
            /*while(true) {
                d.setImage(out);
                d.redraw(1);
                out = d.getOut();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            */
            
            File output = new File(FILENAME + "_out" + EXTENSION);
            System.out.println("output image width: " + out.getWidth());
            System.out.println("output image height: " + out.getHeight());
            ImageIO.write(out,EXTENSION.substring(1),output);
            System.out.println("image writing complete");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}