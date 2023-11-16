package front_end;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import back_end.Barraquina;
import back_end.Venda;

public class Janela extends JFrame implements ActionListener{

	private AreasBotoes areasbotoes;
	protected static AreadoForms areadoForms;
	private ListadeVendas listadeVendas;
	private fundo fundo;
	private JPanel painel;
	private Venda venda;
	private Barraquina barraquinha;
	
	//tentando fazer voltar para o painel de inicio 
	private static final int tempoprafechar = 60000;
	private Timer time;
	
	public Janela() {	
		
		organizarJanela();
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("2979274.png"));
        setIconImage(icon.getImage());
		
		setTitle("Barraquinha de cachorros quentes");
		setSize(800,700);
		setBackground(new Color(255, 255, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	
	}

	public void organizarJanela() {
		
		Venda venda = new Venda(null);
		Barraquina barraquinha = new Barraquina();
		
		//area dos botoes 
		areasbotoes = new AreasBotoes();
		areasbotoes.setPreferredSize(new Dimension(250, 55));
		add(areasbotoes, BorderLayout.NORTH);
		
		//fundo antes de apertar os botões
		fundo = new fundo();
		fundo.setLayout(new GridLayout(0,3));
		add(fundo);
		
		//area da lista de venda 
		listadeVendas = new ListadeVendas();
		listadeVendas.setLayout(new GridLayout(0,3));
		listadeVendas.setPreferredSize(new Dimension(100, 606));
		add(listadeVendas, BorderLayout.SOUTH);
		listadeVendas.setVisible(false);
		areasbotoes.listarVenda.addActionListener(new paineis(areasbotoes.listarVenda));

		//area do formulario
		areadoForms = new AreadoForms(venda, barraquinha);
		areadoForms.setLayout(new GridLayout(7, 2, 5, 25));
		areadoForms.setBorder(BorderFactory.createEmptyBorder(10 ,10 ,10 , 10));
		areadoForms.setPreferredSize(new Dimension(100, 606));
		add(areadoForms, BorderLayout.SOUTH);
		areadoForms.setVisible(false);
		areasbotoes.realizarVenda.addActionListener(new paineis(areasbotoes.realizarVenda));
		
		
		this.getContentPane().setBackground(new Color(255, 255, 153));	
	
		time = new Timer();
		
		// Definir uma tarefa para ocultar o painel após o tempo 
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				SwingUtilities.invokeLater(() -> {
					areadoForms.setVisible(false);
					listadeVendas.setVisible(false);
					fundo.setVisible(true);
				});
			}
		};
		
		// Agendar a tarefa para ser executada após o tempo de atraso
		time.schedule(task, tempoprafechar);
		
	}
	
	private class paineis implements ActionListener{
	
		Botao b;
		
		public paineis(Botao bb) {
			this.b=bb;
		}
	
		public void actionPerformed(ActionEvent e) {
			if(b.getText().equals("Realizar vendas")) {
				areadoForms.setVisible(true);
				listadeVendas.setVisible(false);
				fundo.setVisible(false);
			}
			else if(b.getText().equals("Listar vendas")) {
				listadeVendas.setVisible(true);
				areadoForms.setVisible(false);				
				fundo.setVisible(false);
			}
			else if(b.getText().equals("Mostrar relatório")){
				
			}
			else if(b.getText().equals("Listar clientes")){
				
			}
			
			time.cancel();
		
			time = new Timer();
			
			TimerTask newtask = new TimerTask() {
	            @Override
	            public void run() {
	                SwingUtilities.invokeLater(() -> {
	                	areadoForms.setVisible(false);
	                    listadeVendas.setVisible(false);
	                	fundo.setVisible(true);
	                });
	            }
	        };

	        time.schedule(newtask, tempoprafechar);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}