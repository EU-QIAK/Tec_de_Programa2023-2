package controle;

import java.util.ArrayList;
import java.util.Scanner;

import persistencia.CachorroQuenteDAO;
import persistencia.LerDados;
import persistencia.escreverDados;

public class Barraquina {
	
	public ArrayList<Aluno> alunos;
	public ArrayList<String> dados;	
	private Adicionais adicionais;
	private String Cachorros = "";
	private String Cachorrosdados = "";
	private String aluno = "";
	private String alunodados = "";
	
	public Barraquina() {
		alunos = new ArrayList<Aluno>();
	}

	//funcionando hurrull
	public Aluno criarAluno(String aluno, int matricula) {
		Aluno comprador;
		comprador = new Aluno(aluno, matricula);
		alunos.add(comprador);
		
		escreverDados dadosAluno = new escreverDados();

		//guardar tudo em uma String pra salvar no arquivo
		aluno = comprador.getNome() + ";" + comprador.getMatricula() + ";\n";
		dadosAluno.escreverDados("dados\\Alunos", aluno);
		
		//mostrar no CMD
//		System.out.println("-ALUNO");
//		System.out.println("Nome do aluno: " + comprador.getNome());
//		System.out.println("Matricula do aluno: " + comprador.getMatricula());
		
		
		return comprador;
	}
	
	//funcinando hurrull
	public CachorroQuente escolherCachorroQuente(String tipo, String tipoQueijo, String bebida, Adicionais adicionais) {
		
		escreverDados dadosdoCachorro = new escreverDados();		
		
		TipoEnumQueijo tipodeQueijo = TipoEnumQueijo.chamarporcodigo(tipoQueijo);
		TipoEnumBebidas tipoBebida = TipoEnumBebidas.chamarporcodigo(bebida);
		this.adicionais = adicionais;
		
		CachorroQuente Cachorro = null;
		switch (tipo) {
		case"sem proteina":
			Cachorro = new Semproteina(tipo, tipodeQueijo, tipoBebida, adicionais);
			break;
		case "salsicha":
			Cachorro = new Salsicha(tipo, tipodeQueijo, tipoBebida, adicionais);
			break;
		case "linguiça":
			Cachorro = new Linguica(tipo, tipodeQueijo, tipoBebida, adicionais);
			break;
		case "frango":
			Cachorro = new Frango(tipo, tipodeQueijo, tipoBebida, adicionais);
			break;
		case "bacon":
			Cachorro = new Bacon(tipo, tipodeQueijo, tipoBebida, adicionais);
			break;
		default:
			break;
		}

		String ingredientes =  adicionais(Cachorro);
		
		Cachorros = Cachorro.nome + ";" + Cachorro.queijo.codigo + ";" + ingredientes + ";"+ Cachorro.bebida.codigo +";15,00;\n"; 
		dadosdoCachorro.escreverDados("dados\\Cachorros", Cachorros);		
		
		//numeros pra testar o banco (se eu tivesse tempo eu faria melhor usando os dados reais do sistema).
		Cachorrosdados = "Kaique," + "542062," + "4," + "1," + ingredientes + "," + "1," + "15,00"; 
		dados = new ArrayList<String>();
		dados.add(Cachorrosdados);

		try {
			CachorroQuenteDAO c = new CachorroQuenteDAO();
			c.cachorroQuenteDAO(dados);			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//mostrar no CMD
//		System.out.println("\n-CACHORRO QUENTE");
//		System.out.println("Proteina: " + Cachorro.nome);
//		System.out.println("Queijo: " + Cachorro.queijo.codigo);
//		System.out.println("\nAdicionais:");
//		System.out.println("\nBebida: " + Cachorro.bebida.codigo + "\nUM CACHORRO VENDIDO!");
		
		return null;
	}

	public String adicionais(CachorroQuente cachorroQuente) {
		
		String ingredientes = "";
		String maionese = "Maionese";
		String ketchup = "-Ketchup";
		String ovo = "-Ovo";
		String batata = "-Batata";
		
		if(cachorroQuente.adicionais.isMaionese()) {
			ingredientes += maionese;
		}
		if(cachorroQuente.adicionais.isKetchup()) {
			ingredientes += ketchup;
		}
		if(cachorroQuente.adicionais.isOvo()) {
			ingredientes += ovo;
		}
		if(cachorroQuente.adicionais.isBatata()) {
			ingredientes += batata;
		}
		
		return ingredientes;
	}
}