package negocio;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		SistemaJavalar sistema = new SistemaJavalar();
		sistema.ReceberArquivos(null);
		
	}
}
