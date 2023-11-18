package apresentação;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private BufferedImage backgroundimage;
	
	public ImagePanel(String image) {
		try {
		backgroundimage = ImageIO.read(getClass().getClassLoader().getResource(image));
		} catch (IOException e) {
            e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
		if (backgroundimage != null) {
            g.drawImage(backgroundimage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }	
}
