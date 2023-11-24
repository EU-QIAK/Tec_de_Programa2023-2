package apresentação;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AreaDosBotoes extends JPanel{

	Botao processarProximosInstantes;
	Botao lerNovoArquivodeEntrada;
	Botao GravarRelatorio;
	Botao LerDadosDeOutrosParticipantes;
	Botao GravarArquivoDeSaida;
	
	public AreaDosBotoes() {
		
		setLayout(new GridLayout(5,0));
		
		processarProximosInstantes = criarBotao("processar proximos instantes", new Color(72, 209, 204));
		processarProximosInstantes.setFont(new Font("arial", Font.BOLD, 12));
		processarProximosInstantes.setBorder(BorderFactory.createLineBorder(Color.white));
		processarProximosInstantes.addActionListener(null);
		add(processarProximosInstantes);
		
		lerNovoArquivodeEntrada = criarBotao("ler novo arquivo de entrada", new Color(173, 255, 47));
		lerNovoArquivodeEntrada.setFont(new Font("arial", Font.BOLD, 12));
		lerNovoArquivodeEntrada.setBorder(BorderFactory.createLineBorder(Color.white));
		add(lerNovoArquivodeEntrada);
		
		GravarRelatorio = criarBotao("Gravar relatorio", Color.lightGray);
		GravarRelatorio.setFont(new Font("arial", Font.BOLD, 12));
		GravarRelatorio.setBorder(BorderFactory.createLineBorder(Color.white));
		add(GravarRelatorio);
		
		LerDadosDeOutrosParticipantes = criarBotao("Ler dados de outros participantes", Color.lightGray);
		LerDadosDeOutrosParticipantes.setFont(new Font("arial", Font.BOLD, 11));
		LerDadosDeOutrosParticipantes.setBorder(BorderFactory.createLineBorder(Color.white));
		add(LerDadosDeOutrosParticipantes);
		
		GravarArquivoDeSaida = criarBotao("Gravar arquivo de saida", Color.lightGray);
		GravarArquivoDeSaida.setFont(new Font("arial", Font.BOLD, 12));
		GravarArquivoDeSaida.setBorder(BorderFactory.createLineBorder(Color.white));
		add(GravarArquivoDeSaida);
	}
	
	public Botao criarBotao(String texto, Color cor) {

		Botao b = new Botao(texto, cor);
		return b;
	}

}
