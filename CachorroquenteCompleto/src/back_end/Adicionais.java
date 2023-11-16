package back_end;

public class Adicionais {

	private boolean maionese;
	private boolean ketchup;
	private boolean ovo;
	private boolean batata;
	
	public Adicionais(){
		this.setMaionese(false);
		this.setKetchup(false);
		this.setOvo(false);
		this.setBatata(false);
	}

	public static Adicionais CriarAdicional() {
		
		Adicionais adicional = new Adicionais();
		adicional.setMaionese(false);
		adicional.setKetchup(false);
		adicional.setOvo(false);
		adicional.setBatata(false);
				
		return adicional;
	}
	
	public boolean isMaionese() {
		return maionese;
	}

	public void setMaionese(boolean maionese) {
		this.maionese = maionese;
	}

	public boolean isKetchup() {
		return ketchup;
	}

	public void setKetchup(boolean ketchup) {
		this.ketchup = ketchup;
	}

	public boolean isOvo() {
		return ovo;
	}

	public void setOvo(boolean ovo) {
		this.ovo = ovo;
	}

	public boolean isBatata() {
		return batata;
	}

	public void setBatata(boolean batata) {
		this.batata = batata;
	}
	
}
