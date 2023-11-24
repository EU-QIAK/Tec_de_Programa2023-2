package controle;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import persistencia.EscreverDados;
import persistencia.LerDados;

public class SistemaJava {
	
	private ArrayList<Planeta>listadePlaneta = new ArrayList<Planeta>();
	private ArrayList<String> dados = new ArrayList<String>();
	private ArrayList<String> armazenarLinhas = new ArrayList<String>();
	private int indice = 0;
	private Plano plano = new Plano(15, 15);
	private LerDados lerDados;
	
	public SistemaJava() {
		listadePlaneta = new ArrayList<Planeta>();
		lerDados = new LerDados();
		
		Phyton phyton = new Phyton(6, 7, "phyton" , plano);
		JavaScript javaCript = new JavaScript(5, 7, "JavaScript", plano);
		Ruby Ruby = new Ruby(4, 7, "Ruby", plano);
		Php php = new Php(3, 7, "Php", plano);
		Csharp Csharp = new Csharp(2, 7, "C#", plano);
		Cmaismais Cmaismais = new Cmaismais(1,7, "C++", plano);
		C c = new C(0, 7, "C", plano);
		listadePlaneta.add(phyton); /*0*/
		listadePlaneta.add(javaCript); /*1*/
		listadePlaneta.add(Ruby); /*2*/
		listadePlaneta.add(php); /*3*/
		listadePlaneta.add(Csharp); /*4*/
		listadePlaneta.add(Cmaismais); /*5*/
		listadePlaneta.add(c); /*6*/
	}
	
	public void digitarBugs(int bugs) {
		try {
			for (int i = 0; i < 1; i++) {
//				System.out.println("\nDigite o numero de bugs pra essa rodada(eles serão somados com os da rodada anterior): ");
//				Scanner scam = new Scanner(System.in);
				
				int quantBug = bugs;
				
				int quantMaxBugs = 0;

				if(quantMaxBugs < 112 && quantBug< 112) {
					if(quantBug>-1) {
						plano.sortearbug(quantBug);	
					}else {
						System.err.println("\nentrada invalida!!");
						i--;
					}
				}else {
					System.out.println("ultrapassou a qunatidade de Bugs");
				}
				
				for (Celula celula : plano.listaCel) {
					if(celula.bug==false) {
						quantMaxBugs++;
					}
				}
				
//				double restante = quantMaxBugs-(quantMaxBugs/2);
//				System.out.println("ainda restam: " + restante + " Bugs pra ser sorteado\n");
				
			}
		}catch (java.util.InputMismatchException e) {
			System.err.println("\nentrada invalida!!");
			digitarBugs(bugs);
		}
	}
	
	public void digitarDevs(int devs) {
		try {
			for (int i = 0; i < 1; i++) {
//				System.out.println("Digite o numero de desenvolvedores no plano(eles serão somados com os da rodada anterior): ");
//				Scanner scam2 = new Scanner(System.in);
				int quantDev = devs;
				
				int quantMaxDevs = 0;

				if(quantMaxDevs < 112 && quantDev < 112) {
					if(quantDev>-1) {
						plano.sorteardesenvolvedor(quantDev);	
					}else {
						System.err.println("\nentrada invalida!!");
						i--;
					}
				}else {
					System.out.println("ultrapassou a qunatidade de devs");
				}
				
				for (Celula celula : plano.listaCel) {
					if(celula.desenvolvedor==false) {
						quantMaxDevs++;
					}
				}
				
//				double restante = quantMaxDevs-(quantMaxDevs/2);
//				System.out.println("ainda restam: " + restante + " Devs pra ser sorteado\n");
				
			}
		}catch(java.util.InputMismatchException e) {
			System.err.println("\nentrada invalida!!");
			digitarDevs(devs);
		}
	}
	
