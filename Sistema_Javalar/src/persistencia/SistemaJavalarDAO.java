package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SistemaJavalarDAO {
	
	private Conexao conexao;

	public void SistemaJavalarDAO(ArrayList<String> saleData) {
	  
		for (String string : saleData) {
			
			String[] saleParts = string.split(","); 

            String clientenome = saleParts[0];
            int clientId = Integer.parseInt(saleParts[1]);
            int IndesQueijo = Integer.parseInt(saleParts[2]);
            int IndexProteina = Integer.parseInt(saleParts[3]);
            String ingredientes = saleParts[4];
            int IndexBebida = Integer.parseInt(saleParts[5]);
            double preço = Double.parseDouble(saleParts[6]);
		  
            try {
	    	  Connection connection = new Conexao().getConexao();

	        PreparedStatement insert = connection.prepareStatement("INSERT INTO javalar (nome,matricula,id, nome_arquivo, "
	            + "bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c, "
	            + "dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c, "
	            + "v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, "
	            + "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, "
	            + "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, "
	            + "bug_q1, bug_q2, bug_q3, bug_q4) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

	        insert.setString(1, string );
	        insert.setInt(2, IndexBebida);
	        insert.setInt(3, IndexBebida);
	        insert.setInt(4, IndexBebida);
	        insert.setString(5, string);
	        insert.setInt(6, IndexBebida);
	        insert.setDouble(7, preço);

	        insert.execute();

	        connection.close();
	      } catch (SQLException exception) {
	        exception.printStackTrace();
	      }
	    }
	  }
}
