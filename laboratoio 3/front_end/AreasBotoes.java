package front_end;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AreasBotoes extends JPanel{

	private JLabel label;
	Botao b;
	
	public AreasBotoes() {
						
		label = new JLabel();
		label.setBackground(new Color(255, 255, 153));
		label.setFont(new Font("arial", Font.BOLD, 40));
		this.setBackground(new Color(255, 153, 153));
		add(label);

		b = criarBotao("Realizar vendas", new Color(255, 255, 153)); 
		b.addActionListener(null);
		add(b);
		
		add(criarBotao("Listar vendas", new Color(255, 255, 153)));
		add(criarBotao("Mostrar relatório", new Color(255, 255, 153)));
		add(criarBotao("Listar clientes", new Color(255, 255, 153)));
	}

	public Botao criarBotao(String texto, Color cor) {
		Botao b = new Botao(texto, cor);
		setLayout(new FlowLayout(FlowLayout.CENTER));

		b.setPreferredSize(new Dimension(185, 40));

		return b;
	}
	
	
}
