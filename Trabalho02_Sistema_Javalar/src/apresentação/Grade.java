package apresentação;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import negocio.Celula;
import negocio.Planeta;
import negocio.Plano;
import negocio.SistemaJavalar;

public class Grade extends JPanel {

	public ArrayList<CelulaPanel> celulasdoPlano = new ArrayList<CelulaPanel>();
	private CelulaPanel celulaPanel;
	private Plano plano;
	private SistemaJavalar sistemaJava;

	private ImageIcon Java = new ImageIcon("dados&Imagens\\imagens\\Java.png");
	private ImageIcon phyton = new ImageIcon("dados&Imagens\\imagens\\Phyton.png");
	private ImageIcon JavaScript = new ImageIcon("dados&Imagens\\imagens\\JavaScript.png");
	private ImageIcon Ruby = new ImageIcon("dados&Imagens\\imagens\\Ruby.png");
	private ImageIcon Php = new ImageIcon("dados&Imagens\\imagens\\Php.png");
	private ImageIcon CSharp = new ImageIcon("dados&Imagens\\imagens\\C#.png");
	private ImageIcon Cmaismais = new ImageIcon("dados&Imagens\\imagens\\C++.png");
	private ImageIcon C = new ImageIcon("dados&Imagens\\imagens\\C.png");
	private ImageIcon Bug = new ImageIcon("dados&Imagens\\imagens\\Bug.png");
	private ImageIcon Dev = new ImageIcon("dados&Imagens\\imagens\\Dev.png");
	private ImageIcon Fundo = new ImageIcon("dados&Imagens\\imagens\\Fundo.png");
	
	private ImageIcon phytonMorto = new ImageIcon("dados&Imagens\\imagens\\PhytonMorto.png");
	private ImageIcon JavaScriptMorto = new ImageIcon("dados&Imagens\\imagens\\JavaScriptMorto.png");
	private ImageIcon RubyMorto = new ImageIcon("dados&Imagens\\imagens\\RubyMorto.png");
	private ImageIcon PhpMorto = new ImageIcon("dados&Imagens\\imagens\\PhpMorto.png");
	private ImageIcon CSharpMorto = new ImageIcon("dados&Imagens\\imagens\\C#Morto.png");
	private ImageIcon CmaismaisMorto = new ImageIcon("dados&Imagens\\imagens\\C++Morto.png");
	private ImageIcon CMorto = new ImageIcon("dados&Imagens\\imagens\\CMorto.png");
	
	public Grade(SistemaJavalar sistema) {
		
		this.sistemaJava = sistema;
		
		setLayout(new GridLayout(15,15));
		Criargrade(sistema);	
			
	}
	
	public void Criargrade(SistemaJavalar java) {		
		
		int id = 0;

		for (int i = 0; i < 15; i++) {			
			for (int j = 0; j < 15; j++) {				
				if(i!=7 || j!=7) {
					celulaPanel = new CelulaPanel(i, j, id, Fundo); 
					celulaPanel.setBorder(BorderFactory.createLineBorder(new Color(100, 200, 152)));
//					String numeroString = j +", "+ i ;
//					celulaPanel.add(new JLabel(numeroString));
//					String numeroString = id + "";
//					celulaPanel.add(new JLabel(numeroString)); 
					add(celulaPanel);
					celulasdoPlano.add(celulaPanel);
					id++;
					
				}else {
					celulaPanel = new CelulaPanel(j, i, id, Java); 
					celulaPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW)); 
					celulaPanel.setBackground(new Color(255, 150, 150));
					celulasdoPlano.add(celulaPanel);
					add(celulaPanel, Color.red);
					id++;
					
				}
			}
		}
		
		girar(java);
	
	}
	
	public void resetarPlano(SistemaJavalar java) {
		for (CelulaPanel celula  : celulasdoPlano) {
			this.remove(celula);
		}
		
		celulasdoPlano.removeAll(celulasdoPlano);
		
		Criargrade(java);
		setarDevs();
		setarBugs();
	}	
	
	public void setarBugs(){
		int id=0;
		for (Celula celula : sistemaJava.getplano().listaCel) {
			if(celula.bug == true && celula.desenvolvedor == false) {
				Setarimagem(id, Bug);
			}
			id++;
		}
	}
	
	public void setarDevs(){
		int id=0;
		for (Celula celula : sistemaJava.getplano().listaCel) {
			if(celula.desenvolvedor == true && celula.bug == false) {
				Setarimagem(id, Dev);
			}
			id++;
		}
	}
	
	public void girar(SistemaJavalar java) {
		for (Planeta planeta : java.getListaDePlaneta()) {
			moverPlanetas(planeta);	
		}
	}

	public void moverPlanetas(Planeta planeta) {
		int id = 0;
		for (CelulaPanel CelulaPanel: celulasdoPlano) {			
			if(CelulaPanel.x == planeta.getx() && CelulaPanel.y == planeta.gety()) {				
				if(planeta.nome == "Phyton") {	
					if(planeta.mov!=0) {
						Setarimagem(id, phyton);
					}else if(planeta.mov==0) {
						Setarimagem(id, phytonMorto);
					}
				}
				else if(planeta.nome == "JavaScript"){
					if(planeta.mov!=0) {
						Setarimagem(id, JavaScript);
					}else if(planeta.mov==0) {
						Setarimagem(id, JavaScriptMorto);
					}
				}
				else if(planeta.nome == "Ruby on Rails"){
					if(planeta.mov!=0) {
						Setarimagem(id, Ruby);
					}else if(planeta.mov==0) {
						Setarimagem(id, RubyMorto);
					}
				}
				else if(planeta.nome == "PHP"){
					if(planeta.mov!=0) {
						Setarimagem(id, Php);
					}else if(planeta.mov==0) {
						Setarimagem(id, PhpMorto);
					}
				}
				else if(planeta.nome == "C#"){
					if(planeta.mov!=0) {
						Setarimagem(id, CSharp);
					}else if(planeta.mov==0) {
						Setarimagem(id, CSharpMorto);
					}
				}
				else if(planeta.nome == "C++"){
					if(planeta.mov!=0) {
						Setarimagem(id, Cmaismais);
					}else if(planeta.mov==0) {
						Setarimagem(id, CmaismaisMorto);
					}
				}
				else if(planeta.nome == "C"){
					if(planeta.mov!=0) {
						Setarimagem(id, C);
					}else if(planeta.mov==0) {
						Setarimagem(id, CMorto);
					}
				}
				
			}else {
				Setarimagem(CelulaPanel.id, Fundo);
			}
			id++;
		}
	}
	
	public void Setarimagem(int id, ImageIcon img) {
		CelulaPanel celulaNewImg = celulasdoPlano.get(id);
		celulaNewImg.setImage(img);
		celulaNewImg.revalidate();
		celulaNewImg.repaint();
	}
	
	
	
}
