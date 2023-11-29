package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import negocio.Aluno;

public class RelatorioDAO {

	//limitei a pesquisa ao banco de dados para 100 linhas 
	private ResultSet getData() {
		
		try {
			Connection conexao = new Conexao().getConexao();

			String sql = "SELECT * FROM javalar LIMIT 100";

			return conexao.prepareStatement(sql).executeQuery();
		} catch (SQLException e) {
			System.out.println("conectou não ó boy...");
			e.printStackTrace();
		}

		return null;
	}

	//aluno que mais jogou
	public Aluno retornarAlunoQueMaisJogou() {

		ArrayList<Aluno> estudantes = new ArrayList<Aluno>();

		try {
			Connection conexao = new Conexao().getConexao();

			String sql = "SELECT * FROM javalar LIMIT 100";

			ResultSet resultados = conexao.prepareStatement(sql).executeQuery();

			while (resultados.next()) {
				String name = resultados.getString("nome");
				int matricula = resultados.getInt("matricula");

				estudantes.add(new Aluno(name, matricula));
			}

			conexao.close();

		} catch (Exception e) {
			System.out.println("conectou não boy...");
			e.printStackTrace();
		}

		Map<Aluno, Integer> contagemDeAlunos = new HashMap<>();

		for (Aluno aluno : estudantes) {
			contagemDeAlunos.put(aluno, contagemDeAlunos.getOrDefault(aluno, 0) + 1);
		}
		
		Aluno alunoQueMaisJogou = null;
		int frequencia = 0;

		for (Map.Entry<Aluno, Integer> entry : contagemDeAlunos.entrySet()) {
			if (entry.getValue() > frequencia) {
				frequencia = entry.getValue();
				alunoQueMaisJogou = entry.getKey();
			}
		}
		
		return alunoQueMaisJogou;
	}
	
	//planeta que mais morreu
	public String retornarPlanetaQueMaisMorreu() {

		ArrayList<String> PlanetasMortos = new ArrayList<String>();
		try {
			ResultSet resultados = getData();

			while (resultados.next()) {

				if (resultados.getInt("v_python") == 0) {
					PlanetasMortos.add("Python");
				}
				if (resultados.getInt("v_javascript") == 0) {
					PlanetasMortos.add("JavaScript");					
				}
				if (resultados.getInt("v_ruby") == 0) {
					PlanetasMortos.add("Ruby On Rails");
				}
				if (resultados.getInt("v_php") == 0) {
					PlanetasMortos.add("PHP");
				}
				if (resultados.getInt("v_csharp") == 0) {
					PlanetasMortos.add("C#");
				}
				if (resultados.getInt("v_cmais") == 0) {
					PlanetasMortos.add("C++");					
				}
				if (resultados.getInt("v_c") == 0) {
					PlanetasMortos.add("C");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String planeta : PlanetasMortos) {
			Integer contando = map.get(planeta);
			map.put(planeta, (contando == null) ? 1 : contando + 1);
		}

		String nomeDoPlaneta = "";
		int maiorValorNoMap = 0;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maiorValorNoMap) {
				maiorValorNoMap = entry.getValue();
				nomeDoPlaneta = entry.getKey();
			}
		}

		return nomeDoPlaneta;
	}
	