	public int continuar() {
		int resposta = 0;
		
		try {			
			for (int j = 0; j < 1; j++) {		
				System.out.println("\nopção 01 - digite 1 se SIM. \nopção 02 - digite 2 se NÃO. \n\nDeseja ir mais uma rodada do sistema JAVALAR?:");
				Scanner scam4 = new Scanner(System.in);
				int casos2 = scam4.nextInt();
				
				if(casos2==1 || casos2==2) {
					switch(casos2) {
					case 1:
						resposta = -1;
					case 2:
						continue;
					}
				}else {	
					System.err.println("\nessa opção não existe, tente outra vez!!");
					j--;
				}
			}
		}catch(java.util.InputMismatchException e) {
			System.err.println("\nessa opção não existe, tente outra vez!!");
			resposta=continuar();
		}
		return resposta;		
	}
	
	public void posicao(ArrayList<Planeta>planetas) {
		
		System.out.println("\nLocalização dos planetas: ");
		
		for (Planeta planeta : planetas) {
			if(planeta.getx()>7) {
				System.out.println("o planeta " + planeta.nome + " esta no NORTE");
			}else {
				System.out.println("o planeta " + planeta.nome + " esta no SUL");
			}
		
		}
	
	}
	
	//vou tentar fazer o medoto receber um arquivo com as informações para serem distrubuidas pras funções necessarias 
	public void menudosistema(File file) throws FileNotFoundException, IOException {
		String a1 = "";
		a1 = file.getAbsolutePath();
		try {
			for (String linhas : lerDados.lerDados(a1)) {
					armazenarLinhas.add(linhas);
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void rodada(String linha){
		ArrayList<Integer> numerosDaRodada = new ArrayList<Integer>();
		
		for (String numeros : lerDados.SeparDadosDoRelatorio(linha)) {
			int n = Integer.parseInt(numeros);
			numerosDaRodada.add(n);
			dados.add(numeros);
			System.out.println(""+ numeros);
		}
			
		//inicio
		System.out.println("BEM VINDO AO SISTEMA JAVALAR!!\n");
		System.out.println("Este sistema é uma simulação de um sistema solar, com o java no lugar do sol e linguagens de programação no lugar dos planetas.\nEspero que se divirta!!");
		
		//rodadas javalar	
		digitarBugs(numerosDaRodada.get(9));
		digitarDevs(numerosDaRodada.get(8));
			
		System.out.println("\nRELATORIO DA ROTAÇÃO DOS PLANETAS:");
		
		listadePlaneta.get(0).movimentarContar(numerosDaRodada.get(1));
		listadePlaneta.get(1).movimentarContar(numerosDaRodada.get(2));
		listadePlaneta.get(2).movimentarContar(numerosDaRodada.get(3));
		listadePlaneta.get(3).movimentarContar(numerosDaRodada.get(4));
		listadePlaneta.get(4).movimentarContar(numerosDaRodada.get(5));
		listadePlaneta.get(5).movimentarContar(numerosDaRodada.get(6));
		listadePlaneta.get(6).movimentarContar(numerosDaRodada.get(7));
		
		System.out.println("\nInformações de colisão:");
		for (Planeta planeta : listadePlaneta) {
			plano.bateunobug(plano, planeta);
		}			
		for (Planeta planeta : listadePlaneta) {
			plano.bateunodesenv(plano, planeta);
		}
		
		posicao(listadePlaneta);
		
	}
	
	public void proximaLinhas(){
		if(armazenarLinhas.size() > indice) {
			String linhaAtual = armazenarLinhas.get(indice);
			rodada(linhaAtual);
			indice++;
		}else {
			System.err.println("acabaram as linhas");
		}
	}
	
	public ArrayList<Planeta> getListaDePlaneta() {
		
		return listadePlaneta;
	}
	
	public Plano getplano(){
		return plano;
	}
}

//int rodadas = 1;
//for (int i = 0; i < rodadas; i++) {
//	digitarBugs(0);
//	digitarDevs(0);
//	
//	int instantes = 0;
//	int a = 1;
//			
//	for (int j = 0; j < a; j++) {	
//		try {
//			while(instantes<=0) {
//			System.out.println("Digite o numero de instantes: ");
//			Scanner scam3 = new Scanner(System.in);
//			
//			instantes = scam3.nextInt();
//			
//			if(instantes<=0) {
//				System.err.println("instantes que são menores ou iguais a 0 são invalidos, tente outra vez!");
//			}
//			
//			}
//		}catch(java.util.InputMismatchException e){
//			System.err.println("instante invalido, os numeros devem ser inteiros positivos!");
//			a++;
//		}
//		
//	}
//	
//	System.out.println("\nRELATORIO DA ROTAÇÃO DOS PLANETAS:");
//	
//	//execução dos metodos.		
//	for (Planeta planeta : listadePlaneta) {
//		planeta.movimentarContar(instantes);
//	}
//	System.out.println("\nInformações de colisão:");
//	for (Planeta planeta : listadePlaneta) {
//		plano.bateunobug(plano, planeta);
//	}			
//	for (Planeta planeta : listadePlaneta) {
//		plano.bateunodesenv(plano, planeta);
//	}
//	
//	posicao(listadePlaneta);
//				
//}
//
//System.err.println("\nClique no botão 'processar proximo instantes' para a proxima jogada.");
//
//}

//nota do fim do sistema javalar
//		System.out.println("\n\nOBRIGADO POR UTILIZAR O SITEMA JAVALAR!!\n");
//		System.out.println("fique agora com um resumo de cada linguagem usado pra representar os planetas e o sol:\n");
//		System.out.println("-JAVA:é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na \nempresa Sun Microsystems, que em 2008 foi adquirido pela empresa Oracle Corporation.\n");
//		System.out.println("-PHYTON:é uma linguagem de programação de alto nível, interpretada de script, imperativa, orientada a objetos, funcional, de tipagem dinâmica e forte. \nFoi lançada por Guido van Rossum em 1991.\n");
//		System.out.println("-JAVASCRIPT:é uma linguagem de programação interpretada estruturada, de script em alto nível com tipagem dinâmica fraca e multiparadigma. Juntamente \ncom HTML e CSS, o JavaScript é uma das três principais tecnologias da World Wide Web.\n");
//		System.out.println("-RUBY ON RAILS:é uma linguagem de programação interpretada multiparadigma, de tipagem dinâmica e forte, com gerenciamento de memória automático, \noriginalmente planejada e desenvolvida no Japão em 1995, por Yukihiro \"Matz\" Matsumoto, para ser usada como linguagem de script.\n");
//		System.out.println("-PHP:é uma linguagem interpretada livre, usada originalmente apenas para o desenvolvimento de aplicações presentes e atuantes no lado do servidor, \ncapazes de gerar conteúdo dinâmico na World Wide Web.\n");
//		System.out.println("-C#:é uma linguagem de programação, multiparadigma, de tipagem forte, desenvolvida pela Microsoft como parte da plataforma .NET. A sua sintaxe \norientada a objetos foi baseada no C++ mas inclui muitas influências de outras linguagens de programação, como Object Pascal e, principalmente, Java. \n");
//		System.out.println("-C++:é uma linguagem de programação compilada multi-paradigma e de uso geral. Desde os anos 1990 é uma das linguagens comerciais mais populares, \nsendo bastante usada também na academia por seu grande desempenho e base de utilizadores.\n");
//		System.out.println("-C:é uma linguagem de programação compilada de propósito geral, estruturada, imperativa, procedural, padronizada pela Organização Internacional \npara Padronização, criada em 1972 por Dennis Ritchie na empresa AT&T Bell Labs para desenvolvimento do sistema operacional Unix.\n");
//		System.out.println("NOTA:todos os dados desse resumo foram tirados da wikipédia.");
