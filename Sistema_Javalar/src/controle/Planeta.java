package controle;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Planeta implements Astroquemove {
	
	private int x;
	private int y;
	protected Plano plano;
	protected ArrayList<Integer> id;
	protected ImageIcon image;
	
	//movimentação e nomenclatuta
	public String nome;
	protected int direita;
	protected int esquerda;
	protected int superior;
	protected int inferior;
	protected int mov;
	
	//marcação
	protected int quantMaxAno;
	protected double horasDias;
	protected double quantParaDias;
	
	//construtor
	public Planeta(int x, int y, String nome, Plano plano) {
		this.x = x;
		this.y = y;
		this.nome = nome;
		this.plano = plano;
	}
	
	public int getx() {
        return x;
    }
    
    public int gety() {
        return y;
    }

	
	//movimenta os plaetas e conta os horas, dias e anos
	public void movimentarContar(int tempo) {
		
		System.out.println("\nPlaneta " + nome + ": ");
		
		//contando os anos
		int posiandadas= 0;
		int anos = 0;
		
		//contando as horas e dias
		double horas = tempo * horasDias;
		double dias = horas/quantParaDias;
		
		//movimentandp os planetas
		int auxilio = 0;
		
		//condição pro andar do planeta
		if(mov>0){
			auxilio = mov * tempo;
		
			
		for (int i = 0; i < auxilio; i++) {
			if(x < direita && y == inferior) {
					x++;
					posiandadas++;
			}else {
				if(x > esquerda && y == superior) {
					x--;
					posiandadas++;
				}else {
					if(x == direita && y<superior) {
						y++;
						posiandadas++;
					}else {
						if(x == esquerda && y > inferior) {
							y--;
							posiandadas++;
						}
					}
				}
			}
			
			//contando anos
			if(posiandadas==quantMaxAno){
				anos++;
				posiandadas=0;
			}
		}
		
		double movimento = (auxilio/tempo); 
		
		System.out.println("-após " + tempo + " unidades de tempo, o planeta " + nome + " está na Posição (y, x): ("+ y  + "," + x + ")");
		System.out.println("-Anos andados: " + anos);
		System.out.println("-Horas: " + horas);
		System.out.println("-dias: " + dias);
		System.out.println("-velocidade dos movimentos do " + nome + " está em: " + movimento);
		
		}else {
			System.out.println("O planeta " + nome + "... KABOOM!!(explosão)," + " local da explosão: (" + y +", "+ x + ")");		
		}
	}

}
