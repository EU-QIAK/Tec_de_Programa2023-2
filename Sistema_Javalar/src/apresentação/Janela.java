package apresentação;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import negocio.Main;
import negocio.Planeta;
import negocio.SistemaJava;
import persistencia.EscreverDados;

public class Janela extends JFrame implements ActionListener{

	private Grade grade;
	private AreaDosBotoes botoes;
	private SistemaJava javalar;
	private EscreverDados escreverDados;
	
	public Janela() {
		
		organizar();
		
		setSize(816,600);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); 
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Sistema-Javalar");
			
	}
	
	public void organizar() {
		javalar = new SistemaJava();
		escreverDados = new EscreverDados();
//		java.menudosistema();
		
		//criando a grade
		setLayout(new BorderLayout());
		grade = new Grade(javalar);
		grade.setPreferredSize(new Dimension(600,600));
		grade.addAncestorListener(null);
		add(grade, BorderLayout.WEST);
		grade.girar(javalar);	
		
		//criando os botões
		botoes = new AreaDosBotoes();
		botoes.setPreferredSize(new Dimension(200,0));
		botoes.addAncestorListener(null);
		add(botoes, BorderLayout.EAST);
		botoes.processarProximosInstantes.addActionListener(new paineis(botoes.processarProximosInstantes));
		botoes.lerNovoArquivodeEntrada.addActionListener(new paineis(botoes.lerNovoArquivodeEntrada));
		botoes.GravarRelatorio.addActionListener(new paineis(botoes.GravarRelatorio));
		botoes.LerDadosDeOutrosParticipantes.addActionListener(new paineis(botoes.LerDadosDeOutrosParticipantes));
		botoes.GravarArquivoDeSaida.addActionListener(new paineis(botoes.GravarArquivoDeSaida));
	
	}

	private class paineis implements ActionListener{
		
		Botao b;
		
		public paineis(Botao bb) {
			this.b=bb;
		}
	
		public void actionPerformed(ActionEvent e) {
			if(b.getText().equals("processar proximos instantes")) {
				javalar.proximaLinhas();
				grade.resetarPlano(javalar);
				grade.revalidate();
				grade.repaint();
			}
			else if(b.getText().equals("ler novo arquivo de entrada")) {
				LerArquivos();
			}
			else if(b.getText().equals("Gravar relatorio")){
				javalar.relatorio();
			}
			else if(b.getText().equals("Ler dados de outros participantes")){
				
			}	
			else if(b.getText().equals("Gravar arquivo de saida")){
				
			}
		}
		
	}
	
	public void LerArquivos() {
		
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setCurrentDirectory(new File("dados&Imagens//dados"));
		
		int returnvalor = fileChooser.showOpenDialog(fileChooser);
		
		if(returnvalor == JFileChooser.APPROVE_OPTION){
			
			File selectedFile = fileChooser.getSelectedFile();
			String diretorio = selectedFile+"";
			
			try {
				javalar.menudosistema(selectedFile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//			grade.resetarPlano(javalar);
//			grade.revalidate();
//			grade.repaint();
//			escreverDados.escreverDados(diretorio, getName());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
