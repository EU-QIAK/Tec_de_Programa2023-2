package back_end;

import java.util.ArrayList;
import java.util.Scanner;

import Persistencia.LerDados;
import Persistencia.escreverDados;

public class Barraquina {
	
	private Queijo2 data = new Queijo2();
	public ArrayList<Aluno> alunos;
	public CachorroQuente cq;
	private Adicionais adicionais;
	
	public Barraquina() {
		data.listaVenda = new ArrayList<Venda>();
		alunos = new ArrayList<Aluno>();

	}

	//funcionando hurrull
	public Aluno criarAluno(String aluno, int matricula) {
		Aluno comprador;
		comprador = new Aluno(aluno, matricula);
		alunos.add(comprador);
		
		//guardar tudo em uma String pra salvar no arquivo
		String AlunoClienteDados = "";
		AlunoClienteDados = comprador.getNome() + "-" + comprador.getMatricula() + ";\n";

		escreverDados dadosAluno = new escreverDados();
		dadosAluno.escreverDados("C:\\Users\\55888\\OneDrive\\Área de Trabalho\\notas das aulas do fischer\\laboratorios\\dados\\alunos", AlunoClienteDados);
		
		//mostrar no CMD
		System.out.println("-ALUNO");
		System.out.println("Nome do aluno: " + comprador.getNome());
		System.out.println("Matricula do aluno: " + comprador.getMatricula());
		
		
		return comprador;
	}
	
	//funcinando hurrull
	public CachorroQuente escolherCachorroQuente(String tipo, String tipoQueijo, String bebida, Adicionais adicionais) {
		
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
				
		System.out.println("\n-CACHORRO QUENTE");
		System.out.println("Proteina: " + Cachorro.nome);
		System.out.println("Queijo: " + Cachorro.queijo.codigo);
		System.out.println("\nAdicionais:");
		
		if(Cachorro.adicionais.isMaionese()) {
			System.out.println("-Maionese");
		}
		if(Cachorro.adicionais.isKetchup()) {
			System.out.println("-Ketchup");
		}
		if(Cachorro.adicionais.isOvo()) {
			System.out.println("-Ovo");
		}
		if(Cachorro.adicionais.isBatata()) {
			System.out.println("-Batata");
		}
//		
		System.out.println("\nBebida: " + Cachorro.bebida.codigo + "\n");
		
		return Cachorro;
	}

}