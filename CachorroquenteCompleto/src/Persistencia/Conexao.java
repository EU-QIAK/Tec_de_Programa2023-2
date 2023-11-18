package persistencia;

import java.sql.*;

public class Conexao {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexao() {

		this.host = "test_db.mysql.dbaas.com.br"; 
		this.banco = "test_db";
		this.usuario = "test_db";
		this.senha = "TecProg23-2!@";
	}

	public Connection getConexao() {
		//deu erro de driver, não sei resolver
//		String url = "jdbc:mysql://" + this.host + "/" + this.banco + "?verifyServerCertificate=false&useSSL=true";

		String url="jdbc:mysql://" + this.host + ":3306/" + this.banco + "?enabledTLSProtocols=TLSv1.2&verifyServerCertificate=false&useSSL=true";
		try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            System.out.println("conexão falhou.");
            ex.printStackTrace();
        }
        return null;
	}

}
