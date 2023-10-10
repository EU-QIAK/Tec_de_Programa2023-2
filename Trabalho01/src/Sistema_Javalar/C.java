package Sistema_Javalar;

public class C extends Planeta{

	public C(int x, int y, String nome, Sistema_Javalar.Plano plano) {
		super(x, y, nome, plano);
	
		this.nome= "C";
		
		//condições de limites
		this.direita = 14;
		this.esquerda = 0;
		this.superior = 14;
		this.inferior = 0;
		this.mov = 10;
		
		//condições para a marcação de tempo
		this.quantMaxAno = 56;
		this.horasDias = 0.1;
		this.quantParaDias = 0.1;
	}
}
