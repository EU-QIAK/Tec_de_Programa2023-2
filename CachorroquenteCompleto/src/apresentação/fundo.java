package apresentação;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class fundo extends JPanel{

	JLabel label;

	public fundo() {
		
		ImagePanel panel = new ImagePanel("Fundobarraquinha.png");
		panel.setVisible(true);
		add(panel);
//		label = new JLabel("QUITUTES - UFC");
//		label.setFont(new Font("arial", Font.BOLD, 28));
//		label.setLayout(new GridBagLayout());
//		label.setBackground(new Color(255, 255, 153));
//		this.setBackground(new Color(255, 255, 153));	
//		add(label);
		
	}
}
