package apresentação;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controle.Adicionais;
import controle.Barraquina;
import controle.CachorroQuente;
import controle.TipoEnumBebidas;
import controle.TipoEnumQueijo;

public class AreadoForms extends JPanel implements ActionListener{

	private static final String TipoEnumQueijo = null;
	private JLabel label;
	private JTextField nomeCliente;
	private JTextField matriculaCliente;
	private JComboBox<String> proteina;
	private JComboBox<String> queijos;
	private JComboBox<String> bebidas;
	private Barraquina barraquinha;
	private Adicionais adicionais;
	private PaineldeSelecao paineldeSelecao;
	private TipoEnumQueijo Queijo;
	private TipoEnumBebidas Bebida;
	
	public AreadoForms(Barraquina barraquinha) {
		
		this.barraquinha = barraquinha;
		adicionais = new Adicionais();
		
		this.nomeCliente = new JTextField();
		this.matriculaCliente = new JTextField();
		
		String[] opcoes1 = {"sem proteina","salsicha", "linguiça", "frango", "bacon"};
		this.proteina = new JComboBox<>(opcoes1);
		
		String[] opcoes2 = {"sem queijo","mussarela", "prato", "parmesão", "coalho"};
		this.queijos = new JComboBox<>(opcoes2);
		
		String[] opcoes3 = {"sem bebida","Coca-cola", "Del Rio","Suco do Chaves"};
		this.bebidas = new JComboBox<>(opcoes3);
		
		paineldeSelecao = new PaineldeSelecao(adicionais);
		
		label = new JLabel();
		label.setBackground(new Color(255, 255, 153));
		label.setFont(new Font("arial", Font.BOLD, 40));
		this.setBackground(new Color(255, 255, 153));
		
		add(new JLabel("Nome do cliente: "));
		add(nomeCliente);
		add(new JLabel("Matricula: "));
		add(matriculaCliente);
		add(new JLabel("Opção de queijo: "));
		add(queijos);
		add(new JLabel("Opção de proteína: "));
		add(proteina);
		add(new JLabel("Escolha seus adicionais: "));
		add(paineldeSelecao);
		add(new JLabel("bebidas: "));
		add(bebidas);
		add(new JLabel());

		add(criarBotao("Realizar a venda", new Color(255, 153, 153)));

	}
	

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		String nome = nomeCliente.getText();
		int matricula = 000000; 
		
		try {			
			matricula = Integer.parseInt(matriculaCliente.getText());
		} catch (NumberFormatException e1) {
		}
		
		String tipodoCachorro = (String) proteina.getSelectedItem();
		String tipodeQueijo = (String) queijos.getSelectedItem();
		String tipodeBebida = (String) bebidas.getSelectedItem();
		
				
		if( b.getText().equals("Realizar a venda")) {
			
			//criação do aluno
			barraquinha.criarAluno(nome, matricula);
			
			//criação do cachorro
			barraquinha.escolherCachorroQuente(tipodoCachorro, tipodeQueijo, tipodeBebida, adicionais);
			
			//limpar o formulario
			limparforms(Janela.areadoForms);
		}
	}
	
	public void limparforms(Container container) {
		Component[] components = container.getComponents();
		
		for (Component component : components) {
			if (component instanceof JTextField) {
				
                ((JTextField) component).setText("");
                
            } else if (component instanceof JComboBox) {
      
                ((JComboBox<?>) component).setSelectedIndex(0);
                
            } else if (component instanceof JCheckBox) {
            	
                ((JCheckBox) component).setSelected(false);
                
            }

		}
	}

	public Botao criarBotao(String texto, Color cor) {
		Botao b = new Botao(texto, cor);
		b.setPreferredSize(new Dimension(185, 40));
		b.addActionListener(this);
		return b;
	}

}