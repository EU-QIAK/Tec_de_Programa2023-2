package negocio;

import javax.swing.JOptionPane;

import persistencia.EscreverDados;
import persistencia.RelatorioDAO;

public class EmissãoDoRelatorio{

	private RelatorioDAO relatorioDAO;
	private EscreverDados dados;
	private StringBuilder content;
//	public void run() {
//		relatorioDAO = new RelatorioDAO();
//		dados = new EscreverDados();
//	}

	
	public EmissãoDoRelatorio() {
		relatorioDAO = new RelatorioDAO();
		dados = new EscreverDados();
		content = new StringBuilder();
	}
	public Aluno alunoQueMaisJogou() {
		return relatorioDAO.retornarAlunoQueMaisJogou();
	}
	
	public String retornarPlanetaQueMaisMorreu() {
		return relatorioDAO.retornarPlanetaQueMaisMorreu();
	}
	
	public String retornarPlanetaComMaisVida() {
		return relatorioDAO.retornarPlanetaComMaisVida();
	}
	
	public int retornarQuadranteComMaisBugs() {
		return relatorioDAO.retornarQuadranteComMaisBugs();
	}
	
	public int retornarQuadranteComMaisDevs() {
		return relatorioDAO.retornarQuadranteComMaisDevs();
	}
	
	public int retornarQuantidadeDeInstantesAnalizados() {
		return relatorioDAO.retornarQuantidadeDeInstantesAnalizados();
	}

	public double[] retornarVelocidadeMedia() {
		return relatorioDAO.retornarVelocidadeMedia();
	}
	
	public int retornarQuantidadeDeBugs() {
		return relatorioDAO.retornarQuantidadeDeBugs();
	}
	
	public int retornarQuantidadeDeDevs() {
		return relatorioDAO.retornarQuantidadeDeDevs();
	}
	
	public int retornarQuantidadeHoras() {
		return relatorioDAO.retornarQuantidadeHoras();
	}
	
	public int retornarQuantidadeAnos() {
		return relatorioDAO.retornarQuantidadeAnos();
	}
	
	public void obterInformaçoesRelatorio() {
		Aluno aluno = alunoQueMaisJogou();

		content.append(aluno.getMatricula() + " - " + aluno.getNome());
		content.append(", " + retornarPlanetaQueMaisMorreu());
		content.append(", " + retornarPlanetaComMaisVida());
		content.append(", " + retornarQuadranteComMaisBugs());
		content.append(", " + retornarQuadranteComMaisDevs());
		content.append(", " + retornarQuantidadeDeInstantesAnalizados());

		double[] VelocidadeMedia = retornarVelocidadeMedia();

		for (int i = 0; i < VelocidadeMedia.length; i++) {
			String nomeDoPlaneta = pegarNome.obterNomeDosPlanetas(i + 1);
			String expression = nomeDoPlaneta + ": " + String.format("%.2f", VelocidadeMedia[i]);
			if (i == 0) {
				content.append(", " + expression);
			} else {
				content.append(" - " + expression);
			}
		}

		content.append(", " + retornarQuantidadeDeBugs());
		content.append(", " + retornarQuantidadeDeDevs());
		content.append(", " + retornarQuantidadeHoras());
		content.append(", " + retornarQuantidadeAnos() + "\n");
		
		System.out.println(content.toString());
		JOptionPane.showMessageDialog(null, "Dados do banco obtidos com sucesso, clique em 'gravar arquivo de saida' para emitir o documeto.");
		
	}
	
	public void salvarRelatorio() {
		EscreverDados dados = new EscreverDados();
		
		dados.escreverDados("dados&Imagens//dadosRelatorio//jogo", content.toString());
		JOptionPane.showMessageDialog(null, "linha salva.");

	}
	
	public class pegarNome {

		public static String obterNomeDosPlanetas(int index) {
			switch (index) {
			case 1:
				return "Python";
			case 2:
				return "JavaScript";
			case 3:
				return "Ruby On Rails";
			case 4:
				return "PHP";
			case 5:
				return "C#";
			case 6:
				return "C++";
			case 7:
				return "C";
			default:
				return null;
			}
		}
	}
}
