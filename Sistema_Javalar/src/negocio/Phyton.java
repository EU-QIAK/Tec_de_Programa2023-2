package negocio;

public class Phyton extends Planeta{
	
	public Phyton(int x, int y, String nome, Plano plano) {
		super(x, y, nome, plano);
		
		this.nome= "Phyton";
		
		//condições de limites
		this.direita = 8;
		this.esquerda = 6;
		this.superior = 8;
		this.inferior = 6;
		this.mov = 4;
		
		//condições para a marcação de tempo
		this.quantMaxAno = 8;
		this.horasDias = 24;
		this.quantParaDias = 24;
		this.bateuBug = 0;
		this.bateuDev = 0;
		this.anos = 0;

	}
	
}
