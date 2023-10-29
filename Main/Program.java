package Main;

import Database.JAVASQL_Factory;
import Database.JavaSQL_Handler;

import java.sql.Connection;
import java.util.Map;

import Database.DB_AbstractFactory;
import Entities.Bacharelado;
import Entities.Estudante;

public class Program {
    public static void main(String[] args) {
        // Crie uma fábrica de banco de dados para MySQL
        DB_AbstractFactory mysqlFactory = new JavaSQL_Handler();
        Connection connection = mysqlFactory.createConnection(mysqlFactory);

        // Crie um objeto de estudante com disciplinas e notas no construtor
        Estudante estudante = new Bacharelado("Ganso", "Aprovado", "Bacharelado", Map.of("OOP", 5.5, "Design Pattern", 7.0,"IA", 8.5));

        // Use a classe JAVASQL_Handler para inserir o estudante no banco de dados MySQL
        JavaSQL_Handler inserter = new JavaSQL_Handler();
        inserter.InsertStudent(connection, estudante);
    }
}
