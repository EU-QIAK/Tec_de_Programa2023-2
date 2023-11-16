package front_end;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import back_end.Adicionais;
import back_end.Barraquina;
import back_end.CachorroQuente;

public class PaineldeSelecao extends JPanel implements ActionListener{

	private Adicionais adicionais;
	
	public PaineldeSelecao(Adicionais adicionais){
	
	this.adicionais = adicionais;
	
	setLayout(new GridLayout(2, 2));
	JCheckBox checkBox1 = new JCheckBox("Maionese");
	checkBox1.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			
			if(e.getStateChange() == ItemEvent.SELECTED) {
		
				adicionais.setMaionese(true);
				
            } else {
				
            	adicionais.setMaionese(false);

            }
			
		}
	});
	
	JCheckBox checkBox2 = new JCheckBox("Ketchup");
	checkBox2.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				
				adicionais.setKetchup(true);
				
            } else {
				
            	adicionais.setKetchup(false);

            }
		}
	});
	
	JCheckBox checkBox3 = new JCheckBox("Ovo");
	checkBox3.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				
				adicionais.setOvo(true);
				
            } else {
				
            	adicionais.setOvo(false);

            }
		}
	});
	
	JCheckBox checkBox4 = new JCheckBox("batata palha");
	checkBox4.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				
				adicionais.setBatata(true);
				
            } else {
				
            	adicionais.setBatata(false);

            }
		}
	});

	add(checkBox1);
	add(checkBox2);
	add(checkBox3);
	add(checkBox4);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
