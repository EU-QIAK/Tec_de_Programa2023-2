package apresentação;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.SwingUtilities;

public class main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		SwingUtilities.invokeLater(() -> {	
		Janela janela = new Janela();
		});
	}

}
