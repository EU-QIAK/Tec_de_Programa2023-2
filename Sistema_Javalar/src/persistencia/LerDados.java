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
				leitura.readLine();				
                
                while (leitura.ready()) {
					String a3 = leitura.readLine();
					data.add(a3);
//					System.out.println(a3);
				}

			} catch (Exception e) {
			}

		}
		return data;
	}
	
	public String[] SeparDadosDoRelatorio(String linha) {
		String[] Dados = linha.split("	");
		for (String string : Dados) {
//			System.out.println(string);
		}
		return Dados;
		
	}
}
