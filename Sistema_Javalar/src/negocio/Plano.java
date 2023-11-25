package negocio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import apresentação.Grade;

public class Plano {
	
	public ArrayList<Celula>listaCel;
	protected int tamanhox;
	protected int tamanhoy;
	public int quantbug;
	public int quantdesenv;
	public Celula celula;
	private int quatidadeMaxBug = 0;
	private int quatidadeMaxDev = 0;
	
	//criandoplano
	public Plano(int tamanhox, int tamanhoy) {
		
		listaCel= new ArrayList<Celula>();
		
		this.tamanhox=tamanhox;
		this.tamanhoy=tamanhoy;
		
		int id = 0;
		
		for (int i = 0; i < tamanhox; i++) {
			for (int j = 0; j < tamanhoy; j++) {
				celula= new Celula(j, i, id);
				listaCel.add(celula);
				id++;
			}
		}
		
	}
	
	//add bugs
	public void sortearbug(int quantbug) {
		
		this.quantbug = quantbug;
		
		System.out.println("Os " + quantbug +" bugs estão nas posições: ");
		
		for (int i = 0; i < quantbug; i++) {
			if(quatidadeMaxBug < 112){
			Random random = new Random();
			int aleatorio = 0;
			int checar = 0;
			
			do {
				aleatorio = random.nextInt(225);
				checar = 0;
				
				if(listaCel.get(aleatorio).bug==false && listaCel.get(aleatorio).desenvolvedor==false && aleatorio != 112) {
					listaCel.get(aleatorio).bug=true;
					quatidadeMaxBug++;
					System.out.println(quatidadeMaxBug+"");
					checar = 1;
				}
			}while(checar==0);
			if(aleatorio==112) {
				i--;
				continue;
			}
			
			System.out.println("posição em y e x: ("+ listaCel.get(aleatorio).y + ", " + listaCel.get(aleatorio).x + ")\n");
			
		}else {
			System.out.println("\nacabou os bugs");
		}
		}
	}

	//add desenvolvedor 
	public void sorteardesenvolvedor(int quantdesenv) {
		
		this.quantdesenv = quantdesenv;

		System.out.println("Os " + quantdesenv +" desenvolvedores estão nas posições: ");
				
		for (int i = 0; i < quantdesenv; i++) {	
			if(quatidadeMaxDev < 112){
			Random random = new Random();
			int aleatorio = 0;
			int checar = 0;
			
			do {	
				checar = 0;
				aleatorio = random.nextInt(225);
				if(listaCel.get(aleatorio).desenvolvedor==false && listaCel.get(aleatorio).bug==false && aleatorio != 112) {
					listaCel.get(aleatorio).desenvolvedor=true;
					quatidadeMaxDev++;
					System.out.println(quatidadeMaxDev+"");
					checar = 1;
				}
			}while(checar==0);
			
			if(aleatorio==112) {
				i--;
				continue;
			}
		
			System.out.println("posição em y e x: ("+ listaCel.get(aleatorio).y + ", " + listaCel.get(aleatorio).x + ")\n");
		}else {
			System.out.println("\nacabou os bugs");
		}
		}
	}

	//caso pare em um bug
	public void bateunobug(Plano plano, Planeta planeta) {
		if(planeta.mov>0) {
			for (Celula celula : plano.listaCel) {
				
				if(celula.x == planeta.getx() && celula.y == planeta.gety() && celula.bug == true && celula.desenvolvedor == false ) {
					
					planeta.mov--;
					planeta.bateuBug++;
					quatidadeMaxBug--;
					
					
					celula.bug = false;
					
					System.out.println("-Movimentos de " + planeta.nome + " após colidir com um bug diminuiram pra: " + planeta.mov + " -  Y = " + planeta.gety() +", X = "+ planeta.getx() + ", ID: " + celula.id);
				}
			}
		}
	}
	
	//caso pare em um desenvolvedor 
	public void bateunodesenv(Plano plano, Planeta planeta) {
		if(planeta.mov>0) {
			for (Celula celula : plano.listaCel) {
				if(celula.x == planeta.getx() && celula.y == planeta.gety() && celula.desenvolvedor == true && celula.bug == false) {
					
					planeta.mov++;
					planeta.bateuDev++;
					quatidadeMaxBug--;
					
					celula.desenvolvedor = false;
					
					System.out.println("-Movimentos de " + planeta.nome + " após colidir com um desenvolvedor aumentaram pra: " +  planeta.mov + " -  Y = " + planeta.gety() +", X = "+ planeta.getx() + ", ID: " + celula.id);
				}
			}
		}
	}	
}

//introduzir os personagens ao plano
//	public void estarnoplano(Planeta planeta) {
//		for (Celula celula: listaCel) {
//			if(celula.x == planeta.x && celula.y == planeta.y) {
//				celula.planeta = planeta;
//			}else {
//				celula.planeta = null;
//			}
//		}
//	}