package negocio;

public class Ruby extends Planeta {

	public Ruby(int x, int y, String nome, negocio.Plano plano) {
		super(x, y, nome, plano);

		this.nome= "Ruby on Rails";
		
		//condições de limites
		this.direita = 10;
		this.esquerda = 4;
		this.superior = 10;
		this.inferior = 4;
		this.mov = 2;
		
		//condições para a marcação de tempo
		this.quantMaxAno = 24;
		this.horasDias = 48;
		this.quantParaDias = 48;
		this.bateuBug = 0;
		this.bateuDev = 0;
		this.anos = 0;
	
	}
}
