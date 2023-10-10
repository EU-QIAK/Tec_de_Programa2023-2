package Sistema_Javalar;


import java.util.ArrayList;
import java.util.Scanner;

public class SistemaJava {
	
	ArrayList<Planeta>listadePlaneta;
	
	Plano plano =new Plano(15, 15);
	
	public void digitarBugs() {
		try {
			for (int i = 0; i < 1; i++) {
				System.out.println("\nDigite o numero de bugs pra essa rodada(eles serão somados com os da rodada anterior): ");
				Scanner scam = new Scanner(System.in);
				int quantBug = scam.nextInt();
				
				if(quantBug>-1) {
					plano.sortearbug(quantBug);
				}else {
					System.err.println("\nentrada invalida!!");
					i--;
				}	
			}
		}catch (java.util.InputMismatchException e) {
			System.err.println("\nentrada invalida!!");
			digitarBugs();
		}
	}
	
	public void digitarDevs() {
		try {
			for (int i = 0; i < 1; i++) {
				System.out.println("Digite o numero de desenvolvedores no plano(eles serão somados com os da rodada anterior): ");
				Scanner scam2 = new Scanner(System.in);
				int quantDevs = scam2.nextInt();
				
				if(quantDevs>-1) {
				plano.sorteardesenvolvedor(quantDevs);	
				}else {
					System.err.println("\nentrada invalida!!");
					i--;
				}
			}
		}catch(java.util.InputMismatchException e) {
			System.err.println("\nentrada invalida!!");
			digitarDevs();
		}
	}
	
	public int continuar () {
		
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
			if(planeta.x>7) {
				System.out.println("o planeta " + planeta.nome + " esta no NORTE");
			}else {
				System.out.println("o planeta " + planeta.nome + " esta no SUL");
			}
		
	}
	
}
	
	public void menudosistema() {
		
		//criando o que é necessario
		Scanner scam = new Scanner(System.in);
		
		//arraylist de planetas
		listadePlaneta = new ArrayList<Planeta>();
		
		Phyton phyton = new Phyton(7, 8, "phyton" , plano);
		listadePlaneta.add(phyton);
		JavaScript javaCript = new JavaScript(7, 9, "JavaScript", plano);
		listadePlaneta.add(javaCript);
		Ruby Ruby = new Ruby(7, 10, "Ruby", plano);
		listadePlaneta.add(Ruby);
		Php php = new Php(7, 11, "Php", plano);
		listadePlaneta.add(php);
		Csharp Csharp = new Csharp(7, 12, "C#", plano);
		listadePlaneta.add(Csharp);
		Cmaismais Cmaismais = new Cmaismais(7, 13, "C++", plano);
		listadePlaneta.add(Cmaismais);
		C c = new C(7, 14, "C", plano);
		listadePlaneta.add(c);

		//inicio
		
		System.out.println("BEM VINDO AO SISTEMA JAVALAR!!\n");
		
		System.out.println("Este sistema é uma simulação de um sistema solar, com o java no lugar do sol e linguagens de programação no lugar dos planetas.\nEspero que se divirta!!");
		
		int rodadas = 1;
				
		for (int i = 0; i < rodadas; i++) {
		
			digitarBugs();
			digitarDevs();
			
			int instantes = 0;
			int a = 1;
					
			for (int j = 0; j < a; j++) {	
				try {
					while(instantes<=0) {
					System.out.println("Digite o numero de instantes: ");
					Scanner scam3 = new Scanner(System.in);
					
					instantes = scam3.nextInt();
					
					if(instantes<=0) {
						System.err.println("instantes que são menores ou iguais a 0 são invalidos, tente outra vez!");
					}
					
					}
				}catch(java.util.InputMismatchException e){
					System.err.println("instante invalido, os numeros devem ser inteiros positivos!");
					a++;
				}
			}
			
			System.out.println("\nRELATORIO DA ROTAÇÃO DOS PLANETAS:");
			
			System.out.println("Informações de colisão:");
			
			//execução dos metodos.		
			for (Planeta planeta : listadePlaneta) {
				plano.bateunobug(plano, planeta);
			}
			
			for (Planeta planeta : listadePlaneta) {
				plano.bateunodesenv(plano, planeta);
			}
			
			for (Planeta planeta : listadePlaneta) {
				planeta.movimentarContar(instantes);
			}
			
			posicao(listadePlaneta);
						
			i=continuar();
		}
		
		//nota do fim do sistema javalar
		System.out.println("\n\nOBRIGADO POR UTILIZAR O SITEMA JAVALAR!!\n");
		System.out.println("fique agora com um resumo de cada linguagem usado pra representar os planetas e o sol:\n");
		System.out.println("-JAVA:é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na \nempresa Sun Microsystems, que em 2008 foi adquirido pela empresa Oracle Corporation.\n");
		System.out.println("-PHYTON:é uma linguagem de programação de alto nível, interpretada de script, imperativa, orientada a objetos, funcional, de tipagem dinâmica e forte. \nFoi lançada por Guido van Rossum em 1991.\n");
		System.out.println("-JAVASCRIPT:é uma linguagem de programação interpretada estruturada, de script em alto nível com tipagem dinâmica fraca e multiparadigma. Juntamente \ncom HTML e CSS, o JavaScript é uma das três principais tecnologias da World Wide Web.\n");
		System.out.println("-RUBY ON RAILS:é uma linguagem de programação interpretada multiparadigma, de tipagem dinâmica e forte, com gerenciamento de memória automático, \noriginalmente planejada e desenvolvida no Japão em 1995, por Yukihiro \"Matz\" Matsumoto, para ser usada como linguagem de script.\n");
		System.out.println("-PHP:é uma linguagem interpretada livre, usada originalmente apenas para o desenvolvimento de aplicações presentes e atuantes no lado do servidor, \ncapazes de gerar conteúdo dinâmico na World Wide Web.\n");
		System.out.println("-C#:é uma linguagem de programação, multiparadigma, de tipagem forte, desenvolvida pela Microsoft como parte da plataforma .NET. A sua sintaxe \norientada a objetos foi baseada no C++ mas inclui muitas influências de outras linguagens de programação, como Object Pascal e, principalmente, Java. \n");
		System.out.println("-C++:é uma linguagem de programação compilada multi-paradigma e de uso geral. Desde os anos 1990 é uma das linguagens comerciais mais populares, \nsendo bastante usada também na academia por seu grande desempenho e base de utilizadores.\n");
		System.out.println("-C:é uma linguagem de programação compilada de propósito geral, estruturada, imperativa, procedural, padronizada pela Organização Internacional \npara Padronização, criada em 1972 por Dennis Ritchie na empresa AT&T Bell Labs para desenvolvimento do sistema operacional Unix.\n");
		System.out.println("NOTA:todos os dados desse resumo foram tirados da wikipédia.");
		
		System.err.println("\naté logo... sistema foi fechado.");
		
		System.exit(0);
	}
}
