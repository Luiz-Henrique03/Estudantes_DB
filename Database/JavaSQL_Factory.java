package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Entities.Estudante;

public  interface JAVASQL_Factory extends DB_AbstractFactory {

	@Override
    public Connection createConnection(DB_AbstractFactory factory);


}
