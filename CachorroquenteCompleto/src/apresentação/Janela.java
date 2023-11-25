package apresentação;

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
import java.io.FileNotFoundException;
import java.io.IOException;
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

import controle.Barraquina;

public class Janela extends JFrame implements ActionListener{

	private AreasBotoes areasbotoes;
	protected static AreadoForms areadoForms;
	private ListadeVendas listadeVendas;
	private ListarClientes listarClientes;
	private fundo fundo;
	private ImagePanel imagePanel;
	private JPanel painel;
	private Barraquina barraquinha;
	
	//tentando fazer voltar para o painel de inicio 
	private static final int tempoprafechar = 60000;
	private Timer time;
	
	public Janela() {	
		
		try {
			organizarJanela();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("iconebarraquinha - Copia.png"));
        setIconImage(icon.getImage());
		
		setTitle("Barraquinha radical de cachorros quentes - UFC");
		setSize(800,700);
		setBackground(new Color(255, 255, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public void organizarJanela() throws FileNotFoundException, IOException {
		
		Barraquina barraquinha = new Barraquina();
		
		//area dos botoes 
		areasbotoes = new AreasBotoes();
		areasbotoes.setPreferredSize(new Dimension(250, 55));
		add(areasbotoes, BorderLayout.NORTH);
		
		//area da lista de venda 
		listadeVendas = new ListadeVendas();
		listadeVendas.setLayout(new GridLayout());
		listadeVendas.setPreferredSize(new Dimension(100, 606));
		listadeVendas.setVisible(false);
		areasbotoes.listarVenda.addActionListener(new paineis(areasbotoes.listarVenda));
		add(listadeVendas, BorderLayout.SOUTH);
		
		//area de lista de clientes
		listarClientes = new ListarClientes();
		listarClientes.setLayout(new GridLayout());
		listarClientes.setPreferredSize(new Dimension(100, 606));
		listarClientes.setVisible(false);
		areasbotoes.ListarClientes.addActionListener(new paineis(areasbotoes.ListarClientes));
		add(listadeVendas, BorderLayout.SOUTH);
		
		//fundo antes de apertar os botões
		imagePanel = new ImagePanel("Fundobarraquinha.png");
		imagePanel.setLayout(new GridLayout());
		imagePanel.setPreferredSize(new Dimension(100,606));
		
		add(imagePanel);

		//area do formulario
		areadoForms = new AreadoForms(barraquinha);
		areadoForms.setLayout(new GridLayout(7, 2, 5, 25));
		areadoForms.setBorder(BorderFactory.createEmptyBorder(10 ,10 ,10 , 10));
		areadoForms.setPreferredSize(new Dimension(100, 606));
		areadoForms.setVisible(false);
		areasbotoes.realizarVenda.addActionListener(new paineis(areasbotoes.realizarVenda));
		add(areadoForms, BorderLayout.SOUTH);
		
//		this.getContentPane().setBackground(new Color(255, 255, 153));	
	
		time = new Timer();
		
		// Definir uma tarefa para ocultar o painel após o tempo 
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				SwingUtilities.invokeLater(() -> {
					areadoForms.setVisible(false);
					listadeVendas.setVisible(false);
					imagePanel.setVisible(true);
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
				imagePanel.setVisible(false);
			}
			else if(b.getText().equals("Listar vendas")) {
				listadeVendas.ExibirTabela();
				imagePanel.setVisible(true);
				areadoForms.setVisible(false);				
			}
			else if(b.getText().equals("Mostrar relatório")){
				
			}
			else if(b.getText().equals("Listar clientes")){
				listarClientes.ExibirTabela();
				imagePanel.setVisible(true);
				areadoForms.setVisible(false);	
			}
			
			time.cancel();
		
			time = new Timer();
			
			TimerTask newtask = new TimerTask() {
				public void run() {
	                SwingUtilities.invokeLater(() -> {
	                	areadoForms.setVisible(false);
	                    listadeVendas.setVisible(false);
	                    imagePanel.setVisible(true);
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