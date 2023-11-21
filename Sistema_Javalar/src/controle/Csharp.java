package controle;

public class Csharp extends Planeta{

	public Csharp(int x, int y, String nome, controle.Plano plano) {
		super(x, y, nome, plano);
		
		this.nome= "C#";
		
		//condições de limites
		this.direita = 12;
		this.esquerda = 2;
		this.superior = 12;
		this.inferior = 2;
		this.mov = 1;
		
		//condições para a marcação de tempo
		this.quantMaxAno = 40;
		this.horasDias = 4;
		this.quantParaDias = 4;
	}

}
