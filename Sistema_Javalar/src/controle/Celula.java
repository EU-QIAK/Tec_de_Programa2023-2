package controle;

public class Celula {
	
	protected int x;
	protected int y;
	protected int id;
	public boolean bug;
	public boolean desenvolvedor;
	public Planeta planeta;
	
	//construtor
	public Celula(int y, int x, int id) {
		this.x = x;
		this.y = y;
		this.id=id;
		this.bug=false;
		this.desenvolvedor=false;
	}

}
