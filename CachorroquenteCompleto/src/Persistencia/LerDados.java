package Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import back_end.Aluno;

public class LerDados {

	public ArrayList<Aluno> alunos;
	
	public LerDados(){
		alunos = new ArrayList<Aluno>();	
	}
	
	public void LerDados (String diretorio){
		
		try {
			FileReader arquivo = new FileReader(diretorio);
			BufferedReader Leitura = new BufferedReader(arquivo);
			
			while (Leitura.ready()) {
				alunos.add(SeparDadosDosAlunos(Leitura.readLine()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private Aluno SeparDadosDosAlunos(String linha) {
		
		String[] Dados = linha.split(";");
		Aluno c = new Aluno(Dados[1], 0);
		return c;
		
	}
}
