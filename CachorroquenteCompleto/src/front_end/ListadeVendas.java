package front_end;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListadeVendas extends JPanel{

	private JLabel label;
	
	public ListadeVendas(){
		
		label = new JLabel();
		label.setBackground(Color.YELLOW);
		label.setFont(new Font("arial", Font.BOLD, 40));
		this.setBackground(Color.YELLOW);
//		JTextArea textArea = new JTextArea();
//        textArea.setEditable(false);
//		JScrollPane lista = new JScrollPane(textArea);
//		add(lista);
	}
}
