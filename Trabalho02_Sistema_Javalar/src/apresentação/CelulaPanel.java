package apresentação;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CelulaPanel extends JPanel{

	protected ImageIcon image;
	protected int x;
	protected int y;
	protected int id;
	
	public CelulaPanel(int x, int y, int id, ImageIcon imagePath) {
		this.y = y;
		this.x = x;
		image = imagePath;
		
		celulamodelo();
	}
	
	public void celulamodelo() {
	
		setLayout(new BorderLayout());
		
		if(image!= null) {
			JLabel Icon = new JLabel(image);
			JPanel panel = new JPanel(new BorderLayout());
			panel.setBackground(Color.DARK_GRAY);
			panel.add(Icon, BorderLayout.CENTER);
			setLayout(new BorderLayout());
			add(panel);
		}
		
	}
	
	public ImageIcon getImage() {
		return image;
	}
	
	public void setImage(ImageIcon Newimage) {
		this.image = Newimage;
		celulamodelo();
		repaint();
	}

}
