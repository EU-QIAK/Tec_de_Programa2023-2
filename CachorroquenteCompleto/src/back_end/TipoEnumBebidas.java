package back_end;

public enum TipoEnumBebidas {
	
	SEMBEBIDA("Sem bebida"),
	COCACOLA("Coca-cola"),
	DELRIO("Del Rio"),
	SUCODOCHAVES("Suco do Chaves");
	
	public String codigo;
	
	TipoEnumBebidas(String cod) {
		this.codigo = cod;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public static TipoEnumBebidas chamarporcodigo (String codigo) {
		
		for (TipoEnumBebidas Bebidas : TipoEnumBebidas.values()) {
			if(Bebidas.getCodigo().equalsIgnoreCase(codigo)) {				
				return Bebidas;
			}
		}
		
		return null;
	}
	
}
