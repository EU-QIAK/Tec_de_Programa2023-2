package controle;

public class Php extends Planeta{

	public Php(int x, int y, String nome, controle.Plano plano) {
		super(x, y, nome, plano);
		
		this.nome= "PHP";
		
		//condições de limites
		this.direita = 11;
		this.esquerda = 3;
		this.superior = 11;
		this.inferior = 3;
		this.mov = 2;
		
		//condições para a marcação de tempo
		this.quantMaxAno = 32;
		this.horasDias = 60;
		this.quantParaDias = 60;
		
	}

}
