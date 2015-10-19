import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
 
/**
 * https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/2d/images/examples/LoadImageApp.java */
public class Player extends Component {
           
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BufferedImage img;

	public boolean firstPaint;
 
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
 
    public Player() {
       try {
           img = ImageIO.read(new File("Cartoon-Cow-11.png"));
       } catch (IOException e) {
       }
 
    }
 
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
 
    public static void main(String[] args) {
 
        JFrame f = new JFrame("Cartoon-Cow-11.png");
             
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
 
        f.add(new Player());
        f.pack();
        f.setVisible(true);
    }
}