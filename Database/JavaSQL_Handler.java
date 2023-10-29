package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import Entities.Estudante;

public class JavaSQL_Handler implements JAVASQL_Factory{
	
	 	private static final String JDBC_URL_MYSQL = "jdbc:mysql://localhost/Estudantes?useSSL=false&allowPublicKeyRetrieval=true";
	    private static final String USER_MYSQL = "Luiz";
	    private static final String PASSWORD_MYSQL = "mesutozil10";

  
		@Override
		public Connection createConnection(DB_AbstractFactory factory) {
			try {
	            return DriverManager.getConnection(JDBC_URL_MYSQL, USER_MYSQL, PASSWORD_MYSQL);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
		

		@Override
		public void InsertStudent(Connection connection, Estudante estudante) {
		    if (connection != null) {
		        try {
		            String sql = "INSERT INTO Estudantes3 (nome, aprovado, escolaridade, disciplina1, nota1, disciplina2, nota2, disciplina3, nota3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            preparedStatement.setString(1, estudante.getNome());
		            preparedStatement.setString(2, estudante.getAprovado()); // Insere o status (Aprovado ou Reprovado)
		            preparedStatement.setString(3, estudante.getEscolaridade());

		            // Verifique se há até 3 disciplinas e suas notas
		            Map<String, String> disciplinas = estudante.getNotasDisciplinas();
		            int index = 4;
		            for (Map.Entry<String, String> entry : disciplinas.entrySet()) {
		                if (index > 9) {
		                    break; // Máximo de 3 disciplinas
		                }
		                preparedStatement.setString(index++, entry.getKey()); // Nome da disciplina
		                preparedStatement.setString(index++, entry.getValue()); // Nota da disciplina
		            }

		            int rowsAffected = preparedStatement.executeUpdate();

		            preparedStatement.close();

		            if (rowsAffected > 0) {
		                System.out.println("Estudante inserido com sucesso.");
		            } else {
		                System.out.println("Falha ao inserir o estudante.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		} 
		
		public void updateStudent(Connection connection, int estudanteId, String novaString) {
		    if (connection != null) {
		        try {
		            String sql = "UPDATE Estudantes3 SET escolaridade = ? WHERE id = ?";
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            preparedStatement.setInt(1, estudanteId);
		            preparedStatement.setString(2, novaString);
		            

		            int rowsAffected = preparedStatement.executeUpdate();

		            preparedStatement.close();

		            if (rowsAffected > 0) {
		                System.out.println("Estudante atualizado com sucesso.");
		            } else {
		                System.out.println("Nenhum estudante foi encontrado com o ID especificado.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
   }
		}
}