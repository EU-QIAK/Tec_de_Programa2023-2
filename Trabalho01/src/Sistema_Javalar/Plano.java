package Sistema_Javalar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Plano {
	
	ArrayList<Celula>listaCel;
	protected int tamanhox;
	protected int tamanhoy;
	public int quantbug;
	public int quantdesenv;
	
	//criandoplano
	public Plano(int tamanhox, int tamanhoy) {
		
		this.tamanhox=tamanhox;
		this.tamanhoy=tamanhoy;
		listaCel= new ArrayList<Celula>();
		
		int id = 0;
		
		for (int i = 0; i < tamanhox; i++) {
			for (int j = 0; j < tamanhoy; j++) {
				Celula celula= new Celula(j, i, id);
				listaCel.add(celula);
				id++;
			}
		}
		
	}
	
	//introduzir os personagens ao plano
	public void estarnoplano(Planeta planeta) {
		
		for (Celula celula: listaCel) {
			if(celula.x == planeta.x && celula.y == planeta.y) {
				celula.planeta = planeta;
			}else {
				celula.planeta = null;
			}
		}
	
	}
	
	//add bugs
	public void sortearbug(int quantbug) {
			
		this.quantbug = quantbug;
		
		System.out.println("Os " + quantbug +" bugs estão nas posições: ");
		
		for (int i = 0; i < quantbug; i++) {
		
			Random random = new Random();
			
			int aleatorio = 0;
			int checar =0;
			
			do {
				checar =0;
				aleatorio = random.nextInt(224);
				
				if(listaCel.get(aleatorio).bug==false) {
					listaCel.get(aleatorio).bug=true;
					checar = 1;
				}
			}while(checar==0);
			
			if(aleatorio==112) {
				i--;
				continue;
			}
			
		System.out.println("posição em y e x: ("+ listaCel.get(aleatorio).y + ", " + listaCel.get(aleatorio).x + ")");
		
		}
		System.out.println("");
	}

	//add desenvolvedor 
	public void sorteardesenvolvedor(int quantdesenv) {
		
		this.quantdesenv = quantdesenv;
		
		System.out.println("Os " + quantdesenv +" desenvolvedores estão nas posições: ");
				
		for (int i = 0; i < quantdesenv; i++) {
			
			Random random = new Random();
			
			int aleatorio = 0;
			int checar =0;
			
			do {
				
				checar =0;
				aleatorio = random.nextInt(224);
				
				if(listaCel.get(aleatorio).desenvolvedor==false) {
					listaCel.get(aleatorio).desenvolvedor=true;
					checar = 1;
				}
			}while(checar==0);
			
			if(aleatorio==112) {
				i--;
				continue;
			}
		
			System.out.println("posição em y e x: ("+ listaCel.get(aleatorio).y + ", " + listaCel.get(aleatorio).x + ")");
		
		}
		System.out.println("");
		}

	//caso pare em um bug
	public void bateunobug(Plano plano, Planeta planeta) {
		if(planeta.mov>0) {
			for (Celula celula : plano.listaCel) {
				if(celula.x == planeta.x && celula.y == planeta.y && celula.bug == true) {
					
					planeta.mov--;
					
					celula.bug = false;
					
					System.out.println("-Movimentos de " + planeta.nome + " após colidir com um bug diminuiram pra: " + planeta.mov);
				}
			}
		}
	}
	
	//caso pare em um desenvolvedor 
	public void bateunodesenv(Plano plano, Planeta planeta) {
		if(planeta.mov>0) {
			for (Celula celula : plano.listaCel) {
				if(celula.x == planeta.x && celula.y == planeta.y && celula.desenvolvedor == true) {
					
					planeta.mov++;
					
					celula.desenvolvedor = false;
					
					System.out.println("-Movimentos de " + planeta.nome + " após colidir com um desenvolvedor aumentaram pra: " + planeta.mov);
				}
			}
		}
	}	
}


