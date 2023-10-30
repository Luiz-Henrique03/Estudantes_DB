package Database;

import java.sql.Connection;

import Entities.Estudante;

public interface MongoDB_Factory extends DB_AbstractFactory{

	@Override
	public Connection createConnection(DB_AbstractFactory factory);


   
}