package controle;

public class Cmaismais extends Planeta{

	public Cmaismais(int x, int y, String nome, controle.Plano plano) {
		super(x, y, nome, plano);
	
		this.nome= "C++";
		
		//condições de limites
		this.direita = 13;
		this.esquerda = 1;
		this.superior = 13;
		this.inferior = 1;
		this.mov = 2;
		
		//condições para a marcação de tempo
		this.quantMaxAno = 48;
		this.horasDias = 0.5;
		this.quantParaDias = 0.5;
	}

}
