package controle;

public abstract class clientes {

	private String nome;
	private int identificacao;
	
	public void cliente (String nome, int identificacao) {
		this.nome = nome;
		this.identificacao = identificacao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}
	
	
}
