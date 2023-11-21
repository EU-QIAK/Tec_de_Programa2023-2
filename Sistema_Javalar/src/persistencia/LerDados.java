package persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerDados {

	public ArrayList<String> data;
	
	public ArrayList<String> lerDados (String diretorio) throws FileNotFoundException, IOException{
		
		try (BufferedReader Leitura = new BufferedReader(new FileReader(diretorio))){			
			
			data = new ArrayList<>();
			
			try {
				FileReader arquivo = new FileReader(diretorio);
				BufferedReader leitura = new BufferedReader(arquivo);

				while (leitura.ready()) {
					data.add(leitura.readLine());
				}

			} catch (Exception e) {
			}

		}
	
		return data;
	}
	private String[] SeparDadosDoRelatorio(String linha) {
		String[] Dados = linha.split(" ");
		return Dados;
		
	}
}
