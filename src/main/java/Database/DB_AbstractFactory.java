package Database;

import java.sql.Connection;

import Entities.Estudante;

public interface DB_AbstractFactory {
    Connection createConnection( DB_AbstractFactory factory);
}