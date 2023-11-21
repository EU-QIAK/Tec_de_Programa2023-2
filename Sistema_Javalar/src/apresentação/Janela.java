package apresentação;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controle.Main;
import controle.Planeta;
import controle.SistemaJava;

public class Janela extends JFrame implements ActionListener{

	private Grade grade;
	private AreaDosBotoes botoes;
	private SistemaJava java;
	
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
		java = new SistemaJava();
//		java.menudosistema();
		
		//criando a grade
		setLayout(new BorderLayout());
		grade = new Grade(java);
		grade.setPreferredSize(new Dimension(600,600));
		grade.addAncestorListener(null);
		add(grade, BorderLayout.WEST);
		grade.girar(java.listadePlaneta);	
		
		//criando os botões
		botoes = new AreaDosBotoes();
		botoes.setPreferredSize(new Dimension(200,0));
		botoes.addAncestorListener(null);
		add(botoes, BorderLayout.EAST);
		botoes.processarProximoInstantes.addActionListener(new paineis(botoes.processarProximoInstantes));
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
			if(b.getText().equals("processar proximo instantes")) {
				java.menudosistema();
				grade.resetarPlano(java.listadePlaneta);
				grade.revalidate();
				grade.repaint();
				
			}
			else if(b.getText().equals("ler novo arquivo de entrada")) {
							
			}
			else if(b.getText().equals("Gravar relatorio")){
				
			}
			else if(b.getText().equals("Ler dados de outros participantes")){
				
			}	
			else if(b.getText().equals("Gravar arquivo de saida")){
				
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
//	public void moverPlentas(Planeta planeta) {
//		int id = 0;
//		for (CelulaPanel CelulaPanel: grade.celulasdoPlano) {			
//			if(CelulaPanel.x == planeta.getx() && CelulaPanel.y == planeta.gety()) {
//				
//				if(planeta.nome == "Phyton") {	
//					grade.Setarimagem(97, grade.Fundo);
//					grade.Setarimagem(id, grade.phyton);
//				}
//				else if(planeta.nome == "JavaScript"){
//					grade.Setarimagem(82, grade.Fundo);
//					grade.Setarimagem(id, grade.JavaScript);
//				}
//				else if(planeta.nome == "Ruby on Rails"){
//					grade.Setarimagem(67, grade.Fundo);
//					grade.Setarimagem(id, grade.Ruby);
//				}
//				else if(planeta.nome == "PHP"){
//					grade.Setarimagem(52, grade.Fundo);
//					grade.Setarimagem(id, grade.Php);
//				}
//				else if(planeta.nome == "C#"){
//					grade.Setarimagem(37, grade.Fundo);
//					grade.Setarimagem(id, grade.CSharp);
//				}
//				else if(planeta.nome == "C++"){
//					grade.Setarimagem(22, grade.Fundo);
//					grade.Setarimagem(id, grade.Cmaismais);
//				}
//				else if(planeta.nome == "C"){
//					grade.Setarimagem(7, grade.Fundo);
//					grade.Setarimagem(id, grade.C);
//				}
//			
//			}else {
//				grade.Setarimagem(CelulaPanel.id, grade.Fundo);
//				
//			}
//			grade.Setarimagem(CelulaPanel.id, grade.Fundo);
//			id++;
//		}
//	}
	
//	public static void main(String[] args) {
//		
//		Janela janela= new Janela();
//	}

}
