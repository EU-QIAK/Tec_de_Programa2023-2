package controle;

import java.util.ArrayList;

public abstract class CachorroQuente {

	protected TipoEnumQueijo queijo;
	protected TipoEnumBebidas bebida;
	protected ArrayList<String> ingredientes;
	protected String nome;
	protected Adicionais adicionais;

	
	public CachorroQuente(String nome , TipoEnumQueijo queijo, TipoEnumBebidas bebida, Adicionais adicionais) {
		this.nome = nome;
		this.queijo = queijo;		
		this.bebida = bebida;
		this.adicionais = adicionais;

	}

}