	//planeta que "mais viveu".
	public String retornarPlanetaComMaisVida() {
		try {
			ResultSet resultados = getData();

			int[] planetas = { 0, 0, 0, 0, 0, 0, 0 };
			int Valormaximo = 0;
			int planeta = 0;

			while (resultados.next()) {
				planetas[0] += resultados.getInt("v_python");
				planetas[1] += resultados.getInt("v_javascript");
				planetas[2] += resultados.getInt("v_ruby");
				planetas[3] += resultados.getInt("v_php");
				planetas[4] += resultados.getInt("v_csharp");
				planetas[5] += resultados.getInt("v_cmais");
				planetas[6] += resultados.getInt("v_c");
			}

			for (int i = 0; i < planetas.length; i++) {
				if (planetas[i] > Valormaximo) {
					Valormaximo = planetas[i];
					planeta = i + 1;
				}
			}

			switch (planeta) {
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
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	//quadrante com mais bug
	public int retornarQuadranteComMaisBugs() {

		int[] quadrantes = { 0, 0, 0, 0 };
		int valorMAX = 0;
		int quadrante = 0;

		try {

			ResultSet resultado = getData();
			while (resultado.next()) {
				quadrantes[0] += resultado.getInt("bug_q1");
				quadrantes[1] += resultado.getInt("bug_q2");
				quadrantes[2] += resultado.getInt("bug_q3");
				quadrantes[3] += resultado.getInt("bug_q4");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		for (int i = 0; i < quadrantes.length; i++) {
			if (quadrantes[i] > valorMAX) {
				valorMAX = quadrantes[i];
				quadrante = i + 1;
			}
		}

		return quadrante;
	}

	//quadrante com mais dev
	public int retornarQuadranteComMaisDevs() {

		int[] quadrantes = { 0, 0, 0, 0 };
		int valorMAX = 0;
		int quadrante = 0;

		try {

			ResultSet resultado = getData();
			while (resultado.next()) {
				quadrantes[0] += resultado.getInt("dev_q1");
				quadrantes[1] += resultado.getInt("dev_q2");
				quadrantes[2] += resultado.getInt("dev_q3");
				quadrantes[3] += resultado.getInt("dev_q4");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		for (int i = 0; i < quadrantes.length; i++) {
			if (quadrantes[i] > valorMAX) {
				valorMAX = quadrantes[i];
				quadrante = i + 1;
			}
		}

		return quadrante;
	}
	
	//total de instantes jogados
	public int retornarQuantidadeDeInstantesAnalizados() {
		
		try {
			ResultSet resultado = getData();

			int quantidadeInstantes = 0;

			while (resultado.next()) {
				quantidadeInstantes++;
			}

			return quantidadeInstantes;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	//velocidade media de cada planeta
	public double[] retornarVelocidadeMedia() {

		int[] velocidades = { 0, 0, 0, 0, 0, 0, 0 };
		int ocorrencias = retornarQuantidadeDeInstantesAnalizados();

		try {
			ResultSet resultado = getData();

			while (resultado.next()) {
				velocidades[0] += resultado.getInt("v_python");
				velocidades[1] += resultado.getInt("v_javascript");
				velocidades[2] += resultado.getInt("v_ruby");
				velocidades[3] += resultado.getInt("v_php");
				velocidades[4] += resultado.getInt("v_csharp");
				velocidades[5] += resultado.getInt("v_cmais");
				velocidades[6] += resultado.getInt("v_c");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		double[] velocidadeMedia = new double[velocidades.length];

		for (int i = 0; i < velocidades.length; i++) {
			velocidadeMedia[i] = velocidades[i] / (double) ocorrencias;
		}

		return velocidadeMedia;
	}
	
	//quantidade de bugs
	public int retornarQuantidadeDeBugs() {
		try {
			ResultSet resultado = getData();

			int quantidadeBugs = 0;

			while (resultado.next()) {
				quantidadeBugs += resultado.getInt("bug_python");
				quantidadeBugs += resultado.getInt("bug_javascript");
				quantidadeBugs += resultado.getInt("bug_ruby");
				quantidadeBugs += resultado.getInt("bug_php");
				quantidadeBugs += resultado.getInt("bug_csharp");
				quantidadeBugs += resultado.getInt("bug_cmais");
				quantidadeBugs += resultado.getInt("bug_c");
			}

			return quantidadeBugs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	//quantidade de devs
	public int retornarQuantidadeDeDevs() {
		try {
			ResultSet resultado = getData();

			int quantidadeDevs = 0;

			while (resultado.next()) {
				quantidadeDevs += resultado.getInt("dev_python");
				quantidadeDevs += resultado.getInt("dev_javascript");
				quantidadeDevs += resultado.getInt("dev_ruby");
				quantidadeDevs += resultado.getInt("dev_php");
				quantidadeDevs += resultado.getInt("dev_csharp");
				quantidadeDevs += resultado.getInt("dev_cmais");
				quantidadeDevs += resultado.getInt("dev_c");
			}

			return quantidadeDevs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	//quantidade de dias(em horas)
	public int retornarQuantidadeHoras() {
		try {
			ResultSet resultado = getData();

			int quantidadeHoras = 0;

			while (resultado.next()) {
				quantidadeHoras += resultado.getInt("d_python");
				quantidadeHoras += resultado.getInt("d_javascript");
				quantidadeHoras += resultado.getInt("d_ruby");
				quantidadeHoras += resultado.getInt("d_php");
				quantidadeHoras += resultado.getInt("d_csharp");
				quantidadeHoras += resultado.getInt("d_cmais");
				quantidadeHoras += resultado.getInt("d_c");
			}

			return quantidadeHoras;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	//quantidade de anos
	public int retornarQuantidadeAnos() {
		try {
			ResultSet resultado = getData();

			int quantidadeAnos = 0;

			while (resultado.next()) {
				quantidadeAnos += resultado.getInt("a_python");
				quantidadeAnos += resultado.getInt("a_javascript");
				quantidadeAnos += resultado.getInt("a_ruby");
				quantidadeAnos += resultado.getInt("a_php");
				quantidadeAnos += resultado.getInt("a_csharp");
				quantidadeAnos += resultado.getInt("a_cmais");
				quantidadeAnos += resultado.getInt("a_c");
			}

			return quantidadeAnos;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}
