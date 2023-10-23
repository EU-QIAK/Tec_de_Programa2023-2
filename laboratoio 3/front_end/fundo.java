package front_end;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class fundo extends JPanel{

	JLabel label;

	public fundo() {
		
		add(new JLabel());
		label = new JLabel("QUITUTES - UFC");
		label.setFont(new Font("arial", Font.BOLD, 28));
		label.setLayout(new GridBagLayout());
		label.setBackground(new Color(255, 255, 153));
		this.setBackground(new Color(255, 255, 153));	
		add(label);
		
	}
}
