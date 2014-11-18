import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Game {
	   public static void main(String[] a) {
		   
		      JFrame f = new JFrame();
		      JPanel p1 = new JPanel();
		      JPanel p2 = new JPanel();
		      
		      BufferedImage image = null;
		        try
		        {
		          image = ImageIO.read(new File("src/token.jpg"));
		        }
		        catch (Exception e)
		        {
		          e.printStackTrace();
		          System.exit(1);
		        }
		        ImageIcon imageIcon = new ImageIcon(image);
		        System.out.println(image);
		        JLabel jLabel = new JLabel();
		        jLabel.setIcon(imageIcon);
		        f.add(jLabel);
	
		        f.setLocationRelativeTo(null);
		      
		 
		      
		      
		      f.setSize(800, 800);
		      f.add(p1, BorderLayout.WEST);
		      f.add(p2, BorderLayout.EAST);
		      f.add(new Rectangles());
		      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      f.setVisible(true);
		      
		   }
}
