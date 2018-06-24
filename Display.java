import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
public class Display extends JComponent {
    int WIDTH;
    int HEIGHT;
    int pxsize;
    BufferedImage im;
    BufferedImage af;
    public Display(BufferedImage image) {
        im=image;
        WIDTH=im.getWidth();
        HEIGHT=im.getHeight();
        System.out.println("IMAGE WIDTH: " + WIDTH);
        System.out.println("IMAGE HEIGHT: " + HEIGHT);
    }
    public Display(int w, int h) {
        WIDTH=w;
        HEIGHT=h;
    }
    public void redraw(int size) {
        pxsize=size;
        this.repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color[][] colorList = new Color[WIDTH][HEIGHT];
        /*for(int r=0;r<HEIGHT;r+=pxsize) {
            for(int c=0;c<WIDTH;c+=pxsize) {
                Color co = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
                g.setColor(co);
                g.fillRect(c,r,pxsize,pxsize);
                colorList[r][c]=new Pixel(c,r,co);
            }
        }*/
        for(int r=0;r<colorList.length;r++) {
            for(int c=0;c<colorList[0].length;c++) {
                int rgb = im.getRGB(r,c);
                int red = (rgb>>16)&0xFF;
                int green = (rgb>>8)&0xFF;
                int blue = (rgb)&0xFF;
                /*System.out.println("r: " + r);
                System.out.println("c: " + c);
                System.out.println("rgb: " + rgb);
                System.out.println("red: " + red);
                System.out.println("green: " + green);
                System.out.println("blue: " + blue);*/
                
                //colorList[r][c] = new Pixel(c,r,new Color(red,green,blue));
                colorList[r][c] = new Color(red,green,blue);
            }
        }
        System.out.println("image import complete");
        double[][] vals = new double[WIDTH][HEIGHT];
        for(int r=0;r<colorList.length;r++) {
            for(int c=0;c<colorList[0].length;c++) {
                Color f = colorList[r][c];
                int top = r-1;
                int bot = r+1;
                int lef = c-1;
                int rig = c+1;
                if (r-1<0) {
                    top=0;
                }
                if (r+1>=colorList.length) {
                    bot=colorList.length-1;
                }
                if (c-1<0) {
                    lef=0;
                }
                if (c+1>=colorList[0].length) {
                    rig=colorList[0].length-1;
                }
                //System.out.println("rig: " + rig);
                
                
                int n=0;
                double av=0;
                for(int i1=top;i1<=bot;i1++) {
                    for(int i2=lef;i2<=rig;i2++) {
                        try {
                            if(i1!=r&&i2!=c) {
                                Color o = colorList[i1][i2];
                                int rdiff = o.getRed()-f.getRed();
                                int gdiff = o.getGreen()-f.getGreen();
                                int bdiff = o.getBlue()-f.getBlue();
                                av+=Math.sqrt((rdiff*rdiff)+(gdiff*gdiff)+(bdiff*bdiff));
                                n++;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                av/=n;
                //int maxav = 0;
                //for(
                
                //g.setColor(new Color(255,av/maxav*255,255));
                //g.fillRect(c,r,1,1);
                vals[r][c]=av;
            }
            System.out.println((((double)r/(double)HEIGHT)*100) + "% complete with distance calculations");
        }
        System.out.println("distance heatmap data generated");
        double maxav = 0;
        for(double[] r : vals) {
            for(double i : r) {
                if (i>maxav) {
                    maxav=i;
                }
            }
        }
        System.out.println("maxmimum calculation complete");
        for(int r=0;r<vals.length;r++) {
            for(int c=0;c<vals[0].length;c++) {
                g.setColor(new Color(0,(int)(vals[r][c]/maxav*255),0));
                //System.out.println("value: " + vals[r][c] + " max: " + maxav);
                g.fillRect(r,c,1,1);
            }
        }
        System.out.println("drawing complete");
        
        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        for(int r=0
        
    }
}