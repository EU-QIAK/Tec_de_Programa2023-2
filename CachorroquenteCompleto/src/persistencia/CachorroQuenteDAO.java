package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CachorroQuenteDAO {

    public void cachorroQuenteDAO(ArrayList<String> saleData) {
        for (String sale : saleData) {

            String[] saleParts = sale.split(","); 

            String clientenome = saleParts[0];
            int clientId = Integer.parseInt(saleParts[1]);
            int IndesQueijo = Integer.parseInt(saleParts[2]);
            int IndexProteina = Integer.parseInt(saleParts[3]);
            String ingredientes = saleParts[4];
            int IndexBebida = Integer.parseInt(saleParts[5]);
            double preço = Double.parseDouble(saleParts[6]);

            try {
                Connection connection = new Conexao().getConexao();

                PreparedStatement insert = connection.prepareStatement(
                "INSERT INTO cachorro_quente (nome, matricula, op_queijo, op_proteina, ingredientes, bebida, valor) VALUES (?, ?, ?, ?, ?, ?, ?)");

                insert.setString(1, clientenome);
                insert.setInt(2, clientId);
                insert.setInt(3, IndesQueijo);
                insert.setInt(4, IndexProteina);
                insert.setString(5, ingredientes);
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
