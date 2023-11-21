package controle;

public class JavaScript extends Planeta {

	public JavaScript(int x, int y, String nome, controle.Plano plano) {
		super(x, y, nome, plano);
	
		this.nome= "JavaScript";
		
		//condições de limites
		this.direita = 9;
		this.esquerda = 5;
		this.superior = 9;
		this.inferior = 5;
		this.mov = 3;
		
		//condições para a marcação de tempo
		this.quantMaxAno = 16;
		this.horasDias = 10;
		this.quantParaDias = 10;
	
	}
}
