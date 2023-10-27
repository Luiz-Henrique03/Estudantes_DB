package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import Entities.Estudante;


public interface DB_AbstractFactory {
	
	void InsertStudent(Estudante estudante);
	 
}
