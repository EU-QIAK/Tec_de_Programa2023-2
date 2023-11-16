package back_end;

public enum TipoEnumQueijo {

	SEMQUEIJO("sem queijo"),
	MUSSARELA("mussarela"),
	PRATO("prato"),
	PARMESÃO("parmesão"),
	COALHO("coalho");
	
	public String codigo;

	TipoEnumQueijo(String cod) {
		this.codigo = cod;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public static TipoEnumQueijo chamarporcodigo (String codigo) {
		
		for (TipoEnumQueijo queijo : TipoEnumQueijo.values()) {
			if(queijo.getCodigo().equalsIgnoreCase(codigo)) {				
				return queijo;
			}
		}
		
		return null;
	}
}
