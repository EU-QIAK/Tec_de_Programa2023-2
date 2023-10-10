package Sistema_Javalar;

public class Celula {
	
	protected int x;
	protected int y;
	protected int id;
	protected boolean bug;
	protected boolean desenvolvedor;
	protected Planeta planeta;
	
	//construtor
	public Celula(int y, int x, int id) {
		this.x = x;
		this.y = y;
		this.id=id;
		this.bug=false;
		this.desenvolvedor=false;
	}

}
