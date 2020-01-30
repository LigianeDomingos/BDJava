package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// string de conexao e dados de acesso ao servidor
		String servidor = "jdbc:sqlserver://LIGIANE:1433;databaseName=loja_de_automoveis";
		String usuario = "sa";
		String senha = "1234";

		// conexao
		Connection conexao;
		// instrução SQL
		Statement instrucaoSQL;
		// ewsultados
		ResultSet resultados;

		try {
			// conectando ao banco de dados
			conexao = DriverManager.getConnection(servidor, usuario, senha);
			System.out.println("Acabou de conectar!!!");

			// criando a instrução SQL
			instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			resultados = instrucaoSQL.executeQuery("SELECT * FROM Carros");

		} catch (SQLException erro) {
			System.out.println(erro.getMessage());
		}
	}

}
