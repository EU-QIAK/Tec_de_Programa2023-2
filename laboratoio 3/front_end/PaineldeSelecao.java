package front_end;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PaineldeSelecao extends JPanel{

	public PaineldeSelecao(){
	setLayout(new GridLayout(2, 2));
	JCheckBox checkBox1 = new JCheckBox("Maionese");
	JCheckBox checkBox2 = new JCheckBox("Ketchup");
	JCheckBox checkBox3 = new JCheckBox("Ovo");
	JCheckBox checkBox4 = new JCheckBox("batata palha");

	add(checkBox1);
	add(checkBox2);
	add(checkBox3);
	add(checkBox4);
	}
}
