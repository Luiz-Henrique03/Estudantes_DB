package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Entities.Estudante;

public class JavaSQL_Factory implements DB_AbstractFactory {

    private static final String JDBC_URL = "jdbc:mysql://localhost/Estudantes?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "Luiz";
    private static final String PASSWORD = "sephirothFF7";
    
    public JavaSQL_Factory() {
    	
    	try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            
            // Criar a tabela veiculos se ela não existir
            String createTableSQL = "CREATE TABLE IF NOT EXISTS estudantes (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255),  nota FLOAT, escolaridade VARCHAR(255)";
            statement.executeUpdate(createTableSQL);
            
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com exceções de banco de dados aqui
        }
    }
    
    
	@Override
	public void InsertStudent(Estudante estudante) {
		
		try {
            Connection connection =  DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            String sql = "INSERT INTO Estudantes (nome, nota, escolaridade) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, estudante.getNome());
            preparedStatement.setDouble(2, estudante.getNota());
            preparedStatement.setString(3, estudante.getEscolaridade());

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

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

    

