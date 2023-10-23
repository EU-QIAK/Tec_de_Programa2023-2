package front_end;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Janela extends JFrame implements ActionListener{

	private AreasBotoes areasbotoes;
	private AreadoForms areadoForms;
	private fundo fundo;
	private JPanel painel;
	
	public Janela() {	
		organizarJanela();
		setTitle("Barraquinha de cachorros quentes");
		setSize(800,700);
		setBackground(new Color(255, 255, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void organizarJanela() {
		//area dos botoes 
		areasbotoes = new AreasBotoes();
		areasbotoes.setPreferredSize(new Dimension(250, 55));
		add(areasbotoes, BorderLayout.NORTH);
		
		areadoForms = new AreadoForms();
		areadoForms.setLayout(new GridLayout(7, 2, 0, 5));
		areadoForms.setPreferredSize(new Dimension(100, 606));
		add(areadoForms, BorderLayout.SOUTH);
		areadoForms.setVisible(false);
		areasbotoes.b.addActionListener(new paineis(areasbotoes.b));
		
		fundo = new fundo();
		fundo.setLayout(new GridLayout(0,3));
		add(fundo);
		
		this.getContentPane().setBackground(new Color(255, 255, 153));	
	}
	
	
	private class paineis implements ActionListener{
		Botao bb;
		
		public paineis(Botao bb) {
			this.bb=bb;
		}
	
		public void actionPerformed(ActionEvent e) {
			if(bb.getText().equals("Realizar vendas")) {
				areadoForms.setVisible(true);
			}
			
		}
		
	}
	
	public static void main(String[] args) {

		Janela janela = new Janela();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}