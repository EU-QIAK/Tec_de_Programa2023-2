package negocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

import apresentação.Janela;
import persistencia.EscreverDados;
import persistencia.LerDados;
import persistencia.SistemaJavalarDAO;

public class SistemaJavalar {
	
	private ArrayList<Planeta>listadePlaneta = new ArrayList<Planeta>();
	private ArrayList<String> armazenarLinhas = new ArrayList<String>();
	private Plano plano = new Plano(15, 15);
	private LerDados lerDados;
	private File file;
	private Aluno aluno;
	private int indice = 0;
	
	public SistemaJavalar() {
		
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
								
			}
		}catch (java.util.InputMismatchException e) {
			System.err.println("\nentrada invalida!!");
			digitarBugs(bugs);
		}
	}
	
	public void digitarDevs(int devs) {
		try {
			for (int i = 0; i < 1; i++) {
				
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
				
			}
		}catch(java.util.InputMismatchException e) {
			System.err.println("\nentrada invalida!!");
			digitarDevs(devs);
		}
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
	
	//O medoto recebe um arquivo com as informações para serem distrubuidas pros medotos necessarios 
	public void ReceberArquivos(File file) throws FileNotFoundException, IOException {
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

	//onde o milagre acontece, faço a distribuição das informações contidas nas linhas para os metodos 
	public void rodada(String linha){
		ArrayList<Integer> numerosDaRodada = new ArrayList<Integer>();
		
		for (String numeros : lerDados.SeparDadosDoRelatorio(linha)) {
			int n = Integer.parseInt(numeros);
			numerosDaRodada.add(n);
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
	
	//faz o sistema pegar outra linha para executar
	public void proximaLinhas(){
		if(armazenarLinhas.size() > indice) {
			String linhaAtual = armazenarLinhas.get(indice);
			rodada(linhaAtual);
			indice++;
		}else {
			JOptionPane.showMessageDialog(null, "Não há mais linhas para executar o javaLar(selecione um novo arquivo de entrada).");
		}
	}
	
	//envia o relatorio para o banco de dados
	public void relatorio(File file) {
		this.file = file;
		
		aluno = new Aluno("Kaique Damasceno", 542062);
		
		//função para checar os quadrantes
		int bugQ1=0;
		int devQ1=0;
		int bugQ2=0;
		int devQ2=0;
		int bugQ3=0;
		int devQ3=0;
		int bugQ4=0;
		int devQ4=0;
		
		for (Celula celula: plano.listaCel) {
			if(celula.id <119) {
				if(celula.x<=6 && celula.y<=6) {
					if(celula.bug==true) {
						bugQ1++;
					}else if(celula.desenvolvedor==true){
						devQ1++;
					}
				}
				else if(celula.x<=6 && celula.y>=8) {
					if(celula.bug==true) {
						bugQ2++;
					}else if(celula.desenvolvedor==true){
						devQ2++;
					}
				}
				
			}else {
				if(celula.x>=8 && celula.y<=6) {
					if(celula.bug==true) {
						bugQ3++;
					}else if(celula.desenvolvedor==true){
						devQ3++;
					}
				}
				else if(celula.x>=8 && celula.y>=8) {
					if(celula.bug==true) {
						bugQ4++;
					}else if(celula.desenvolvedor==true){
						devQ4++;
					}
				}
			}
		}
				
		String relatorio = aluno.getNome()+ "," + aluno.getMatricula() + "," + file.getName() + "," + listadePlaneta.get(0).bateuBug + "," + listadePlaneta.get(1).bateuBug + "," + listadePlaneta.get(2).bateuBug
				+ "," + listadePlaneta.get(3).bateuBug + "," + listadePlaneta.get(4).bateuBug + "," + listadePlaneta.get(5).bateuBug + "," + listadePlaneta.get(6).bateuBug + "," + listadePlaneta.get(0).bateuDev
				+ "," + listadePlaneta.get(1).bateuDev + "," + listadePlaneta.get(2).bateuDev + "," + listadePlaneta.get(3).bateuDev + "," + listadePlaneta.get(4).bateuDev + "," + listadePlaneta.get(5).bateuDev
				+ "," + listadePlaneta.get(6).bateuDev + "," + listadePlaneta.get(0).movimentos + "," + listadePlaneta.get(1).movimentos + "," + listadePlaneta.get(2).movimentos + "," + listadePlaneta.get(3).movimentos
				+ "," + listadePlaneta.get(4).movimentos + "," + listadePlaneta.get(5).movimentos + "," + listadePlaneta.get(6).movimentos + "," + listadePlaneta.get(0).horas + "," + listadePlaneta.get(1).horas
				+ "," + listadePlaneta.get(2).horas + "," + listadePlaneta.get(3).horas + "," + listadePlaneta.get(4).horas + "," + listadePlaneta.get(5).horas + "," + listadePlaneta.get(6).horas 
				+ "," + listadePlaneta.get(0).anos + "," + listadePlaneta.get(1).anos + "," + listadePlaneta.get(2).anos + "," + listadePlaneta.get(3).anos + "," + listadePlaneta.get(4).anos
				+ "," + listadePlaneta.get(5).anos + "," + listadePlaneta.get(6).anos + "," + bugQ1 + "," + bugQ2 + "," + bugQ3 + "," + bugQ4 + "," + devQ1 + "," + devQ2 + "," + devQ3 + "," + devQ4;
		
//		System.out.println(relatorio);
		
		ArrayList<String> relatorioLista = new ArrayList<String>();
		relatorioLista.add(relatorio);
		
		SistemaJavalarDAO s = new SistemaJavalarDAO();
		s.SistemaJavalarDAO(relatorioLista);
		
		JOptionPane.showMessageDialog(null, "Relatorio enviado.");

		System.out.println("Relatorio enviado.");
		
	}
	
	public ArrayList<Planeta> getListaDePlaneta() {
		return listadePlaneta;
	}
	
	public Plano getplano(){
		return plano;
	}
}