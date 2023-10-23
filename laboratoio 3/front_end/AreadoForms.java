package front_end;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AreadoForms extends JPanel {

	private JLabel label;
	
	public AreadoForms() {
		
		JTextField textField = new JTextField();
		JTextField textField2 = new JTextField();
		
		String[] opcoes = {"mussarela", "prato", "parmesão", "coalho"};
		JComboBox<String> comboBox = new JComboBox<>(opcoes);
		String[] opcoes2 = {"salsicha", "linguiça", "frango", "bacon"};
		JComboBox<String> comboBox2 = new JComboBox<>(opcoes2);
		String[] opcoes3 = {"Coca-cola", "Del Rio","Suco do Chaves"};
		JComboBox<String> comboBox3 = new JComboBox<>(opcoes3);
		PaineldeSelecao selecao = new PaineldeSelecao();
		
		label = new JLabel();
		label.setBackground(new Color(255, 255, 153));
		label.setFont(new Font("arial", Font.BOLD, 40));
		this.setBackground(new Color(255, 255, 153));
		add(new JLabel("Nome do cliente: "));
		add(textField);
		add(new JLabel("Matricula: "));
		add(textField2);		
		add(new JLabel("Opção de queijo: "));
		add(comboBox);
		add(new JLabel("Opção de proteína: "));
		add(comboBox2);
		add(new JLabel("Escolha seus adicionais: "));
		add(selecao);
		add(new JLabel("bebidas: "));
		add(comboBox3);
		add(new JLabel());

		add(criarBotao("Realizar a venda", new Color(255, 153, 153)));

	}
	
	public Botao criarBotao(String texto, Color cor) {
		Botao b = new Botao(texto, cor);
		b.setPreferredSize(new Dimension(185, 40));
		return b;
	}
	
}
