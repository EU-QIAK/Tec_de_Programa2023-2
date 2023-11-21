package apresentação;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AreaDosBotoes extends JPanel{

	Botao processarProximoInstantes;
	Botao lerNovoArquivodeEntrada;
	Botao GravarRelatorio;
	Botao LerDadosDeOutrosParticipantes;
	Botao GravarArquivoDeSaida;
	
	public AreaDosBotoes() {
		
		setLayout(new GridLayout(5,0));
		
		processarProximoInstantes = criarBotao("processar proximo instantes", Color.lightGray);
		processarProximoInstantes.setFont(new Font("arial", Font.BOLD, 12));
		processarProximoInstantes.setBorder(BorderFactory.createLineBorder(Color.white));
		processarProximoInstantes.addActionListener(null);
		add(processarProximoInstantes);
		
		lerNovoArquivodeEntrada = criarBotao("ler novo arquivo de entrada", Color.lightGray);
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
