package apresentação;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.Celula;
import controle.Planeta;
import controle.Plano;
import controle.SistemaJava;

public class Grade extends JPanel {

	public ArrayList<CelulaPanel> celulasdoPlano = new ArrayList<CelulaPanel>();
	private CelulaPanel celulaPanel;
	private Plano plano;
	private SistemaJava sistemaJava;

	private ImageIcon Java = new ImageIcon("dados&Imagens\\Java.png");
	private ImageIcon phyton = new ImageIcon("dados&Imagens\\Phyton.png");
	private ImageIcon JavaScript = new ImageIcon("dados&Imagens\\JavaScript.png");
	private ImageIcon Ruby = new ImageIcon("dados&Imagens\\Ruby.png");
	private ImageIcon Php = new ImageIcon("dados&Imagens\\Php.png");
	private ImageIcon CSharp = new ImageIcon("dados&Imagens\\C#.png");
	private ImageIcon Cmaismais = new ImageIcon("dados&Imagens\\C++.png");
	private ImageIcon C = new ImageIcon("dados&Imagens\\C.png");
	private ImageIcon Bug = new ImageIcon("dados&Imagens\\Bug.png");
	private ImageIcon Dev = new ImageIcon("dados&Imagens\\Dev.png");
	private ImageIcon Fundo = new ImageIcon("dados&Imagens\\\\Fundo.png");
	
	public Grade(SistemaJava sistema) {
		
		this.sistemaJava = sistema;
		
		setLayout(new GridLayout(15,15));
		Criargrade(sistema.listadePlaneta);	
		
//		girar(sistema.listadePlaneta);
		
	}
	
	public void Criargrade(ArrayList<Planeta> listadePlaneta) {		
		
		int id = 0;

		for (int i = 0; i < 15; i++) {			
			for (int j = 0; j < 15; j++) {				
				if(i!=7 || j!=7) {
					celulaPanel = new CelulaPanel(i, j, id, Fundo); 
					celulaPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//					String numeroString = i +", "+ j ;
//					celulaPanel.add(new JLabel(numeroString)); 
					add(celulaPanel);
					celulasdoPlano.add(celulaPanel);
					id++;
					
				}else {
					celulaPanel = new CelulaPanel(j, i, id, Java); 
					celulaPanel.setBorder(BorderFactory.createLineBorder(Color.red)); 
					celulaPanel.setBackground(new Color(255, 150, 150));
					celulasdoPlano.add(celulaPanel);
					add(celulaPanel, Color.red);
					id++;
					
				}
			}
		}
		
		girar(listadePlaneta);
	
	}
	
	public void resetarPlano(ArrayList<Planeta> listadePlaneta) {
		for (CelulaPanel celula  : celulasdoPlano) {
			this.remove(celula);
		}
		
		celulasdoPlano.removeAll(celulasdoPlano);
		
		Criargrade(listadePlaneta);
		setarBugs(listadePlaneta);
		setarDevs(listadePlaneta);
	}	
	
	public void setarBugs(ArrayList<Planeta> listadePlaneta){
		int id=0;
		for (Celula celula : sistemaJava.plano.listaCel) {
			if(celula.bug == true) {
//				System.out.println("kaique" + id);
				Setarimagem(id, Bug);
			}
			id++;
		}
	}
	

	public void setarDevs(ArrayList<Planeta> listadePlaneta){
		int id=0;
		for (Celula celula : sistemaJava.plano.listaCel) {
			if(celula.desenvolvedor == true) {
//				System.out.println("kaique" + id);
				Setarimagem(id, Dev);
			}
			id++;
		}
	}
	
	public void girar(ArrayList<Planeta> listadePlaneta) {
		for (Planeta planeta : listadePlaneta) {
			moverPlanetas(planeta);	
		}
	}

	public void moverPlanetas(Planeta planeta) {
		int id = 0;
		for (CelulaPanel CelulaPanel: celulasdoPlano) {			
			if(CelulaPanel.x == planeta.getx() && CelulaPanel.y == planeta.gety()) {
				
				if(planeta.nome == "Phyton") {	
					//Setarimagem(97, Fundo);
					Setarimagem(id, phyton);
				}
				else if(planeta.nome == "JavaScript"){
				//	Setarimagem(82, Fundo);
					Setarimagem(id, JavaScript);
				}
				else if(planeta.nome == "Ruby on Rails"){
//					Setarimagem(67, Fundo);
					Setarimagem(id, Ruby);
				}
				else if(planeta.nome == "PHP"){
//					Setarimagem(52, Fundo);
					Setarimagem(id, Php);
				}
				else if(planeta.nome == "C#"){
//					Setarimagem(37, Fundo);
					Setarimagem(id, CSharp);
				}
				else if(planeta.nome == "C++"){
//					Setarimagem(22, Fundo);
					Setarimagem(id, Cmaismais);
				}
				else if(planeta.nome == "C"){
//					Setarimagem(7, Fundo);
					Setarimagem(id, C);
				}
			
			}else {
				Setarimagem(CelulaPanel.id, Fundo);
				
			}
			Setarimagem(CelulaPanel.id, Fundo);
			id++;
		}
	}
	
	public void Setarimagem(int id, ImageIcon img) {
		CelulaPanel celulaNewIMG = celulasdoPlano.get(id);
		celulaNewIMG.setImage(img);
		celulaNewIMG.revalidate();
		celulaNewIMG.repaint();
	}
	
	
	
}
